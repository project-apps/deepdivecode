<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%> <%@ page isELIgnored="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='<c:url value="/views/assets/web/assets/jquery/jquery.min.js"/>'></script>
<script src='<c:url value="/views/js/login.js"/>'></script>
<script type="text/javascript">
var authUserFirstLastName = "<c:out value='${authUserFirstLastName}'/>";
loginSuccess(authUserFirstLastName, 'social');
window.close();
</script>
</head>
<body>
</body>
</html>