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
	<jsp:useBean id="log" class="br.csi.modelo.dao.BolsistasDao" />
	<c:set var="bolsistas" value="${log.getBolsistas()}" />
	
	<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="RedPrin">Projeto final geociências</a>
		</div>

		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="RedPrin">inicio</a></li>
				<li><a href="RedSobre">Sobre</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Professores<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="MVC?logica=RedirecionaCadastraProfessor">Cadastrar</a></li>
						<li><a href="#produto">professor 2</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Funcionarios<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#destaques">funcionario 1</a></li>
						<li><a href="#produto">funcionario 2</a></li>
					</ul>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">bolsistas<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#destaques">bolsista 1</a></li>
						<li><a href="#produto">bolsista 2</a></li>
					</ul></li>
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
									<form action="CadastrarBolsista" method="post">
										<div class="form-group">
											<h2 align="center">Cadastrar Bolsistas</h2>
												<label for="nome">Nome:</label>
												<input class="form-control" type="text" name="nome"/>
												<br />
												<label for="siape">Matricula:</label>
												<input class="form-control" type="text" name="matricula"/>
												<br />
												<label for="ramal">Curso:</label>
												<input class="form-control" type="text" name="curso"/>
												<br />
												<label for="celular">Identidade:</label>
												<input class="form-control" type="text" name="identidade"/>
												<br />
												<label for="sala">Celular:</label>
												<input class="form-control" type="text" name="celular"/>
												<br />
												<label for="cpf">Email:</label>
												<input class="form-control" type="text" name="email"/>
												<br />
												<button class="btn btn-primary" type="submit">Cadastrar</button>
										</div>
									</form>
								</div>
							</nav>
						</div>
						
						<!-- teste mostra professores -->
						
						<div class="thumbnail" align="center">
						<div class="row">
							<div class="col-md-12">
								<section>
								<table class="text-center table table-bordered table-responsive">
									<thead>
										<tr>
											<h1 align="center">bolsistas cadastrados</h1>
											<th class="text-center">Nome</th>
											<th class="text-center">Matricula</th>
											<th class="text-center">Curso</th>
											<th class="text-center">identidade</th>
											<th class="text-center">celular</th>
											<th class="text-center">email</th>
											<th class="text-center">alterar</th>
											<th class="text-center">deletar</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="bolsistas" items="${bolsistas}">
											<tr>
												<td>${bolsistas.nome}</td>
												<td>${bolsistas.matricula}</td>
												<td>${bolsistas.curso}</td>
												<td>${bolsistas.identidade}</td>
												<td>${bolsistas.celular}</td>
												<td>${bolsistas.email}</td>
												<td><a class="btn btn-success btn-sm glyphicon glyphicon-refresh" href="RedAlteraBol?id=${bolsistas.id}"></a></td>
												<td><a class="btn btn-danger  btn-sm btn btn-success btn-sm glyphicon glyphicon-remove" href="RemoverBolsista?id=${bolsistas.id}"></a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								</section>
							</div>
						</div>
					</div>
						
						<!-- teste mostra professores -->
						
						
					</div>
				</div>
			</div>
		</div>
	</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>



