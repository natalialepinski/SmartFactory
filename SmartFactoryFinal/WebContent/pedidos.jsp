<%@page import="br.com.portal.bo.VendaBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.portal.to.Venda"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="#">
<title>Pedidos | Smart Factory</title>
<!--<link rel="icon" href="assets/img/favicon.png" type="image/x-icon"/> -->
<%@include file="imports.jsp"%>
</head>
<body>
	<jsp:include page="menu-horizontal.html"></jsp:include>
	<jsp:include page="menu.html"></jsp:include>
	<jsp:include page="modalFornecedor.html"></jsp:include>
	<div class="container">
		<section>
			<h1>Pedidos</h1>
			<div class="container crud-table">
				<div class="clearfix">
					<div class="form-inline pull-right">
						Busca por código:
						<div class="form-group">
							<input class="form-control" type="text"
								placeholder="Digite o código do produto" />
						</div>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>Código</th>
							<th>Data de Emissão</th>
							<th>Valor do Pedido</th>
							<th>Status</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody class="text-center">
						<c:forEach items="${listaVenda}" var="pedido" varStatus="id">
							<tr>
								<td>${pedido.codigoVenda}</td>
								<td>${pedido.dataEmissao}</td>
								<td>${pedido.total}</td>
								<td>${pedido.status}</td>
								<td>
								<a href="status?opt=1&codigoProduto=${pedido.codigoVenda}">
								<button class="btn btn-primary">
										<span class="glyphicon glyphicon-ok">
									</button></a>
								</td>
								<td>
								<a href="status?opt=2&codigoProduto=${pedido.codigoVenda}">
								<button class="btn btn-danger">
										<span class="glyphicon glyphicon-remove">
									</button></a>
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