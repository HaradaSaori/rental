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
  </head>
  <body>
  <div align="center">
  <img src="./img/index_tanuki.jpg" /><br><br>
  <img src="./img/logo_tanuki.png" /><br><br>
  選び抜かれた化け術の得意なたぬきたちが<br>
  なんでも代行・代理・同行いたします<br><br><br>
<table>
<tr>
<td width="100" align="center"><button type="button" class="btn btn-info" onclick="location.href='LoginServlet'">ログイン</button></td>
<td width="100" align="center"><button type="button" class="btn btn-warning" onclick="location.href='NewUserServlet'">新規登録</button></td>
</tr>
</table><br><br><br>
  </div>
  </body>
</html>
