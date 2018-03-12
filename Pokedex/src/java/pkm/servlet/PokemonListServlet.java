/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.servlet;

import com.sun.net.httpserver.HttpContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import pkm.dao.PokemonDAO;
import pkm.util.JAXBHelper;
import pkm.xml.object.PokemonList.xsd.PokemonList;

/**
 *
 * @author DUCVINH
 */
public class PokemonListServlet extends HttpServlet {

    private static String pokemonListPage = "pokemonList.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        PokemonList pkmList = null;
        try {

            HttpSession session = request.getSession(false);
            String displayMode = request.getParameter("pokemonCount");
            PokemonDAO pkmDAO = new PokemonDAO();
            if (!displayMode.isEmpty() && displayMode.equals("all")) {
                String pokemonFullList = (String) session.getAttribute("POKEMONLISTFULL");
                if (pokemonFullList == null) {
                    pkmList = pkmDAO.getAllPokemonBasicInfo();
                    String pokemonListXML = JAXBHelper.marshallToString(pkmList);
                    session.setAttribute("POKEMONLISTFULL", pokemonListXML);
                }
            }
            if (!displayMode.isEmpty() && displayMode.equals("genI")) {
                String pokemonGenI = (String) session.getAttribute("POKEMONLISTGENI");
                if (pokemonGenI == null) {
                    pkmList = pkmDAO.getGenIBasicInfo();
                    String pokemonListXML = JAXBHelper.marshallToString(pkmList);
                    System.out.println(pokemonListXML);
                    session.setAttribute("POKEMONLISTGENI", pokemonListXML);
                }
            }

            request.setAttribute("DISPLAYMODE", displayMode);
        } catch (JAXBException ex) {
            Logger.getLogger(PokemonListServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(pokemonListPage);
            rd.forward(request, response);
            out.close();
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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