<%--
  Created by IntelliJ IDEA.
  User: AMD
  Date: 02/10/2024
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="assets/css/Style.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <title>Title</title>
</head>
<body>
<nav>
    <h1 class="title"> <i class="fa-solid fa-users"></i>  Employee Management</h1>
</nav>

<div >
    <img src="assets/img/background.jpg" alt="Description of image" class="image">
</div>

<h2 class="addtitle">Add New Employee</h2>
<div class="center-wrapper">
<div class="form-container">
    <form action="employees?action=add" method="post">
        <div class="input-group">
            <i class="fas fa-user"></i>
            <label for="name">Name:</label>
            <input type="text" class="inputform" name="name" id="name" required>
        </div>
        <div class="input-group">
            <i class="fas fa-envelope"></i>
            <label for="email">Email:</label>
            <input type="email" class="inputform"  name="email" id="email" required>
        </div>
        <div class="input-group">
            <i class="fas fa-phone"></i>
            <label for="phone_number">Phone Number:</label>
            <input type="text"  class="inputform" name="phone_number" id="phone_number" required>
        </div>
        <div class="input-group">
            <i class="fas fa-building"></i>
            <label for="department">Department:</label>
            <input type="text" class="inputform"  name="department" id="department" required>
        </div>
        <div class="input-group">
            <i class="fas fa-briefcase"></i>
            <label for="position">Position:</label>
            <input type="text" class="inputform"  name="position" id="position" required>
        </div>
        <input type="submit" class="submitform" value="Add Employee">
    </form>
</div>

</div>

</body>
</html>
