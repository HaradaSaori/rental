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

レンタル金額(一日)：￥${castdata.price}<br>
<button type="button" class="btn btn-warning btn-lg" onclick="location.href='ReserveServlet'">レンタルする！</button><br><br><br><br>
<br>
<img src="./img/s_review.jpg">  <font size = "4">お客様の声</font>
<div class="inline_box">
<table>
 <tr><td width="180" valign="top">東京都 20代女性：</td>
 <td  width="380">結婚式で親戚役をお願いしました。<br>
 実の父より号泣していてちょっと気まずかったです。</td></tr>
 <tr><td><hr></td><td><hr></td></tr>
<tr><td width="180" valign="top">埼玉県 20代男性：</td>
 <td  width="380">彼女のお父さんに結婚の申し込みに行く練習にレンタルさせてもらいました。<br>
 厳格な父親を演じてほしかったのですが、優しくてすぐOKしてしまうのであまり練習になりませんでした。</td></tr>
<tr><td><hr></td><td><hr></td></tr>
<tr><td width="180" valign="top">東京都 50代男性：</td>
 <td  width="380">仕事の愚痴を同年代に聞いてほしくて呼びました。<br>
 とっても熱心に話を聞いてくれ、最後には二人で泣き笑いでした。<br>
 ありがとう！我が友よ。</td></tr>
</table></div>
<br><br><br>
<table>
<tr>
<td width="100" align="center"><button type="button" class="btn btn-danger" onclick="location.href='CastDeleteServlet'">削除</button></td>
<td width="100" align="center"><button type="button" class="btn btn-info" onclick="location.href='CastF5Servlet'">更新</button></td>
</tr>
</table><br><br><br>
</div>
  </body>
</html>