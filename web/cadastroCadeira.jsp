<%-- 
    Document   : cadastroCadeira
    Created on : Jul 29, 2024, 11:06:46 PM
    Author     : jamilly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar cadeira</title>
    </head>
    <body>
        <h1>Cadastrar cadeira</h1>
        
        <form method="post" action="CadeiraServlet">
            Código: <input type="number" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? cadeira.codigo : ''}"></br>
            Nome: <input type="text" name="nome" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? cadeira.nome : ''}"></br>
            Ano: <input type="number" name="ano" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? cadeira.ano : ''}"></br>
            Semestre: <input type="number" name="semestre" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? cadeira.semestre : ''}"></br>
            Descrição: <input type="text" name="descricao" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? cadeira.descricao : ''}"></br>
            
            <input type="hidden" name="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}" value="1"/>
            <input type="submit" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}"/>
        </form>
    </body>
</html>
