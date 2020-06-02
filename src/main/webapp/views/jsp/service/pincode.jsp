<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true"%> <%@ page isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
     <div class="container" style="padding-bottom: 50px;">
        <div class="row justify-content-center">
            <div class="title col-12 col-lg-8">
                <h2 class="align-center pb-2 mbr-fonts-style display-2">
                   <span class="mbri-map-pin mbr-iconfont mbr-iconfont-btn"></span> Location Service
                </h2>
                <h3 class="mbr-section-subtitle align-center pb-5 mbr-light mbr-fonts-style display-5">
                    Find location details by providing area pincode.
                </h3>
            </div>
        </div>
        <div class="media-container-row">
            <div class="row col-12 col-md-12">
                <div class="col-12 mbr-text mbr-fonts-style col-md-6 display-5">
                     <p>Integrate Location API into your application for detailed and live updates. </p>
                </div>
                <div class="mbr-text counter-container col-12 col-md-6 mbr-fonts-style display-7">
	                <ol>
	                    <li><strong>Single Record</strong> - Get pincode of Delhi with area pincode - 110001 with single record <a href="http://api.deepdivecode.com:8000/locationservice/db/pincode/1/110001" target="_blank">110001</a></li>
	                    <li><strong>All Records</strong> - Get pincode of Delhi with area pincode - 110001 with multiple record <a href="http://api.deepdivecode.com:8000/locationservice/db/pincode/0/110001" target="_blank">110001</a></li>
	                </ol>
            	</div>
            </div>
        </div>
        <form:form action="pincode" modelAttribute="pincodeDto" method="GET">
        <div class="dragArea row form-inline justify-content-center">
        	<div class="col-auto  form-group">
        	<label for="pincode-form1-v" class="form-control-label mbr-fonts-style">Pincode</label>
        		<form:input cssClass="form-control input-sm input-inverse my-2 display-7" placeholder="Enter pincode" path="pincode" required="required"/>
        	</div>
        	<div class="col-auto  form-group">
        	<label for="pincode-form1-r" class="form-control-label mbr-fonts-style">Record Type</label>
        		<form:select path="dataView" cssClass="form-control input-sm input-inverse my-2 display-7">
		        	<form:option value="0" label="All"/>
		        	<form:option value="1" label="Single"/>
			     </form:select>
        		<!-- <input type="email" name="email" placeholder="Email" data-form-field="Email" required="required" class="form-control input-sm input-inverse my-2 display-7" id="email-footer4-18"> -->
        	</div>
        	<div class="col-auto  input-group-btn  m-2">
            	<button type="submit" class="btn btn-primary m-0 display-4">Submit</button>
            </div>
        </div>
        </form:form>
      
	<c:if test="${pincodeJSON ne null}">
	<section class="features3 cid-rZxSxtf7AD" id="features3-1b">
	    <div class="container">
	        <div class="media-container-row">
	            <div class="card p-3 col-12">
	                <div class="card-wrapper">
	                    <div class="card-box">
	                        <h4 class="card-title mbr-fonts-style display-7">
	                            Result
	                        </h4>
	                        <p class="mbr-text mbr-fonts-style display-7">
	                           <c:out value='${pincodeJSON}'/>
	                        </p>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</section>
</c:if>
</div>