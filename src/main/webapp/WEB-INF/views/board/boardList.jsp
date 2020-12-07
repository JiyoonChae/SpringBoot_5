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
  <h2>${board} List</h2>
  <p>The .table-hover class enables a hover state on table rows:</p>            
  	<!-- select box -->
	<form action="./${board}List" id="frm">  
	<input type="hidden" name="curPage" id="curPage" value=1>
	<div class="form-group">
	  <label for="sel1">Select list:</label>
	  <select class="form-control" id="kind" name="kind">
	    <option>title</option>
	    <option>writer</option>
	    <option>contents</option>
	  </select>
	</div>
	    <div class="input-group">
	      <input type="text" class="form-control" placeholder="Search" name="search" id="search">
	      <div class="input-group-btn">
	        <button class="btn btn-default" type="submit">
	        <i class="glyphicon glyphicon-search"></i></button>
	      </div>
	    </div>
	  
	</form>
  	
 
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Num</th>
        <th>Title</th>
        <th>Writer</th>
        <th>Date</th>
        <th>Hit</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="ar">
      <tr>
        <td>${ar.num }</td>
        <td><a href="./${board}Select?num=${ar.num}">${ar.title }</a></td>
        <td>${ar.writer }</td>
        <td>${ar.regDate }</td>
        <td>${ar.hit }</td>
      </tr>
     	</c:forEach>
    </tbody>
  </table>
  	
  	 <!-- write 버튼 생성 클릭 -->
 		<button type="button" class="btn btn-info" id="btn">write</button>
 		
  	<!-- 페이징 처리 -->
  	<ul class="pagination pager">
  	<c:if test="${pager.before}">
  	 <li><a href="#" class="list" title="${pager.startNum-1}">Previous</a></li>
   </c:if>
   	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    <li><a href="#" class="list" title="${i}">${i}</a></li>
   </c:forEach>
   
  <c:if test="${pager.after}">
    <li><a href="#" class="list" title="${pager.lastNum+1}">Next</a></li>
  </c:if>
  </ul>
  
</div>

	<script type="text/javascript">

	$(".list").click(function(){
			var curPage=$(this).attr("title");
			$("#curPage").val(curPage);

			$("#frm").submit();
			})
			
	$("#btn").click(function(){
		
		location.href="./${board}Write";
		})		
	</script>
</body>
</html>