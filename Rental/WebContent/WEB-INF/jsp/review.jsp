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
    border-collapse: separate;
    border-spacing: 8px 0px;
}
a:hover img{
opacity: 0.6;
filter: alpha(opacity=60);
-moz-opacity:0.6;
}
  </style>
  </head>
  <body>
  <jsp:include page="/baselayout/header.jsp" />
      	<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
  <div align="center">
  <img src="./img/s_review_t.jpg">  レビュー投稿<br><br>
<form class="form-signin" action="ReviewServlet" method="post">
<table>
<tr><td>
キャスト名:</td>
<td>
<select name="castId">
<option value="sojiro">宗次郎</option>
<option value="ponta">ぽん太</option>
<option value="hanako">花子</option>
</select>
</td>
</tr>
<tr>
<td>投稿者</td>
<td>
<select name="userId">
<option value="admin">管理者</option>
<option value="harada">原田沙織</option>
<option value="satou">佐藤一郎</option>
</select>
</td>
</tr>
<tr>
<td>内容</td>
<td><textarea class="form-control" name="revC" rows="5" cols="80"></textarea></td></tr>
</table><br><br>
<input type="submit" class="btn btn-success" name = "submit" value="投稿"></form>
  </div>
  </body>
</html>