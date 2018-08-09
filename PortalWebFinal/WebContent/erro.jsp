<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>ERRO</title>
</head>
<body>
	<h1><font color='red'>ERRO</font></h1>
	<br>
	<br>
	<c:out value="${mensagemFimOperacao}"/>
	<br>
	<a href="javascript:history.back()">voltar</a>
</body>
</html>