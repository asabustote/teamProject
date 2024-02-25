<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//結果メッセージをリクエストスコープから取得
String message = (String)request.getAttribute("message");
if(message == null){
	message ="";
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--CSSです。--%>
<style type="text/css">
<%--管理者IDとパスワードのCSSです。 --%>
input.center {
  padding: 10px;
  text-align: center;
}
<%--管理者IDとパスワードの位置のCSSです。--%>
.example2{
    text-align: center;
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
</style>
<%--ここまでCSS--%>
<title>管理者ログイン画面</title>
</head>
<body>
<h1 align="center">管理者ログイン画面</h1>
<%--管理者IDとパスワードが一致しない場合エラーメッセージを
ログアウトした場合ログアウトメッセージをindex.jspに返す --%> 
 <font color="red"><%= message %></font>
<form action="Login" method="post">
<p>
<div class="example2">
	管理者ID:<input type="text" name="loginId" placeholder="管理者ID" class="center"><br><br>
	パスワード:<input type="password" name="pass" placeholder="パスワード" class="center"><br>
	<input type="submit" value="ログイン" align="center" class="button" class="center">
	<input type="reset" value="入力内容のクリア" align="center" class="button" class="center">
</div>
</p>
</form>

<form action="Direction" method="get">
<div class="example2">
<input type="submit" name="direction" value="計測画面へ" class="button">
</div>
</form>
</body>
</html>