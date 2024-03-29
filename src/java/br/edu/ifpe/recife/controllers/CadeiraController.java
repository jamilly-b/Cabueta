/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.entities.Cadeira;
import br.edu.ifpe.recife.model.repositories.CadeiraRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jamilly
 */
@WebServlet(name = "CadeiraController", urlPatterns = {"/CadeiraController"})
public class CadeiraController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                if (request.getParameter("codigo") != null) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            if (request.getParameter("op") != null) {

                if (request.getParameter("op").equals("edit")) {

                    Cadeira cEdit = CadeiraRepository.read(codigo);

                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("   <title>Alterar dados da cadeira</title>");
                        out.println("    <style>");
                        out.println("        body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }");
                        out.println("        .container { max-width: 600px; margin: 20px auto; padding: 20px; margin-top: 100px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
                        out.println("        h1 { margin-top: 0; text-align: center; }");
                        out.println("        form { margin-top: 20px; }");
                        out.println("        label { display: block; margin-bottom: 5px; }");
                        out.println("        input[type=\"text\"], textarea { width: 100%; padding: 10px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }");
                        out.println("        input[type=\"submit\"] { background-color: #007bff; color: #fff; border: none; border-radius: 4px; padding: 10px 20px; cursor: pointer; font-size: 16px; }");
                        out.println("        input[type=\"submit\"]:hover { background-color: #0056b3; }");
                        out.println("        a { display: block; text-align: center; margin-top: 20px; color: #007bff; text-decoration: none; }");
                        out.println("        a:hover { text-decoration: underline; }");
                        out.println("    </style>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("    <div class=\"container\">");
                        out.println("        <h1>Editar Cadeira</h1>");
                        out.println("        <a href='CadeiraController'>Ver cadeiras cadastradas</a>");
                        out.println("        <form method='post' action='CadeiraController'>");
                        out.println("            <input type='hidden' name='codigo' value='" + cEdit.getCodigo() + "'/>");
                        out.println("            <label for=\"nome\">Nome:</label>");
                        out.println("            <input type='text' id=\"nome\" name='nome' value='" + cEdit.getNome() + "'/>");
                        out.println("            <label for=\"ano\">Ano:</label>");
                        out.println("            <input type='text' id=\"ano\" name='ano' value='" + cEdit.getAno() + "'/>");
                        out.println("            <label for=\"semestre\">Semestre:</label>");
                        out.println("            <input type='text' id=\"semestre\" name='semestre' value='" + cEdit.getSemestre() + "'/>");
                        out.println("            <label for=\"descricao\">Descrição:</label>");
                        out.println("            <textarea id=\"descricao\" name='descricao'>" + cEdit.getDescricao() + "</textarea>");
                        out.println("            <input type='submit' value='Editar'/>");
                        out.println("        </form>");
                        out.println("    </div>");
                        out.println("</body>");
                        out.println("</html>");

                        return;
                    }

                }

                if (request.getParameter("op").equals("delete")) {

                    CadeiraRepository.delete(codigo);

                    response.setContentType("text/html;charset=UTF-8");

                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html lang='pt-BR'>");
                        out.println("<head>");
                        out.println("    <meta charset='UTF-8'>");
                        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                        out.println("    <title>Remover Cadeira</title>");
                        out.println("    <style>");
                        out.println("        body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f4f4f4; }");
                        out.println("        .container { max-width: 600px; margin: auto; padding: 20px; margin-top: 100px; background-color: #fff; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,.1); }");
                        out.println("        h1 { color: #333; }");
                        out.println("        a { display: inline-block; margin-top: 20px; padding: 10px 15px; background-color: #007bff; color: #fff; text-decoration: none; border-radius: 5px; }");
                        out.println("        a:hover { background-color: #0056b3; }");
                        out.println("    </style>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("    <div class='container'>");
                        out.println("        <h1>A Cadeira foi deletada com sucesso!</h1>");
                        out.println("        <a href='CadeiraController'>Cadeiras Cadastradas</a>");
                        out.println("    </div>");
                        out.println("</body>");
                        out.println("</html>");
                    }

                }

            }
            
            Cadeira cadeira = CadeiraRepository.read(codigo);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Cadeiras</title>");
                out.println("<style>");
                out.println("    body { font-family: Arial, sans-serif; margin: 0; margin-top: 100px; padding: 0; background-color: #f7f7f7; }");
                out.println("    .container { max-width: 800px; margin: 20px auto; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }");
                out.println("    h1 { color: #333; }");
                out.println("    h5 { color: #666; }");
                out.println("    a { text-decoration: none; color: #007bff; }");
                out.println("    a:hover { text-decoration: underline; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("    <h1>Cadeira cadastrada no sistema</h1>");
                out.println("    <div>");
                out.println("        <h5>Código: " + cadeira.getCodigo() + "</h5>");
                out.println("        <h5>Nome: " + cadeira.getNome() + "</h5>");
                out.println("        <h5>Ano: " + cadeira.getAno() + "</h5>");
                out.println("        <h5>Semestre: " + cadeira.getSemestre() + "</h5>");
                out.println("        <h5>Descrição: " + cadeira.getDescricao() + "</h5>");
                out.println("    </div>");
                out.println("    <a href='CadeiraController'>Ver outras cadeiras cadastradas</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
            return;
        }

        List<Cadeira> cadeiras = CadeiraRepository.readAll();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadeiras</title>");
            out.println("<style>");
            out.println("  body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f0f0f0; }");
            out.println("  table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            out.println("  th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }");
            out.println("  th { background-color: #0056b3; color: white; }");
            out.println("  tr:hover { background-color: #f5f5f5; }");
            out.println("  a { color: #333; text-decoration: none; }");
            out.println("  a:hover { text-decoration: underline; }");
            out.println("  .header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }");
            out.println("  .header h1 { margin: 0; }");
            out.println("  .header a { background-color: #007BFF; color: white; padding: 10px 20px; border-radius: 5px; text-decoration: none; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("  <div class='header'>");
            out.println("    <h1>Cadeiras cadastradas</h1>");
            out.println("    <a href='index.html'>Home</a>");
            out.println("  </div>");
            out.println("  <table>");
            out.println("    <tr><th>Código</th><th>Nome</th><th>Ano</th><th>Semestre</th><th>Descrição</th><th>Ações</th></tr>");

            for (Cadeira cadeira : cadeiras) {
                out.println("    <tr>");
                out.println("      <td>" + cadeira.getCodigo() + "</td>");
                out.println("      <td>" + cadeira.getNome() + "</td>");
                out.println("      <td>" + cadeira.getAno() + "</td>");
                out.println("      <td>" + cadeira.getSemestre() + "</td>");
                out.println("      <td>" + cadeira.getDescricao() + "</td>");
                out.println("      <td>");
                out.println("        <a href='CadeiraController?codigo=" + cadeira.getCodigo() + "'>Detalhar</a> | ");
                out.println("        <a href='CadeiraController?codigo=" + cadeira.getCodigo() + "&op=edit'>Editar</a> | ");
                out.println("        <a href='CadeiraController?codigo=" + cadeira.getCodigo() + "&op=delete'>Deletar</a>");
                out.println("      </td>");
                out.println("    </tr>");
            }

            out.println("  </table>");
            out.println("</body>");
            out.println("</html>");

        }        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        int ano = Integer.parseInt(request.getParameter("ano"));
        int semestre = Integer.parseInt(request.getParameter("semestre"));
        String descricao = request.getParameter("descricao");

        Cadeira cadeira = new Cadeira();

        cadeira.setCodigo(codigo);
        cadeira.setNome(nome);
        cadeira.setAno(ano);
        cadeira.setSemestre(semestre);
        cadeira.setDescricao(descricao);

        Cadeira cadeiraCadastrada = CadeiraRepository.read(codigo);

        CadeiraRepository.update(cadeira);

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* Alteração de Cadeira */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alteração de Cadeira</title>");
            out.println("<style>");
            out.println("  body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f0f0f0; }");
            out.println("  a { background-color: #4CAF50; color: white; padding: 10px 20px; border-radius: 5px; text-decoration: none; }");
            out.println("  a:hover { text-decoration: underline; }");
            out.println("  h1 { margin-top: 20px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>A cadeira " + nome + " foi alterada com sucesso</h1>");
            out.println("<a href='CadeiraController'>Cadeiras Cadastradas</a>");
            out.println("</body>");
            out.println("</html>");

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
