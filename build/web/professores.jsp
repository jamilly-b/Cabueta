<%-- 
    Document   : professores
    Created on : Jul 29, 2024, 3:21:47 PM
    Author     : jamilly
--%>

<%@page import="br.edu.ifpe.recife.model.entities.Professor"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.ifpe.recife.model.repositories.ProfessorRepository"%>
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
                session.removeAttribute("msg");
            }
        %>
        
        <button onclick="modalopen()">novo professor</button>
        <div id="modal" style="position: absolute; top: 200px; left: 200px;border: 1px black solid">
            
            <%@include file="cadastroProfessor.jsp"%>
            
            
            <br/>
            <button onclick="modalclose()">fechar</button>
        </div>
            
        <div id="modal2" style="position: absolute; top: 200px; left: 200px;border: 1px black solid">
            
            <%@include file="visualizaprofessor.jsp"%>

            <br/>
            <button onclick="modal2close()">fechar</button>
        </div>    
            
        <%
        
            List<Professor> professores = ProfessorRepository.readAll();
        %> 
        
        <table>
            <tr>
                <th>Código</th><th>Nome</th><th>Email</th><th>Ações</th>
            </tr>
            <%
                for(Professor professor : professores){
            %>
            <tr>
                <td><%= professor.getCodigo()%></td>
                <td><%= professor.getNome()%></td>
                <td><%= professor.getEmail()%></td>
                <td><a href="ProfessorServlet?codigo=<%=professor.getCodigo()%>&redirect=visualiza">visualizar</a>
                    <a href="ProfessorServlet?codigo=<%=professor.getCodigo()%>&redirect=atualiza">editar</a>
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
        </script>
        
    </body>
</html>
