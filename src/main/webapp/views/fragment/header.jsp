<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Palo IT example</title>

<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/employees/add" var="urlAddEmployees" />
<spring:url value="/find" var="urlFindEmployees" />

<nav class="navbar navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Home</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlAddEmployees}">Add
						Employee</a></li>
				<li class="active"><a href="${urlFindEmployees}">Find
						Employee</a></li>
			</ul>
		</div>
	</div>
</nav>