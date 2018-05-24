/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import pkm.dao.PokemonDAO;
import pkm.dao.TypeInteractionDAO;
import pkm.util.JAXBHelper;
import pkm.xml.object.PokemonList.xsd.PokemonList;
import pkm.xml.object.TypeInteractionList.xsd.TypeInteractionList;

/**
 *
 * @author DUCVINH
 */
public class TypeDetailsServlet extends HttpServlet {

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
        try {
            String type = request.getParameter("type");

            TypeInteractionDAO interDAO = new TypeInteractionDAO();
            PokemonDAO pkmDAO =  new PokemonDAO();
            
            TypeInteractionList attackList = interDAO.findByAttackType(type);
            String attackXML = JAXBHelper.marshallToString(attackList);
            request.setAttribute("TYPEATTACK", attackXML);

            TypeInteractionList defenseList = interDAO.findByDefenseType(type);
            String defenseXML = JAXBHelper.marshallToString(defenseList);
            request.setAttribute("TYPEDEFENSE", defenseXML);
            
            PokemonList pokemonList = pkmDAO.searchByType(type);
            String pokemonXML = JAXBHelper.marshallToString(pokemonList);
            request.setAttribute("TYPEPOKEMON", pokemonXML);
            
            request.setAttribute("TYPE", type);
        } catch (JAXBException ex) {
            Logger.getLogger(TypeDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("typeDetails.jsp");
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
