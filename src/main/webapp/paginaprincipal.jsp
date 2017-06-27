<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1 ,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Banana APP</title>
</head>

<body>
	<header><jsp:include page="header.jsp"></jsp:include></header>

	<section>

		<h3>Proyectos Activos:</h3>
		<c:forEach var="proy" items="${listaProyectosAmostrar}" varStatus="counter">
			<div>
				<c:if test="${proy.estado}">
					<li><a href="proyectosServlet?idp=${proy.idProyecto}"
						| <span>${proy.nombreProyecto}</span> -
				  <span>${proy.idProyecto}</span> -
				  <span>${proy.fechaFinProyecto}</span>></a>
					</li>
				</c:if>
			</div>
			<div>

				<c:if test="${!proy.estado}">
					<li>a <span>${proy.nombreProyecto}</span> - <span>${proy.idProyecto}</span>
						- <span>${proy.fechaFinProyecto}</span>
					</li>

				</c:if>


			</div>
		</c:forEach>

	</section>





























	<!-- modal edit -->
	<div id='modal_edit' class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" id='btn_x' data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id='tit_editarproyecto'>Editar
						Proyecto</h4>
				</div>
				<div class="modal-body" id="modal_inner"></div>
				<div class="modal-footer">
					<button id="btn_closemodal" class="btn btn-default"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id='btn_save'>Save
						changes</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!-- modal nuevo proyecto-->
	<div id='modal_nuevo' class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" id='btn_xnuevo'
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id='tit_nuevo_proyecto'>Nuevo proyecto</h4>
				</div>
				<div class="modal-body" id="modalnuevo_inner"></div>
				<div class="modal-footer">
					<button id="btn_closemodalnuevo" class="btn btn-default"
						data-dismiss="modal">Close</button>
					<button id='btn_save' class="btn btn-primary">Save changes</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



	<footer>
		<center>
			<strong>Powered by <a href="" target="_blank">BananaProjects</a></strong>
		</center>
		<br> <br>
	</footer>

</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src='scripts/bananaguest.js'></script>

</html>