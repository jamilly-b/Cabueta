<%-- 
    Document   : cadastroProfessor
    Created on : Jul 29, 2024, 4:06:57 PM
    Author     : jamilly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Professor</title>
    </head>
    <body>
        <h1>Cadastrar professor</h1>
        
        <form method="post" action="ProfessorServlet">
            Código: <input type="number" name="codigo"></br>
            Nome: <input type="text" name="nome"></br>
            Email: <input type="email" name="email"></br>
            Senha: <input type="password" name="senha"></br>
            
            <input type="submit" value="cadastrar"/>
        </form>
    </body>
</html>
