/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.ServletNovo;

import br.edu.ifpe.recife.model.entities.Cadeira;
import br.edu.ifpe.recife.model.repositories.CadeiraRepository;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CadeiraServlet", urlPatterns = {"/CadeiraServlet"})
public class CadeiraServlet extends HttpServlet {

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
        
        Cadeira c = CadeiraRepository.read(codigo);
        
        request.setAttribute("cadeira", c);
        
        getServletContext().getRequestDispatcher("/cadeiras.jsp").forward(request, response);
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
        
        String a = request.getParameter("atualizar");
        
        Cadeira c = new Cadeira();

        c.setCodigo(codigo);
        c.setNome(nome);
        c.setAno(ano);
        c.setSemestre(semestre);
        c.setDescricao(descricao);
        
        HttpSession session = request.getSession();
        
        if(a != null){
             CadeiraRepository.update(c);
             session.setAttribute("msg", "Cadeira " + c.getNome() + " foi atualizado com sucesso!");
        
        } else {     
            CadeiraRepository.create(c);
            session.setAttribute("msg", "Cadeira " + c.getNome() + " foi cadastrado com sucesso.");
        }
        
        response.sendRedirect("cadeiras.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response); //To change body of generated methods, choose Tools | Templates.
    
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        Cadeira c = CadeiraRepository.read(codigo);
        
        CadeiraRepository.delete(codigo);
        
        HttpSession session = request.getSession();
        session.setAttribute("msg", "Cadeira "+ c.getNome() + " excluído.");
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
