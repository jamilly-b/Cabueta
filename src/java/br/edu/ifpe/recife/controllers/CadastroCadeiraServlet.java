package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.entities.Cadeira;
import br.edu.ifpe.recife.model.repositories.CadeiraRepository;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jamilly
 */
@WebServlet(name = "CadastroCadeiraServlet", urlPatterns = {"/CadastroCadeiraServlet"})
public class CadastroCadeiraServlet extends HttpServlet {

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
       
        
        Cadeira c = new Cadeira();
        
        c.setNome(nome);
        c.setCodigo(codigo);
        c.setAno(ano);
        c.setSemestre(semestre);
        c.setDescricao(descricao);
        
        CadeiraRepository.create(c);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* Cadastro de Cadeira */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadeira Cadastrado</title>");
            out.println("<style>");
            out.println("  body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background-color: #f0f0f0; }");
            out.println("  h1 { margin-top: 20px; }");
            out.println("  a { background-color: #4CAF50; color: white; padding: 10px 20px; border-radius: 5px; text-decoration: none; }");
            out.println("  a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>A Cadeira " + c.getNome() + " foi cadastrada.</h1>");
            out.println("<a href='index.html'>Voltar para página inicial</a>");
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
