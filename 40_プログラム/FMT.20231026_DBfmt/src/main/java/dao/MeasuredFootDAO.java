package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.DynamicSQLBuilder;
import model.LeftFoot;
import model.MeasuredPerson;
import model.ResultMeasure;
import model.RightFoot;
import model.searchMeasuredPerson.ResultMeasuredPearson;
import model.searchMeasuredPerson.SearchParams;

public class MeasuredFootDAO {
    private final String URL = "jdbc:postgresql://localhost:5432/fmt";
    private final String USER = "postgres";
    private final String PASSWORD = "test";

   
	// コンストラクタ
	public MeasuredFootDAO() {
		/* JDBCドライバの準備 */
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * willFix:ゆくゆくはsearchMeasuredPersonメソッドに統合したい Oct.19th 23
	 * 利用目的：被測定者IDを基に
	 * 引数　　：String measuredPersonId
	 * 戻り値　：List<ResultMeasuredPearson> searchMeasuredPerson
	 * 
	 */
	public ResultMeasuredPearson searchMeasuredPersonById(String measuredPersonId) {
		
		ResultMeasuredPearson resultMeasuredPearsons = null;
		
		String sql = "";
			   sql = "SELECT * FROM measured_foot ";
			   sql += "WHERE measured_person_id = " + measuredPersonId + ";";
			   
			   
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			 Statement  st = con.createStatement();) {
			
			ResultSet resultSet = st.executeQuery(sql);
			
			resultMeasuredPearsons = this.createResultMeasuredPearson(resultSet);
			
	    } catch (Exception e) {
	    	System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
	    } 
			   
		return resultMeasuredPearsons;
	}
	
	//ここの例外処理要確認 Oct.19th 23
	//現状、呼び出し元に例外は任せる方針
	private ResultMeasuredPearson createResultMeasuredPearson (ResultSet resultSet) throws SQLException {
		ResultMeasuredPearson resultMeasurePearson = new ResultMeasuredPearson();
		
		while (resultSet.next()) {
			int     measuredPersonId       = resultSet.getInt("measured_person_id");
			String  kana                     = resultSet.getString("kana");
			String  name                     = resultSet.getString("name");
			String  kind                     = resultSet.getString("kind");
			int	    age                      = resultSet.getInt("age");
			int	    height                   = resultSet.getInt("hight");
			int	    bodyWeight               = resultSet.getInt("weight");
			double ordinaryShoesSize       = resultSet.getDouble("regular_shoe_size");
			String  measuredDate            = resultSet.getString("measured_date");
			String  writtenBy               = resultSet.getString("writtenby_person");
			
			//5
			int	    LFootLength             = resultSet.getInt("left_length");
			int	    LFootCWeith             = resultSet.getInt("left_weighted_thickness");
			int	    LFootCRegu              = resultSet.getInt("left_regular_thickness");
			int	    LFootWidthWeith        = resultSet.getInt("left_weighted_width");
			int	    LFootWidthRegu         = resultSet.getInt("left_regular_width");
			
			//5
			int	    RFootLength            = resultSet.getInt("right_length");
			int	    RFootCWeith            = resultSet.getInt("right_weighted_thickness");
			int	    RFootCRegu             = resultSet.getInt("right_regular_thickness");
			int	    RFootWidthWeith       = resultSet.getInt("right_weighted_width");
			int	    RFootWidthRegu        = resultSet.getInt("right_regular_width");
			
			//3
			String  hardness 				= resultSet.getString("hardness");
			double recomendSize  	        = resultSet.getDouble("recomend_shoe_size");	
			String thickness 				= resultSet.getString("thickness");
			
			
			resultMeasurePearson.setMeasuredPersonId(measuredPersonId);
			resultMeasurePearson.setKana(kana);
			resultMeasurePearson.setName(name);
			resultMeasurePearson.setKind(kind);
			resultMeasurePearson.setHeight(height);
			resultMeasurePearson.setBodyWeight(bodyWeight);
			resultMeasurePearson.setOrdinaryShoesSize(ordinaryShoesSize);
			resultMeasurePearson.setMeasuredDate(measuredDate);
			resultMeasurePearson.setWrittenBy(writtenBy);
			
			resultMeasurePearson.setLFootLength(LFootLength);
			resultMeasurePearson.setLFootCWeith(LFootCWeith);
			resultMeasurePearson.setLFootCRegu(LFootCRegu);
			resultMeasurePearson.setLFootWidthWeith(LFootWidthWeith);
			resultMeasurePearson.setLFootCRegu(LFootCRegu);

			resultMeasurePearson.setRFootLength(RFootLength);
			resultMeasurePearson.setRFootCWeith(RFootCWeith);
			resultMeasurePearson.setRFootCRegu(RFootCRegu);
			resultMeasurePearson.setRFootWidthWeith(RFootWidthWeith);
			resultMeasurePearson.setRFootWidthRegu(RFootWidthRegu);
			
			resultMeasurePearson.setHardness(hardness);
			resultMeasurePearson.setRecomendSize(recomendSize);
			resultMeasurePearson.setThickness(thickness);
			
			
		}
		return resultMeasurePearson;
	}
	
	//全検索条件に対応バージョン
	/*
	 * 利用方法：フォームから渡ってきた値により任意のSQL文を実行し
	 * 　　　　　データベースから値のリストを生成する
	 * 引数　　：SearchParamsクラス（検索条件を持つクラス）
	 * 戻り値　：List<ResultMeasuredPearson>　(一個人の情報を格納しているリスト)
	 * 
	 */
	
	public List<ResultMeasuredPearson> searchMeasuredPerson (SearchParams searchParams) {
		List<ResultMeasuredPearson> resultMeasuredPearsonList = null;
		
		//検索条件に応じたSQLを生成
		DynamicSQLBuilder dynamicSQLBuilder  = new DynamicSQLBuilder();
		String sql = dynamicSQLBuilder.buildQuery(searchParams);	
		
		
		//postgresへの接続
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	 		 Statement  st = con.createStatement();) {
			
			//sql文の実行
			ResultSet resultSet = st.executeQuery(sql);
			
			//検索結果情報を持つリストの生成
			resultMeasuredPearsonList = this.createResultMeasuredPearsonList(resultSet);
			
			
		} catch (Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
		
		
		return resultMeasuredPearsonList;
	}
	
	
	/*
	 * 
	 *利用目的：データベースから取得した被測定クラスを格納するリストを生成 
	 * 引数　 ：ResultSet(データベースから取得したレコード達)
	 * 戻り値 ：List<ResultMeasuredPearson>（被測定クラスを格納したクラス）
	 * 
	 */
	private List<ResultMeasuredPearson> createResultMeasuredPearsonList (ResultSet resultSet) throws SQLException {
		List<ResultMeasuredPearson> resultMeasuredPearsonList = new ArrayList<ResultMeasuredPearson>();
		ResultMeasuredPearson resultMeasurePearson = null;
		
		while (resultSet.next()) {
			//10
			int     measuredPersonId       = resultSet.getInt("measured_person_id");
			String  kana                     = resultSet.getString("kana");
			String  name                     = resultSet.getString("name");
			String  kind                     = resultSet.getString("kind");
			int	    age                      = resultSet.getInt("age");
			int	    height                   = resultSet.getInt("hight");
			int	    bodyWeight               = resultSet.getInt("weight");
			double ordinaryShoesSize       = resultSet.getDouble("regular_shoe_size");
			String  measuredDate            = resultSet.getString("measured_date");
			String  writtenBy               = resultSet.getString("writtenby_person");
			
			//5
			int	    LFootLength             = resultSet.getInt("left_length");
			int	    LFootCWeith             = resultSet.getInt("left_weighted_thickness");
			int	    LFootCRegu              = resultSet.getInt("left_regular_thickness");
			int	    LFootWidthWeith        = resultSet.getInt("left_weighted_width");
			int	    LFootWidthRegu         = resultSet.getInt("left_regular_width");
			
			//5
			int	    RFootLength            = resultSet.getInt("right_length");
			int	    RFootCWeith            = resultSet.getInt("right_weighted_thickness");
			int	    RFootCRegu             = resultSet.getInt("right_regular_thickness");
			int	    RFootWidthWeith       = resultSet.getInt("right_weighted_width");
			int	    RFootWidthRegu        = resultSet.getInt("right_regular_width");
			
			//3
			String  hardness 				= resultSet.getString("hardness");
			double recomendSize  	        = resultSet.getDouble("recomend_shoe_size");	
			String thickness 				= resultSet.getString("thickness");
			
			resultMeasurePearson = new ResultMeasuredPearson(measuredPersonId,
															  kana,
															  name,
															  kind,
															  age,
															  height,
															  bodyWeight,
															  ordinaryShoesSize,
															  measuredDate,
															  writtenBy,
															  LFootLength,
															  LFootCWeith,
															  LFootCRegu,
															  LFootWidthWeith,
															  LFootWidthRegu,
															  RFootLength,
															  RFootCWeith,
															  RFootCRegu,
															  RFootWidthWeith,
															  RFootWidthRegu,
															  hardness,
															  recomendSize,
															  thickness);
			
			resultMeasuredPearsonList.add(resultMeasurePearson);
		}
		
		return resultMeasuredPearsonList;
	}
	
	
	//インサートする文
	public int insertInfo (MeasuredPerson mesuredPerson,
						    LeftFoot leftFoot,
						    RightFoot rightFoot,
						    ResultMeasure resultMeasure) {
		
		int result_numOfInsert = 0;
		
		String sql = "";
		sql = "INSERT INTO measured_foot(name, kana, kind, age, hight, weight, "; //6
		sql += "regular_shoe_size, measured_date, writtenby_person, ";            //7-9
		sql += "left_length, left_weighted_thickness, left_regular_thickness, ";  //10-12
		sql += "left_weighted_width, left_regular_width, ";                       //13-14
		sql += "right_length, right_weighted_thickness, right_regular_thickness, "; //15-17
		sql += "right_weighted_width, right_regular_width, ";                      //18-19
		sql += "result_left_weighted_thickness, result_left_regular_thickness, ";  //20-21
	    sql += "result_left_weighted_width, result_left_regular_width, ";    //22-23
		sql += "result_right_weighted_thickness, result_right_regular_thickness, ";  //24-5
		sql += "result_right_weighted_width, result_right_regular_width, ";         //26-27
		sql += "hardness, recomend_shoe_size, thickness)";                                       //28-30
		
		sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
	
		/* PostgreSQLへの接続 */
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement st = con.prepareStatement(sql);) {
			
			//SQL文の?部分を置き換え
			st.setString(1, mesuredPerson.getName());
			st.setString(2, mesuredPerson.getKana());
			st.setString(3, mesuredPerson.getKind());
			st.setInt(4, mesuredPerson.getAge());
			st.setInt(5, mesuredPerson.getHeight());
			st.setInt(6, mesuredPerson.getBodyWeight());
			
			st.setDouble(7, mesuredPerson.getOrdinaryShoesSize());
//			st.setDate(8, new java.sql.Date(new Date().getTime())); //日付取得
			st.setString(8, mesuredPerson.getMeasuredDate()); //日付取得
			st.setString(9, mesuredPerson.getWrittenBy());			
			
			st.setInt(10, leftFoot.getLFootLength()); //左足の足長
			st.setInt(11, leftFoot.getLFootCWeith());//体重のかかった時の左足の太さ
			st.setInt(12, leftFoot.getLFootCRegu());//通常時の左足の太さ
			
			st.setInt(13, leftFoot.getLFootWidthWeith());//体重のかかった時の左足の幅
			st.setInt(14, leftFoot.getLFootWidthRegu());//通常時の左足の幅
			
					
			st.setInt(15, rightFoot.getRFootLength());  //右足の足長
			st.setInt(16, rightFoot.getRFootCWeith());  //体重のかかった時の右足の太さ
			st.setInt(17, rightFoot.getRFootCRegu());  //通常時の右足の太さ
			
			st.setInt(18, rightFoot.getRFootWidthWeith());  //体重のかかった時の右足の幅
			st.setInt(19, rightFoot.getRFootWidthRegu());  //通常時の右足の幅
			
						
			st.setString(20, resultMeasure.getResult_Left_Weighted_Thickness());//体重のかかった時の左足の太さの結果
			st.setString(21, resultMeasure.getResult_Left_Regular_Thickness());//通常時の左足の太さの結果
			
			st.setString(22, resultMeasure.getResult_Left_Weighted_Width());//体重のかかった時の左足の幅の結果
			st.setString(23, resultMeasure.getResult_Left_Regular_Width());//通常時の左足の幅の結果
			st.setString(24, resultMeasure.getResult_Right_Weighted_Thickness());//体重のかかった時の右足の太さ
			st.setString(25, resultMeasure.getResult_Right_Regular_Thickness());//通常時の右足の太さの結果
			st.setString(26, resultMeasure.getResult_Right_Weighted_Width());//体重のかかった時の右足の幅の結果
			st.setString(27, resultMeasure.getResult_Right_Regular_Width());//通常時の右足の幅の結果
			
			st.setString(28, resultMeasure.getHardness());  //硬さ
			st.setDouble(29, resultMeasure.getRecomendSize());         //サイズ
			st.setString(30, resultMeasure.getThickness());    //太さ
			
			result_numOfInsert = st.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
		
		return result_numOfInsert;
	}
	
}
