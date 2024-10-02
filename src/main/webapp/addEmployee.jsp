<%--
  Created by IntelliJ IDEA.
  User: AMD
  Date: 02/10/2024
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add New Employee</h2>
<form action="Employee?action=add" method="post">

    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required><br><br>

    <label for="email">Email:</label>
    <input type="email" name="email" id="email" required><br><br>

    <label for="phone_number">Phone Number:</label>
    <input type="text" name="phone_number" id="phone_number" required><br><br>

    <label for="department">Department:</label>
    <input type="text" name="department" id="department" required><br><br>

    <label for="position">Position:</label>
    <input type="text" name="position" id="position" required><br><br>

    <input type="submit" value="Add Employee">
</form>



</body>
</html>
