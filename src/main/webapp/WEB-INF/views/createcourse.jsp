<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>


	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="course">
		<table class="formtable">
			<tr>
				<td class="label">수강년도:</td>
				<td><sf:input class="control" type="text" path="cyear" /> <br/>
				 <sf:errors path="cyear" class="error" /> </td>
			</tr>
			<tr>
				<td class="label">학기:</td>
				<td><sf:input class="control" type="text" path="semester" /> <br/>
				 <sf:errors path="semester" class="error" /></td>
			</tr>
			<tr>
				<td class="label">교과코드:</td>
				<td><sf:input class="control" type="text" path="ccode" /> <br/>
				 <sf:errors path="ccode" class="error" /></td>
			</tr>
			<tr>
				<td class="label">교과목명:</td>
				<td><sf:input class="control" type="text" path="ctitle" /> <br/>
				 <sf:errors path="ctitle" class="error" /></td>
			</tr>
			<tr>
				<td class="label">구분:</td>
				<td><sf:input class="control" type="text" path="division" /> <br/>
				 <sf:errors path="division" class="error" /></td>
			</tr>
			<tr>
				<td class="label">학점:</td>
				<td><sf:input class="control" type="text" path="grade" /> <br/>
				 <sf:errors path="grade" class="error" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="신청하기" /></td>
			</tr>
		</table>
	</sf:form>

</body>
</html>