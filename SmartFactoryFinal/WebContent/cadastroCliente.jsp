<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="#">
	<title>Cadastro | Smart Factory</title>
	<link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
	<link href="assets/css/cadastroCliente.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="form">
		<div class="tab-content">
			<div id="signup">
				<h1>Complete seu Cadastro</h1>
				<form action="#" method="post">
					<div class="top-row">
						<div class="field-wrap">
							<label for="nome">Nome Fantasia<span class="req">*</span></label>
							<input type="text" name="nomeFantasia">
						</div>
						<div class="field-wrap">
							<label for="sobrenome">Razão Social<span class="req">*</span></label>
							<input type="text" name="razaoSocial">
						</div>
					</div>
					<div class="field-wrap">
						<label for="rg">CNPJ<span class="req">*</span></label> <input
							type="text" name="cnpj" size="18" maxlength="18">
					</div>
					<div class="top-row">
						<div class="field-wrap">
							<label for="nome" class="active highlight">Nome<span
								class="req">*</span></label> <input type="text" name="nome"
								value="Gabriel">
						</div>
						<div class="field-wrap">
							<label for="sobrenome" class="active highlight">Sobrenome<span
								class="req">*</span></label> <input type="text" name="sobrenome"
								value="Vizone">
						</div>
					</div>
					<div class="telefone top-row">
						<div class="field-wrap">
							<label for="ddd">DDD<span class="req">*</span></label> <input
								type="text" name="ddd" size="2" maxlength="2">
						</div>
						<div class="field-wrap">
							<label for="ddd">Número de telefone<span class="req">*</span></label>
							<input type="text" name="telefone" size="9" maxlength="9">
						</div>
					</div>
					<div class="field-wrap">
						<label for="cep">CEP<span class="req">*</span></label> <input
							type="text" name="cep" size="9" maxlength="9">
					</div>
					<div class="top-row">
						<div class="field-wrap">
							<label for="estado">Estado<span class="req">*</span></label> <input
								type="text" name="estado">
						</div>
						<div class="field-wrap">
							<label for="cidade">Cidade<span class="req">*</span></label> <input
								type="text" name="cidade">
						</div>
					</div>
					<div class="field-wrap">
						<label for="rua">Rua<span class="req">*</span></label> <input
							type="text" name="rua">
					</div>
					<div class="top-row">
						<div class="field-wrap">
							<label for="numero">Numero<span class="req">*</span></label> <input
								type="text" name="numero" size="4">
						</div>
						<div class="field-wrap">
							<label for="complemento">Complemento</label> <input type="text"
								name="complemento">
						</div>
					</div>
					<div class="field-wrap">
						<label for="bairro">Bairro<span class="req">*</span></label> <input
							type="text" name="bairro">
					</div>
					<div class="field-wrap">
						<label for="email" class="active highlight">E-mail</label> <input
							type="text" name="email" value="gabriel.vizone@gmail.com">
					</div>
					<div class="top-row">
						<div class="field-wrap">
							<label for="pass" class="active highlight">Senha</label> <input
								type="password" name="senha" value="12345678">
						</div>
						<div class="field-wrap">
							<label for="passconfirm">Confirme a senha</label> <input
								type="password" name="reconfirmarSenha">
						</div>
					</div>
					<button type="submit" class="button button-block">
						<a href="cadastro.html">Cadastrar</a>
					</button>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="assets/js/jQuery/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="assets/js/loginCliente.js"></script>
</body>
</html>