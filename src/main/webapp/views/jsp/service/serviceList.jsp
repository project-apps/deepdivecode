<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%> <%@ page isELIgnored="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<section class="cid-rZxSAQmpuT">
    <div class="container">
        <div class="media-container-row">
			<c:forEach items="${serviceList}" var="service">            
		            <div class="card p-3 col-12 col-md-6 col-lg-4">
		            <a href='<c:url value="${service.action}"/>'>
		                <div class="card-img pb-3">
		                    <span class="${service.imageUrl}"></span>
		                    <%-- <c:out value="${service.imageUrl}"/> --%>
		                </div>
		                <div class="card-box">
		                    <h4 class="card-title py-3 mbr-fonts-style display-7">
		                        <c:out value="${service.name}"/>
		                    </h4>
		                    <p class="mbr-text mbr-fonts-style display-7">
		                      <c:out value="${service.desc}"></c:out>
		                    </p>
		                </div>
		            </a>
		            </div>
			</c:forEach>
        </div>
    </div>
</section>