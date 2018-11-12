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
<br><br><br>
<img src ="./img/s_delete.jpg"> <font size ="3">削除確認</font><br><br><br>
キャスト名：宗次郎<br>
本当に削除してよろしいですか？<br><br>
<table>
<tr>
<td width="120">
<form>
<div align="center"><input type="button" class="btn btn-light" name = "cancel" value="キャンセル" onclick="history.back()"></div>
</form>
</td>
<td width="120">
<form action="Userdelete" method="post">
<input type="hidden" value="" name="loginid">

<div align="center"><input type="submit" class="btn btn-info" name = "submit" value="OK"></div>
</form>
</td></tr></table>
</div>
  </body>
</html>