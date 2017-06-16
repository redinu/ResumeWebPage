<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.add{
   		display:none;
	}
</style>
</head>
<body>
<script>
	
		document.getElementById("addBtn").addEventListener("click", showform);
			
		function showform() {
			
			documents.getElementsByClassName(".add").style.display = 'block';
 		
			}
	</script>

<p>${person.firstName} ${person.lastName}</p>
<p>${person.email}</p>

Education<br>
<c:forEach items="${educations}" var="education">

		<c:out value="${education.typeOfDegree}"></c:out>
		<c:out value="${education.institute}"></c:out>
		<c:out value="${education.endDate}"></c:out>
</c:forEach>

<p>Experience</p>
<c:forEach items="${experiences}" var = "experience">
		<p><c:out value="${experience.position}"></c:out></p>
		<p><c:out value="${experience.company}"></c:out>,<p><c:out value="${experience.startDate}"></c:out>
		<c:out value="${experience.endDate}"></c:out>
		</p>
		<c:out value="${experience.duty}"></c:out>

</c:forEach><br>

Skills<br>
<c:forEach items="${skills}" var="skill">

		<c:out value="${skill.skill}"></c:out>
		<c:out value="${skill.rating}"></c:out>
</c:forEach>
<button id = "addBtn">Add experience</button>
<button >Done</button>

<form action ="SkillServlet" method = post>
	<% int counter=0; %>
		<c:forEach items="${skills}" var="skill">	
			
			<input type="hidden" name = "skId" value = ${skill.skillId}></input>
			
			<input type="hidden" id ="counter" name = "counter" value = <%= ++counter %> ></input>
		</c:forEach>
		<br>
		<p class = "add">skill </p>  <input class = "add" type="text" name="skill" /> <br>
		<p class = "add" >How do you rate your self </p> <input  class = "add" type="text" name="rating" /> <br>
</form>
</body>
</html>