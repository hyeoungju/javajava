<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>계좌생성</h3>
	<form:form method="post" modelAttribute="account">
		<label>계좌타입 선택</label>
		<form:radiobuttons path="accType" 
							itemValue="accHost" 
							itemLabel="accCode" 
							items="${accTypeProviderList }"/><br>
		<label>초기 입금액</label>
		<form:input path="balance"/><br>
		<input type="submit" value="계좌만들기"/>
	
	</form:form>
</body>
</html>