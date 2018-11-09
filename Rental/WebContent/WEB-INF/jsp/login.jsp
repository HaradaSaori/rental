<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>レンタルたぬき</title>
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- オリジナルCSS読み込み -->
    <link href="css/original/common.css" rel="stylesheet">
    <!-- Jqeryの読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
    <!-- レイアウトカスタマイズ用個別CSS -->
    <style type="text/css">
a:hover img{
opacity: 0.6;
filter: alpha(opacity=60);
-moz-opacity:0.6;
}
</style>
  </head>
  <body>
 <jsp:include page="/baselayout/header.jsp" />
<div align="center"><br><br><br><br><img src="./img/s_login.jpg"><br><br>
<form class="form-signin" action="LoginServlet" method="post">
<table>
<tr>
<td>
      <label for="inputId" class="sr-only">ログインID</label>
      <input type="text" name="loginId" id="inputLoginId" class="form-control" placeholder="ログインID"></td>
      </tr>
      <tr>
      <td>
      <label for="inputPassword" class="sr-only">パスワード</label>
      <input type="password" name="password" id="inputPassword" class="form-control" placeholder="パスワード"></td>
      <tr><td><br></td></tr><tr><td>
      <button class="btn btn-info" type="submit">ログイン</button>
    </td>
</tr></table></form></div>
  </body>
</html>