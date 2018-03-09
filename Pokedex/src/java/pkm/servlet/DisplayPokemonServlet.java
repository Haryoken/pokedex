/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import pkm.dao.MoveDAO;
import pkm.dao.PokemonAbilitiesDAO;
import pkm.dao.PokemonDAO;
import pkm.dao.PokemonMovesDAO;
import pkm.dao.PokemonStatsDAO;
import pkm.util.JAXBHelper;
import pkm.xml.object.MoveList.xsd.Move;
import pkm.xml.object.MoveList.xsd.MoveList;
import pkm.xml.object.PokemonAbilitiesList.xsd.PokemonAbilities;
import pkm.xml.object.PokemonAbilitiesList.xsd.PokemonAbilitiesList;

import pkm.xml.object.PokemonList.xsd.Pokemon;
import pkm.xml.object.PokemonList.xsd.PokemonList;
import pkm.xml.object.PokemonMovesList.xsd.PokemonMoves;
import pkm.xml.object.PokemonMovesList.xsd.PokemonMovesList;
import pkm.xml.object.PokemonStatsList.xsd.PokemonStats;
import pkm.xml.object.PokemonStatsList.xsd.PokemonStatsList;

/**
 *
 * @author DUCVINH
 */
public class DisplayPokemonServlet extends HttpServlet {

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

        String pokemonId = request.getParameter("pokemonId");

        PokemonDAO pkmDAO = new PokemonDAO();
        PokemonAbilitiesDAO pkmAbilitiesDAO = new PokemonAbilitiesDAO();
        PokemonStatsDAO pkmStatsDAO = new PokemonStatsDAO();
        PokemonMovesDAO pkmMovesDAO = new PokemonMovesDAO();
        MoveDAO moveDAO = new MoveDAO();

        Pokemon pokemon = null;
        PokemonList pkmList = new PokemonList();
        PokemonAbilitiesList pkmAbilitiesList = null;
        PokemonStats pkmStats = null;
        PokemonStatsList statsList = new PokemonStatsList();
        PokemonMovesList pkmMovesList = null;
        MoveList moveList = null;

        try {
            pokemon = pkmDAO.findById(Integer.parseInt(pokemonId));
            pkmList.getPokemon().add(pokemon);
            
            pkmAbilitiesList = pkmAbilitiesDAO.findByPokemonID(Integer.parseInt(pokemonId));
            
            pkmStats = pkmStatsDAO.findById(Integer.parseInt(pokemonId));
            statsList.getPokemonStats().add(pkmStats);
            
            pkmMovesList = pkmMovesDAO.findByPokemonId(Integer.parseInt(pokemonId));
            moveList = moveDAO.findByMovePokemonId(Integer.parseInt(pokemonId));

            String pokemonXML = JAXBHelper.marshallToString(pkmList);
            String pokemonAbilitiesXML = JAXBHelper.marshallToString(pkmAbilitiesList);
            String pkmStatsXML = JAXBHelper.marshallToString(statsList);
            String pkmMovesXML = JAXBHelper.marshallToString(pkmMovesList);
            String moveXML = JAXBHelper.marshallToString(moveList);
            
            
            request.setAttribute("POKEMON_XML", pokemonXML);
            request.setAttribute("POKEMONABILITIES_XML", pokemonAbilitiesXML);
            request.setAttribute("STATS_XML", pkmStatsXML);
            request.setAttribute("POKEMONMOVES_XML", pkmMovesXML);
            request.setAttribute("MOVE_XML", moveXML);

        } catch (JAXBException ex) {
            Logger.getLogger(DisplayPokemonServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect("pokemon.jsp");
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
