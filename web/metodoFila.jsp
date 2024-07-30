<%-- 
    Document   : metodoFila
    Created on : Jul 29, 2024, 11:37:07 PM
    Author     : jamilly
--%>

<%@page import="br.edu.ifpe.recife.model.repositories.MetodoFilaRepository"%>
<%@page import="br.edu.ifpe.recife.model.entities.MetodoFila"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Metodos de fila cadastrados</h1>
        <%
            String mensagem = (String)session.getAttribute("msg");
            if(mensagem != null){
                out.println("<h2>"+mensagem+"</h2>");
                session.removeAttribute("msg");
            }
        %>
        
        <button onclick="modalopen()">novo método de fila</button>
        <div id="modal" style="position: absolute; top: 200px; left: 200px;border: 1px black solid">
            
            <%@include file="cadastroMetodoFila.jsp"%>
            
            
            <br/>
            <button onclick="modalclose()">fechar</button>
        </div>
            
        <div id="modal2" style="position: absolute; top: 200px; left: 200px;border: 1px black solid">
            
            <%@include file="visualizarMetodoFila.jsp"%>

            <br/>
            <button onclick="modal2close()">fechar</button>
        </div>    
            
        <%
            List<MetodoFila> metodos = MetodoFilaRepository.readAll();
        %> 
        
        <table>
            <tr>
                <th>Código</th><th>Método</th><th>Descrição</th><th>Ações</th>
            </tr>
            <%
                for(MetodoFila metodo : metodos){
            %>
            <tr>
                <td><%= metodo.getCodigo()%></td>
                <td><%= metodo.getDescricaoCurta()%></td>
                <td><%= metodo.getDescricaoLonga()%></td>
                <td><a href="MetodoFilaServlet?codigo=<%=metodo.getCodigo()%>&redirect=visualiza">visualizar</a>
                    <a href="MetodoFilaServlet?codigo=<%=metodo.getCodigo()%>&redirect=atualiza">editar</a>
                    <a href="MetodoFilaServlet?codigo=<%=metodo.getCodigo()%>&op=delete" onclick="deleteMetodoFila(<%=metodo.getCodigo()%>)">deletar</a>
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
            
            function deleteMetodoFila(codigo){
                fetch("MetodoFilaServlet?codigo="+codigo,{method:'delete'})
                    .then(function(response){
                        location.reload();
                });
            };
            
        </script>
        
    </body>
</html>
