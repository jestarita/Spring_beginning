<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>todos list</title>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-responsive">
    <thead>
    <tr>
        <th>id</th>
        <th>Desc</th>
        <th>target Date</th>
        <th>is done?</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.desc}</td>
            <td>${item.targetDate}</td>
            <td>${item.done}</td>
            <td><a  type="button" class="btn btn-danger" href="/delete-todo?id=${item.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


${name} if you want to add a new todo just enter <a href="/add-todo">Here</a>.



<script>
    $(document).ready(function(){

        console.log("volumen 37 padre clero");
    });
</script>
</body>

</html>