<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<meta charset="UTF-8">
		<meta name="description" content="Calendar Reminder">
		<meta name="keywords" content="Calendar Reminder">
		<meta name="author" content="Daug cia ju">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		<title>Calendar</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Sign UP</h3>
						</div>
						<div class="panel-body">
							<form:form role="form" method="GET" action="signup">
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="Name" name="user" type="text" autofocus>
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Password" name="pwd" type="password">
									</div>
									<!-- Change this to a button or input when using this as a form -->
									<button type="submit" class="btn btn-success btn-block">Sign UP</button>
								</fieldset>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>