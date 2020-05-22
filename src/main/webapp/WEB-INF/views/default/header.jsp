<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
 .main_header{background-color: white; height:200px; width:600px; text-align: center; text-align: center; margin: 0 auto;}
 .main_header img{width: 100px; height: 100px; margin-top: 20%;}
 .main_header span{font-family:cursive; font-size: 50px; font-weight:bold; color:#005766;  margin-top: 20%;}
 
  .other_header{background-color: white; height:100px; width:600px; text-align: center; text-align: center; margin: 0 auto;}
  .other_header img{width: 50px; height: 50px; margin-top: 10%;}
  .other_header span{font-family:cursive; font-size: 25px; font-weight:bold; color:#005766;  margin-top: 10%;}
</style>

</head>
<body>
<c:choose>
<c:when test="${title == null }">
	<div class="main_header">
	<img alt="로고" src="resources/images/studyLogo.png"><span>Study R</span><br>
	</div>
</c:when>
<c:otherwise>
	<div class="other_header">
	<img alt="로고" src="resources/images/studyLogo.png"><span>Study R</span><br>
	</div>
</c:otherwise>
</c:choose>
</body>
</html>