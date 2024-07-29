/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.ServletNovo;

import br.edu.ifpe.recife.model.entities.Professor;
import br.edu.ifpe.recife.model.repositories.ProfessorRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jamilly
 */
@WebServlet(name = "ProfessorServlet", urlPatterns = {"/ProfessorServlet"})
public class ProfessorServlet extends HttpServlet {

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
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Professor p = new Professor();
        
        p.setNome(nome);
        p.setCodigo(codigo);
        p.setEmail(email);
        p.setSenha(senha);
        
        ProfessorRepository.create(p);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("msg", "Professor " + p.getNome() + " foi cadastrado com sucesso.");
        response.sendRedirect("jsps/professores.jsp");
    
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
