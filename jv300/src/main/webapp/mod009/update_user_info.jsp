<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 변경</title>
</head>
<body>
	<table class="table_a">
        <tr>
          <td>
            <h3>
              <label for="userId" name="userId" value="">회원 아이디</label>
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
              <label for="year" name="email">이메일</label>
            </h3>
            <div class="input-group">
              <input type="text" maxlength="20" placeholder="입력하세요"> @
              <input type="text" id="email2" name="email2"></input>
            </div>
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
</body>
</html>