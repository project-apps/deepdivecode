 <%@ page session="true"%> <%@ page isELIgnored="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<style type="text/css" >
.position-static a.display-4 {
  line-height: 2;
  word-break: break-word;
  word-wrap: break-word;
}
</style>
<section class="menu cid-qTkzRZLJNu" once="menu" id="menu1-0">
<nav class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-toggleable-sm">

        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <div class="hamburger">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
        </button>
        
        <div class="menu-logo">
            <div class="navbar-brand">
                <span class="navbar-logo">
                    <a href='<c:url value="/home"/>'>
                         <img src='<c:url value="/views/images/logo-md-white.gif"/>' alt="DeepdiveCode"/>
                    </a>
                </span>
                <span class="navbar-caption-wrap"><a class="navbar-caption text-white display-4" href='<c:url value="/home"/>'>
                        DeepdiveCode</a></span>
            </div>
        </div>
        <div class="navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true">
                
                <li class="nav-item dropdown position-static">
                <a class="nav-link link text-white dropdown-toggle display-4" href="#" aria-expanded="false" data-toggle="dropdown-submenu">
                		<span class="socicon socicon-rss mbr-iconfont mbr-iconfont-btn"></span>Courses</a>
	            <ul class="dropdown-menu w-100 shadow" id="navbarDropdownCourses">
					
					<div class="row">
				      	<div class="col-md-4">
				      		<li class="dropdown-item">
				      			<div class="d-flex flex-row">
				                   <a href='<c:url value="/course/java/introduction-to-java"/>' class="text-white">
				                 <div class="col-md-6">
				                       <img src="<c:url value='/views/images/java.png'/>" style="height: 75px">
				                   </div>
				                   <div class="col-md-6">
				                       <p>Learn java and j2ee technology</p>
				                   </div>
				                   </a>
				                   </div>
				                   
				      		</li>
				      	</div>
				      	<div class="col-md-4">
				      		<li class="dropdown-item">
				      			<div class="d-flex flex-row">
				                   <a href='<c:url value="/course/nodejs/introduction-to-nodejs"/>' class="text-white">
				                 <div class="col-md-6">
				                       <img src="<c:url value='/views/images/nodejs-logo.png'/>" style="height: 75px">
				                   </div>
				                   <div class="col-md-6">
				                       Learn NodeJS
				                   </div>
				                   </a>
				                   </div>
				      		
				      		</li>
				      	</div>
				      	<div class="col-md-4">
				      		<li class="dropdown-item">
				      			<div class="d-flex flex-row">
				            	<a href='<c:url value="/course/python/introduction-to-python"/>' class="text-white">
				                 <div class="col-md-6">
				                       <img src="<c:url value='/views/images/python-logo.png'/>" style="height: 75px">
				                   </div>
				                   <div class="col-md-6">
				                       Learn Python
				                   </div>
				                   </a>
				               	</div>
				               	
				      		</li>
				      	</div>
					</div>
    			</ul>   
          	</li>
                
            <li class="nav-item dropdown">
                <a class="nav-link link text-white dropdown-toggle display-4" href="#" data-toggle="dropdown-submenu" aria-expanded="false">
                    <span class="mbri-home mbr-iconfont mbr-iconfont-btn"></span>
                    Services
                </a><div class="dropdown-menu"><a class="text-white dropdown-item display-4" href="<c:url value='/service/pincode'/>">
                	<span class="mbri-map-pin mbr-iconfont mbr-iconfont-btn"></span>Pincode</a></div></li>
           	
           	<li class="nav-item dropdown position-static" style="align-self: auto;">
                <a class="nav-link link text-white dropdown-toggle display-4" href="#" aria-expanded="false" data-toggle="dropdown-submenu">
                		<span class="mbri-search mbr-iconfont mbr-iconfont-btn"></span>About Us</a>
	            <ul class="dropdown-menu w-100 shadow" id="navbarDropdownAboutUs">
				      <div class="row">
				      	<div class="col-md-6">
				      		<li class="dropdown-item">
				                      <a href='<c:url value="/writewithus"/>' class="text-white">
				                       <span class="mbri-edit mbr-iconfont mbr-iconfont-btn"></span>Write with us.</a>
				      		</li>
				      	</div>
				      	<div class="col-md-6">
				      		<li class="dropdown-item">
				                   <a href='<c:url value="/contactus"/>' class="text-white">
				                   	<span class="mbrib-pin mbr-iconfont mbr-iconfont-btn"></span>Contact us.
				                   </a>
				      		</li>
				      	</div>
				      </div>
    			</ul>   
          	</li>
               	
           <li class="nav-item">
               <c:choose>
             	<c:when test="${sessionScope.authuser ne null}">
               <div class="nav-item dropdown user-toogle">
             		<a class="nav-link link text-white dropdown-toggle display-4" href="#" data-toggle="dropdown-submenu" aria-expanded="false">
                    	${sessionScope.authuser.name}
                	</a>
             	</c:when>
              <c:otherwise>
               <div>
               <a class="nav-link link text-white display-4" href="<c:url value='/loginReg'/>" id="logginRegModalGenerator" data-toggle="modal">
               	<span class="mbrib-user mbr-iconfont mbr-iconfont-btn"></span>Login</a></div>
              <div class="nav-item dropdown user-toogle hide">
              	<a class="nav-link link text-white dropdown-toggle display-4" href="#" data-toggle="dropdown-submenu" aria-expanded="false"></a>
              </c:otherwise>
             </c:choose>
               <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
			    <a class="text-white dropdown-item display-4" href="#"><span class="mbri-user mbr-iconfont mbr-iconfont-btn"></span>Profile</a>
			    <a class="text-white dropdown-item display-4" href="#"><span class="mbri-setting mbr-iconfont mbr-iconfont-btn"></span>Settings</a>
			  	<a class="text-white dropdown-item display-4" href="<c:url value="/logout"/>"><i class="fas fa-sign-out-alt"></i>
			  	 <span class="mbri-logout mbr-iconfont mbr-iconfont-btn"></span>Logout</a>
			   </div>
		 	  </div>
         </li>
		</ul>
        </div>
    </nav>
</section>