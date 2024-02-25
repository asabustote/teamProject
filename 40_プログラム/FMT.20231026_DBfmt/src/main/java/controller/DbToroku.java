package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MeasuredFootDAO;
import model.LeftFoot;
import model.MeasuredPerson;
import model.ResultMeasure;
import model.RightFoot;


@WebServlet("/DbToroku")
public class DbToroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//セッションスコープの取得
		MeasuredPerson measuredPerson = (MeasuredPerson)session.getAttribute("measuredPerson");

		LeftFoot leftFoot = (LeftFoot)session.getAttribute("leftFoot");

		RightFoot rightFoot =(RightFoot)session.getAttribute("rightFoot");
		
		ResultMeasure resultMeasure = (ResultMeasure)session.getAttribute("resultMeasure");
		
		
		//入力情報や結果をDBに登録
		MeasuredFootDAO dao = new MeasuredFootDAO();
		dao.insertInfo(measuredPerson, leftFoot, rightFoot, resultMeasure);
		
		//セッションスコープを破棄
		session.invalidate();
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/jsp/FootSizeMeasuredDBToroku.jsp");
		dispatcher.forward(request, response);
	}
}