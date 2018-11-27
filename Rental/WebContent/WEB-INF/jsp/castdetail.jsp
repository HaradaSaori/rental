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
    border-spacing: 8px 10px;
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

<img src="./img/s_tanukidetail.jpg">  <font size = "4">${castdata.castName}</font><br><br><br>
<table>
 <tr><td rowspan="6"  width="400"><img src="./img/s_tanuki_profile.jpg"></td></tr>
 <tr><td>名前：</td>
 <td>${castdata.castName}</td></tr>
  <tr><td>性別：</td>
 <td>${castdata.gender}</td></tr>
  <tr><td>人年齢：</td>
 <td>${castdata.age}代</td></tr>
  <tr><td>得意な化け術：</td>
 <td>${castdata.bake}</td></tr>
  <tr><td>一言：</td>
 <td>${castdata.comment}</td></tr>
</table><br><br><br>

<img src="./img/s_reserve.jpg">  <font size = "4">予約済</font><br><br>
	<c:forEach var="reserve" items="${reserveList}">
						<table>
							<tr>
								<td width="400"  valign="top">${reserve.rDate}</td>
							</tr>
							</table>
		</c:forEach><br><br>


レンタル金額(一日)：￥${castdata.price}<br>
<button type="button" class="btn btn-warning btn-lg" onclick="location.href='ReserveServlet?id=${castdata.id}'">レンタルする！</button><br><br><br><br>
<br>
<img src="./img/s_review.jpg">  <font size = "4">お客様の声</font><br><br>
	<c:forEach var="review" items="${reviewList}">
    <c:choose>
    <c:when test="${review.castId == castdata.loginId}">

						<table>
							<tr>
								<td width="400"  valign="top">${review.revC}(${review.userName})</td>
							</tr>
							</table>
						<br><img src="./img/s_line.jpg">
		</c:when></c:choose></c:forEach><br><br>
		  <button type="button" class="btn btn-success" onclick="location.href='ReviewServlet?id=${castdata.id}'">レビューを書く</button>
		<br>
</div>
  </body>
</html>