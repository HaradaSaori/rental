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
<br><br><br><br>
<form class="form-signin" action="MypageServlet" method="post">
<input type="hidden" value="${userdata.loginId}" name="loginId">
<table>
    <tr>
      <th scope="col">ログインID</th><th></th></tr>
		<tr>
           <td height="50" valign="top">${userdata.loginId}</td></tr>
           <tr>
      <th scope="col">氏名</th>
      <th scope="col">電話番号</th>
      </tr>
      <tr>
            <td height="50" valign="top"><input type="text" name="userName" value="${userdata.userName}" class="form-control"></td>
      <td height="50" valign="top"><input type="text" name="phone" value="${userdata.phone}" class="form-control"></td>
    </tr>
          <tr><th scope="col">パスワード</th>
      <th scope="col">パスワード確認</th>
      </tr>
         <tr>
            <td height="50" valign="top"><input type="password" name="password" class="form-control"></td>
      <td height="50" valign="top"><input type="password" name="passwordCon" class="form-control"></td>
    </tr>
</table><br>
<input type="submit" class="btn btn-light" value="情報の更新"></form><br>
<br><br><br>
<font size = "5">レンタル履歴</font><br><br>
<button type="button" class="btn btn-success" onclick="location.href='MyReserveServlet?id=${userdata.loginId}'">予約を確認する</button>
<br><br>
<c:forEach var="reserve" items="${reserveList}">
<table>
 <tr align=center>
 <td width="200"><input type="hidden" value="${reserve.id}" name="id">
  <img src=./img/s_tanukidetail.jpg>
  </td><td width="500">
  ${reserve.castName} <br>(${reserve.formatDate})</td>
  <td width="800">
  ${reserve.resCom}  <br>${reserve.place}
  </td></tr>
</table><img src=./img/s_line.jpg></c:forEach><br><br><br>
</div>
  </body>
</html>