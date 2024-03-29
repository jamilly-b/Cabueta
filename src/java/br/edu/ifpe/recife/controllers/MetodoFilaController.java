/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.entities.MetodoFila;
import br.edu.ifpe.recife.model.repositories.MetodoFilaRepository;
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
@WebServlet(name = "MetodoFilaController", urlPatterns = {"/MetodoFilaController"})
public class MetodoFilaController extends HttpServlet {

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

            /*
                dentro deste if está o código que apresenta o 
                formulário de alteração
            */
            if (request.getParameter("op") != null) {

                if (request.getParameter("op").equals("edit")) {

                    MetodoFila mfEdit = MetodoFilaRepository.read(codigo);

                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("   <title>Alterar dados do Método de Fila</title>");
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
                        out.println("    <div class='container'>");
                        out.println("        <h1>Editar Método de Fila</h1>");
                        out.println("        <form method='post'>");
                        out.println("            <input type='hidden' name='codigo' value='" + mfEdit.getCodigo() + "'/>");
                        out.println("            <label for='descricaoCurta'>Descrição Curta:</label>");
                        out.println("            <input type='text' id='descricaoCurta' name='descricaoCurta' value='" + mfEdit.getDescricaoCurta() + "'/>");
                        out.println("            <label for='descricaoLonga'>Descrição Longa:</label>");
                        out.println("            <input type='text' id='descricaoLonga' name='descricaoLonga' value='" + mfEdit.getDescricaoLonga() + "'/>");
                        out.println("            <input type='submit' value='Editar'/>");
                        out.println("        </form>");
                        out.println("    </div>");
                        out.println("</body>");
                        out.println("</html>");
                        return;
                    }
                }

                /*
                 dentro deste if está o código para realizar o delete de estudante
                */

                if (request.getParameter("op").equals("delete")) {

                    MetodoFilaRepository.delete(codigo);

                    response.setContentType("text/html;charset=UTF-8");

                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html lang='pt-BR'>");
                        out.println("<head>");
                        out.println("    <meta charset='UTF-8'>");
                        out.println("    <title>Remover Método</title>");
                        out.println("    <style>");
                        out.println("        body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f4f4f4; }");
                        out.println("        .container { max-width: 600px; margin: auto; padding: 20px; margin-top: 100px; background-color: #fff; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,.1); }");
                        out.println("        h1 { color: #333; text-align: center; }");
                        out.println("        a { display: block; text-align: center; margin-top: 20px; background-color: #007bff; color: #fff; padding: 10px 15px; border-radius: 5px; text-decoration: none; }");
                        out.println("        a:hover { background-color: #0056b3; }");
                        out.println("    </style>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("    <div class='container'>");
                        out.println("        <h1>O Método de Fila foi deletado com sucesso!</h1>");
                        out.println("        <a href='MetodoFilaController'>Metodo Fila Cadastrados</a>");
                        out.println("    </div>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }

            /*
                O código abaixo apresenta a tabela com todos os 
                métodos de fila cadastrados. Este código é executado quando
                o MetodoFilaServlet é chamado sem parametros
            */

            MetodoFila metodoFila = MetodoFilaRepository.read(codigo);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Métodos de Fila</title>");
                out.println("<style>");
                out.println("    body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f7f7f7; }");
                out.println("    .container { max-width: 800px; margin: 20px auto; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }");
                out.println("    h1 { color: #333; text-align: center; }");
                out.println("    h5 { color: #666; }");
                out.println("    a { text-decoration: none; color: #007bff; }");
                out.println("    a:hover { text-decoration: underline; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("    <h1>Método de Fila cadastrado no sistema</h1>");
                out.println("    <div>");
                out.println("        <h5>Código: " + metodoFila.getCodigo() + "</h5>");
                out.println("        <h5>Descrição Curta: " + metodoFila.getDescricaoCurta() + "</h5>");
                out.println("        <h5>Descrição Longa: " + metodoFila.getDescricaoLonga() + "</h5>");
                out.println("    </div>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
            return;
        }

        List<MetodoFila> metodosFila = MetodoFilaRepository.readAll();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Métodos de Fila</title>");
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
            out.println("    <h1>Métodos de Fila cadastrados</h1>");
            out.println("    <a href='index.html'>Home</a>");
            out.println("  </div>");
            out.println("    <table>");
            out.println("      <tr><th>Código</th><th>Descrição Curta</th><th>Descrição Longa</th><th>Ações</th></tr>");

            for (MetodoFila mf : metodosFila) {
                out.println("    <tr>");
                out.println("      <td>" + mf.getCodigo() + "</td>");
                out.println("      <td>" + mf.getDescricaoCurta() + "</td>");
                out.println("      <td>" + mf.getDescricaoLonga() + "</td>");
                out.println("      <td>");
                out.println("        <a href='MetodoFilaController?codigo=" + mf.getCodigo() + "'>Detalhar</a> | ");
                out.println("        <a href='MetodoFilaController?codigo=" + mf.getCodigo() + "&op=edit'>Editar</a> | ");
                out.println("        <a href='MetodoFilaController?codigo=" + mf.getCodigo() + "&op=delete'>Deletar</a>");
                out.println("      </td>");
                out.println("    </tr>");
            }

            out.println("  </table>");
            out.println("</div>");
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
        String descricaoCurta = request.getParameter("descricaoCurta");
        String descricaoLonga = request.getParameter("descricaoLonga");

        MetodoFila metodoFila = new MetodoFila();

        metodoFila.setCodigo(codigo);
        metodoFila.setDescricaoCurta(descricaoCurta);
        metodoFila.setDescricaoLonga(descricaoLonga);

        MetodoFila metodoFilaExistente = MetodoFilaRepository.read(codigo);

        MetodoFilaRepository.update(metodoFila);

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* Alteração do Método de Fila */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alteração de Método de Fila</title>");
            out.println("<style>");
            out.println("  body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f0f0f0; }");
            out.println("  a { background-color: #4CAF50; color: white; padding: 10px 20px; border-radius: 5px; text-decoration: none; }");
            out.println("  a:hover { text-decoration: underline; }");
            out.println("  h1 { margin-top: 20px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>O método de fila '" + descricaoCurta + "' foi alterado com sucesso</h1>");
            out.println("<a href='MetodoFilaController'>Voltar aos Métodos de Fila</a>");
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
