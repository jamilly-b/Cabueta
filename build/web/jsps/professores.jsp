<%-- 
    Document   : professores
    Created on : Jul 29, 2024, 3:21:47 PM
    Author     : jamilly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Professor JSP</title>
    </head>
    <body>
        <h1>Professores cadastrados</h1>
        <%
            String mensagem = (String)session.getAttribute("msg");
            if(mensagem != null){
                out.println("<h2>"+mensagem+"</h2>");
            }
        %>
    </body>
</html>
