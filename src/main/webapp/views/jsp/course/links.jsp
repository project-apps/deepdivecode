<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%> <%@ page isELIgnored="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<style type="text/css">
	.list-group-item{
	position: relative;
	display: block;
	font-size: 0.75rem; 
	padding: 0.2rem 0.5rem 0.2rem 0.5rem;
	margin-bottom: -1px;
	background-color: #fff;
	border: 1px solid rgba(0,0,0,.125);
}	
</style>

<div id="related-links" data-url='<c:url value="/course/links/${requestScope.course}"/>'>
	<span class="list-group-item list-group-item-action align-center"><strong>Related topics</strong></span>
	<div id="contents"></div>
</div>

<script src='<c:url value="/views/assets/web/assets/jquery/jquery.min.js"/>'></script>

<script type="text/javascript">
	var url = $('#related-links').attr('data-url');
	$.ajax({
		url: url,
	}).done(function(response){
		parseSubmenu(response, $('#related-links > #contents'));
	}).fail(function(data){
		console.log(data);
	});
	
	function parseSubmenu(data, dom){
		var children = data.children;
		var headerMenu='';
		for(var i=0; i< children.length; i++){
			var row = children[i];
			var itemName = formatMenu(row.name);
			var itemType = row.type;
			if((itemType.toUpperCase()==='FILE') && (itemName.toUpperCase()!='HOME')){
				//var uri = row.path.replace(rootPath,'');
				uri = '<c:url value="/course/${requestScope.course}"/>/'+row.name;
				var item =  '<a href="'+uri+'" class=" list-group-item list-group-item-action">'
	                +'<span class="menu-collapsed">'+formatMenu(row.name)+'</span>'
	                +'</a>';
	                
				dom.append(item);
			}
			parseSubmenu(row, dom);
		}
	}
	function formatMenu(name){
		name = name.split('.')[0];
		name = name.charAt(0).toUpperCase()+name.slice(1);
		name = removeSpclChars(name);
		return name;
	}
	function removeSpclChars(data){
		data = data.split('-').join(' ')
		return data;
	}
	
</script>