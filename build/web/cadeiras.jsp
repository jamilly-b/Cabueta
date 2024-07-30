<%-- 
    Document   : cadeiras
    Created on : Jul 29, 2024, 11:06:26 PM
    Author     : jamilly
--%>

<%@page import="br.edu.ifpe.recife.model.repositories.CadeiraRepository"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadeira JSP</title>
    </head>
    <body>
        <h1>Cadeiras cadastrados</h1>
        <%
            String mensagem = (String)session.getAttribute("msg");
            if(mensagem != null){
                out.println("<h2>"+mensagem+"</h2>");
                session.removeAttribute("msg");
            }
        %>
        
        <button onclick="modalopen()">nova cadeira</button>
        <div id="modal" style="position: absolute; top: 200px; left: 200px;border: 1px black solid">
            
            <%@include file="cadastroCadeira.jsp"%>
            
            
            <br/>
            <button onclick="modalclose()">fechar</button>
        </div>
            
        <div id="modal2" style="position: absolute; top: 200px; left: 200px;border: 1px black solid">
            
            <%@include file="visualizarCadeira.jsp"%>

            <br/>
            <button onclick="modal2close()">fechar</button>
        </div>    
            
        <%
        
            List<Cadeira> cadeiras = CadeiraRepository.readAll();
        %> 
        
        <table>
            <tr>
                <th>Código</th><th>Nome</th><th>Ano</th><th>Semestre</th><th>Descrição</th><th>Ações</th>
            </tr>
            <%
                for(Cadeira cadeira : cadeiras){
            %>
            <tr>
                <td><%= cadeira.getCodigo()%></td>
                <td><%= cadeira.getNome()%></td>
                <td><%= cadeira.getAno()%></td>
                <td><%= cadeira.getSemestre()%></td>
                <td><%= cadeira.getDescricao()%></td>
                <td><a href="CadeiraServlet?codigo=<%=cadeira.getCodigo()%>&redirect=visualiza">visualizar</a>
                    <a href="CadeiraServlet?codigo=<%=cadeira.getCodigo()%>&redirect=atualiza">editar</a>
                    <a href="CadeiraServlet?codigo=<%=cadeira.getCodigo()%>&op=delete" onclick="deleteCadeira(<%=cadeira.getCodigo()%>)">deletar</a>
                </td>
            </tr>
            <% } %>
        </table>        
        
        <script>
            var modal = document.getElementById("modal");
            var modal2 = document.getElementById("modal2");
            
            <%
                String redirect = request.getParameter("redirect");
                if(redirect == null){
            %>
                document.body.removeChild(modal);
                document.body.removeChild(modal2);
            <%
            } else if(redirect.equals("visualiza")){ %>
                document.body.removeChild(modal);
            <%
            }else{ %>
                document.body.removeChild(modal2);
            <%}%>
            
            
            function modalclose() {
                document.body.removeChild(modal);
            }
            function modal2close() {
                document.body.removeChild(modal2);
            }
            function modalopen() {
                document.body.appendChild(modal);
            }
            
            function deleteCadeira(codigo){
                fetch("CadeiraServlet?codigo="+codigo,{method:'delete'})
                    .then(function(response){
                        location.reload();
                });
            };
            
        </script>
        
    </body>
</html>
