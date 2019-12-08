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
			<th>년도</th>
			<th>학기</th>
			<th>이수 학점</th>
			<th>상세보기</th>
		</tr>

		<c:set var="sum" value="0" />
		<c:set var="cyear" value="null" />
		<c:set var="semester" value="null" />
		<c:forEach var="course" items="${courses }">
			<c:if test="${course.cyear eq 2019 && course.semester eq 2}">
				<c:set var="sum" value="${sum + course.grade }" />
				<c:set var="cyear" value="${course.cyear }" />
				<c:set var="semester" value="${course.semester }" />
			</c:if>
		</c:forEach>
		<tr>
			<td><c:out value="${cyear}"></c:out></td>
			<td><c:out value="${semester}"></c:out></td>
			<td><c:out value="${sum}"></c:out></td>

			<td><a href="${pageContext.request.contextPath}/201902Course">상세보기</a></td>
		</tr>

		<c:set var="sum" value="0" />
		<c:set var="cyear" value="null" />
		<c:set var="semester" value="null" />
		<c:forEach var="course" items="${courses }">
			<c:if test="${course.cyear eq 2019 && course.semester eq 1}">
				<c:set var="sum" value="${sum + course.grade }" />
				<c:set var="cyear" value="${course.cyear }" />
				<c:set var="semester" value="${course.semester }" />
			</c:if>
		</c:forEach>
		<tr>
			<td><c:out value="${cyear}"></c:out></td>
			<td><c:out value="${semester}"></c:out></td>
			<td><c:out value="${sum}"></c:out></td>

			<td><a href="${pageContext.request.contextPath}/201901Course">상세보기</a></td>
		</tr>
	</table>
</body>
</html>