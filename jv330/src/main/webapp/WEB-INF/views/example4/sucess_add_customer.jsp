<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>성공!</h3>
	<label>E-mail : </label>${customerCommand.email }<br>
	<label>비밀번호 : </label>${customerCommand.passwd }<br>
	<label>이름 : </label>${customerCommand.name }<br>
	<label>주민번호 : </label>${customerCommand.ssn }<br>
	<label>연락처 : </label>${customerCommand.phone }<br>
</body>
</html>