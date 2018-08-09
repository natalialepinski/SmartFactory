<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.portal.to.ItemVenda"%>
<%@page import="br.com.portal.to.Venda"%>
<%@page import="br.com.portal.to.Produto"%>

<!DOCTYPE html>
<html>
<head>
<title>Smart Factory | Carrinho</title>
<c:import url="imports.jsp" />
</head>
<body>
	<c:import url="menu.jsp" />
	<div class="wrapper-area">
		<div class="inner-page-banner-area">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="breadcrumb-area">
							<h1>Carrinho de Compras</h1>
							<ul>
								<li><a href="index.jsp">Home</a> /</li>
								<li>Carrinho</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Área do Carrinho de Compra -->
		<div class="cart-page-area">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="cart-page-top table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<td class="cart-form-heading"></td>
										<td class="cart-form-heading">Produto</td>
										<td class="cart-form-heading">Preço</td>
										<td class="cart-form-heading">Quantidade</td>
										<td class="cart-form-heading">Total</td>
										<td class="cart-form-heading"></td>
									</tr>
								</thead>
								<tbody id="quantity-holder">
									<c:forEach var="item" items="${carrinhoUsuario.values()}">
										<tr>
											<td><img src="${item.urlImg}"
												style="width: 100px; height: 150px;"></td>
											<td>${item.nomeProduto} ${item.cor}</td>
											<td><p class="card-text">R$ ${item.valorProduto}</p></td>
											<td><p class="card-text">${item.quantidade}</p></td>
											<td><p class="card-text">R$ ${item.total}</td>
											<td><a href="RemoveProdutoServlet?id=${item.id}"
												style="color: #111"><i class="fa fa-times"
													aria-hidden="true"></i></a></td>
											<c:set var="total" value="${total = (total + item.total)}"></c:set>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="update-button">
								<a class="btn-apply-coupon disabled" id="teste"
									href="home">Continuar Comprando</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
						<div class="cart-page-bottom-right">
							<h3>
								Total:
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; R$
								<c:out value="${total}"></c:out>
							</h3>
							<div class="proceed-button">
								<a class="btn-apply-coupon disabled" id="teste" href="finaliza">Finalizar</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp" />
	<c:import url="scripts.jsp" />
</body>
</html>