<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Tool</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2 style="text-align:center;">Welcome to Marvel College</h2>
    <h2 style="text-align:center;">Annual Fest 2022</h2>
		</div>

	</div>

	<div id="container">

		<div id="content">

			<input type="button" value="Register Student"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<table>
				<tr>
					<th>SL. No.</th>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>



				<c:forEach var="tempStudent" items="${students}" varStatus="c">
				
					<!-- construct update link with student id -->
					<c:url var="updateLink" value="/student/showFormForUpdate">
						<c:param name="studentId" value="${tempStudent.id}" />

					</c:url>
					
					<!-- construct delete link with student id -->
					<c:url var="deleteLink" value="/student/delete">
						<c:param name="studentId" value="${tempStudent.id}" />

					</c:url>
					
					

					<tr>
						<td>${c.count}</td>
						<td>${tempStudent.name}</td>
						<td>${tempStudent.department}</td>
						<td>${tempStudent.country}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
						</td>
						
						
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>
</html>