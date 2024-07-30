<%-- 
    Document   : visualizarMetodoFila
    Created on : Jul 29, 2024, 11:36:48 PM
    Author     : jamilly
--%>

<%@page import="br.edu.ifpe.recife.model.entities.MetodoFila"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Metodo de fila</h1>
        <%
            MetodoFila mf = (MetodoFila) request.getAttribute("metodoFila");
            if (mf != null) {
        %>

        <table>
            <tr>
                <th>Código</th><td><%= mf.getCodigo()%></td>
            </tr>
            <tr>
                <th>Método de fila</th><td><%= mf.getDescricaoCurta()%></td>
            </tr>
            <tr>
                <th>Descrição</th><td><%= mf.getDescricaoLonga()%></td>
            </tr>
        </table>
        <%}%>
    </body>
</html>
