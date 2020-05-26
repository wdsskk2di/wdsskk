<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>

<style type="text/css">
 .div_main{background-color: white; height:500px; width:600px; text-align: center; text-align: center; margin: 0 auto;}
 .div_main img{margin-top: 50px; margin-bottom: 100px; margin-left: 30px; width: 600px; height: 360px;}
 .div_main table{margin: 0 auto; margin-top: 150px;}
 .div_main button{color:white; background-color: silver; width: 250px; height: 80px; margin: 5px; font-size: 20px; font-weight: bold;}
</style>

</head>

<body class="main_body">
<c:import url="/WEB-INF/views/default/header.jsp"/>

<div class="div_main">
<img alt="가격표" src="resources/images/price.jpg">
</div>

<c:import url="/WEB-INF/views/default/footer.jsp"/>
</body>

</html>