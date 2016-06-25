<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<title>Departamento de geociências</title>
</head>
<body>

	<jsp:useBean id="log" class="br.csi.modelo.dao.NoticiaDao" />
	<c:set var="noticias" value="${log.getNoticias()}" />
	
	<jsp:useBean id="log1" class="br.csi.modelo.dao.ProfessorDao" />
	<c:set var="professores" value="${log1.getProfessores()}" />


	<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="RedPrin">Projeto final geociências</a>
		</div>

		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="RedPrin">inicio</a></li>
				<li><a href="RedSobre">Sobre</a></li>
				<li><a href="RedProf">Professores</a></li>
				<li><a href="RedFunc">Funcionarios</a></li>
				<li><a href="RedBol">Bolsistas</a></li>
			</ul>
		</div>
	</div>
	</nav>


	<div class="container">
		<div class="row">
			<div class="jumbotron">
				<div class="container">
					<div class="container">
						<div class="row">
							<div align="center">
								<img class="img-responsive"
									src="http://w3.ufsm.br/ccne/images/ccne_logo.png">
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="list-group">
							<a class="list-group-item text text-center" style="background: #E7E7E7"> MENU </a>
							<a href="#" class="list-group-item"> Formularios </a>
							<a href="Redlocal" class="list-group-item"> Localização Salas de Aula </a>
							<a href="#" class="list-group-item"> Certificados Monitoria </a>
							<a href="#" class="list-group-item"> relatorios </a>
							<a href="RedCadastraNot" class="list-group-item"> Cadastrar Noticia </a>
							<a href="RedCadastraProf" class="list-group-item"> Cadastrar Professor </a>
							<a href="RedCadastraFunc" class="list-group-item"> Cadastrar Funcionario </a>
							<a href="RedCadastraBol" class="list-group-item"> Cadastrar Bolsista</a>
						</div>
					</div>

					<div class="col-md-9">
						<div class="list-group">
							<nav class="navbar navbar-default navbar-static-top">
							<div class="container">
								<h1 align="center">
									<b>Avisos  principal</b>
								</h1>
								<hr>
								<c:forEach var="noticias" items="${noticias}">
									<div class="thumbnail text text-center">
										<h2>
											<b>${noticias.titulo}</b>
										</h2>
										<hr>
										<p align="center">${noticias.texto}</p>
									</div>
								</c:forEach>
							</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>