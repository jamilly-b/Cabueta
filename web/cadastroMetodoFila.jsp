<%-- 
    Document   : cadastroMetodoFila
    Created on : Jul 29, 2024, 11:36:34 PM
    Author     : jamilly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar Metodo de Fila</h1>
        
        <form method="post" action="MetodoFilaServlet">
            Código: <input type="number" name="codigo" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? metodoFila.codigo : ''}"></br>
            Método: <input type="text" name="descricaoCurta" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? metodoFila.descricaoCurta : ''}"></br>
            Descrição: <input type="text" name="descricaoLonga" value="${(param.redirect != null && param["redirect"] eq 'atualiza')? metodoFila.descricaoLonga : ''}"></br>
            
            <input type="hidden" name="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}" value="1"/>
            <input type="submit" value="${(param.redirect != null && param["redirect"] eq 'atualiza')?'atualizar':'cadastrar'}"/>
        </form>
    </body>
</html>
