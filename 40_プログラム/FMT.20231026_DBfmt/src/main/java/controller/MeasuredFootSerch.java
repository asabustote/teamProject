package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.CheckValue;
import measuredLogic.DicideKind;
import model.LeftFoot;
import model.MeasuredPerson;
import model.ResultMeasure;
import model.RightFoot;


@WebServlet("/MeasuredFootSerch")
public class MeasuredFootSerch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメータの取得(16項目ある)
		String kana = request.getParameter("kana");  //ふりがな
		String name = request.getParameter("name");  //氏名
		String kind = request.getParameter("kind");  //性別
		String age = request.getParameter("age");    //年齢
		String day = request.getParameter("day");	//計測日
		String writtenBy = request.getParameter("writtenBy");  //記入者
		
		String LFootLength = request.getParameter("LFootLength");  //左足の足長
		String RFootLength = request.getParameter("RFootLength");  //右足の足長
		
		String LFootCWeith = request.getParameter("LFootCWeith");  //体重のかかった時の左足の太さ
		String RFootCWeith = request.getParameter("RFootCWeith");  //体重のかかった時の右足の太さ
		
		String LFootCRegu = request.getParameter("LFootCRegu");    //通常時の左足の太さ
		String RFootCRegu = request.getParameter("RFootCRegu");    //通常時の右足の太さ
		
		String LFootWidthWeith = request.getParameter("LFootWidthWeith");  //体重のかかった時の左足の幅
		String RFootWidthWeith = request.getParameter("RFootWidthWeith");  //体重のかかった時の右足の幅
		
		String LFootWidthRegu = request.getParameter("LFootWidthRegu");  //通常時の左足の幅
		String RFootWidthRegu = request.getParameter("RFootWidthRegu");  //通常時の右足の幅
		
		String ordinaryShoesSize = request.getParameter("ordinaryShoesSize"); //通常時の靴のサイズ
		String height = request.getParameter("height");                       //身長
		String bodyWeight = request.getParameter("bodyWeight");               //体重
		
		 //レスポンス後に画面に表示する結果のメッセージ
		String message = "";
		
		//入力値のチェックで返すフォワード先を選択
		String forwardPath = "";
		
		//入力値のチェック
		String errMsg = CheckValue.checkNotEnterd(kana, name, kind, age, day, writtenBy, LFootLength, RFootLength,
									LFootCWeith, RFootCWeith, LFootCRegu, 
									RFootCRegu, LFootWidthWeith, RFootWidthWeith, 
									LFootWidthRegu, RFootWidthRegu,
									ordinaryShoesSize, height, bodyWeight);
		/*テスト用*/
//			System.out.println(CheckValue.checkNotEnterd(kana, name, kind, age, writtenBy, LFootLength, RFootLength, 
//								LFootCWeith, RFootCWeith, LFootCRegu, RFootCRegu, 
//								LFootWidthWeith, RFootWidthWeith, LFootWidthRegu, RFootWidthRegu, 
//								ordinaryShoesSize, height, bodyWeight));
		
		if("".equals(errMsg)) {
			forwardPath = "WEB-INF/jsp/searchresult.jsp";
		
			//String → int への変換
			int age_int = Integer.parseInt(age);//年齢
			int LFootLength_int = Integer.parseInt(LFootLength); //左足の足長
			int RFootLength_int = Integer.parseInt(RFootLength); //右足の足長
			int LFootCWeith_int = Integer.parseInt(LFootCWeith); //体重のかかった時の左足の太さ
			int RFootCWeith_int = Integer.parseInt(RFootCWeith); //体重のかかった時の右足の太さ
			int LFootCRegu_int = Integer.parseInt(LFootCRegu); //通常時の左足の太さ
			int RFootCRegu_int = Integer.parseInt(RFootCRegu);//通常時の右足の太さ
			int LFootWidthWeith_int = Integer.parseInt(LFootWidthWeith);  //体重のかかった時の左足の幅
			int RFootWidthWeith_int = Integer.parseInt(RFootWidthWeith);  //体重のかかった時の右足の幅
			int LFootWidthRegu_int = Integer.parseInt(LFootWidthRegu); //通常時の左足の幅
			int RFootWidthRegu_int = Integer.parseInt(RFootWidthRegu); //通常時の右足の幅
			Double ordinaryShoesSize_double = Double.parseDouble(ordinaryShoesSize);//通常時の靴のサイズ
			int height_int = Integer.parseInt(height);//身長
			int bodyWeight_int = Integer.parseInt(bodyWeight);//体重
		
		
		
		DicideKind dicideKind = new DicideKind();
		ResultMeasure resultMeasure = dicideKind.dicideKind(kind, 
																 RFootLength_int, 
																 RFootCWeith_int, 
																 RFootCRegu_int, 
																 RFootWidthWeith_int, 
																 RFootWidthRegu_int, 
																 LFootLength_int, 
																 LFootCWeith_int, 
																 LFootCRegu_int, 
																 LFootWidthWeith_int, 
																 LFootWidthRegu_int);
		
		MeasuredPerson measuredPerson = new MeasuredPerson (kana, 
														   name, 
														   kind, 
														   age_int, 
														   writtenBy, 
														   ordinaryShoesSize_double, 
														   height_int, 
														   bodyWeight_int,
														   day);
		
		//引数5つ
		LeftFoot leftFoot = new LeftFoot (LFootLength_int,
										   LFootCWeith_int,
										   LFootCRegu_int,
										   LFootWidthWeith_int,
										   LFootWidthRegu_int);
		
		//引数5つ
		RightFoot rightFoot = new RightFoot (RFootLength_int,
										   RFootCWeith_int,
										   RFootCRegu_int,
										   RFootWidthWeith_int,
										   RFootWidthRegu_int);
		
		//セッションスコープの取得
		HttpSession session = request.getSession(); 
		
		//セッションスコープに格納
		session.setAttribute("measuredPerson", measuredPerson);
		session.setAttribute("leftFoot", leftFoot);
		session.setAttribute("rightFoot", rightFoot);
		session.setAttribute("resultMeasure", resultMeasure);
		//入力情報や結果をDBに登録
//		MeasuredFootDAO dao = new MeasuredFootDAO();
//		dao.insertInfo(measuredPerson, leftFoot, rightFoot, resultMeasure);
		}else {
			forwardPath = "index.jsp";
			
			message = errMsg;
		}
		
		// 結果messageをリクエストスコープに保存
				request.setAttribute("message", message);
		
		//フォワード先の指定
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

}
