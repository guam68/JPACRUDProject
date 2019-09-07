<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>

	<c:if test="${not empty message }">
		${message } <br><br>	
	</c:if>

	<c:forEach items="${books }" var="book">
		<a href="getBook.do?isbn=${book.isbn }">${ book.title }</a>
	</c:forEach>
</body>
</html>