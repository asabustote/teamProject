package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MeasuredFootDAO;
import logic.ConvertToCsv;
import model.searchMeasuredPerson.ResultMeasuredPearson;
import model.searchMeasuredPerson.SearchParams;

/**
 * Servlet implementation class ExportFile
 */
@WebServlet("/ExportFile")
public class ExportFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの値を取得(CSV出力したい被測定者のIDが取れる)
		String[] measuredPersonId_array = request.getParameterValues("checked");
		
		if (measuredPersonId_array == null) {
			
			String msgOfCsvError = "CSVファイルとして出力したい被測定者を選択してください。";
			
			request.setAttribute("msgOfCsvError", msgOfCsvError);
			
			//検索条件で再検索を行う、
			//データベースから再度検索した被測定者情報を取得し
			//リクエストスコープに検索結果を保持したリストを格納する
			this.setResearchResultToRequestScope(request);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/searchMeasuredPerson.jsp");
			requestDispatcher.forward(request, response);
		} else {
			
			//被測定者IDを基にデータベースからCSV出力する被測定者情報取得
			//しリストを生成する
			List<ResultMeasuredPearson> exportToCsvList = this.createMeasuredPersonsCsvList(measuredPersonId_array);
			
			ConvertToCsv convertToCsv = new ConvertToCsv();
			String dataOfCsv = convertToCsv.createCsvData(exportToCsvList);
			
			// CSV情報をレスポンスに書き出し。
			// （ContentTypeヘッダをtext/csvとすることで、ブラウザは
			//   送り返されるレスポンス情報を、	HTMLではなくCSVであると認識する）
			response.setContentType("text/csv; charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename=measuredPerson.csv");
			PrintWriter out = response.getWriter();
			out.print(dataOfCsv);
			
		}
		
	}
	
	/*
	 * 
	 * 利用方法：CSV出力する為の被測定者情報を持つリストを生成 
	 * 引数    ：String[] measuredPersonId_array ←CSV出力したい被測定者情報のIDが格納されている配列
	 * 戻り値  ：List<ResultMeasuredPearson>　　 ←CSV出力したい被測定者情報を持つリスト
	 * 
	 */
	private List<ResultMeasuredPearson> createMeasuredPersonsCsvList (String[] measuredPersonId_array) {
		List<ResultMeasuredPearson> exportToCsvMeasuredPersonsList = new ArrayList<ResultMeasuredPearson>();
		MeasuredFootDAO measuredFootDAO = new MeasuredFootDAO();
		for (int i = 0; i < measuredPersonId_array.length; i++) {
			ResultMeasuredPearson resultMeasuredPearsonForCsv = measuredFootDAO.searchMeasuredPersonById(measuredPersonId_array[i]);
			exportToCsvMeasuredPersonsList.add(resultMeasuredPearsonForCsv);
		}
		return exportToCsvMeasuredPersonsList;
	}
	
	
	/*
	 * 利用方法：CSV出力する情報がチェックされていない場合、
	 * 			 検索JSP側で同じ検索内容のテーブルを表示する為に、
	 * 			 同じ検索結果をデータベースから取得する
	 * 引数1   ：HttpServletRequest request
	 * 引数2   ：SearchParams searchParams  検索条件が格納されているクラス
	 * 戻り値  ：List<ResultMeasuredPearson> resultMeasuredPearsonList
	 * 			                                検索結果が格納されたリスト
	 * 
	 */
	private List<ResultMeasuredPearson> resarchMeasuredPerson (SearchParams searchParams) {
//		HttpSession session = request.getSession();
//		SearchParams searchParams = (SearchParams)session.getAttribute("searchParams");
		
		MeasuredFootDAO measuredFootDAO = new MeasuredFootDAO();
		//検索結果の取得
		List<ResultMeasuredPearson> resultMeasuredPearsonList = null;
		
		resultMeasuredPearsonList = measuredFootDAO.searchMeasuredPerson(searchParams);
	
//		request.setAttribute("resultMeasuredPearsonList", resultMeasuredPearsonList);
//		
//		//セッションスコープ内のデータを削除
//		session.removeAttribute("searchParams");
		
		return resultMeasuredPearsonList;
	}
	
	/*
	 * 利用方法：CSV出力する情報がチェックされていない場合、
	 * 			 検索JSP側で同じ検索内容のテーブルを表示する為に、
	 * 			 同じ検索結果をデータベースから取得するしリクエストスコープに格納する
	 * 引数1   ：HttpServletRequest request
	 * 引数2   ：SearchParams searchParams  検索条件が格納されているクラス
	 * 戻り値  ：なし
	 * 
	 */
	private void setResearchResultToRequestScope (HttpServletRequest request) {
		HttpSession session = request.getSession();
		SearchParams searchParams = (SearchParams)session.getAttribute("searchParams");
		
		MeasuredFootDAO measuredFootDAO = new MeasuredFootDAO();
		//検索結果の取得
		List<ResultMeasuredPearson> resultMeasuredPearsonList = null;
		
		resultMeasuredPearsonList = measuredFootDAO.searchMeasuredPerson(searchParams);
	
		request.setAttribute("resultMeasuredPearsonList", resultMeasuredPearsonList);
		//検索結果件数の出力
		int numOfResultSearch    = resultMeasuredPearsonList.size();
		String msgOfResultSearch = "<h2>検索結果：" + numOfResultSearch + "件</h2>";
		request.setAttribute("msgOfResultSearch", msgOfResultSearch);
		
//		//セッションスコープ内のデータを削除
		session.removeAttribute("searchParams");
	}

}
