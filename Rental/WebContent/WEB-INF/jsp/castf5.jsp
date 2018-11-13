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
<br><br><br><br><form class="form-signin"  action="CastF5Servlet" method="post">
<input type="hidden" value="${castdata.loginId}" name="loginId">
<table>
<tr><td>ID：</td>
<td>${castdata.loginId}
</td></tr><tr><td><br></td></tr>
 <tr><td>キャスト名：</td>
 <td><input class="form-control" type="text" name="castName" value="${castdata.castName}"></td></tr>
  <tr><td>性別：</td>
 <td><input class="form-control" type="text" name="gender" value="${castdata.gender}"></td></tr>
  <tr><td>人年齢：</td>
 <td><input class="form-control" type="text" name="age" value="${castdata.age}"></td></tr>
  <tr><td>得意な化け術：</td>
 <td><input class="form-control" type="text" name="bake" value="${castdata.bake}"></td></tr>
  <tr><td>一言：</td>
 <td><input class="form-control" type="text" name="comment" value="${castdata.comment}"></td></tr>
   <tr><td>レンタル金額：</td>
 <td><input class="form-control" type="text" name="price" value="${castdata.price}"></td></tr>
</table><br>
<input type="submit" class="btn btn-light" value="情報の更新"></form>
</div>
  </body>
</html>