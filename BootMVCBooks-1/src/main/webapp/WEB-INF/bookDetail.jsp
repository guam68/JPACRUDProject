<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	${book }
	
 	<form action="deleteBook.do">
 		<input type="hidden" value="${book.id }" name="id">
 		<input type="submit" value="Delete Book">	
 	</form>
</body>
</html>