<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    border-spacing: 8px 15px;
}
</style>
  </head>
  <body>
<jsp:include page="/baselayout/header.jsp" />
  <div align="center"><br><br><br>
<img src ="./img/s_tanukidetail.jpg"> <font size ="3">レンタル申し込み</font><br><br><br>
<form class="form-signin">
<table>
<tr>
<td>日にち</td>
<td><input class="form-control" type="date" name="deta"></td>
</tr>
<tr>
<td>場所</td>
<td><input class="form-control" type="text" name="place" ></td>
</tr>
<tr>
<td>依頼内容</td>
<td><textarea class="form-control" name="comment"></textarea></td></tr>
<tr>
</table><br>
<input type="submit" class="btn btn-info" value="予約する"></form><br><br><br><br>
  </div>
  </body>
</html>
