<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tab {
	margin-left : 40px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<c:forEach var="message" items="${textLines}">
			${message}
			<br>
		</c:forEach>	
	</div>
</body>
</html>