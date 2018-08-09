<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
	<head>
		<title>Smart Factory | Registrar</title>
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
								<h1>Cadastro</h1>
								<ul>
									<li><a href="index.jsp">Home</a> /</li>
									<li>Cadastro</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

		<!-- Área de Registro -->
			<div class="checkout-page-area">
				<div class="container">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
							<div class="billing-details-area">
								<h2 class="cart-area-title">Complete seu Registro</h2>
								<form id="checkout-form" action="AdicionaClienteServlet" method="get">
									<input type="hidden" name="acao" value="incluirAluno">
									<div class="row">
										<!-- Nome Completo -->
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="nomeConpleto">Nome Completo*</label>
												<input type="text" name="nomeCompleto" id="first-name" class="form-control" value="${param.nomeCompleto}" required>
											</div>
										</div>
									</div>
									<div class="row">
										<!-- Razão Social -->
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="razaoSoial">Razão Social *</label>
												<input type="text" name="razaoSocial" id="razaoSocial" class="form-control" required>
											</div>
										</div>
									</div>
									<div class="row">
										<!-- Nome Fantasia -->
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="nomeFantasia">Nome Fantasia *</label> 
												<input type="text" name="nomeFantasia" id="nomeFantasia" class="form-control" required>
											</div>
										</div>
									</div>
									<div class="row">
										<!-- CNPJ -->
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="cnpj">CNPJ *</label> 
												<input type="text" name="cnpj" id="cnpj" class="form-control" required>
											</div>
										</div>
									</div>
									<div class="row">
										<!-- Email -->
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="email">E-mail *</label> 
												<input type="text" name="email" id="email" class="form-control" value="${param.email}">
											</div>
										</div>
										<!-- Telefone -->
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="telefone">Telefone *</label> 
												<input type="text" name="telefone" id="telefone" class="form-control">
											</div>
										</div>
									</div>
									<div class="row">
										<!-- Logradouro - Complemento -->
										<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
											<div class="form-group">
												<label class="control-label" for="logradouro">Endereço *</label> 
												<input type="text" name="logradouro" id="logradouro" class="form-control">
											</div>
										</div>
										<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
											<div class="form-group">
												<label class="control-label" for="numero">Número *</label> 
												<input type="text" name="numero" id="numero" class="form-control">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
											<div class="form-group">
												<label class="control-label" for="commplemento">Complemento *</label> 
												<input type="text" name="complemento" id="complemento" class="form-control">
											</div>
										</div>
										
									</div>
									<div class="row">
										<!-- Cidade -->
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="cidade">Cidade *</label>
												<input type="text" name="cidade" id="cidade" class="form-control">
											</div>
										</div>
									</div>
									<div class="row">
										<!-- Estado -->
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="estado">Estado *</label>
												<input type="text" name="estado" id="estado" class="form-control">
											</div>
										</div>
										<!-- CEP -->
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="cep">CEP *</label> 
												<input type="text" name="cep" id="cep" class="form-control">
											</div>
										</div>
									</div>
									<div class="row">
										<!-- Senha -->
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="senha">Senha *</label>
												<input type="password" name="senha" id="senha" class="form-control" value="${param.senha}">
											</div>
										</div>
										<!-- Confirmar Senha -->
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<div class="form-group">
												<label class="control-label" for="confirmaSenha">Confirmar Sennha *</label> 
												<input type="password" name="confirmaSenha" id="confirmaSenha" class="form-control">
											</div>
										</div>
									</div>
									<div class="row">
										<!-- Finalizar Cadastro -->
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="form-group">
												<span><input style="width: 40%; padding: 20px;" class="btn-send-message disabled" type="submit" value="Registrar"></span>
											</div>
										</div>
									</div>
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