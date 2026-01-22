<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
  <%@includefile = "header.jsp" %>
 <sf:form method = "post"  modelAttribute = "form">
   <div align = "center">
   
   <h1 style="color: navy">Login</h1>
			<span style="color: green">${msg}</span>
   
   <table>
				<tr>
					<th align="left">login :</th>
					<td><sf:input path="login" /></td>
				</tr>
				<tr>
					<th align="left">password :</th>
					<td><sf:input path="password" /></td>
				</tr>
			<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signIn"></td>
				</tr>
			
			
   </table>
   </div>
   </sf:form>
</body>
</html>