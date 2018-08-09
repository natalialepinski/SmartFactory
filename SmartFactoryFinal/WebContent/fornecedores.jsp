<%@page import="br.com.portal.bo.FornecedorBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.portal.to.Fornecedor"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="#">
<title>Fornecedores | Smart Factory</title>
<!--<link rel="icon" href="assets/img/favicon.png" type="image/x-icon"/> -->
<%@include file="imports.jsp"%>
<link href="assets/css/fornecedores.css" rel="stylesheet"
	type="text/css" />

</head>
<body>
	<jsp:include page="menu-horizontal.html"></jsp:include>
	<jsp:include page="menu.html"></jsp:include>
	<jsp:include page="modalFornecedor.html"></jsp:include>
	<div class="container">
		<section>
			<h1>Fornecedores</h1>
			<div class="container crud-table">
				<div class="clearfix">
					<div class="form-inline pull-left">
						<button class="btn btn-success" data-toggle="modal" data-target="#myModalHorizontal">
							<span class="glyphicon glyphicon-plus"> </span>Registrar novo
							fornecedor
						</button>
					</div>
					<div class="form-inline pull-right">
						Busca por nome:
						<div class="form-group">
							<input class="form-control" type="text"
								placeholder="Digite o nome do fornecedor" />
						</div>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>Código</th>
							<th>Nome Fantasia</th>
							<th>Valor</th>
							<th>Quantidade</th>
							<th></th>
						</tr>
					</thead>
					<tbody class="text-center">
						<c:forEach items="${listaFornecedor}" var="fornecedor" varStatus="id">
							<tr>
								<td>${fornecedor.codigoFornecedor}</td>
								<td>${fornecedor.nomeFantasia}</td>
								<td></td>
								<td></td>
								<td>
									<button class="btn btn-primary" data-toggle="modal" data-target="#myModalHorizontal">
										<span class="glyphicon glyphicon-edit">
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</div>
	<%@include file="scripts.jsp"%>
</body>
</html>