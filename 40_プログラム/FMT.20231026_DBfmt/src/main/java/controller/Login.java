package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginUserDAO;
import logic.CheckValue;
import logic.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメータの取得
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");
		
		//Userをインスタンス化してリクエストパラメータの入力値をフィールドに持つ
		User user = new User(loginId, pass);
		
		LoginUserDAO loginUserDAO = new LoginUserDAO();
		
		LoginLogic loginLogic = new LoginLogic();
		
		 //レスポンス後に画面に表示する結果のメッセージ
		String message = "";
		
		//入力値のチェックで返すフォワード先を選択
		String forwardPath = "";
		
		//入力値のチェック
		String errMsg = CheckValue.CheckValueLogin(user, loginUserDAO.findAll());
		
		if(loginLogic.execute(user, loginUserDAO.findAll())) {
			forwardPath = "WEB-INF/jsp/searchMeasuredPerson.jsp";
		
//			loginLogic.execute(user, loginUserDAO.findAll());
			
		} else {
			forwardPath = "WEB-INF/jsp/login.jsp";
			
			message = errMsg;
		}
		
		//結果messageをリクエストスコープに保存
		request.setAttribute("message", message);
		
		//フォワード先の指定
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
		
		
	}

}
