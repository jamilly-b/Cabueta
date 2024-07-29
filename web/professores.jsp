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
            
        <%
        
            List<Professor> professores = ProfessorRepository.readAll();
        %> 
        
        <table>
            <tr>
                <th>Código</th><th>Nome</th><th>Email</th>
            </tr>
            <%
                for(Professor professor : professores){
            %>
            <tr>
                <td><%= professor.getCodigo()%></td>
                <td><%= professor.getNome()%></td>
                <td><%= professor.getEmail()%></td>
            </tr>
            <%}%>
        </table>
        
            


        
           
            
            
        
        <script>
            var modal = document.getElementById("modal");
            document.body.removeChild(modal);
            function modalclose() {
                document.body.removeChild(modal);
            }
            function modalopen() {
                document.body.appendChild(modal);
            }
        </script>
        
    </body>
</html>
