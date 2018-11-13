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
    border-spacing: 8px 5px;
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
<br><br><br><img src ="./img/s_search.jpg"> <font size ="3">検索条件</font><br><br>
<table>
    <tr>
      <th>性別</th>
      <td><input type="radio" value="男">男 <input type="radio" value="女">女</td>
    </tr>
    <tr>
      <th>人年齢</th>
      <td><input class="form-control" type="text" name="age" ></td>
    </tr>
    <tr>
      <th>空きスケジュール</th>
      <td><input class="form-control" type="text" name="schedule" ></td>
      </tr>
      <tr>
      <th></th><td>
      <div align ="right"><input type="submit" class="btn btn-light" value="検索"></div>
      </td>
    </tr>
</table><br><a href="NewCastServlet">キャスト登録</a><br><br>
<img src="./img/line.jpg">
<br><br><br>
<img src="./img/s_tanukilist.jpg">  <font size = "4">キャスト一覧</font><br><br>
<br>
<table>
<tr align=center> <c:forEach var="cast" items="${castList}">
  <td>${cast.castName}<br><a href="CastDetailServlet?id=${cast.id}"><img src=./img/s_tanuki_profile.jpg></a>
  <br>${cast.age}代・${cast.gender}
  <c:choose>
  <c:when test="${userInfo.loginId == 'admin'}">
<button type="button" class="btn btn-danger" onclick="location.href='CastdeleteServlet?id=${cast.id}'">削除</button>
<button type="button" class="btn btn-info" onclick="location.href='CastF5Servlet?id=${cast.id}'">更新</button>
</c:when></c:choose>
 </td> </c:forEach>
</tr>
</table>
</div><br><br><br>
  </body>
</html>