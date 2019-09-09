<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>

	<c:if test="${not empty message }">
		${message } <br>
		<br>
	</c:if>

	<form id="search_form">
		<input type="text" name="search">	
		<input type="hidden" name="id" value="0">	
		<input type="submit" id="search_isbn_btn" value="Search by ISBN">
		<input type="submit" id="search_word_btn" value="Search by Keyword">
		<input type="submit" id="create_book" value="Create Book">
	</form>


	<script type="text/javascript">
		document.getElementById("search_isbn_btn").addEventListener("click", function(){
		     	document.getElementById("search_form").action = "getBookByIsbn.do"
		    }  
		)
		
		document.getElementById("search_word_btn").addEventListener('click', function (){
		     	document.getElementById("search_form").action = "getBookByKeyword.do"
		    }  
		)

		document.getElementById("create_book").addEventListener('click', function (){
		     	document.getElementById("search_form").action = "showUpdateForm.do"
		    }  
		)
	
	</script>

</body>


</html>