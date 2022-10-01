<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
	
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-student-style.css"/>

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Student Registration</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Student Form</h3>
		
		<form:form action="saveStudent" modelAttribute="student" method="POST">
		
			<!--  to associate this data with customer id -->
			<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>						
					</tr>					
					<tr>
						<td><label>Department</label></td>
						<td><form:input path="department" /></td>						
					</tr>					
					<tr>
						<td><label>Country</label></td>
						<td><form:input path="country" /></td>						
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>						
					</tr>
				
				
				</tbody>
			
			
			</table>
		
		
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/student/list">Back to List</a>
		</p>
		
	
	</div>



</body>
</html>