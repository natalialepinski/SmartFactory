<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
	<head>
		<title>Smart Factory | Produto</title>
		<c:import url="imports.jsp"/>
	</head>
	<body>
		<c:import url="menu.jsp"/>
		<div class="wrapper-area">
		<div class="inner-page-banner-area">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="breadcrumb-area">
							<h1>Detalhes do Produto</h1>
							<ul>
								<li><a href="index.jsp">Home</a> /</li>
								<li>Produto</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="product-details2-area">
				<div class="container">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
							<div class="inner-product-details-left">
								<div class="tab-content">
									<div class="tab-pane fade active in" id="related1">
										<a href="#" class="zoom ex1">
											<img alt="single" src="img/mochila_magenta.png" class="img-responsive">
										</a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
							<div class="inner-product-details-right">
								<h3>${nome} ${cor}</h3>
							<ul>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
								<li><i class="fa fa-star" aria-hidden="true"></i></li>
							</ul>
							<p class="price">${valor}</p>
							<p>${descricao}</p>
							<div class="product-details-content">
								<p>
									<span>COD:</span> ${id}
								</p>
							</div>
							<form method="post" action="ControleCarrinho?opt=2&codigoProduto=${id}">
								<ul class="inner-product-details-cart">
									<li><input type="hidden" name="idProduto" value="1" /> <input
										type="hidden" name="acao" value="addProduto" />
										<div class="input-group quantity-holder" id="quantity-holder">
											<input type="text" name='quantity'
												class="form-control quantity-input" value="1"
												placeholder="1">
											<div class="input-group-btn-vertical">
												<button class="btn btn-default quantity-plus" type="button">
													<i class="fa fa-plus" aria-hidden="true"></i>
												</button>
												<button class="btn btn-default quantity-minus" type="button">
													<i class="fa fa-minus" aria-hidden="true"></i>
												</button>
											</div>
										</div></li>
									
									<li><input class="btn-add-to-cart-fill-box3" type="submit" value="Adicionar ao Carrinho"/></li>
								</ul>
							</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:import url="footer.jsp"/>
		<c:import url="scripts.jsp"/>
	</body>
</html>