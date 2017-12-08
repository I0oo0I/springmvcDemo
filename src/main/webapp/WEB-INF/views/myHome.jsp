<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>

<script type="text/javascript">
	function submitIds(){
		var url = "${pageContext.request.contextPath}/home3";
		var param = {};
		param.ids = new Array('1','2','3','4');
		$.post(url, param, function(result){
			console.log(result);
		}, function(){
			console.log("111");
		})
	}
</script>

</head>
<body>
	<h1>Home page</h1>
	<a href= "<c:url value="/" />">index</a>
	<a href= "<c:url value="/home" />">注册</a>
	
	<button value="提交" onclick="submitIds()"></button>
</body>
</html>