<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
		<head>
		<meta charset="utf-8">
		<title>Cadastro de Novela</title>
	</head>
	<body>
		<h1>Cadastro de Novela</h1>
		
		<p>A seguinte novela foi cadastrada com sucesso: </p>
		
		<p>
		T�tulo: <%=request.getParameter("titulo") %><BR />
		Hor�rio: <%=request.getParameter("horario") %> horas<BR />
		Cap�tulos: <%=request.getParameter("capitulos") %><BR />
		</p>
	</body>
</html>