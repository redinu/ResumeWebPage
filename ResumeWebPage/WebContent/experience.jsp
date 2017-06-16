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

</c:forEach>


<button id = "addBtn">Add experience</button>

<form action ="ExperienceServlet" method = post>
	<% int counter=0; %>
		<c:forEach items="${experiences}" var="experience">				
			<input type="hidden" name = "expId" value = ${experience.experienceId}></input>
			
			<input type="hidden" id ="counter" name = "counter" value = <%= ++counter %> ></input>
		</c:forEach>
		<br>
		<p class = "add">company </p>  <input class = "add" type="text" name="company" /> <br>
		<p class = "add" >Start Date </p> <input  class = "add" type="text" name="startDate" /> <br>
		<p class = "add">End Date  </p> <input class = "add" type="text" name="endDate" /> <br>
		<p class = "add">position </p>  <input class = "add" type="text" name="position" /> <br>
		<input class = "add"  type="submit" value="submit" />
	</form>
<div>

Add all your skills 
	<form id= "skill" name= "skill" action="SkillServlet" method="post">
		skill <br> <input type= "text" name="skill" /> <br>
		how do you rate your self in this skill<input type= "number" max = "10" min = "1" name="rating" id="rating"/> <br>
		
		<input type="submit" value="submit" />
		
	</form>
</div>
</body>
</html>