<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="addCustomer" method="post">
		<label>E-mail</label> <input type="text" name="email"><br>
		<label>비밀번호</label> <input type="password" name="passwd"><br>
		<label>이름</label> <input type="text" name="name"><br>
		<label>주민번호</label> <input type="text" name="ssn"><br>
		<label>전화번호</label> <input type="text" name="phone"><br>
		<input type="submit" value="회원가입"/>
	</form>
</body>
</html>