<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Agenda</title>
	</head>
	<body>
		<spring:url value="/agenda/salvar" var="salvarURL" />
		<form:form modelAttribute="agendaForm" method="post" action="${salvarURL }">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>Nome:</td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>Telefone:</td>
					<td><form:input path="telefone" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button type="submit">Salvar</button>
					</td>
				</tr>
			</table>
				
		</form:form>
	
	</body>
</html>