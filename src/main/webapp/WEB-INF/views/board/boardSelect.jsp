<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
	<h3>${vo.num }</h3>
	<h3>${vo.title}</h3>
	<h3>${vo.writer}</h3>
	<h3>${vo.contents}</h3>
	
	<button class="btn btn-success" id="update">Update</button>
	<input type="button" value="Delete" class="btn btn-danger" id="delete">
	
	
</div>	
	
	<script type="text/javascript">
		$("#update").click(function(){
			
			location.href="./${board}Update?num=${vo.num}";
			
			});

		$("#delete").click(function(){
			location.href="./${board}Delete?num=${vo.num}";
			})

	</script>
</body>
</html>