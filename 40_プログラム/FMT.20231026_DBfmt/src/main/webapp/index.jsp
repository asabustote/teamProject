<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 結果メッセージをリクエストスコープから取得
String message = (String)request.getAttribute("message");
if (message == null) {
	message = "";
}

//セッションスコープ内にインスタンスがある場合削除
//セッションスコープの取得

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
  border-radius : 90%;          /* 角丸       */
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

<%--submitボタンとresetボタンの位置CSSです。--%>
.example2{
    text-align: center;
}
<%--ログイン画面へsubmitボタンのCSSです。--%>
.button2 {
  display       : inline-block;
  border-radius : 0%;          /* 角丸       */
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
.button2:hover {
  box-shadow    : none;        /* カーソル時の影消去 */
  color         : #ffffff;     /* 背景色     */
  background    : #000000;     /* 文字色     */
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

<title>足サイズ計測表</title>
</head>
<body>
<h1><svg viewbox="0 0 520 60">
  <text class="s01 active" x="60" y="10">🌟👣足サイズ計測表👣🌟</text>
  </svg></h1>
 <p>
 <%--記入漏れの場合エラーメッセージをindex.jspに返す --%> 
 <font color="red"><%= message %></font>
 </p>
<form action="Direction" method="get">
<input type="submit" name="direction" value="ログイン画面へ" align="right" class="button2">
</form>
<br>
<form action="MeasuredFootSerch" method="post">
<table2 align="left" width="100" height="100">
	<tr>
		<td>計測日:<input type="date" name="day"><br></td>
	</tr>
	<tr>
		<td>記入者:<input type="text" name="writtenBy"  placeholder="記入者"><br></td>
	</tr>
</table2>
<table2 width="100" height="100">
	<tr>
		<td>ふりがな:<input type="text" name="kana" placeholder="ふりがな"></td>
		<td>　お名前:<input type="text" name="name" placeholder="お名前"></td>
	</tr>
</table2>
<br>
<table2 width="100" height="100">
<tr>
	<td>性別:(男:<input type="radio" name="kind" value="男">
	女:<input type="radio" name="kind" value="女">
	子ども:<input type="radio" name="kind" value="子ども">)</td>
	<td>年齢:<input type="text" name="age" placeholder="年齢"></td>
</tr>
</table2>
<hr>
<table align="center" border="1" cellpadding="2" class="table" width="500" height="200">
<tbody>
	<tr>
		<th colspan="2">硬め・普通・柔らかめ</th>
	</tr>
	<tr>
		<td align="center" valign="middle">サイズ</td>
		<td align="center" valign="middle">cm</td>
	</tr>
	<tr>
		<td align="center" valign="middle">太さ</td>
		<td align="center" valign="middle">細め・普通・太め</td>
	</tr>
</tbody>
</table>

<table  border="1" cellpadding="5"  class="table">
<tbody>
	<tr>
		<th></th>
		<th colspan="2">左</th>
		<th colspan="2">右</th>
	</tr>
	<tr><td>足長</td>
		<td colspan="2"><input type="text" name="LFootLength">mm</td>
		<td colspan="2"><input type="text" name="RFootLength">mm</td>
	</tr>
	<tr>
		<td>体重のかかった太さ</td>
		<td><input type="text" name="LFootCWeith">mm</td>
		<td width="20"></td>
		<td><input type="text" name="RFootCWeith">mm</td>
		<td width="20"></td>
	</tr>
	<tr>
		<td>体重のかからない太さ</td>
		<td><input type="text" name="LFootCRegu">mm</td>
		<td width="20"></td>
		<td><input type="text" name="RFootCRegu">mm</td>
		<td width="20"></td>
	</tr>
	<tr>
		<td>体重のかかった幅</td>
		<td><input type="text" name="LFootWidthWeith">mm</td>
		<td width="20"></td>
		<td><input type="text" name="RFootWidthWeith">mm</td>
		<td width="20"></td>
	</tr>
	<tr>
		<td>体重のかからなかった幅</td>
		<td><input type="text" name="LFootWidthRegu">mm</td>
		<td width="20"></td>
		<td><input type="text" name="RFootWidthRegu">mm</td>
		<td width="20"></td>
	</tr>
	<tr>
		<td>普段の靴のサイズ</td>
		<td colspan="4" align="center"><input type="text" name="ordinaryShoesSize">cm</td>
	</tr>
	<tr>
		<td>身長・体重</td>
		<td colspan="4"><input type="text" name="height">cm
		<input type="text" name="bodyWeight">kg</td>
	</tr>
</tbody>
</table>
<div class="example2"> 
	<input type="submit" value="診断👟" class="button">
	<input type="reset" value="入力内容のクリア" class="button">
</div>
</form>
</body>
</html>