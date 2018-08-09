<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<title>Smart Factory | Conta</title>
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
								<h1>Login / Cadastro</h1>
								<ul>
									<li><a href="home">Home</a> /</li>
									<li>Login | Cadastro</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

		<!-- Área de Login e Registro -->
        	<div class="login-registration-page-area">
            	<div class="container">
                	<div class="row">
                    	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        	<div class="login-registration-field">
                            	<h2 class="cart-area-title">Login</h2>
                            	
                            	<form action="login" method="post">
                                	<label class="control-label" for="email">E-mail *</label> 
									<input type="text" name="email" id="email" class="form-control" required>
                                	<label class="control-label" for="senha">Senha *</label>
									<input type="password" name="senha" id="senha" class="form-control" required>
                                	<!-- <label class="check">Esqueceu a senha?</label>  -->
                                	<input style="width: 40%; padding: 12px 40px 40px 40px;" class="btn-send-message disabled" type="submit" value="login">
                                	<span><input type="checkbox" name="remember"/>Lembrar-me</span>
                                	<input type="hidden" name="opt" value="entrar">
                            	</form>
                       	 	</div>
                    	</div>
                    	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        	<div class="login-registration-field">
                            	<h2 class="cart-area-title">Registrar</h2>
                            	<form action="register.jsp" method="get">
                                	<label class="control-label" for="nomeConpleto">Nome Completo*</label>
									<input type="text" name="nomeCompleto" id="first-name" class="form-control" required>
                                	<label class="control-label" for="email">E-mail *</label> 
									<input type="text" name="email" id="email" class="form-control" required>
                                	<label class="control-label" for="senha">Senha *</label>
									<input type="password" name="senha" id="senha" class="form-control" required>
                                	<input style="width: 40%; padding: 12px 40px 40px 40px;" class="btn-send-message disabled" type="submit" value="Registrar">
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