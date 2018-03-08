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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkm.dao.PokemonAbilitiesDAO;
import pkm.dao.PokemonDAO;
import pkm.dao.PokemonStatsDAO;
import pkm.xml.object.PokemonAbilities.xsd.PokemonAbilities;
import pkm.xml.object.PokemonList.xsd.Pokemon;
import pkm.xml.object.PokemonStats.xsd.PokemonStats;

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
        
        Pokemon pokemon = null;
        List<String> pokemonAbilities = new ArrayList<>();
        PokemonStats pkmStats = null;
        try{
           pokemon = pkmDAO.findById(Integer.parseInt(pokemonId));
           pokemonAbilities = pkmAbilitiesDAO.findByPokemonID(Integer.parseInt(pokemonId));
           pkmStats = pkmStatsDAO.findById(Integer.parseInt(pokemonId));
            System.out.println("POKEMON MAIN INFO=============================");
            System.out.println("ID: "+pokemon.getNationalDexId());
            System.out.println("Name: "+pokemon.getEnglishName());
            System.out.println("Jap: "+pokemon.getJapaneseName());
            System.out.println("Rom: "+pokemon.getRomajiName());
            System.out.println("Pics: "+pokemon.getPictureURI());
            System.out.println("GrowthRate: "+pokemon.getGrowthRate());
            System.out.println("Happiness: "+pokemon.getBaseHappiness());
            System.out.println("BaseExp: "+pokemon.getBaseExp());
            System.out.println("CatchRate: "+pokemon.getCatchRate());
            System.out.println("ABILITIES=====================================");
            for(String ability: pokemonAbilities){
                System.out.println("Ability"+ability);
            }
            System.out.println("STATS:========================================");
            System.out.println("HP: "+pkmStats.getBaseHP());
            System.out.println("atk: "+pkmStats.getAttack());
            System.out.println("def: "+pkmStats.getDefense());
            System.out.println("spatk: "+pkmStats.getSpAttack());
            System.out.println("spdef: "+pkmStats.getSpDefense());
            System.out.println("speed: "+pkmStats.getSpeed());

        }finally{
            
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
