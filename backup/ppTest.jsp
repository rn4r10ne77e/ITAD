<%@ page language="java" contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>파일 업로드 폼</title>
</head>

<body>
  <script src="js/MoveTo.js"></script>
<form name="fileForm" id="fileForm" method="POST" enctype="multipart/form-data">

    <input type="text" name="title" id="title"><br><br>

    tag : <input type="text" name="idx" id="idx" value="100"><br>
    no : <input type="text" name="imgnumber" id="imgnumber" value="1"><br><br>
       
    <input type="file" name="uploadFile" id="uploadFile" onchange="alert('dddd')"><br> 
    <input type="button" value="전송" onclick="uploadajax( 'upload_ok.jsp', 'uploadFile', 100, 1 )">
</form>
</body>
</html>