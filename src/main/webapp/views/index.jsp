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
        <input type="hidden" name="action" value="filter" />

        <!-- Department Filter -->
        <label for="department">Department:</label>
        <select name="department" id="department">
            <option value="">All Departments</option>
            <c:forEach var="department" items="${uniqueDepartments}">
                <option value="${department}">${department}</option>
            </c:forEach>
        </select>

        <!-- Position Filter -->
        <label for="position">Position:</label>
        <select name="position" id="position">
            <option value="">All Positions</option>
            <c:forEach var="position" items="${uniquePositions}">
                <option value="${position}">${position}</option>
            </c:forEach>
        </select>

        <!-- Submit Button -->
        <input type="submit" value="Filter" class="button"/>
    </form>

</div>
    <a href="employees?action=add" class="button">
        <i class="fa-solid fa-user-plus"></i>
    </a>
</div>



<div class="card-container">
    <c:if test="${not empty employees}">

        <c:forEach var="employee" items="${employees}">
            <div class="card">
                <div class="card-img"><i class="fa-solid fa-user-tie"></i></div>
                <div class="card-body">
                    <h3 class="card-title"><c:out value="${employee.name}"/></h3>
                    <p class="card-text">Phone Number: <c:out value="${employee.phone_number}"/></p>
                    <p class="card-text">Email: <c:out value="${employee.email}"/></p>
                    <p class="card-text">Position: <c:out value="${employee.position}"/></p>
                    <p class="card-text">Department: <c:out value="${employee.department}"/></p>
                    <a href="employees?action=edit&id=${employee.id}" class="card-button">
                        <i class="fas fa-edit"></i>
                    </a>
                    <button><i class="fa-solid fa-trash"></i></button>
                </div>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${empty employees}">
        <p>No employees found.</p>
    </c:if>
</div>





</body>
</html>
