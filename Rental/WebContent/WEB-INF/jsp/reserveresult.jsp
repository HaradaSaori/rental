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
  <div align="center">
  <img src="./img/index_tanuki.jpg" /><br><br>
ご予約ありがとうございます！<br><br>
<table>
<tr>
<td width="100" align="center"><button type="button" class="btn btn-success" onclick="location.href='CastListServlet'">続けて予約する</button></td>
<td width="100" align="center"><button type="button" class="btn btn-light" onclick="location.href='MyReserveServlet?id=${userInfo.loginId}'">予約を確認する</button></td>
</tr>
</table><br><br><br>
  </div>
  </body>
</html>