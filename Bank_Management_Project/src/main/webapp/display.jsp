<%@ page import="dto.Registration" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Management Project</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="script.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="home.html"><i class="fa-solid fa-building-columns logo"></i><span class="logotext"> Scotia Bank</span></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item one">
                <a class="nav-link active" aria-current="page" href="home.html">HOME</a>
              </li>
              <li class="nav-item two">
                <a class="nav-link" href="#">ABOUT US</a>
              </li>
              <li class="nav-item three">
                <a class="nav-link" href="userlogin.html">USER LOGIN</a>
              </li>
              <li class="nav-item four">
                <a class="nav-link" href="adminlogin.html" tabindex="-1" aria-disabled="true">ADMIN LOGIN</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
	<%
	 List<Registration> registration= (List<Registration>) request.getAttribute("Registrations");
	%>
	<table class="table table-dark table-striped">
	 <tr>
                <th>Registration ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Date of Birth</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Password</th>
                <th>Gender</th>
                <th>Address</th>
                <th>Amount</th>
                <th>PIN</th>
                <th>Delete</th>
            </tr>
            
             <%
                for (Registration registrations : registration) {
            %>
            <tr>
            <td> <%= registrations.getRegistrationId() %>  </td>
            <td> <%=registrations.getRegistrationFirstName()  %>  </td>
            <td> <%= registrations.getRegistrationLastName() %>  </td>
            <td> <%=registrations.getRegistrationDOB()  %>  </td>
            <td> <%=registrations.getRegistrationPhone()  %>  </td>
            <td> <%=registrations.getRegistrationEmail()  %>  </td>
            <td> <%=registrations.getRegistrationPassword()  %>  </td>
            <td> <%=registrations.getRegistrationGender()  %>  </td>
            <td> <%= registrations.getRegistrationAddress() %>  </td>
            <td> <%= registrations.getRegistrationAmount() %>  </td>
            <td> <%= registrations.getRegistrationPIN()  %>  </td>
            <td> <a href="delete?id=<%=registrations.getRegistrationId()%>"><button class="deletebutton">Delete</button></a></td>
            
            
            
            
            </tr>
 <%
        }
    %>
    
    </table>
	
	
	
</body>
</html>