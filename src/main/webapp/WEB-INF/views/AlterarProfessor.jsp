<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<title>Departamento de geoci�ncias</title>
</head>
<body>
	<jsp:useBean id="log" class="br.csi.modelo.dao.ProfessorDao" />
	<c:set var="professores" value="${log.getProfessores()}" />

	<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">Projeto final
				geoci�ncias</a>
		</div>

		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">inicio</a></li>
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
							<a href="#" class="list-group-item"> Formularios </a> <a href="#"
								class="list-group-item"> Localiza��o Salas de Aula </a> <a
								href="#" class="list-group-item"> Certificados Monitoria </a> <a
								href="#" class="list-group-item"> relatorios </a> <a
								href="MVC?logica=RedirecionaCadastrarNoticia#"
								class="list-group-item">Cadastrar Noticias </a>
						</div>
					</div>

					<div class="col-md-9">
						<div class="list-group">
							<nav class="navbar navbar-default navbar-static-top">
							<div class="container">
								<form action="AlteraProfessor" method="post">
									<div class="form-group">
										<h2 align="center">Alterar Professores</h2>
										<input class="form-control" type="hidden" name="id" value="${prof.id}"/>
										<label for="nome">Nome:</label>
										<input class="form-control" type="text" name="nome" value="${prof.nome}"/>										
										<br />
										<label for="siape">SIAPE:</label>
										<input class="form-control" type="text" name="siape" value="${prof.siape}" />
										<br />
										<label for="ramal">Ramal:</label>
										<input class="form-control" type="text" name="ramal" value="${prof.ramal}" />
										<br />
										<label for="celular">Celular:</label>
										<input class="form-control" type="text" name="celular" value="${prof.celular}" />
										<br />
										<label for="sala">Sala:</label>
										<input class="form-control" type="text" name="sala" value="${prof.sala}" />
										<br />
										<label for="cpf">CPF:</label>
										<input class="form-control" type="text" name="cpf" value="${prof.cpf}" />
										<br />
										<label for="identidade">Identidade:</label>
										<input class="form-control" type="text" name="identidade" value="${prof.identidade}" />
										<br />
										<label for="email">Email:</label>
										<input class="form-control" type="text" name="email" value="${prof.email}" />
										<br />
										
										<button class="btn btn-primary" type="submit">Alterar</button>
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
									<table
										class="text-center table table-bordered table-responsive">
										<thead>
											<tr>
												<h1 align="center">professores cadastrados</h1>
												<th class="text-center">Nome</th>
												<th class="text-center">siape</th>
												<th class="text-center">ramal</th>
												<th class="text-center">celular</th>
												<th class="text-center">sala</th>
												<th class="text-center">cpf</th>
												<th class="text-center">identidade</th>
												<th class="text-center">email</th>
												<th class="text-center">alterar</th>
												<th class="text-center">deletar</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="professores" items="${professores}">
												<tr>
													<td>${professores.nome}</td>
													<td>${professores.siape}</td>
													<td>${professores.ramal}</td>
													<td>${professores.celular}</td>
													<td>${professores.sala}</td>
													<td>${professores.cpf}</td>
													<td>${professores.identidade}</td>
													<td>${professores.email}</td>
													<td><a
														class="btn btn-success btn-sm glyphicon glyphicon-refresh"
														href="AlteraProfessor?id=${professores.id}"></a></td>
													<td><a
														class="btn btn-danger  btn-sm btn btn-success btn-sm glyphicon glyphicon-remove"
														href="RemoverProfessor?id=${professores.id}"></a></td>
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


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>


