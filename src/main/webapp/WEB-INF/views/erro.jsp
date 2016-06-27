<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="navbar-fixed-top.css" rel="stylesheet">
    <script src="resources/js/ie-emulation-modes-warning.js"></script>
      <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<title>Departamento de geociências</title>
</head>
<body>
	
	<jsp:useBean id="log3" class="br.csi.modelo.dao.NoticiaDao" />
	<c:set var="noticias" value="${log3.getNoticias()}" />
	
	<jsp:useBean id="log2" class="br.csi.modelo.dao.FuncionarioDao" />
	<c:set var="funcionarios" value="${log2.getFuncionarios()}" />

	<jsp:useBean id="log" class="br.csi.modelo.dao.ProfessorDao" />
	<c:set var="professores" value="${log.getProfessores()}" />
	
	<jsp:useBean id="log1" class="br.csi.modelo.dao.BolsistasDao" />
	<c:set var="bolsistas" value="${log1.getBolsistas()}" />

	<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="index">Dpto Geociências</a>
		</div>

		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index">Inicio</a></li>
				<li><a href="RedSobre">Sobre</a></li>
				<li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Professores <span class="caret"></span></a>
              <ul class="dropdown-menu">
              <c:forEach var="professores" items="${professores}">
                <li><a href="RedAlteraProf2Al?id=${professores.id}">${professores.nome}</a></li>
               </c:forEach>
               </ul>
              </li>
              
              				<li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Funcionarios <span class="caret"></span></a>
              <ul class="dropdown-menu">
              <c:forEach var="funcionarios" items="${funcionarios}">
                <li><a href="RedAlteraProf2Al?id=${funcionarios.id}">${funcionarios.nome}</a></li>
               </c:forEach>
               </ul>
              </li>
              
              <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Bolsistas <span class="caret"></span></a>
              <ul class="dropdown-menu">
              <c:forEach var="bolsistas" items="${bolsistas}">
                <li><a href="RedAlteraBol2Al?id=${bolsistas.id}">${bolsistas.nome}</a></li>
               </c:forEach>
               </ul>
              </li>
					<li>
					<div id="navbar" class="navbar-collapse collapse">
						<form action="login" class="navbar-form navbar-right">
							<div class="form-group">
								<input class="form-control" type="text" id="login"
									placeholder="Nome" name="login"
									placeholder="Informe o seu nome" />
							</div>
							<div class="form-group">
								<input class="form-control" type="password" laceholder="Senha"
									id="senha" name="senha" />
							</div>
							<button type="submit" class="btn btn-success">Logar</button>
						</form>
					</div>
				</li>
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
							<a href="RedForm" class="list-group-item"> Formularios </a>
							<a href="Redlocal" class="list-group-item">Localização Salas de Aula </a>
							<a href="RedCert" class="list-group-item"> Certificados Monitoria </a>
						</div>
					</div>

					<div class="col-md-9">
						<div class="list-group">
							<nav class="navbar navbar-default navbar-static-top">
							<div class="container">
								<h1 align="center">
									<b>Avisos</b>
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