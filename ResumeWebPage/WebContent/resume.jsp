<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#add{
   		display:none;
	}
</style>
</head>
<body>


<p>${person.firstName} ${person.lastName}</p>
<p>${person.email}</p>

<h6>Education</h6><br>
<c:forEach items="${educations}" var="education">

		<c:out value="${education.typeOfDegree}"></c:out><br>
		<c:out value="${education.institute}"></c:out>,
		<c:out value="${education.endDate}"></c:out>
</c:forEach>
<hr>
<h6>Experience</h6>
<c:forEach items="${experiences}" var = "experience">
		<p><c:out value="${experience.position}"></c:out></p>
		<p><c:out value="${experience.company}"></c:out>,<p><c:out value="${experience.startDate}"></c:out>
		- <c:out value="${experience.endDate}"></c:out>
		</p>
		<c:out value="${experience.duty}"></c:out>

</c:forEach><br>
<hr>
<h6>Skills</h6><br>
<c:forEach items="${skills}" var="skill">

		<p> <c:out value="${skill.skill}"></c:out> <c:out value="${skill.rating}"></c:out><p/><br>
</c:forEach>
<button id = "addBtn" onClick='document.getElementById("add").style.display = "block";'>Add Skill</button>
<button id = "done"onClick='document.getElementById("addBtn").style.display = "none";'>Done</button>
<form id = "add" action ="SkillServlet" method = post>
	<% int counter=0; %>
		<c:forEach items="${skills}" var="skill">	
			
			<input type="hidden" name = "skId" value = ${skill.skillId}></input>
			
			<input type="hidden" id ="counter" name = "counter" value = <%= ++counter %> ></input>
		</c:forEach>
		<br>
		<p >skill </p>  <input  type="text" name="skill" /> <br>
		<p  >How do you rate your self </p> <input   type="text" name="rating" /> <br>
		  <input  type="submit" value = "submit"/> <br>
</form>
<script>
	
		document.getElementById("addBtn").addEventListener("click", showform);
			
		function showform() {
			
			documents.getElementById(".add").style.display = 'block';
 		
			}
</script>
</body>
</html>