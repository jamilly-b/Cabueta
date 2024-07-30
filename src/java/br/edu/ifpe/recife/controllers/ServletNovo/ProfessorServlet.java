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
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String redirect = request.getParameter("redirect");
        
        Professor p = ProfessorRepository.read(codigo);
        
        request.setAttribute("professor", p);
        
        getServletContext().getRequestDispatcher("/professores.jsp").forward(request, response);
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
        
        String a = request.getParameter("atualizar");
        
        Professor p = new Professor();
        
        p.setNome(nome);
        p.setCodigo(codigo);
        p.setEmail(email);
        p.setSenha(senha);
        
        HttpSession session = request.getSession();
        
        if(a != null){
             ProfessorRepository.update(p);
             session.setAttribute("msg", "Professor " + p.getNome() + " foi atualizado com sucesso!");
        
        } else {     
            ProfessorRepository.create(p);
            session.setAttribute("msg", "Professor " + p.getNome() + " foi cadastrado com sucesso.");
        }
        
        response.sendRedirect("professores.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response); //To change body of generated methods, choose Tools | Templates.
    
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        Professor p = ProfessorRepository.read(codigo);
        
        ProfessorRepository.delete(codigo);
        
        HttpSession session = request.getSession();
        session.setAttribute("msg", "Professor "+ p.getNome() + " excluído.");
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
