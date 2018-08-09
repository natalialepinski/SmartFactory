<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="#">
<title>Login | Smart Factory</title>
<!--<link rel="icon" href="assets/img/favicon.png" type="image/x-icon"/> -->
<link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
<link href="assets/css/loginCliente.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="form">
		<div class="tab-content">
			<div id="login" style="display: block;">
				<h1>Bem-Vindo</h1>

				<form action="#" method="post">

					<div class="field-wrap">
						<label> E-mail<span class="req">*</span>
						</label> <input type="email" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Senha<span class="req">*</span>
						</label> <input type="password" required autocomplete="off" />
					</div>

					<p class="forgot">
						<a href="#">Esqueceu a senha?</a>
					</p>

					<button type="submit" class="button button-block">
						<a href="principal.jsp">Continuar</a>
					</button>

				</form>

			</div>

		</div>

	</div>
	<script type="text/javascript" src="assets/js/jQuery/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="assets/js/loginCliente.js"></script>
</body>
</html>