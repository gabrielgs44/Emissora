<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Cadastro de Novelas</title>
		
	</head>
	<body>
		<h1>Cadastro de Novela</h1>
		<form method="post" action="SalvarNovela">
			<fieldset>
				<legend>Dados da novela</legend>
				
				<p><label for="titulo">Título: </label>
				<input type="text" id="titulo" name="titulo" size="40"	/>
				</p>
				
				<fieldset><legend>Selecione o horário</legend>
					<input type="radio" id="h6" name="horario" value="6"	/>
					<label for="h6">6 horas</label>
					<input type="radio" id="h7" name="horario" value="7"	/>
					<label for="h7">7 horas</label>
					<input type="radio" id="h9" name="horario" value="9" checked	/>
					<label for="h9">9 horas</label>
				</fieldset>
				<p><label for="capitulos">Capítulos</label>
				<input type="number" id="capitulos" name="capitulos"	/>
				</p>
				
				<p><input type="submit" value="Cadastrar Novela"	/>
			</fieldset>
		</form>
	</body>
</html>