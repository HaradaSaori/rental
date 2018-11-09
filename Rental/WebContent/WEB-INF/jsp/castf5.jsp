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
<br><br><br><br><form class="form-signin">
<table>
<tr><td>
</td></tr>
 <tr><td>キャスト名：</td>
 <td><input class="form-control" type="text" name="name"></td></tr>
  <tr><td>性別：</td>
 <td><input class="form-control" type="text" name="f"></td></tr>
  <tr><td>人年齢：</td>
 <td><input class="form-control" type="text" name="age"></td></tr>
  <tr><td>得意な化け術：</td>
 <td><input class="form-control" type="text" name="bake"></td></tr>
  <tr><td>一言：</td>
 <td><input class="form-control" type="text" name="comment"></td></tr>
   <tr><td>レンタル金額：</td>
 <td><input class="form-control" type="text" name="price"></td></tr>
</table><br>
<input type="submit" class="btn btn-light" value="情報の更新"></form>
</div>
  </body>
</html>