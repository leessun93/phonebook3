<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 이걸 써야 jstl 쓸수있음 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>[phonebook2]</h1>
	<h2>전화번호 리스트</h2>
	<p>입력한 정보 내역입니다.</p>
	
	
	<c:forEach items= "${personList}" var="personVo">
		<table border='1'>
			<tr>
				<td>이름(name)</td>
				<td></td>
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td></td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td></td>
			</tr>
			<tr>
				<td><a href="">수정하기</a></td>
				<td><a href="">삭제하기</a></td>
			</tr>
		</table>
	</c:forEach>
		<br>
	
	

	
	
</body>
</html>