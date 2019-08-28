<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragment/header.jsp" />

<div class="container">

	<spring:url value="/employee" var="employeeActionUrl" />

	<form:form class="form-horizontal" method="post"
		modelAttribute="employeeForm" action="${employeeActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="email">
			<div class="form-group">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" type="text" class="form-control "
						id="email" placeholder="Email" />
					<form:errors path="email" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="fullname">
			<div class="form-group">
				<label class="col-sm-2 control-label">Fullname</label>
				<div class="col-sm-10">
					<form:input path="fullname" type="text" class="form-control "
						id="fullname" placeholder="Fullname" />
					<form:errors path="fullname" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="arrivalDate">
			<div class="form-group">
				<label class="col-sm-2 control-label">Arrival Date</label>
				<div class="col-sm-10">
					<form:input path="arrivalDate" type="date" class="form-control"
						id="arrivalDate" placeholder="Arrival Date" />
				</div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
			</div>
		</div>

	</form:form>

</div>

<jsp:include page="fragment/footer.jsp" />

</body>
</html>