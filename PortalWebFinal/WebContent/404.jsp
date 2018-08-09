<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Página não encontrada</title>
<c:import url="imports.jsp" />
</head>
<body>

	<c:import url="menu.jsp" />
	
	<!-- Página de erro - Começo -->
	<div class="inner-page-banner-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="breadcrumb-area">
						<h1>ERROR 404 - Página não encontrada</h1>
						<ul>
							<li><a href="javascript:history.back()">voltar</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Página de erro - Fim -->
	
	<c:import url="footer.jsp" />
	<c:import url="scripts.jsp" />
</body>
</html>
