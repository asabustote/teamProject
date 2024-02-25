<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.searchMeasuredPerson.ResultMeasuredPearson" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>

<%@page import="logic.SelectedValueMapLogic" %>
<%@page import="model.searchMeasuredPerson.SelectedValueMaps" %>
<%@page import="model.searchMeasuredPerson.SearchParams" %>

<%@page  import="logic.OptionTagLogic"%>
<%@page  import="model.searchMeasuredPerson.OptionTagsList"%>

<% List<ResultMeasuredPearson> resultMeasuredPearsonList = (List<ResultMeasuredPearson>)request.getAttribute("resultMeasuredPearsonList"); 
   String msgOfResultSearch = (String)request.getAttribute("msgOfResultSearch");
   
   String msgOfCsvError = (String)request.getAttribute("msgOfCsvError");
      
   SelectedValueMapLogic selectedValueMapLogic = new SelectedValueMapLogic();
   SelectedValueMaps selectedValueMaps = (SelectedValueMaps)request.getAttribute("selectedValueMaps");
   if (selectedValueMaps == null) {
	   selectedValueMaps = (SelectedValueMaps)selectedValueMapLogic.createSelectedValueMapsClass();
   }
   
   //氏名の入力状況を管理するMapを取得
   Map<String,String> inputedValueMapForName  = selectedValueMaps.getInputedValueMapForName();
   String conditionOfNameTag = inputedValueMapForName.get("名前");
   
   //フォームの各オプションタグのリストを持つクラスを生成
   OptionTagLogic optionTagLogic = new OptionTagLogic();
   OptionTagsList optionTagsList = optionTagLogic.createOptionTagListClass(selectedValueMaps,
		   																   selectedValueMapLogic);
   //フォームの各オプションタグのリストを持つクラスがらリストを取得
   List<String> decadeOptionList    = optionTagsList.getDecadeOptionTagList();
   List<String> kindOptionList      = optionTagsList.getKindOptionTagList();
   List<String> hardnessOptionList  = optionTagsList.getHardnessOptionTagList();
   List<String> thicknessOptionList = optionTagsList.getThicknessOptionTagList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--CSSです。--%>
<style type="text/css">
<%--各ボックスの位置のCSSです。--%>
.example2{
    text-align: center;
}
.example3{
    text-align: right;
}
<%--submit resetボタンのCSSです。 --%>
.button {
  display       : inline-block;
  border-radius : 20%;          /* 角丸       */
  font-size     : 16pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 12px 12px;   /* 余白       */
  background    : #ffffff;     /* 背景色     */
  color         : #000000;     /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  transition    : .3s;         /* なめらか変化 */
  box-shadow    : 6px 6px 3px #666666;  /* 影の設定 */
  border        : 2px solid #ffffff;    /* 枠の指定 */
}
.button:hover {
  box-shadow    : none;        /* カーソル時の影消去 */
  color         : #ffffff;     /* 背景色     */
  background    : #000000;     /* 文字色     */
}
.s01{
  text-anchor: start; dominant-baseline: hanging;
  &.active{
    stroke-dasharray: 500; //線の間隔
    stroke: #333;
    animation-name: kf_s01;
    animation-duration: 2s;
    animation-fill-mode: forwards;
  }
}
<%--tableタグのCSS--%>
.table {
  table-layout: fixed;
  width: 600;
  max-width: 1000;
  margin: 50px auto;
  border-spacing: 0;
  border-collapse: separate;
  border-radius: 10px;
  border-top: 1px solid #000066;
  border-left: 1px solid #000066;
}
th {
 padding: 10px;
 background-color: #e3faf8;
 border: solid 1px #748ca5;
 border-right: 1px solid #000066;
 border-bottom: 1px solid #000066;
}
td {
 padding: 10px;
 border: solid 1px #748ca5;
 border-right: 1px solid #000066;
 border-bottom: 1px solid #000066;
}
td:first-child {
 background: #e3faf8;
 font-weight: bold;
}
.table tr:first-child th {
  border-radius: 10px 0 0 0;
}
.table tr:first-child td {
  border-radius: 0 10px 0 0;
}
.table tr:last-child th {
  border-radius: 0 0 0 10px;
}
.table tr:last-child td {
  border-radius: 0 0 10px 0;
}
</style>
<%--ここまでCSS--%>
<title>被測定者検索画面</title>
</head>
<body>
  <h1 align="center">被測定者検索</h1>
  <% if (msgOfCsvError != null) { %>
    <p align="center"><%= msgOfCsvError %><p>
  <% } %>
  <form action="SearchMeasuredPerson" method="post">
  	<table align="center" class="table">
  	<tbody>
  	  <tr>
  	    <th>名前：</th>
  	    <td><input type="text" name="search_name" <%= conditionOfNameTag %>></td>
  	  </tr>
  	    <tr>
  	    <th>年代：</th>
  	    <td>
  	      <select name="decade">
  	        <option value="unselected">年代を選択してください。</option>   
  	        <% for (String decadeOption : decadeOptionList) { %>
  	        	<%= decadeOption %>
  	        <% } %>  
  	      </select>
  	    </td>
  	  </tr>
  	  <tr>
  	  	<th>性別（男性・女性・子ども）：</th>
  	  	<td>
  	      <select name="kind">
  	        <option value="unselected">性別（男性・女性・子ども）を選択してください。</option>
  	        <% for (String kindOption : kindOptionList) { %>
  	        	<%= kindOption %>
  	        <% } %>  
  	      </select>
  	    </td>
  	  </tr>
  	  <tr>
  	    <th>硬さ：</th>
  	    <td><select name="hardness">
  	        <option value="unselected">硬さを選択してください。</option>
  	        <% for (String hardnessOption : hardnessOptionList) { %>
  	        	<%= hardnessOption %>
  	        <% } %> 
  	      </select>
  	     </td>
  	  </tr>
  	  <tr>
  	    <th>太さ：</th>
  	    <td><select name="thickness">
  	        <option value="unselected">太さを選択してください。</option>
  	        <% for (String thicknessOption : thicknessOptionList) { %>
  	        	<%= thicknessOption %>
  	        <% } %> 
  	      </select>
  	     </td>
  	  </tr>
  	 </tbody>
  	</table> 
  	<div class="example2"> 
  	<input type="submit" value="検索" class="button">
  	<input type="reset" value="入力内容のクリア" class="button">
  	</div>
  </form>
  <% if (resultMeasuredPearsonList != null) {%>
	  <p><%= msgOfResultSearch %></p>
  <%}%>
  <%if (resultMeasuredPearsonList != null) { %>
  <form action="ExportFile" method="post">
    <table border="1" align="center" class="table">
    <tbody>
      <tr>
        <th>選択</th>
        <th>被測定者ID</th>
        <th>ふりがな</th>
        <th>氏名</th>
        <th>性別（男性・女性・子ども）</th>
        <th>年齢</th>
        <th>身長</th>
        <th>体重</th>
        <th>通常時の靴のサイズ</th>
        <th>測定日</th>
        <th>記入者</th>
        <th>左足の足長さ</th>
        <th>左足の体重のかかった時の左足の太さ</th>
        <th>左足の通常時の左足の太さ</th>
        <th>左足の体重のかかった時の左足の幅</th>
        <th>左足の通常時の幅</th>
        <th>右足の足長さ</th>
        <th>右足の体重のかかった時の左足の太さ</th>
        <th>右足の通常時の左足の太さ</th>
        <th>右足の体重のかかった時の左足の幅</th>
        <th>右足の通常時の幅</th>
        <th>硬さ</th>
        <th>最適なサイズ</th>
        <th>太さ</th>
      </tr>
      <%for (int i = 0; i < resultMeasuredPearsonList.size(); i++) { %>
      <tr>
        <td><label><input type="checkbox" name="checked" value="<%= resultMeasuredPearsonList.get(i).getMeasuredPersonId() %>"></label></td>
        <td><%= resultMeasuredPearsonList.get(i).getMeasuredPersonId() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getKana() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getName() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getKind() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getAge() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getHeight() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getBodyWeight() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getOrdinaryShoesSize() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getMeasuredDate() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getWrittenBy() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getLFootLength() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getLFootCWeith() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getLFootCRegu() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getLFootWidthWeith() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getLFootWidthRegu() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getRFootLength() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getRFootCWeith() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getRFootCRegu() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getRFootWidthWeith() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getRFootWidthRegu() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getHardness() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getRecomendSize() %></td>
        <td><%= resultMeasuredPearsonList.get(i).getThickness() %></td>
      </tr>
      <% }%>
      </tbody>
    </table>
    <div class="example3">
    <input type="submit" value="CSV出力" align="right" class="button">
    </div>
  </form>
  <%}%>
  <div class="example2">
  <form action="Direction" method="get">
    <input type="submit" name="direction" value="計測画面へ" class="button">
    <input type="submit" name="direction" value="ログアウト" class="button">
  </form>
  </div>
</html>