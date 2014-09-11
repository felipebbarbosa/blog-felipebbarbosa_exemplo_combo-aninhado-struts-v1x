<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Combo box aninhado com Struts 1.x - Cadastro de Cidade</title>
	<script type="text/javascript" src="jquery-1.7.min.js"></script>
</head>
<body>

	<html:form action="cadastraCidade">		
		<table border="0" cellpadding="0" cellspacing="0">		
		<tr>
			<td>País</td>
			<td>
				<html:select styleId="pais" property="paisId">
					<html:option value="-1">Selecione</html:option>
					<html:options collection="paises" property="id" labelProperty="nome"/>
				</html:select>			  
			</td>
		</tr>
		<tr>
			<td>Estado</td>
			<td>
				<html:select styleId="estado" property="estadoId">
					<html:option value="-1">Selecione</html:option>					
				</html:select>				
			</td>
		</tr>				
		<tr>
			<td>Nome</td>
			<td><html:text property="nome" styleId="nome"></html:text></td>
		</tr>					
		</table>		
		<html:submit value="Salvar"></html:submit>		
	</html:form>
	
	
	
	<script type="text/javascript">
		$(function() {
			$("#pais").change(function() {
				$("#estado").empty();
				$.getJSON('carregaEstados.do?pais=' + $(this).val(), function(data) {
					$("#estado").append('<option value=-1>Selecione</option>');
					$.each(data, function(index, item) {
						$("#estado").append('<option value=' + item.id + '>' + item.nome + '</option>');
					});
				});
			});
		});
	</script>

</body>
</html:html>