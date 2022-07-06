<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>

<div id="wrapper">
	<div id="header">
		<jsp:include page="/incl/banner.jsp">
			<jsp:param name="subtitle" value="<%=URLEncoder.encode(\"mod008 : 자바빈즈\",\"UTF-8\") %>"/>
		</jsp:include>
	</div>
	<div id="content-wrapper">
		<h3>회원가입</h3>
		<form action="add_user.do" method="post">
		<div id="header">
     		<h1>Sign up</h1>
   		</div>
    <table class="table_a">
        <tr>
          <td>
            <h3>
              <label for="userId" name="userId">회원 아이디</label>
            </h3>
            <input type="text" class="big" name="userId">
          </td>
        </tr>
        <tr>
          <td>
            <h3>
              <label for="passwd" name="passwd">비밀번호</label>
            </h3>
            <input type="password" class="big" name="passwd">
          </td>
        </tr>
        <tr>
          <td>
            <h3>
              <label for="passwd" name="passwd">비밀번호재확인</label>
            </h3>
            <input type="password" class="big" name="passwd">
          </td>
        </tr>
        <tr>
          <td>
            <h3>
              <label for="userName" name="userName">이름</label>
            </h3>
            <input type="text" class="big" name="userName">
          </td>
        </tr>
        <tr>
          <td>
            <h3>
              <label for="year" name="ssn" >주민번호</label>
            </h3>
            <div class="input-group">
              <input type="text" maxlength="6" placeholder="년(6자)" name="ssn">
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <h3>
              <label for="year" name="email1">이메일</label>
            </h3>
            <div class="input-group">
              <input type="text" maxlength="20" placeholder="입력하세요"> @
              <select id="email2" name="email2">
                <option value="naver" name="email2">naver.com</option>
                <option value="gmail" name="email2">gmail.com</option>
                <option value="daum" name="email2">daum.net</option>
              </select>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <h3>
              주소
            </h3>
         		<input type="text" name="addr1">
         		<input type="text" name="addr2">
          </td>
        </tr>
        <tr>
        	<td>
        		<h3> </h3>
        		<input type="submit" value="확인"/>
        	</td>
        </tr>
      </table>
	</form>
	</div>
	<div id="footer">
		<%@ include file="/incl/footer.jsp" %>
	</div>
</div>

</body>
</html>