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
        
        <style>
            body{
                background-color: white;
            }
        </style>
    </head>
    <body>
        <h1>Cadastrar professor</h1>
        
        <form method="post" action="ProfessorServlet">
            Código: <input type="number" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? professor.codigo : ''}"></br>
            Nome: <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? professor.nome : ''}"></br>
            Email: <input type="email" name="email" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? professor.email : ''}"></br>
            Senha: <input type="password" name="senha" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? professor.senha : ''}"></br>
            
            <input type="hidden" name="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}" value="1"/>
            <input type="submit" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}"/>
        </form>
    </body>
</html>
