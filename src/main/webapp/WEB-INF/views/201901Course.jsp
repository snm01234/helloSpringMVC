<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>수강년도</th>
			<th>학기</th>
			<th>교과코드</th>
			<th>교과목명</th>
			<th>구분</th>
			<th>학점</th>
		</tr>
	<c:forEach var="course" items="${courses}">
		<c:if test="${course.cyear eq 2019 && course.semester eq 1}">
			<tr>
				<td>${course.cyear }</td>
				<td>${course.semester }</td>
				<td>${course.ccode }</td>
				<td>${course.ctitle }</td>
				<td>${course.division }</td>
				<td>${course.grade }</td>
			</tr>
		</c:if>
	</c:forEach>
	</table>
	
</body>
</html>