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

<p>Skills</p>
<p>${skill.skill} </p>
<form action = "SkillServlet" method ="post">
<button>Add another skill</button>
</form>
</body>
</html>