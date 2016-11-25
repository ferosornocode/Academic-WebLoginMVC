<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
    <table>
        
	Bienvenido 
        
<table style="width:800px">
  <tr>
    <th>Nombre<br></th>
    <th>Apellido Paterno<br></th>
    <th>Apellido Materno<br></th>
    <th>Teléfono<br></th>
    <th>Correo<br></th>
    
  </tr>
  <tr>
    <td>${requestScope['user'].nombre}<br></td>
    <td>${requestScope['user'].apPaterno}<br></td>
    <td>${requestScope['user'].apMaterno}<br></td>
    <td>${requestScope['user'].telefono}<br></td>
    <td>${requestScope['user'].correo}<br></td>
    
  </tr>   
</table>
</body>
</html>