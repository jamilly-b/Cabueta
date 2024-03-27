package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.entities.Estudante;
import br.edu.ifpe.recife.model.repositories.EstudanteRepository;
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
 * @author ALUNO
 */
@WebServlet(name = "EstudanteController", urlPatterns = {"/EstudanteController"})
public class EstudanteController extends HttpServlet {

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

            Estudante est = EstudanteRepository.read(codigo);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Estudante Controller</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Estudante cadastrado no sistema</h1>");
                out.println("<a href='EstudanteController'>ver estudantes cadastrados</a><br/>");
                out.println("<h5>código:" + est.getCodigo() + "</h5>");
                out.println("<h5>Nome:" + est.getNome() + "</h5>");
                out.println("<h5>e-mail:" + est.getEmail() + "</h5>");
                out.println("<h5>Ano de entrada:" + est.getAnoEntrada() + "</h5>");
                out.println("</tr>");
                out.println("</body>");
                out.println("</html>");

            }
            return;
        }

        List<Estudante> estudantes = EstudanteRepository.readAll();

        /*response.setContentType("application/pdf");
        response.getOutputStream().write(bytes);*/
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EstudanteController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Estudantes cadastrados no sistema</h1>");
            out.println("<a href='index.html'>home</a><br/>");
            out.println("<br>");
            out.println("<table border=\"2\">");
            out.println("<tr> <th>Código</th><th>Nome</th> <th>e-mail</th> <th>operações</th></tr>");;
            for (Estudante estudante : estudantes) {
                out.println("<tr>");
                out.println("<td>" + estudante.getCodigo() + "</td>");
                out.println("<td>" + estudante.getNome() + "</td>");
                out.println("<td>" + estudante.getEmail() + "</td>");
                out.println("<td><a href='EstudanteController?codigo=" + estudante.getCodigo() + "'>detalhar</a></td>");
                out.println("<td><a href='EstudanteController?codigo=" + estudante.getCodigo() + "'>editar</a></td>");
                out.println("<td><a href='EstudanteController?codigo=" + estudante.getCodigo() + "'>deletar</a></td>");
                out.println("</tr>");
            }

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
