package logic;

import java.util.List;

import dao.LoginUserDAO;
import model.User;

public class CheckValue {

	
	//入力チェック
	/*
	 * 未入力の値があった場合、エラーメッセージを返すメソッド
	 * 
	 * 戻り値：String errMsg;
	 * 
	 * */
	/*
	 * Nullか空文字かをチェックする
	 * 戻り値：true/false
	 * 
	 * true :値は入力されている
	 * false:値は未入力
	 * */
	
	public static boolean isInputed (String value) {
		boolean result = true;
		
		if (value == null) {
			result = false;
		} else if ("".equals(value)) {
			result = false;
		}
		
		return result;
	}
	
	//
	/*未入力チェックをするメソッド
	 * 戻り値：String
	 * 
	 * 
	 */
	//Think:StringBuffer or Listに変更を検討 Oct.10.23
	//willFix:もはや
	public static String checkNotEnterd (String kana,
										  String name,
										  String kind,
										  String age,
										  String day,
										  String writtenBy,   //記入者
										  String LFootLength, //左足の足長さ
										  String RFootLength, //右足の足長さ
										  String LFootCWeith,  //weighted左足の足囲	
										  String RFootCWeith,  //weighted右足の足囲
										  String LFootCRegu,  //通常時の左足の足囲
										  String RFootCRegu,
										  String LFootWidthWeith,
										  String RFootWidthWeith,
										  String LFootWidthRegu,
										  String RFootWidthRegu,
										  String ordinaryShoesSize, //通常時の靴のサイズ
										  String height,			//身長
										  String bodyWeight         //体重
										  ) {
		String errMessage = "";
		
		//必須項目チェック
		if ("".equals(kana)) {
			errMessage += "ふりがなは必須項目です。<br>";
		}
		//正規表現を用いてふりがなはひらがな入力以外エラーメッセージを返す
		if(!isHiragana(kana)) {
			errMessage += "ふりがなはひらがなで入力してください。<br>";
		}
		
		if ("".equals(name)) {
			errMessage += "お名前は必須項目です。<br>";
		}
		
		if (kind == null) {
			errMessage += "性別は必須項目です。<br>";
		}
		
		if("".equals(age)) {
			errMessage += "年齢は必須項目です。<br>";
		}
		
		if("".equals(day)) {
			errMessage += "計測日は必須項目です。<br>";
		}
		
		if ("".equals(writtenBy	)) {
			errMessage += "記入者は必須項目です。<br>";
		}
		
		if ("".equals(LFootLength)) {
			errMessage += "左足の足長は必須項目です。<br>";
		}
		
		if ("".equals(RFootLength)) {
			errMessage += "右足の足長は必須項目です。<br>";
		}
		
		if ("".equals(LFootCWeith)) {
			errMessage += "左足の足囲体重のかかった太さは必須項目です。<br>";
		}
		
		if ("".equals(RFootCWeith)) {
			errMessage += "右足の足囲体重のかかった太さは必須項目です。<br>";
		}
		
		if ("".equals(LFootCRegu)) {
			errMessage += "左足の足囲体重のかからない太さは必須項目です。<br>";
		}
		
		if ("".equals(RFootCRegu)) {
			errMessage += "右足の足囲体重のかからない太さは必須項目です。<br>";
		}
		
		if ("".equals( LFootWidthWeith)) {
			errMessage += "左足の足幅体重のかかった太さは必須項目です。<br>";
		}
		
		if ("".equals( RFootWidthWeith)) {
			errMessage += "右足の足幅体重のかかった太さは必須項目です。<br>";
		}
		
		if ("".equals(LFootWidthRegu)) {
			errMessage += "左足の足幅体重のかからない太さは必須項目です。<br>";
		}

		if ("".equals(RFootWidthRegu)) {
			errMessage += "右足の足幅体重のかからない太さは必須項目です。<br>";
		}
		if ("".equals(ordinaryShoesSize)) {
			errMessage += "普段の靴のサイズは必須項目です。<br>";
		}
		if ("".equals(height)) {
			errMessage += "身長は必須項目です。<br>";
		}
		if ("".equals(bodyWeight)) {
			errMessage += "体重は必須項目です。<br>";
		}
		
		//文字数(桁数)チェック
		if (age.length() != 1 && age.length() != 2) {
			errMessage += "年齢は1桁または2桁で入力してください。<br>";
		}
		
		if (LFootLength.length() != 3) {
			errMessage += "左足の足長は3桁で入力してください。<br>";
		}
		
		if (RFootLength.length() != 3) {
			errMessage += "右足の足長は3桁で入力してください。<br>";
		}
		
		if (LFootCWeith.length()  != 2 && LFootCWeith.length() != 3) {
			errMessage += "左足の足囲体重のかかった太さは2桁または3桁で入力してください。<br>";
		}
		
		if (RFootCWeith.length()  != 2 && RFootCWeith.length() != 3) {
			errMessage += "右足の足囲体重のかかった太さは2桁または3桁で入力してください。<br>";
		}
		
		if (LFootCRegu.length()  != 2 && LFootCRegu.length() != 3) {
			errMessage += "左足の足囲体重のかからない太さは2桁または3桁で入力してください。<br>";
		}
		
		if (RFootCRegu.length()  != 2 && RFootCRegu.length() != 3) {
			errMessage += "右足の足囲体重のかからない太さは2桁または3桁で入力してください。<br>";
		}
		
		if (LFootWidthWeith.length() != 2 && LFootWidthWeith.length() != 3) {
			errMessage += "左足の足幅体重のかかった太さは2桁または3桁で入力してください。<br>";
		}
		
		if (RFootWidthWeith.length() != 2 && RFootWidthWeith.length() != 3) {
			errMessage += "右足の足幅体重のかかった太さは2桁または3桁で入力してください。<br>";
		}
		
		if (LFootWidthRegu.length() != 2 && LFootWidthWeith.length() != 3) {
			errMessage += "左足の足幅体重のかからない太さは2桁または3桁で入力してください。<br>";
		}

		if (RFootWidthRegu.length() != 2 && RFootWidthRegu.length() != 3) {
			errMessage += "右足の足幅体重のかからない太さは2桁または3桁で入力してください。<br>";
		}
		if (ordinaryShoesSize.length() != 4) {
			errMessage += "普段の靴のサイズは4桁で入力してください。<br>";
		}
		if (height.length() != 2 && height.length() != 3) {
			errMessage += "身長は2桁または3桁で入力してください。<br>";
		}
		if (bodyWeight.length() != 2 && bodyWeight.length() != 3) {
			errMessage += "体重は2桁から3桁で入力してください。<br>";
		}
		
		//整数チェック
		if(!isConvertInt(age)) {
			errMessage += "年齢は整数を入力してください。<br>";
		}
		
		if(!isConvertInt(LFootLength)) {
			errMessage += "左足の足長は整数を入力してください。<br>";
		}
		
		if(!isConvertInt(RFootLength)) {
			errMessage += "左足の足長は整数を入力してください。<br>";
		}
		
		if(!isConvertInt(LFootCWeith)) {
			errMessage += "左足の足囲体重のかかった太さは整数を入力してください。<br>";
		}
		
		if(!isConvertInt(RFootCWeith)) {
			errMessage += "右足の足囲体重のかかった太さは整数を入力してください。<br>";
		}
		
		if(!isConvertInt(LFootCRegu)) {
			errMessage += "左足の足囲体重のかからない太さは整数を入力してください。<br>";
		}
		
		if(!isConvertInt(RFootCRegu)) {
			errMessage += "右足の足囲体重のかからない太さは整数を入力してください。<br>";
		}
		
		if(!isConvertInt(LFootWidthWeith)) {
			errMessage += "左足の足幅体重のかかった太さは整数を入力してください。<br>";
		}
		
		if(!isConvertInt(RFootWidthWeith)) {
			errMessage += "右足の足幅体重のかかった太さは整数を入力してください。<br>";
		}
		
		if(!isConvertInt(LFootWidthRegu)) {
			errMessage += "左足の足幅体重のかからない太さは整数を入力してください。<br>";
		}
		
		if(!isConvertInt(RFootWidthRegu)) {
			errMessage += "右足の足幅体重のかからない太さは整数を入力してください。<br>";
		}
		
		if(!isConvertDouble(ordinaryShoesSize)) {
			errMessage += "普段の靴のサイズは整数を入力してください。<br>";
		}
		
		if(!isConvertInt(height)) {
			errMessage += "身長は整数を入力してください。<br>";
		}
		
		if(!isConvertInt(bodyWeight)) {
			errMessage += "体重は整数を入力してください。<br>";
		}
		
		return errMessage;
			
	}
	//渡された文字列がint型に変換可能かチェックします。
	public static boolean isConvertInt(String val) {
		if (!"".equals(val)) {
			try {
				Integer.parseInt(val);
			} catch (NumberFormatException e) {
				return false;
			}
		}

		return true;
	}
	
	//渡された文字列がdouble型に変換可能かチェックします。
		public static boolean isConvertDouble(String val) {
			if (!"".equals(val)) {
				try {
					Double.parseDouble(val);
				} catch (NumberFormatException e) {
					return false;
				}
			}

			return true;
		}
	
		public static boolean isHiragana(String text) {
		    // ひらがなの正規表現
		    return text.matches("^[ぁ-ん]+$");
		}
	
		//ログインページの入力値のチェック
	public static String CheckValueLogin(User user, List<User> userList) {
		String errMsg = "";
		
		LoginUserDAO loginUserDAO = new LoginUserDAO();
		
		LoginLogic loginLogic = new LoginLogic();
		
		loginLogic.execute(user, loginUserDAO.findAll());
		
		//必須項目チェック
		
		
		
		for(int i = 0; i < userList.size(); i++) {
			
//			if(!userList.get(i).getLoginId().equals(user.getLoginId()) &&
//					userList.get(i).getPass().equals(user.getPass())) {
//				System.out.println("ユーザー入力:" + user.getLoginId());
//				System.out.println(userList.get(i).getLoginId());
//				
//				errMsg ="管理者IDが違います。<br>";
//				
//			}
//			if(userList.get(i).getLoginId().equals(user.getLoginId()) &&
//					!userList.get(i).getPass().equals(user.getPass())) {
//				System.out.println("ユーザー入力:" + user.getLoginId());
//				System.out.println(userList.get(i).getLoginId());
//				
//				errMsg ="パスワードが違います。<br>";
//				
//			}
			if(!userList.get(i).getLoginId().equals(user.getLoginId()) ||
					!userList.get(i).getPass().equals(user.getPass())) {
				System.out.println("ユーザー入力:" + user.getLoginId());
				System.out.println(userList.get(i).getLoginId());
				
				errMsg ="管理者IDまたはパスワードが違います。<br>";
			}
			
//			if(!userList.get(i).getPass().equals(user.getPass())){
//				System.out.println("ユーザー入力:" + user.getPass());
//				System.out.println(userList.get(i).getPass());
//			
//				errMsg += "パスワードが違います。<br>";
//			}
			break;
		}
//			for(int j = 0; j < userList.size(); j++) {
//				if(!userList.get(j).getPass().equals(user.getPass())){
//					System.out.println("ユーザー入力:" + user.getPass());
//					System.out.println(userList.get(j).getPass());
//				
//					errMsg = "パスワードが違います。<br>";
//				}
//			}
	
			if(user.getPass().length() < 8 || user.getPass().length() > 16) {
				errMsg += "パスワードは8文字以上16文字以下で入力してください。<br>";
			}
		return errMsg;
	}
//		public static booolean isDouble(String no) {
//			//○○.○の正規表現
//		}
//	
//	String kana = request.getParameter("kana");
//	String name = request.getParameter("name");
//	String kind = request.getParameter("kind");
//	String age = request.getParameter("age");
//	String writtenBy = request.getParameter("writtenBy");
//	
//	String LFootLength = request.getParameter("LFootLength");
//	String RFootLength = request.getParameter("RFootLength");
//	
//	String LFootCWeith = request.getParameter("LFootCWeith");
//	String RFootCWeith = request.getParameter("RFootCWeith");
//	
//	String LFootCRegu = request.getParameter("LFootCRegu");
//	String RFootCRegu = request.getParameter("RFootCRegu");
//	
//	String LFootWidthWeith = request.getParameter("LFootWidthWeith");
//	String RFootWidthWeith = request.getParameter("RFootWidthWeith");
//	
//	String LFootWidthRegu = request.getParameter("LFootWidthRegu");
//	String RFootWidthRegu = request.getParameter("RFootWidthRegu");
//	
//	String ordinaryShoesSize = request.getParameter("ordinaryShoesSize");
//	String height = request.getParameter("height");
//	String bodyWeight = request.getParameter("bodyWeight");
//	
	//3桁かのチェック
}
