<%@ page import="model.MeasuredPerson"%>
<%@ page import="model.LeftFoot" %>
<%@ page import="model.RightFoot" %>
<%@ page import="model.ResultMeasure" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//セッションスコープの取得
MeasuredPerson measuredPerson = (MeasuredPerson)session.getAttribute("measuredPerson");

LeftFoot leftFoot = (LeftFoot)session.getAttribute("leftFoot");

RightFoot rightFoot =(RightFoot)session.getAttribute("rightFoot");

ResultMeasure resultMeasure = (ResultMeasure)session.getAttribute("resultMeasure");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--CSSです。--%>
<%--submit resetボタンのCSSです。 --%>
<style type="text/css">
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
<%--各ボックスの位置のCSSです。--%>
.example2{
    text-align: center;
}
.example3{
    text-align: right;
}
<%--画面上部のCSS--%>
@keyframes kf_s01 {
  0%{
    stroke-dashoffset: 500; //線の開始位置
    stroke-width: 1px;
    fill: transparent;
  }
  40% {
    fill: transparent;
  }
  60% {
    stroke-width: 1px;
  }
  90% {
    stroke-dashoffset: 0;
  }
  100% {
    stroke-width: 0px;
    fill: #333;
  }
}
<%--結果のCSSです。--%>
.c01{
  position: relative; color: white;
  &::before{
    content: ""; position: absolute; z-index: 1; top: 0%; right: 100%; bottom: 0%; left: 0%;
    background : #00FFFF;
  }
  &.active{
    animation-name: kf_c01a;
    animation-duration: 2.0s;
    animation-delay: 2.0s;
    animation-fill-mode: forwards;
    &::before{
      animation-name: kf_c01b;
      animation-duration: 1.5s;
      animation-delay: 1.5s;
      animation-fill-mode: forwards;
    }
  }
}
@keyframes kf_c01a {
  100%{
    color: inherit;
  }
}
@keyframes kf_c01b {
  50%{
    left: 0%; right: 0%;
  }
  100%{
    left: 100%; right: 0%;
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

<title>足サイズ計測表・結果</title>
</head>
<body>
<h1><svg viewbox="0 0 520 60">
  <text class="s01 active" x="60" y="10">🌟👣足サイズ計測表👣🌟</text>
  	</svg></h1><br>
  <div class="c01 active" align="center"><h1>👟結果👟</h1></div>
<table2 align="left" width="100" height="100">
	<tr>
		<td>計測日:<%= measuredPerson.getMeasuredDate() %><br></td>
	</tr>
	<tr>
		<td>記入者:<%= measuredPerson.getWrittenBy() %></td>
	</tr>
</table>
<br>
<table2 width="100" height="100">
	<tr>
		<td>ふりがな:<%= measuredPerson.getKana() %></td>
　		<td>お名前:<%= measuredPerson.getName() %></td>
	</tr>
</table2>
<br>
<table2 width="100" height="100">
<tr>
	<td>　性別:<%= measuredPerson.getKind() %></td>
	<td>年齢:<%=measuredPerson.getAge() %></td>
</tr>
</table2>
<hr>
<table align="center" border="1" cellpadding="2" class="table" width="500" height="200">
<tbody>
	<tr>
		<th colspan="2"><%-- 硬め・普通・柔らかめ--%><%= resultMeasure.getHardness()%></th>
	</tr>
	<tr>
		<td align="center" valign="middle">サイズ</td>
		<td align="center" valign="middle"><%=resultMeasure.getRecomendSize() %>cm</td>
	</tr>
	<tr>
		<td align="center" valign="middle">太さ</td>
		<td align="center" valign="middle"><%-- 細め・普通・太め--%><%=resultMeasure.getThickness() %></td>
	</tr>
</tbody>
</table>
<table border="1" cellpadding="5" class="table">
<tbody>
	<tr>
		<th></th>
		<th colspan="2" width="200">左</th>
		<th colspan="2" width="200">右</th>
	</tr>
	<tr><td>足長</td>
		<td colspan="2" align="center"><%=leftFoot.getLFootLength() %>mm</td>
		<td colspan="2" align="center"><%=rightFoot.getRFootLength() %>mm</td>
	</tr>
	<tr>
		<td>体重のかかった太さ</td>
		<td align="center"><%=leftFoot.getLFootCWeith() %>mm</td>
		<td width="20"><%=resultMeasure.getResult_Left_Weighted_Thickness() %></td>
		<td align="center"><%=rightFoot.getRFootCWeith() %>mm</td>
		<td width="20"><%=resultMeasure.getResult_Right_Weighted_Thickness() %></td>	
	</tr>
	<tr>
		<td>体重のかからない太さ</td>
		<td align="center"><%=leftFoot.getLFootCRegu() %>mm</td>
		<td width="20"><%=resultMeasure.getResult_Left_Regular_Thickness() %></td>
		<td align="center"><%=rightFoot.getRFootCRegu() %>mm</td>
		<td width="20"><%=resultMeasure.getResult_Right_Regular_Thickness() %></td>
	</tr>
	<tr>
		<td>体重のかかった幅</td>
		<td align="center"><%=leftFoot.getLFootWidthWeith() %>mm</td>
		<td width="20"><%=resultMeasure.getResult_Left_Weighted_Width() %></td>
		<td align="center"><%=rightFoot.getRFootWidthWeith() %>mm</td>
		<td width="20"><%=resultMeasure.getResult_Right_Weighted_Width() %></td>
	</tr>
	<tr>
		<td>体重のかからなかった幅</td>
		<td align="center"><%=leftFoot.getLFootWidthRegu() %>mm</td>
		<td width="20"><%=resultMeasure.getResult_Left_Regular_Width() %></td>
		<td align="center"><%=rightFoot.getRFootWidthRegu() %>mm</td>
		<td width="20"><%=resultMeasure.getResult_Right_Regular_Width() %></td>
	</tr>
	<tr>
		<td>普段の靴のサイズ</td>
		<td colspan="4" align="center"><%=measuredPerson.getOrdinaryShoesSize() %>cm</td>
	</tr>
	<tr>
		<td>身長・体重</td>
		<td colspan="4" align="center"><%=measuredPerson.getHeight() %>cm
		<%=measuredPerson.getBodyWeight() %>kg</td>
	</tr>
</tbody>
</table>
<div class="example2">
<form action="DbToroku" method="post">
	<input type="submit"  value="診断結果を登録👟" class="button">
</form>
<br>
<form action="Direction" method="get">
    <input type="submit" name="direction" value="計測画面へ" class="button">
</form>
</div>
</body>
</html>