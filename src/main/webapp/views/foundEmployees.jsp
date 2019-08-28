<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragment/header.jsp" />

<body>

	<div class="container">

		<h1>Found Employees</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Email</th>
					<th>Full Name</th>
					<th>Arrival Date</th>
					<th>Manager</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="employee" items="${employeeList}">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.email}</td>
					<td>${employee.fullname}</td>
					<td>${employee.arrivalDate}</td>
					<td>${employee.manager.fullname}</td>
					<td><spring:url value="/employees/${employee.id}"
							var="employeeUrl" /> <spring:url
							value="/employees/${employee.id}/delete" var="deleteUrl" /> <spring:url
							value="/employees/${employee.id}/update" var="updateUrl" />

						<button class="btn btn-info"
							onclick="location.href='${employeeUrl}'">Details</button>
						<button class="btn btn-primary"
							onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger"
							onclick="location.href='${deleteUrl}'">Delete</button></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="fragment/footer.jsp" />

</body>
</html>