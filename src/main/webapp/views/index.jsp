<%@ page import="java.util.List" %>
<%@ page import="model.Employee" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>


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
    <h1 class="title"> <i class="fa-solid fa-users"></i>  Employee Management</h1>
</nav>

<div >
    <img src="assets/img/background.jpg" alt="Description of image" class="image">
</div>

<div class="search-filter-add-container">
    <form method="get" action="employees" class="search-form">
        <input type="hidden" name="action" value="search" />
        <input type="text" name="search" placeholder="Search employees..." />
        <button type="submit" value="Search" class="button">
            <i class="fa fa-search"></i>
        </button>
    </form>

    <form method="get" action="employees" class="filter-form">
        <input type="hidden" name="action" value="filter" /> <!-- Add this hidden field -->

        <label for="department">Department:</label>
        <select name="department">
            <option value="">All Departments</option>
            <%
                // Create a Set to hold unique department names
                Set<String> uniqueDepartments = new HashSet<>();
                List<Employee> employees = (List<Employee>) request.getAttribute("employees");

                // Collect unique departments
                if (employees != null) {
                    for (Employee employee : employees) {
                        uniqueDepartments.add(employee.getDepartment());
                    }
                }

                // Populate the dropdown with unique departments
                for (String department : uniqueDepartments) {
            %>
            <option value="<%= department %>"><%= department %></option>
            <%
                }
            %>
        </select>

        <label for="position">Position:</label>
        <select name="position">
            <option value="">All Positions</option>
            <%
                Set<String> uniquePositions = new HashSet<>();

                if (employees != null) {
                    for (Employee employee : employees) {
                        uniquePositions.add(employee.getPosition());
                    }
                }

                for (String position : uniquePositions) {
            %>
            <option value="<%= position %>"><%= position %></option>
            <%
                }
            %>
        </select>

        <!-- Add a submit button -->
        <input type="submit" value="Filter" class="button"/>
    </form>

</div>
    <a href="employees?action=add" class="button">
        <i class="fa-solid fa-user-plus"></i>
    </a>
</div>

<div class="card-container">
    <%
        List<Employee> allemployees = (List<Employee>) request.getAttribute("employees");

        if (employees != null) {
            for (Employee employe : allemployees) {
    %>
    <div class="card">
        <div class="card-img"><i class="fa-solid fa-user-tie"></i></div>
        <div class="card-body">
            <h3 class="card-title"><%= employe.getName() %></h3>
            <p class="card-text">Phone Number: <%= employe.getPhone_number() %></p>
            <p class="card-text">Email: <%= employe.getEmail() %></p>
            <p class="card-text">Position: <%= employe.getPosition() %></p>
            <p class="card-text">Department: <%= employe.getDepartment() %></p>
            <a href="Employee?action=edit&id=<%= employe.getId() %>" class="card-button"><i class="fas fa-edit"></i> Edit</a>
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
