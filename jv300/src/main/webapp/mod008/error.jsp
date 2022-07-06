<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% List<String> error = (List)request.getAttribute("error");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<c:if test="${not empty error}">
			<h3>에러가 발생했습니다.</h3>
			<ul>
				<c:forEach var="error" items="${error}">
					<li>${error}</li>
				</c:forEach>
			</ul>
		</c:if>
	</div>
</body>
</html>