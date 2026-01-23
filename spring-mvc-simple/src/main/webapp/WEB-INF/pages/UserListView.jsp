<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "header.jsp" %>
<div align = "center">
<h1>UserList</h1>

<sf:form method=post modelAttribute="form">
<table>
<tr>
<th align="left">first Name : </th>
<td><sf:input path="firstName"/>
     <input type="text" name="operaton" value="search"></td>
</tr>
</table>

	<table width="100%" border="1px">
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>Password</th>
					<th>Dob</th>
					<th>Address</th>
				</tr>

			<c:forEach items="${list}" var="user">
			<tr align="center">
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.firstName}"></c:out></td>
						<td><c:out value="${user.lastName}"></c:out></td>
						<td><c:out value="${user.login}"></c:out></td>
						<td><c:out value="${user.password}"></c:out></td>
						<td><fmt:formatDate value="${user.dob}" pattern="dd/MM/yyyy" />
						</td>
						<td><c:out value="${user.address}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
</sf:form>
</div>
</body>
</html>