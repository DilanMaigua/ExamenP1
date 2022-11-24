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
		String nombre=request.getParameter("cmbUsuarios");
		String opinion=request.getParameter("txtsugerencia");
		int valo=Integer.parseInt(request.getParameter("txtrango"));
		Valoracion va = new Valoracion();
		int id_va = va.consultarmaxID()+1;
		
		va.ingresarValoracion(id_va, valo, opinion, nombre);
		response.sendRedirect("formulario.jsp");
		%>
</body>
</html>	