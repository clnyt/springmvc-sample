<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragment/header.jsp" />

<div class="container">
	<br />
	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Employee Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${employee.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10">${employee.email}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Name</label>
		<div class="col-sm-10">${employee.fullname}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Email</label>
		<div class="col-sm-10">${employee.arrivalDate}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Manager</label>
		<div class="col-sm-10">${employee.manager.fullname}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Managed Employees</label>
		<div class="col-sm-10">
			<ul>
				<c:forEach var="managedEmployee"
					items="${employee.managedEmployees}">
					<li>${managedEmployee.fullname}</li>
				</c:forEach>
			</ul>
		</div>
	</div>

</div>

<jsp:include page="fragment/footer.jsp" />

</body>
</html>