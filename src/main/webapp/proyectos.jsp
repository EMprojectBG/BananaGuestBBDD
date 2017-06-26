<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<section id="detalle">
	<div>
			<h2>Detalle del proyecto:</h2>
			<li>
			<h4>Nombre:</h4>
			${ProyectoB.nombreProyecto}
			</li>
			<li>
			<h4>ID:</h4>
			${ProyectoB.idProyecto}
			</li>
			<li>
			<h4>Descrpición:</h4>
			${ProyectoB.descProyecto}
			</li>
			<li>
			<h4>Fecha de finalización:</h4>
			${ProyectoB.fechaFinProyecto}
			</li>
			<li>
			<h4>Estado:</h4>
			${ProyectoB.estado}
			</li>
	</div>
	<div>
		<c:forEach var="tar"  items="${listaDeTareas}" varStatus="counter">
		<h2>Tareas asociadas:</h2>
			<li>
			<span>${tar.nombreTarea}</span>
			<span>${tar.descTarea}</span>
			<span>${tar.responsable}</span>
			</li>
		</c:forEach>
	</div>
</section>

</body>