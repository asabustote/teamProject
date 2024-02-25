package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MeasuredFootDAO;
import logic.SelectedValueMapLogic;
import model.searchMeasuredPerson.ResultMeasuredPearson;
import model.searchMeasuredPerson.SearchParams;
import model.searchMeasuredPerson.SelectedValueMaps;


@WebServlet("/SearchMeasuredPerson")
public class SearchMeasuredPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメータの取得
		//measuredPersonIdは渡って来ない為、初期値として0を設定
		//検索メソッド統合時に利用予定 Oct 19th 23
//		int    initialNum = 0;
//		int    measuredPersonId = initialNum;
		String name               = request.getParameter("search_name"); //氏名
		String decade             = request.getParameter("decade");    //年代	
		String kind               = request.getParameter("kind");     //性別（男性・女性・子ども）	
		String hardness           = request.getParameter("hardness"); //硬さ
		String thickness          = request.getParameter("thickness");//太さ	
		//入力値のチェック
		
		//検索条件クラスの生成
		SearchParams searchParams= new SearchParams(name,
													  kind,
										  			  decade,
										  			  hardness,
										  			  thickness);
		
		//再検索用に検索条件クラスをセッションスコープに格納
		HttpSession session = request.getSession();
		session.setAttribute("searchParams", searchParams);
		
		MeasuredFootDAO measuredFootDAO = new MeasuredFootDAO();
		//検索結果の取得
		List<ResultMeasuredPearson> resultMeasuredPearsonList = null;
		
		resultMeasuredPearsonList = measuredFootDAO.searchMeasuredPerson(searchParams);
		
		
		//検索結果件数の出力
		int numOfResultSearch    = resultMeasuredPearsonList.size();
		String msgOfResultSearch = "<h2>検索結果：" + numOfResultSearch + "件</h2>";
		request.setAttribute("msgOfResultSearch", msgOfResultSearch);
		
		
		SelectedValueMapLogic selectedValueMapLogin = new SelectedValueMapLogic();
		SelectedValueMaps     selectedValueMaps = null;
		
		//選択状態を保持しているマップのをフィールドにもつクラスを生成
		
			selectedValueMaps = selectedValueMapLogin.createCheckedSelectedValueMapsClass(searchParams);	
		
		//選択状態を保持しているマップのをフィールドにもつクラスをリクエストスコープへ格納
		request.setAttribute("selectedValueMaps", selectedValueMaps);
		
		//検索結果をスコープへ設定
		request.setAttribute("resultMeasuredPearsonList", resultMeasuredPearsonList);
		//フォワード先の設定
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/searchMeasuredPerson.jsp");
		dispatcher.forward(request, response);
	}

}
