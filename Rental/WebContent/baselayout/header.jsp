<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
       <!-- header -->
    <header>
      <nav class="navbar navbar-inverse">
      	<div class="container">
      		<div class="navbar-header">
            <a class="navbar-brand" href="CastListServlet"><img src="./img/s_tanuki.png" /></a>
            </div>

             <ul class="nav navbar-nav navbar-right">
             <li>
            <a class="navbar-brand" href="MypageServlet?userId=${user.userId}"><img src="./img/s_mypage.png" /></a>
            <a class="navbar-brand" href="LogoutServlet"><img src="./img/s_logout.png" /></a>
  		  </li>
  		  </ul>
      		</div>
      </nav>
    </header>
    <!-- /header -->