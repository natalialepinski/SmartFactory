<%@page import="br.com.portal.bo.ProdutoBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.portal.to.Produto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="#">
<title>Estoque | Smart Factory</title>
<!--<link rel="icon" href="assets/img/favicon.png" type="image/x-icon"/> -->
<%@include file="imports.jsp"%>
<link href="assets/css/estoque.css" rel="stylesheet" type="text/css" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<jsp:include page="menu-horizontal.html"></jsp:include>
	<jsp:include page="menu.html"></jsp:include>
	<jsp:include page="modalEstoque.jsp"></jsp:include>

	<div class="container">
			<h1>Produtos</h1>

			<div class="container crud-table">
				<div class="clearfix">
					<div class="form-inline pull-left">
						<button class="btn btn-success" data-toggle="modal"
							data-target="#myModalHorizontal">
							<span class="glyphicon glyphicon-plus"> </span>Solicitar Produção
						</button>
					</div>
					<div class="form-inline pull-right">
						Busca por nome:
						<div class="form-group">
							<input class="form-control" type="text"
								placeholder="Digite o nome do produto" />
						</div>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>Código</th>
							<th>Nome</th>
							<th>Cor</th>
							<th>Quantidade</th>
						</tr>
					</thead>
					<tbody class="text-center">
						<c:forEach items="${listaProduto}" var="produto" varStatus="id">
							<tr>
								<td>${produto.codigoProduto}</td>
								<td>${produto.nomeProduto}</td>
								<td>${produto.cor}</td>
								<td>${produto.quantidade}</td>
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