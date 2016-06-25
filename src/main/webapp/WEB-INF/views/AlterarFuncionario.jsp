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
	<jsp:useBean id="log" class="br.csi.modelo.dao.FuncionarioDao" />
	<c:set var="funcionarios" value="${log.getFuncionarios()}" />

	
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
									<form action="AlteraFuncionario" method="post">
										<div class="form-group">
											<h2 align="center">Alterar Funcionarios</h2>
										<input class="form-control" type="hidden" name="id" value="${func.id}"/>
										<label for="nome">Nome:</label>
										<input class="form-control" type="text" name="nome" value="${func.nome}"/>										
										<br />
										<label for="siape">SIAPE:</label>
										<input class="form-control" type="text" name="siape" value="${func.siape}" />
										<br />
										<label for="ramal">Ramal:</label>
										<input class="form-control" type="text" name="ramal" value="${func.ramal}" />
										<br />
										<label for="celular">Celular:</label>
										<input class="form-control" type="text" name="celular" value="${func.celular}" />
										<br />
										<label for="sala">Sala:</label>
										<input class="form-control" type="text" name="sala" value="${func.sala}" />
										<br />
										<label for="cpf">CPF:</label>
										<input class="form-control" type="text" name="cpf" value="${func.cpf}" />
										<br />
										<label for="identidade">Identidade:</label>
										<input class="form-control" type="text" name="identidade" value="${func.identidade}" />
										<br />
										<label for="email">Email:</label>
										<input class="form-control" type="text" name="email" value="${func.email}" />
										<br />
										
										<button class="btn btn-primary" type="submit">Alterar</button>
										</div>
									</form>
								</div>
							</nav>
						</div>
						
						<!-- teste mostra funcionarios -->
						
						<div class="thumbnail" align="center">
						<div class="row">
							<div class="col-md-12">
								<section>
								<table class="text-center table table-bordered table-responsive">
									<thead>
										<tr>
											<h1 align="center">Funcionarios cadastrados</h1>
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

										<c:forEach var="funcionarios" items="${funcionarios}">
												<tr>
													<td>${funcionarios.nome}</td>
													<td>${funcionarios.siape}</td>
													<td>${funcionarios.ramal}</td>
													<td>${funcionarios.celular}</td>
													<td>${funcionarios.sala}</td>
													<td>${funcionarios.cpf}</td>
													<td>${funcionarios.identidade}</td>
													<td>${funcionarios.email}</td>
													<td><a class="btn btn-success btn-sm glyphicon glyphicon-refresh" href="AlteraFuncionario?id=${funcionarios.id}"></a></td>
													<td><a class="btn btn-danger  btn-sm btn btn-success btn-sm glyphicon glyphicon-remove" href="RemoverFuncionario?id=${funcionarios.id}"></a></td>
												</tr>
											</c:forEach>
									</tbody>
								</table>

								</section>
							</div>
						</div>
					</div>
						
						<!-- teste mostra funcionarios -->
						
						
					</div>
				</div>
			</div>
		</div>
	</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>



