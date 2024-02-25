package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Direction")
public class Direction extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String direction = request.getParameter("direction");
		
		String forwardPath = "";
		
		
		if ("ログイン画面へ".equals(direction)) {
			forwardPath = "WEB-INF/jsp/login.jsp";
		} else if ("計測画面へ".equals(direction)) {
			forwardPath = "index.jsp";
		} else if ("ログアウト".equals(direction)) {
			forwardPath = "WEB-INF/jsp/login.jsp";
			String logoutMessage = "ログアウトしました。";
			request.setAttribute("message", logoutMessage);
			
		} else {
			forwardPath = "MeasuredFootSerch";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

}
