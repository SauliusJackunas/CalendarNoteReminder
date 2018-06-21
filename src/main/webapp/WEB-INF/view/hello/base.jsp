<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="<c:url value="/resources/css/picker.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<title>Calendar</title>


<title><spring:message code="message.title" /></title>
</head>
<body>
	<c:if test="${empty user}">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">User log in failed</h3>
						</div>
								<fieldset>
									
									<!-- Change this to a button or input when using this as a form -->
									<a href="http://localhost:8080/" type="submit" class="btn btn-success btn-block">Try to log in once again</a>
								</fieldset>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${not empty user}">
		<c:if test="${not empty user}">
			<article>
				<h1>
					<spring:message code="message.welcome" />
				</h1>

				<p class="subtitle fancy">
					<span> <c:if test="${not empty user.login}">
		    			${user.login}
		    		</c:if>
					</span>
				</p>
			</article>
		</c:if>

		<article>
			<form:form method="POST" action="base">
				<label>Pick a reminder date and time: </label>
				<input type="text" id="input" name="reminderDate">
				<div class="js-mini-picker-container"></div>
				<input type="submit" name="submit">
			</form:form>

			<form:form method="POST" action="base">
				<label>Write a message: </label>
				<input type="text" id="input" name="reminderNote">

				<input type="submit" name="submit">
			</form:form>
		</article>

		<article>
			<h1>
				<spring:message code="message.language_example" />
			</h1>

			<p class="subtitle fancy">
				<span> <spring:message code="message.language" /> : <a
					href="?lang=en"><spring:message code="message.english" /></a> | <a
					href="?lang=lt"><spring:message code="message.lithuanian" /></a>
				</span>
			</p>

			<p>
				<spring:message code="message.hello" />
			</p>

			<p>
				<spring:message code="message.time_now" />
				:
				<fmt:formatDate type="both" value="${now}" />
			</p>
		</article>
		<article>
			<h1>
				<spring:message code="message.operating_system" />
			</h1>

			<p class="subtitle fancy">
				<span>${operatingSystem}</span>
			</p>

			<p>
				<spring:message code="message.java_version" />
				<span>${javaVersion}</span>
			</p>
		</article>

		<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
		<script src="<c:url value="/resources/js/picker.js"/>"></script>
		<script src="<c:url value="/resources/js/main.js"/>"></script>
	</c:if>
</body>
</html>