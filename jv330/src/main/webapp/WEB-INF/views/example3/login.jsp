<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h3>로그인</h3>
	<form action="login" method="post">
		<label>아이디</label> <input type="text" name="userId"><br>
		<label>비밀번호</label> <input type="password" name="passwd"><br>
		<input type="submit" value="login"/>
	</form>
</body>
</html>