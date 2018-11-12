<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  table {
width: 400px;
    border-collapse: separate;
    border-spacing: 8px 15px;
}
</style>
  </head>
  <body>
  	<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
  <div align="center"><br><br><br>
<img src ="./img/s_new.jpg"> <font size ="3">新規登録</font><br><br><br>
<form class="form-signin" action="NewUserServlet" method="post">
<table>
<tr>
<td>ログインID</td>
<td><input class="form-control" type="text" name="loginId"  autofocus></td>
</tr>
<tr>
<td>氏名</td>
<td><input class="form-control" type="text" name="userName" ></td>
</tr>
<tr>
<td>電話番号</td>
<td><input class="form-control" type="text" name="phone"></td></tr>
<tr>
<td>パスワード</td>
<td><input class="form-control" type="password" size="20" name ="password"></td>
</tr>
<tr>
<td>パスワード(確認)</td>
<td><input class="form-control" type="password" size="20" name ="passwordCon" ></td>
</tr>
</table><br>
<input type="submit" class="btn btn-info" value="登録"></form><br><br><br><br>
  </div>
  </body>
</html>
