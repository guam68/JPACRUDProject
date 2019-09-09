<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>

	<c:if test="${not isUpdate }">
		<c:choose>
		
			<c:when test="${empty book }">
				No books found
			</c:when>
			
			<c:when test="${fn:length(book) == 1 }">
				${book }
	 			<form action="deleteBook.do">
					<input type="hidden" value="${book[0].id }" name="id"> <input
						type="submit" value="Delete Book">
				</form>

				<form action="showUpdateForm.do">
					<input type="hidden" value="${book[0].id}" name="id"> <input
						type="submit" value="Update Book">
				</form>
			</c:when>
			
			<c:otherwise>
				<c:forEach items="${book }" var="b">
					<a href="getBookByIsbn.do?search=${b.isbn }">${b.title}</a>
				</c:forEach>
			</c:otherwise>
			
		</c:choose>
	</c:if>


</body>
</html>