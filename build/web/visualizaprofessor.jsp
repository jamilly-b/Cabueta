<%-- 
    Document   : visualizaprofessor
    Created on : Jul 29, 2024, 5:01:28 PM
    Author     : jamilly
--%>

<%@page import="br.edu.ifpe.recife.model.entities.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar professor</title>
    </head>
    <body>
        <h1>Professor</h1>
        <%
            Professor p = (Professor) request.getAttribute("professor");
            if (p != null) {
        %>

        <table>
            <tr>
                <th>Código</th><td><%= p.getCodigo()%></td>
            </tr>
            <tr>
                <th>Nome</th><td><%= p.getNome()%></td>
            </tr>
            <tr>
                <th>Email</th><td><%= p.getEmail()%></td>
            </tr>
        </table>
        <%}%>
    </body>
</html>
