<%@page import="br.com.portal.bo.ProdutoBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.portal.to.Produto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Smart Factory | Página Inicial</title>
<c:import url="imports.jsp" />
</head>
<body>
	<c:import url="menu.jsp" />
	<div class="wrapper-area">
		<!-- Services1 Area Start Here -->
		<div class="services1-area">
			<div class="container">
				<div class="row">
					<c:forEach items="${listaProd}" var="produto" varStatus="id">
							<form action="${produto.urlPagina}">
								<input type="hidden" name="tNomeProd" value="${produto.codigoProduto}" />
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
									<div class="services-area-box">
										<div class="media">
											<a class="pull-left" href="ControleCarrinho?opt=1&codigoProduto=${produto.codigoProduto}&valor=${produto.valorProduto}&descricao=${produto.descricao}&imagem=${produto.urlImg}&nome=${produto.nomeProduto}&cor=${produto.cor}"> 
											
												<img src="${produto.urlImg}" alt="${produto.nomeProduto} ${produto.cor}"
													class="img-responsive">
											</a>
											<div class="media-body">
												<p><span>${produto.nomeProduto} ${produto.cor}</span></p>
												<a href="ControleCarrinho?opt=1&codigoProduto=${produto.codigoProduto}&valor=${produto.valorProduto}&descricao=${produto.descricao}&imagem=${produto.urlImg}&nome=${produto.nomeProduto}&cor=${produto.cor}" class="btn-shop-now">Comprar<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
												</a>
											</div>
										</div>
									</div>
								</div>
							</form>
						</c:forEach>
				
				</div>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp" />
	<c:import url="scripts.jsp" />
</body>
</html>