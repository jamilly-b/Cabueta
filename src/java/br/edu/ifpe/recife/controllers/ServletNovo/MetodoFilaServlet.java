/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.ServletNovo;

import br.edu.ifpe.recife.model.entities.MetodoFila;
import br.edu.ifpe.recife.model.repositories.MetodoFilaRepository;
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
@WebServlet(name = "MetodoFilaServlet", urlPatterns = {"/MetodoFilaServlet"})
public class MetodoFilaServlet extends HttpServlet {

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
        
        MetodoFila mf = MetodoFilaRepository.read(codigo);
        
        request.setAttribute("metodoFila", mf);
        
        getServletContext().getRequestDispatcher("/metodoFila.jsp").forward(request, response);
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

        MetodoFila mf = new MetodoFila();
        String a = request.getParameter("atualizar");
        
        mf.setCodigo(codigo);
        mf.setDescricaoCurta(descricaoCurta);
        mf.setDescricaoLonga(descricaoLonga);
        
        HttpSession session = request.getSession();
        
        if(a != null){
             MetodoFilaRepository.update(mf);
             session.setAttribute("msg", "Metodo " + mf.getDescricaoCurta()+ " foi atualizado com sucesso!");
        
        } else {     
            MetodoFilaRepository.create(mf);
            session.setAttribute("msg", "Metodo " + mf.getDescricaoCurta()+ " foi cadastrado com sucesso.");
        }
        
        response.sendRedirect("metodoFila.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response); //To change body of generated methods, choose Tools | Templates.
    
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        MetodoFila mf = MetodoFilaRepository.read(codigo);
        
        MetodoFilaRepository.delete(codigo);
        
        HttpSession session = request.getSession();
        session.setAttribute("msg", "Metodo de Fila "+ mf.getDescricaoCurta()+ " excluído.");
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
