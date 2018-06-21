<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<link href="<c:url value="/resources/css/picker.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	
    <title><spring:message code="message.title" /></title>
</head>
<body>
	<c:if test="${not empty user}">
		<article>
			<h1><spring:message code="message.welcome" /></h1>
			
			<p class="subtitle fancy">
		    	<span>
		    		<c:if test="${not empty user.login}">
		    			${user.login}
		    		</c:if>
		    	</span>
		    </p>
		</article>
	</c:if>
	<article>
		<c:forEach items="${user.getReminders()}" var="reminder">
    		<ul>
    			<li>${reminder}</li>
    		</ul>
		</c:forEach>
	</article>
	<article>
		<form:form method="POST" action="base">
			<label>Pick a reminder date and time: </label>
			<input type="text" id="input" name="reminderDate">
			<div class="js-mini-picker-container"></div>
			<input type="submit" name="submit">
		</form:form>
	</article>
	<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/picker.js"/>"></script>
	<script src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>