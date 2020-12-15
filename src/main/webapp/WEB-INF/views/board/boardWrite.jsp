<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	
	<form:form modelAttribute="boardVO" enctype="multipart/form-data">
		<div class="form-group">
  		<h3><spring:message code="hello"></spring:message> </h3>
    		<label for="title">Title</label>
    		<!-- path는 parameter name -->
    		<form:input path="title" class="form-control"/>
    		<form:errors path="title"> </form:errors>
  		</div>
	
		<div class="form-group">
    		<label for="writre">Writer</label>
    		<form:input path="writer" class="form-control"/>
			<form:errors path="writer"></form:errors>
  		</div>
  		<div class="form-group">
			  <label for="contents">Contents:</label>
	 		 <form:textarea path="contents" id="summernote"/>
		</div>
		<div class="form-group">
    		<label for="files">File</label>
    		<input type="file"  name="files">
    		<input type="file"  name="files">
  		</div>
  	  <button type="submit" class="btn btn-default">Write</button>
	</form:form>
  		
  		
	
	
	</div>
	
	<script type="text/javascript">
	
	  $('#summernote').summernote({
		  height: 300,                 // set editor height
		  focus: true                  // set focus to editable area after initializing summernote
		  });


	</script>
</body>
</html>