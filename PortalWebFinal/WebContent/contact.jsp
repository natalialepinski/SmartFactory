<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Smart Factory | Contato</title>
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
							<h1>Contato</h1>
							<ul>
								<li><a href="home">Home</a> /</li>
								<li>Contato</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Área da página de contato -->
			<div class="contact-us-page-area">
				<div class="container">
					<div class="row">
						<div class="col-lg-9 col-md-9 col-sm-8 col-xs-12">
							<div class="contact-us-left">
								<h2>Envie sua mensagem</h2>
								<div class="alert alert-success" role="alert" style="display:none;"><i class="fa fa-check" aria-hidden="true"></i>Mensagem enviada com sucesso!</div>
								<div class="row">
									<div class="contact-form">
										<form id="contact-form">
											<fieldset>
												<div class="col-sm-6">
													<div class="form-group">
														<input type="text" placeholder="Nome*" class="form-control"
															id="form-name" data-error="Name field is required"
															required>
														<div class="help-block with-errors"></div>
													</div>
												</div>
												<div class="col-sm-6">
													<div class="form-group">
														<input type="email" placeholder="E-mail*"
															class="form-control" id="form-email"
															data-error="Email field is required" required>
														<div class="help-block with-errors"></div>
													</div>
												</div>
												<div class="col-sm-12">
													<div class="form-group">
														<textarea placeholder="Mensagem*"
															class="textarea form-control" id="form-message" rows="8"
															cols="20" data-error="Message field is required" required></textarea>
														<div class="help-block with-errors"></div>
													</div>
												</div>
												<div class="col-sm-12">
													<div class="form-group">
														<button type="submit" class="btn-send-message">Envie
														uma mensagem</button>
													</div>
												</div>
											</fieldset>
										</form>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class='form-response'></div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
							<div class="contact-us-right">
								<h2 class="title-sidebar">Informações de contato</h2>
								<ul>
									<li class="con-envelope">contato@smartfactory.com</li>
									<li class="con-phone">+ 55 11 2222.2222</li>
								</ul>
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