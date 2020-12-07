<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		//db에서 받아서 js로 바로 실행할수있구낭~~히히 ->EL 사용해서 DB-JS사용법 찾아보기
		var msg= '${msg}';
		var path='${path}';
			alert(msg);
			location.href=path;
		
	</script>
</body>
</html>