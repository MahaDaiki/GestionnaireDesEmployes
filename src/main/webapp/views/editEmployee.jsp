<%--
  Created by IntelliJ IDEA.
  User: AMD
  Date: 04/10/2024
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="assets/css/Style.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <title>Edit Employee</title>
</head>
<body class="formpages">
<nav>
    <a href="employees">
        <h1 class="title"><i class="fa-solid fa-users"></i> Employee Management</h1>
    </a>
</nav>

<div>
    <img src="assets/img/background.jpg" alt="Description of image" class="background-image">
</div>

<h2 class="addtitle">Edit Employee</h2>
<div class="center-wrapper">
    <div class="form-container">
        <form action="employees?action=update" method="post">

            <input type="hidden" name="id" value="${employee.id}">

            <div class="input-group">
                <i class="fas fa-user"></i>
                <label for="name">Name:</label>
                <input type="text" class="inputform" name="name" id="name" value="${employee.name}" required>
            </div>
            <div class="input-group">
                <i class="fas fa-envelope"></i>
                <label for="email">Email:</label>
                <input type="email" class="inputform" name="email" id="email" value="${employee.email}" required pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" title="Please enter a valid email address.">
            </div>
            <div class="input-group">
                <i class="fas fa-phone"></i>
                <label for="phone_number">Phone Number:</label>
                <input type="text" class="inputform" name="phone_number" id="phone_number" value="${employee.phone_number}" required pattern="^\d{10}$" title="Please enter a 10-digit phone number.">
            </div>
            <div class="input-group">
                <i class="fas fa-building"></i>
                <label for="department">Department:</label>
                <input type="text" class="inputform" name="department" id="department" value="${employee.department}" required>
            </div>
            <div class="input-group">
                <i class="fas fa-briefcase"></i>
                <label for="position">Position:</label>
                <input type="text" class="inputform" name="position" id="position" value="${employee.position}" required>
            </div>

            <input type="submit" class="submitform" value="Update Employee">
        </form>
    </div>
</div>
</body>
</html>
