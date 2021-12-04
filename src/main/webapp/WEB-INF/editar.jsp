<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="cl.desafiolatam.bibliotecaBooklet.model.Libro"%>
<%@page import="cl.desafiolatam.bibliotecaBooklet.vo.LibroVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<title>Biblioteca Booklet</title>
</head>
<body>
	<section>
		<div class="container">
			<h1 class="mt-3">Biblioteca Booklet</h1>
			<h3 class="mt-3">EDITAR LIBRO</h3>
			<h4>${mensaje}</h4>

			<form action="/editar" method="post">
				<input type="hidden" name="id" value="${VO.getId()}">
				
				<div class="row g-3 align-items-center">
					<div class="input-group">
						<div class="col-8">
							<label class="form-label" for="titulo">Título</label>
							<input type="text" class="form-control" id="titulo" name="titulo">
						</div>

						<div class="col-4">
							<label class="form-label" for="anio">Año de Publicación</label>
							<input type="text" class="form-control" id="anio" name="anio">
						</div>
					</div>
					
					<div class="input-group">
						<div class="col-md-6">
							<label class="form-label" for="autor">Autor</label>
							<input type="text" class="form-control" id="autor" name="autor">
						</div>
						
						<div class="col-md-4">
							<label class="form-label" for="imprenta">Imprenta</label>
							<input type="text" class="form-control" id="imprenta" name="imprenta">
						</div>
						
						<div class="col-md-2 mt-5">
							<label class="form-label" for="disponible">Disponible</label>
							<select class="form-select" id="disponible" name="disponible">
								<option selected> </option>
								<option value="true" label="SI"></option>
								<option value="false" label="NO"></option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-12 text-start mt-2">
					<button class="btn btn-primary" type="submit">Editar</button>
				</div>
				
			</form>
		</div>
	</section>
</body>
</html>
