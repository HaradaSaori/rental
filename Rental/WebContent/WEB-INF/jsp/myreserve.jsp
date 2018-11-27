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
  <img src="./img/s_reserve.jpg" /><font size ="3">  現在のご予約状況</font><br><br>
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
</table><img src=./img/s_line.jpg></c:forEach>

  </div>
  </body>
</html>