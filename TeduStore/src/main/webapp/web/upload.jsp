<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<!-- 上传图片使用post方法 enctype="multipart/form-data表示上传功能-->
	<form action="${pageContext.request.contextPath}/upload/upload.do" method="post" enctype="multipart/form-data">
	请选择文件：
		<input type="file" id="file" name="file"><br>
		<input type="submit" value="上传">
	</form>
</body>
</html>