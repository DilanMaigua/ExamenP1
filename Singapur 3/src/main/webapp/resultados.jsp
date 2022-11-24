<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.calificacion.notas.*"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<meta name="viewport"
		content="width=device-width, user-scalable=no, initial-scale=1.0, maximus-scale=1.0, minimun-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">	
		
		<link href="css/reset.css" rel="stylesheet">
		<link href="css/est_hotel.css" rel="stylesheet">
	
	<title>Marina Bay</title>

</head>

<body>
		<header class="main-header">
			<nav class="main-nav">
				<div class="logo">
					<span>Singapur</span>
				</div>
				<ul>
					<li><a href="index.jsp">Inicio</a></li>
					<li><a href="hoteles.jsp">Hospedaje</a></li>
					<li><a href="lugares.jsp">Interes</a></li>
					<li><a href="gastronomia.jsp">Gastronomia</a></li>
					<li><a href="video.jsp">Video</a></li>
					<li><a href="formulario.jsp">Formulario</a></li>
				</ul>
			</nav>
			
			<section class="contenedor-2" id="hoteles">
                <div class="textos">
                
                <h2>Mejores Puntuaciones del Formulario</h2>
                
                <br>
                <br>
                <br>
			<%
			Nota notas = new Nota();
			out.print(notas.consultarTodo());
			%>	
				<br>
                <br>
				
			<div class="textos">
				<a href="formulario.jsp">Regresar</a>
				</div>
			</div>
			</section>	
				
						
			</header>
	
</body>
</html>