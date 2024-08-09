<%-- 
    Document   : visualizarCadeira
    Created on : Jul 29, 2024, 11:06:14 PM
    Author     : jamilly
--%>

<%@page import="br.edu.ifpe.recife.model.entities.Cadeira"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/tagCabueta" prefix="web2" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar cadeiras</title>
    </head>
    <body>
        
        <h1>Cadeira</h1>
        <%
            Cadeira c = (Cadeira) request.getAttribute("cadeira");
            if (c != null) {
        %>
        
        
        <web2:carrega entidade="cadeira" var="cadeiras" escopo="pagina" codigo="${param.codigo}"/>
        <h3>${pageScope.cadeiras.nome}</h3>

        <table>
            <tr>
                <th>Código</th><td><%= c.getCodigo()%></td>
            </tr>
            <tr>
                <th>Nome</th><td><%= c.getNome()%></td>
            </tr>
            <tr>
                <th>Ano</th><td><%= c.getAno()%></td>
            </tr>
            <tr>
                <th>Semestre</th><td><%= c.getSemestre()%></td>
            </tr>
            <tr>
                <th>Descrição</th><td><%= c.getDescricao()%></td>
            </tr>
        </table>
        <%}%>
    </body>
</html>
