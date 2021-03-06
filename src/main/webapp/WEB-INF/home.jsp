<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="cl.desafiolatam.bibliotecaBooklet.model.Libro"%>
<%@page import="cl.desafiolatam.bibliotecaBooklet.vo.LibroVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<title>Biblioteca Booklet</title>
</head>
<body>
	<section>
		<div class="container">
			<h1 class="mt-3">Biblioteca Booklet</h1>
			<h3 class="mt-3">${mensaje}</h3>
			<div class="container-fluid d-flex justify-content-between mx-2">
				<div>
					<h2 class="mt-3">Listado de Libros</h2>
				</div>
				<div class="btn-toolbar" role="toolbar"
					aria-label="Toolbar with button groups">

					<div class="btn-group mt-3" role="group" aria-label="first group">
						<form:form action="/buscarLibros" method="post"
							modelAttribute="libro">
							<input type="text" name="filtro"
								placeholder="Buscar por titulo o autor">
							<button class="btn btn-primary" type="submit">Buscar</button>
						</form:form>
					</div>
					<div class="btn-group" role="group" aria-label="second group">
						<div class="col-md-12 text-start">
							<a class="btn btn-primary mt-3" href="agregarForm" role="button">Agregar
								Libro</a>
						</div>
					</div>
				</div>
			</div>

			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Titulo</th>
						<th>Año de Publicación</th>
						<th>Autor</th>
						<th>Imprenta</th>
						<th>Disponibilidad</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${VO.libros}" var="libro">
						<tr>
							<td>${libro.getId()}</td>
							<td>${libro.getTitulo()}</td>
							<td>${libro.getAnio()}</td>
							<td>${libro.getAutor()}</td>
							<td>${libro.getImprenta()}</td>
							<td><select onChange="window.location.href=this.value"
								class="form-select ms-2" aria-label="form-select"
								id="disponible" name="disponible">
									<c:if test="${libro.getDisponible() == true  }">
										<option
											value="/disponiblidad?id=${libro.getId()}&disponible=${true}">Si</option>
										<option
											value="/disponiblidad?id=${libro.getId()}&disponible=${false}">No</option>
									</c:if>
									<c:if test="${libro.getDisponible() == false  }">
										<option
											value="/disponiblidad?id=${libro.getId()}&disponible=${false}">No</option>
										<option
											value="/disponiblidad?id=${libro.getId()}&disponible=${true}">Si</option>
									</c:if>
							</select></td>
							<td><a href="editarForm?id=${libro.getId()}">Editar</a><br />
								<a href="eliminar?id=${libro.getId()}">Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>

</body>
</html>