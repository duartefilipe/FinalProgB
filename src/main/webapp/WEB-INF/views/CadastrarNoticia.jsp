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

	<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="RedPrin">Projeto final
				geociências</a>
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
								<form action="cadastrarNoticia" method="post">
									<div class="form-group">
										<h2 align="center">Cadastrar Noticias</h2>
										
										<label for="titulo">titulo:</label> <input
											class="form-control" type="text" id="titulo" name="titulo" />
										<br /> <label for="texto">texto:</label> <input
											class="form-control" type="text" id="texto" name="texto" />
										<br />

										<button class="btn btn-primary" type="submit">Cadastrar</button>
									</div>
								</form>
							</div>
							</nav>
						</div>

						<!-- teste mostra noticias -->

						<div class="thumbnail" align="center">
							<div class="row">
								<div class="col-md-12">
								<h2>noticias cadastradas</h2>
									<table class="text-center table table-striped table-responsive">
										<thead>
											<tr>
												<th class="text-center">titulo</th>
												<th class="text-center">texto</th>
												<th class="text-center">alterar</th>
												<th class="text-center">deletar</th>

											</tr>
										</thead>
										<tbody>

											<c:forEach var="noticias" items="${noticias}">
												<tr>
													<td>${noticias.titulo}</td>
													<td>${noticias.texto}</td>
													<td><a
														class="btn btn-success btn-sm glyphicon glyphicon-refresh"
														href="RedAlteraNoti?id=${noticias.id}">
													</a></td>
													<td><a a
														class="btn btn-danger  btn-sm btn btn-success btn-sm glyphicon glyphicon-remove"
														href="RemoverNoticia?id=${noticias.id}">
													</a></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>

						<!-- teste mostra noticias -->

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



