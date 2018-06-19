<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <link href="<c:url value="/resources/css/picker.css" />" rel="stylesheet">
        
        <script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/picker.js" />"></script>
        
        <title>Simple calendar</title>
    </head>
    <body>
        <!-- Cia musu kalendorius -->
        <input type="text" class="form-control js-date-picker" value="10/24/2048">
    </body>
</html>
<script>
(function() {
    new Picker(document.querySelector('.js-date-picker'), {
          format: 'MM/DD/YYYY HH:mm',
    });
})();
</script>