<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
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
    <div align="center">
    		<c:forEach var="review" items="${reviewList}">
						<table>
							<tr>
								<td height="50" valign="top">${review.revC}(${review.userName})</td>
							</tr>
						</table>
		</c:forEach>
		<br>
		<br>

    </div>
</body>
</html>