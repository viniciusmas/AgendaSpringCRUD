<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Agenda</title>
	</head>
	<body>
		<spring:url value="/agenda/adicionar" var="adicionarURL" />
		<a href="${adicionarURL }">Adicionar na agenda</a>
	
		<h1>Listar Agenda</h1>
		<table width="100%" border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Email</th>
				<th colspan="2">Ação</th>
			</tr>
			<c:forEach items="${listarAgenda }" var="agenda">
				<tr>
					<td>${agenda.id }</td>
					<td>${agenda.nome }</td>
					<td>${agenda.telefone }</td>
					<td>${agenda.email }</td>
					<td><spring:url value="/agenda/atualizar/${agenda.id }" var="atualizarURL" /> <a href="${atualizarURL }">Atualizar</a></td>
					<td><spring:url value="/agenda/deletar/${agenda.id }" var="deletarURL" /> <a href="${deletarURL }">Deletar</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>