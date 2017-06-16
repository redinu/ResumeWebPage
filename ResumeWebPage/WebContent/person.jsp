<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${person.firstName} ${person.lastName}</p>
<p>${person.email}</p>
<c:if  test="${not empty educations}">
<c:forEach items="${educations}" var="education">
        
         <c:out value = "${education.typeOfDegree}"></c:out>
		 <c:out value ="${education.institute}" ></c:out> <c:out value="${education.endDate}"></c:out> 
       
</c:forEach>
</c:if>
 
<div>
	<form id ="education" name ="education" action="EducationServlet" method="post">
		Degree obtained <br> <input type="text" name="typeOfDegree" id ="typeOfDegree"/> <br>
		Institute <br>  <input type="text" name="institute" id ="institute"/> <br>
		End Date  <br> <input type="text" name="endDate" id ="endDate"/> <br>
		<input type="submit" value="submit" />
	</form>
	
</div>

</body>
</html>