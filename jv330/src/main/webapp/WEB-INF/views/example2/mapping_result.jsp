<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경로 매핑</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h3 class="text-muted">요청 매핑 어노테이션을 이용한 경로 매핑</h3>
	<h4 >Result : ${result}</h4>
	<form action="" method="post">
		<input type="submit" value="확인"/>
	</form>
</body>
</html>