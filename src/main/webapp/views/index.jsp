<%@ page import="java.util.List" %>
<%@ page import="model.Employee" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <link rel="stylesheet" type="text/css" href="assets/css/Style.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>

<body>
<nav>
    <h1 id="hh" class="title"> <i class="fa-solid fa-users"></i>  Employee Management</h1>
</nav>

<div >
    <img src="assets/img/background.jpg" alt="Description of image" class="image">
</div>

<a href="employees?action=add" class="button"><i class="fa-solid fa-user-plus"></i></a>
<form action="employees?action=search" method="get">
    <input type="text" name="search" placeholder="Search employees..." />
    <input type="submit" value="Search" />
</form>


<div class="card-container">
    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");

        if (employees != null) {
            for (Employee employee : employees) {
    %>
    <div class="card">
        <div class="card-img"><i class="fa-solid fa-user-tie"></i></div>
        <div class="card-body">
            <h3 class="card-title"><%= employee.getName() %></h3>
            <p class="card-text">Phone Number: <%= employee.getPhone_number() %></p>
            <p class="card-text">Email: <%= employee.getEmail() %></p>
            <p class="card-text">Position: <%= employee.getPosition() %></p>
            <p class="card-text">Department: <%= employee.getDepartment() %></p>
            <a href="Employee?action=edit&id=<%= employee.getId() %>" class="card-button"><i class="fas fa-edit"></i> Edit</a>
        </div>
    </div>
    <%
        }
    } else {
    %>
    <p>No employees found.</p>
    <%
        }
    %>
</div>




</body>
</html>
