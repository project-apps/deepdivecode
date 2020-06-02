<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%> <%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="<c:url value="/views/images/logo.png"/>"/>
   	<title><tiles:insertAttribute name="title" ignore="true" /></title> 
   	<link rel="stylesheet" href="<c:url value='/views/bootstrap/4.4.1/css/bootstrap.min.css'/>">
   	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
   	<link rel="stylesheet" href="<c:url value='/views/css/style.css'/>">
<style type="text/css">

</style>
	
</head>

<body>
<div class="container-fluid">	
	<div class="wrapper">
		<tiles:insertAttribute name="navbar" />
		<div class="row" style="margin-top: 60px;">
			<div class="container">
				<tiles:insertAttribute name="body" />
			</div>
			
    	</div>
</div>
</div>
 <footer>
    <tiles:insertAttribute name="footer" />
 </footer>
<script	type="text/javascript" src="<c:url value='/views/js/jquery-3.4.1.min.js'/>"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script type="text/javascript" src="<c:url value='/views/bootstrap/4.4.1/js/bootstrap.min.js'/>"></script>
<script src="https://kit.fontawesome.com/bf48b5b943.js" crossorigin="anonymous"></script>
</body>
</html>
