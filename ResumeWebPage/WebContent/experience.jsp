<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${person.firstName} ${person.lastName}</p>
<p>${person.email}</p>
Education<br>
<p>${education.typeOfDegree},</p> 
<p>${education.institute}, ${education.endDate}</p> 
<p>Experience</p>
<p>${experience.position}</p>
<p>${experience.company}, ${experience.startDate} - ${experience.endDate}</p>
<p>${experience.duty}</p>
<form action ="education.jsp" method = post>
	<button>Add another experience</button> <br>
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