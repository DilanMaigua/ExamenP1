<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.calificacion.notas.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
 
 	<%
	String pregunta1=request.getParameter("txtpregunta1");
	String pregunta2=request.getParameter("cmbpregunta2");
	String pregunta3=request.getParameter("rdpregunta3");
	String pregunta4=request.getParameter("txtpregunta4");
	String pregunta5=request.getParameter("txtpregunta5");
 	String nombre=request.getParameter("txtNombre");
	String foto=request.getParameter("txtfoto");
 	
 	int nota1=1;
 	int nota2=1;
 	int nota3=1;
 	int nota5=1;
 	int nota4=1;
 	int notafinal=1;
 	
 	if(pregunta1.equals("Singapur") || pregunta1.equals("SINGAPUR") || pregunta1.equals("singapur") ){
 		nota1=5;
 	}else{
 		nota1=0;
 	}
 	
 	
 	if(pregunta2.equals("Bahia")){
 		nota2=5;
 	}else{
 		nota2=0;
 	}
 	
 	
 	if(pregunta3.equals("dos")){
 		nota3=5;
 	}else{
 		nota3=0;
 	}
 	
 	if(pregunta4.equals("2008-09")){
 		nota4=5;
 	}else{
 		nota4=0;
 	}
 	
 	if(pregunta5.equals("Si")){
 		nota5=5;
 	}else{
 		nota5=0;
 	}
 	
 	notafinal=nota1+nota2+nota3+nota4+nota5;
 	
 
 	Nota notas = new Nota();
	int idno=notas.consultarmaxID()+1;
	int idus=notas.consultarmaxID()+1;
 	notas.ingresarNotas(idno, nota1, nota2, nota3, nota4, nota5, notafinal, nombre); 
	
 	usuarios u = new usuarios();
 	u.ingresarUsuario(idus,nombre,foto);
 	
 	response.sendRedirect("formulario.jsp");
 	%>
 	
 	
 	
</body>
</html>