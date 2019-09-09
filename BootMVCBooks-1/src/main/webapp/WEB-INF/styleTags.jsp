<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Use <jsp:include page="styleTags.jsp"/> to prevent repetition of code -->
	
			<form:form action="updateBook.do" method="POST">
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
		<br />
		<form:label path="isbn13">ISBN13:</form:label>
		<form:input path="isbn13" />
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

		<span> <input type="submit" value="Update" />
		</span>
		</form:form>
</body>
</html>