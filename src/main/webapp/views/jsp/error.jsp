<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%> <%@ page isELIgnored="false"%> <%@ page isErrorPage="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<style type="text/css" >
.error-template {padding: 40px 15px;text-align: center;}
.error-actions {margin-top:15px;margin-bottom:15px;}
.error-actions .btn { margin-right:10px; }
</style>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>
                <h2>
                   ${requestScope.HttpStatus.value()} ${requestScope.HttpStatus.getReasonPhrase()}</h2>
                <div class="error-details">
                    Sorry, an error has occured, Requested page not found!
                </div>
                <div class="error-actions">
                    <a href="<c:url value="/home"/>" class="btn btn-primary btn-lg"><i class="fas fa-home" aria-hidden="true"></i></span>
                        Take Me Home </a><a href="<c:url value="/contactus"/>" class="btn btn-default btn-lg"><i class="fa fa-envelope" aria-hidden="true"></i> Contact Support </a>
                </div>
				 <!-- Exception:  ${exception.message} </br>
				  <div id="stacktrace" class="collapse hide" align="left">
				    <c:forEach items="${exception.stackTrace}" var="ste">
				        ${ste} 
					 </c:forEach>
				  </div>  -->
            </div>
        </div>
    </div>
</div>





<%-- 
<div align="center">
	<h1 class="m-0">${requestScope.HttpStatus.value()}</h1>
	<h6>${requestScope.HttpStatus.getReasonPhrase()}</h6>
	<p><button onclick="goBack()"><-Go Back</button></p>
</div> --%>

<script>
function goBack() {
  window.history.back();
}
</script>
