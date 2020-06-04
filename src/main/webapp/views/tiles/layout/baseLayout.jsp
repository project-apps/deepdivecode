<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%> <%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<!DOCTYPE html>
<html  >
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="twitter:card" content="summary_large_image"/>
  <meta name="twitter:image:src" content="assets/images/cour-meta.png">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href='<c:url value="/views/images/logo-md-black-bold.gif"/>' type="image/x-icon">
  <meta name="description" content="">
  
  <title><tiles:insertAttribute name="title" ignore="true"/> | Deepdivecode</title>
  <link rel="stylesheet" href="<c:url value='/views/assets/web/assets/mobirise-icons-bold/mobirise-icons-bold.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/views/assets/web/assets/mobirise-icons/mobirise-icons.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/views/assets/bootstrap/css/bootstrap.min.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/views/assets/bootstrap/css/bootstrap-grid.min.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/views/assets/bootstrap/css/bootstrap-reboot.min.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/views/assets/web/assets/gdpr-plugin/gdpr-styles.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/views/assets/tether/tether.min.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/views/assets/socicon/css/styles.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/views/assets/dropdown/css/style.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/views/assets/animatecss/animate.min.css'/>"/>
  <link rel="stylesheet" href="<c:url value='/views/assets/theme/css/style.css'/>"/>
  <link rel="preload" as="style" href="<c:url value='/views/assets/mobirise/css/mbr-additional.css'/>"/><link rel="stylesheet" href="<c:url value='/views/assets/mobirise/css/mbr-additional.css'/>" type="text/css"/>
  <link rel="stylesheet" href="<c:url value='/views/css/style.css'/>"/>
</head>
<body>
<div class="header-container">
	<tiles:insertAttribute name="navbar" />
</div>
<div class="container-fluid">
		<tiles:insertAttribute name="body" />
</div>
<div class="modal-container"></div>
<div class="footer-container">
	<tiles:insertAttribute name="footer" />
</div>
  <script src='<c:url value="/views/assets/web/assets/jquery/jquery.min.js"/>'></script>
  <script src='<c:url value="/views/assets/popper/popper.min.js"/>'></script>
  <script src='<c:url value="/views/assets/bootstrap/js/bootstrap.min.js"/>'></script>
  <script src='<c:url value="/views/assets/tether/tether.min.js"/>'></script>
  <script src='<c:url value="/views/assets/web/assets/cookies-alert-plugin/cookies-alert-core.js"/>'></script>
  <script src='<c:url value="/views/assets/web/assets/cookies-alert-plugin/cookies-alert-script.js"/>'></script>
  <script src='<c:url value="/views/assets/viewportchecker/jquery.viewportchecker.js"/>'></script>
  <script src='<c:url value="/views/assets/dropdown/js/nav-dropdown.js"/>'></script>
  <script src='<c:url value="/views/assets/dropdown/js/navbar-dropdown.js"/>'></script>
  <script src='<c:url value="/views/assets/touchswipe/jquery.touch-swipe.min.js"/>'></script>
  <script src='<c:url value="/views/assets/mbr-popup-btns/mbr-popup-btns.js"/>'></script>
  <script src='<c:url value="/views/assets/mbr-flip-card/mbr-flip-card.js"/>'></script>
  <script src='<c:url value="/views/assets/smoothscroll/smooth-scroll.js"/>'></script>
  <script src='<c:url value="/views/assets/theme/js/script.js"/>'></script>
  <script src='<c:url value="/views/assets/formoid/formoid.min.js"/>'></script>
  <script src='<c:url value="/views/js/app.js"/>'></script>
  
<input name="cookieData" type="hidden" data-cookie-customDialogSelector='null' data-cookie-colorText='#424a4d' data-cookie-colorBg='rgba(234, 239, 241, 0.99)' data-cookie-textButton='Agree' data-cookie-colorButton='' data-cookie-colorLink='#424a4d' data-cookie-underlineLink='true' data-cookie-text="We use cookies to give you the best experience. Read our <a href='privacy.html'>cookie policy</a>.">
   <div id="scrollToTop" class="scrollToTop mbr-arrow-up"><a style="text-align: center;"><i class="mbr-arrow-up-icon mbr-arrow-up-icon-cm cm-icon cm-icon-smallarrow-up"></i></a></div>
    <input name="animation" type="hidden">
  </body>
</html>