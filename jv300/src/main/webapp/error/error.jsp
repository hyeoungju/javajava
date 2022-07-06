<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<String> error = (List)request.getAttribute("errorMsgs");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<% for(String msg : error) { %>
		<h3>error!!! <%=msg %></h3>
		<% } %>
	</div>
</body>
</html>