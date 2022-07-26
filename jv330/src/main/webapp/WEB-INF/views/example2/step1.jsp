<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>약관동의</title>
</head>
<body>
	<h3>약관</h3>
	<h4>약관내용</h4>
	<form action="step2" method="post">
		<input type="checkbox"  name="agree"/>약관동의
		<input type="submit" value="확인"/>
	</form>
</body>
</html>