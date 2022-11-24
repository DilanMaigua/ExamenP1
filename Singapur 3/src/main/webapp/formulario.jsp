<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.calificacion.notas.*"%>
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


		<br> <br>
		<br> <br>
		<br> <br>
		

		<%usuarios u =new usuarios();%>

		<br>
		<section class="contenedor-2" id="hoteles">
			<div class="textos">
				<h2>Evaluacion</h2>
				<br><br>
				<p>A continuacion se le realizara un evaluacion de todo lo
					aprendido sobre Marina-Bays</p>
				<br><br>
				<form action="respuesta.jsp" method="post">
					
					
					<table border="1" bgcolor="#FFFFFF" style="margin: 0 auto;">
						<tr>
							<td bgcolor="#5863F8" , style="border: solid 4px black;">Ingrese
								su nombre :</td>
							<td style="border: solid 4px black;"><input
								type="text" name="txtNombre" maxlength="50" pattern="[a-z A-Z]{1,50}" required /></td>
						</tr>
						<tr>
							<td bgcolor="#5863F8" , style="border: solid 4px black;">Ingrese
								su foto :</td>
							<td style="border: solid 4px black;"><input
								type="file" name="filefoto" accept=".jpg, .jpeg, .png" id="foto" required />	
								<input type="text" name="txtfoto" id="txtfoto"/></td>
						</tr>
					
					</table>
					
					<img src="<%//out.print(u.mostrarFoto(1));%>"> 
					<br> <br>
					<h2>Tendra 5 preguntas para contestar cada 1 valdra 5 puntos.
						Suerte!!</h2>

					<br> <br>


					<table border="1"  style="margin: 0 auto;">
						<tr>
							<td bgcolor="#5863F8" , style="border: solid 4px black;">La
								ciudad mostrada en la pagina web forma parte del pais?</td>
							<td style="border: solid 4px black;"><input type="text"
								name="txtpregunta1" maxlength="10" pattern="[a-z A-Z]{1,10}" required /></td>
						</tr>

						<tr>
							<td bgcolor="#5863F8" , style="border: solid 4px black;">Mariana
								Bay es considerado como:</td>
							<td style="border: solid 4px black;"><select
								name="cmbpregunta2">
									<option value="Bahia">Bahia</option>
									<option value="Ciudad">Ciudad</option>
									<option value="Playa">Playa</option>
									<option value="Parque">Parque</option></td>
							</select>
						</tr>

						<tr>
							<td bgcolor="#5863F8" , style="border: solid 4px black;">La
								atraccion turistica que tiene como objetivo ser "una ciudad
								dentro de un jardin"</td>
							<td style="border: solid 4px black;"><input type="radio"
								name="rdpregunta3" value="uno" />Clarke Quay <br> <input
								type="radio" name="rdpregunta3" value="dos" required />Gardens by the
								Bay <br> <input type="radio" name="rdpregunta3"
								value="tres" />Merlion Park</td>
						</tr>



						<tr>
							<td bgcolor="#5863F8" , style="border: solid 4px black;">En
								que anio se realizo la primera carrera de la Formula 1 en
								Singapur?</td>
							<td style="border: solid 4px black;"><input type="month"
								name="txtpregunta4" required /></td>
						</tr>

						<tr>
							<td bgcolor="#5863F8" , style="border: solid 4px black;">Beef Rendang es un plato tipico de Marina Bay?
							</td>
							<td style="border: solid 4px black;"><input type="radio"
								name="txtpregunta5" value="Si" required />Verdadero <br> <input
								type="radio" name="txtpregunta5" value="No" />Falso<br> 
						</tr>
						<tr>

							<td><input type="submit" /></td>
							<td><input type="reset" /></td>
						</tr>
					</table>


				</form>

				<br> <br>
				
					<a href="resultados.jsp">Calificaciones</a>
					
					<br> <br>
					<form action="respuesta2.jsp" method="post">
						<h2>Porfavor ingrese una valoracion a la pagina web</h2>
						<br> <br>
						
						<p>Ingrese su nombre: <% 
						String combo = u.mostrarUsuarios();
						out.print(combo);
						 %> </p>
						
						<br>
						<div style="text-align: center">
						<label for="temp">Elija una valoracion para la pagina webs del 0 al 3:</label>
						<br> <br>
						<input type="range" name="txtrango" min="0" max="3" value="1"
							step="1" id="temp" list="valoracion" oninput="rangeValue.innerText = this.value">
							
							<label style="font-size: 30px ;padding: 8px 12px;  " id="rangeValue">1  .</label>
						
						</div>
							<br> <br>
						<h2>Ingrese sugerencias sobre la pagina web</h2>
						<br> <br>
						<input type="text" name="txtsugerencia" size="150" pattern="[a-z A-Z0-9 ,-.()%@]{1,150}" maxlength="150" />
						<br>
						<br>
						<br>
						<div style="text-align: center">
						<input type="submit" />
						</div>
					</form>
				
				
				<br><br>
				<h2> Valoraciones y Sugerencias</h2>
				<br><br>
				<h3 style="color: white">
				<% Valoracion va=new Valoracion(); 
					out.print(va.consultarValoraciones());
				%>
				</h3>


				


			</div>
		</section>
	</header>
		<script>
		let foto=document.getElementById("foto");
		let setDataFoto=document.getElementById("txtfoto");
		
		foto.addEventListener("change", function() {
  		console.log(this.files);
			const reader = new FileReader();
  		reader.addEventListener("load", () => {
  		setDataFoto.value=reader.result;
  		});
  		reader.readAsDataURL(this.files[0]);
  		console.log(reader);
		});		 
		
		</script>
</body>
</html>