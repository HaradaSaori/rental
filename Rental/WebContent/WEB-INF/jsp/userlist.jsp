<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>レンタルたぬき</title>
<!-- BootstrapのCSS読み込み -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- オリジナルCSS読み込み -->
<link href="css/original/common.css" rel="stylesheet">
<!-- Jqeryの読み込み -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<!-- BootstrapのJS読み込み -->
	<script src="js/bootstrap.min.js">
</script>
<!-- レイアウトカスタマイズ用個別CSS -->
<style type="text/css">
table {
	width: 400px;
	border-collapse: separate;
	border-spacing: 8px 5px;
}

a:hover img {
	opacity: 0.6;
	filter: alpha(opacity = 60);
	-moz-opacity: 0.6;
}
</style>
</head>
<body>
	<jsp:include page="/baselayout/header.jsp" />
	<div align="center">
		<c:forEach var="user" items="${userList}">
			<tr>
				<c:choose>
					<c:when test="${userInfo.loginId == 'admin'}">
						<table>
							<tr>
								<th scope="col">ログインID</th>
								<th></th>
							</tr>
							<tr>
								<td height="50" valign="top">${user.loginId}</td>
							</tr>
							<tr>
								<th scope="col">氏名</th>
								<th scope="col">電話番号</th>
							</tr>
							<tr>
								<td height="50" valign="top">${user.userName}</td>
								<td height="50" valign="top">${user.phone}</td>
							</tr>
							<tr>
								<td><a class="btn btn-primary"
									href="MypageServlet?id=${userInfo.loginId}">詳細・更新</a></td>
							</tr>
						</table>
						<br>
						<table>
							<tr>
								<td><div align="right">
										<a href="UserDeleteServlet?id=${user.id}">退会する</a>
									</div></td>
							</tr>
						</table>
					</c:when>

					<c:when test="${userInfo.loginId == user.loginId}">

						<table>
							<tr>
								<th scope="col">ログインID</th>
								<th></th>
							</tr>
							<tr>
								<td height="50" valign="top">${user.loginId}</td>
							</tr>
							<tr>
								<th scope="col">氏名</th>
								<th scope="col">電話番号</th>
							</tr>
							<tr>
								<td height="50" valign="top">${user.userName}</td>
								<td height="50" valign="top">${user.phone}</td>
							</tr>
							<tr>
								<td><a class="btn btn-primary"
									href="MypageServlet?id=${userInfo.loginId}">詳細・更新</a></td>
							</tr>
						</table>
						<br>
						<table>
							<tr>
								<td><div align="right">
										<a href="UserDeleteServlet?id=${user.id}">退会する</a>
									</div></td>
							</tr>
						</table>
						<br>
						<br>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
		<br>
		<br>
	</div>
</body>
</html>