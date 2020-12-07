<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	  <form action="./${board}Write" method="post" enctype="multipart/form-data">
  		<div class="form-group">
    		<label for="title">Title</label>
    		<input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
  		</div>
  		<div class="form-group">
    		<label for="writre">Writer</label>
    		<input type="text" class="form-control" id="writer" name="writer">
  		</div>
  		<div class="form-group">
			  <label for="contents">Contents:</label>
	 		 <textarea id="summernote" name="contents" class="form-control" rows="25" ></textarea>
		</div>
		<div class="form-group">
    		<label for="files">File</label>
    		<input type="file"  name="files">
    		<input type="file"  name="files">
  		</div>
  	  <button type="submit" class="btn btn-default">Write</button>
	</form>
		
		
	
	</div>
	
	<script type="text/javascript">
	
	  $('#summernote').summernote({
		  height: 300,                 // set editor height
		  focus: true                  // set focus to editable area after initializing summernote
		  });


	</script>
</body>
</html>