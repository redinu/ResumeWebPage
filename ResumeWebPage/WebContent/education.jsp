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
	<p>${person.firstName}${person.lastName}</p>
	<p>${person.email}</p>
	Education
	<br>
	<c:forEach items="${educations}" var="education">

		<c:out value="${education.typeOfDegree}"></c:out>
		<c:out value="${education.institute}"></c:out>
		<c:out value="${education.endDate}"></c:out>
	</c:forEach>
<button id = "addBtn">Add another education</button>
	
<form action="EducationServlet" method="post" commandName="educations" >

 			<% int counter=0; %>
		<c:forEach items="${educations}" var="education">	
			
			<input type="hidden" name = "eduId" value = ${education.educationId} ></input>
			
			<input type="hidden" id ="counter" name = "counter" value = <%= ++counter %> ></input>
		</c:forEach>
		
		<br>
		<p class = "add" >Degree obtained </p> <input  class = "add" type="text" name="typeOfDegree" /> <br>
		<p class = "add">Institute </p>  <input class = "add" type="text" name="institute" /> <br>
		<p class = "add">End Date  </p> <input class = "add" type="text" name="endDate" /> <br>
		<input class = "add"  type="submit" value="submit" />
</form>
		<div>
		<c:if test="${not empty educations}">
			<p>${experience[0].position}</p>
			<p>${experience[0].company},${experience[0].startDate} -
				${experience[0].endDate}</p>
			<p>${experience[0].duty}</p>
		</c:if>
	</div>
	<div>
		Add all your experience
		<form id="experience" name="experience" action="ExperienceServlet"
			method="post">
			Start Date <br> <input type="text" name="startDate"
				id="startDate" /> <br> End Date <br> <input type="text"
				name="endDate" id="endDate" /> <br> Position <br> <input
				type="text" name="position" id="position" /> <br> Company <br>
			<input type="text" name="company" id="company" /> <br> Duty <br>
			<input type="text" name="duty" id="duty" /> <br> <input
				type="submit" value="submit" />
		</form>

	</div>
	
	</body>
	</html>



