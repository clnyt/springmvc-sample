<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragment/header.jsp" />

<div class="container">

	<spring:url value="/findEmployee" var="findEmployeeActionUrl" />
	<h2>Find some employees</h2>

	<form method="GET" action="${findEmployeeActionUrl}">

		<div class="form-group">
			<label class="col-sm-2 control-label">Arrival Date</label>
			<div class="col-sm-10">
				<input type="date" class="form-control" id="arrivalDate"
					placeholder="Arrival Date" name="arrivalDate" />
			</div>
		</div>

		<div class="form-check">
			<input class="form-check-input" type="radio" name="dateRef"
				id="dateRef1" value="before" checked> <label
				class="form-check-label" for="dateRef1"> Before </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="dateRef"
				id="dateRef2" value="after"> <label class="form-check-label"
				for="dateRef2"> After </label>
		</div>
		<br />
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary pull-right">Find</button>
			</div>
		</div>
	</form>


</div>

<jsp:include page="fragment/footer.jsp" />

</body>
</html>