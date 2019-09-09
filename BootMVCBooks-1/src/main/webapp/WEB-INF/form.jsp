<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="updateBook.do" id="modify_form" method="POST" modelAttribute="book">
		<input type="hidden" name="id" value="${id}">
		<form:label path="title">Title:</form:label>
		<form:input path="title" />
		<br />
		<form:label path="authors">Authors:</form:label>
		<form:input path="authors" />
		<br />
		<form:label path="avgRating">Avg Rating":</form:label>
		<form:input path="avgRating" />
		<form:errors path="avgRating" />
		<br />
		<form:label path="isbn">ISBN:</form:label>
		<form:input path="isbn" />
		<form:errors path="isbn" />
		<br />
		<form:label path="isbn13">ISBN13:</form:label>
		<form:input path="isbn13" />
		<form:errors path="avgRating" />
		<br />
		<form:label path="languageCode">Language Code:</form:label>
		<form:input path="languageCode" />
		<br />
		<form:label path="numPages">Number of Pages:</form:label>
		<form:input path="numPages" />
		<br />
		<form:label path="ratingsCount">Ratings Count:</form:label>
		<form:input path="ratingsCount" />
		<br />
		<form:label path="textReviewsCount">Text Reviews Count:</form:label>
		<form:input path="textReviewsCount" />
		<br />

		<c:choose>
			<c:when test="${id != 0 }">
				<span> <input type="submit" id="update_btn" value="Update" />
				</span>
			</c:when>

			<c:otherwise>
				<span> <input type="submit" id="create_btn" value="Create" />
				</span>
			</c:otherwise>

		</c:choose>

	</form:form>
	
	<script type="text/javascript">
		document.getElementById("update_btn").addEventListener("click", function(){
		     	document.getElementById("modify_form").action = "updateBook.do"
		    }  
		)
		
		document.getElementById("create_btn").addEventListener('click', function (){
		     	document.getElementById("modify_form").action = "createBook.do"
		    }  
		)
	
	</script>
</body>
</html>