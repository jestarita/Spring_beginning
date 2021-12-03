<html>
<head>
    <title>New todo</title>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<font color="red">${message}</font>
<form method="post" modelAttribute="todo">
    Desc: <input type="text" name="desc" />
    <input type="submit" />
</form>
</body>
</html>