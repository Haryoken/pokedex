/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import pkm.dao.PokemonDAO;
import pkm.util.JAXBHelper;
import pkm.xml.object.PokemonList.xsd.Pokemon;
import pkm.xml.object.PokemonList.xsd.PokemonList;

/**
 *
 * @author DUCVINH
 */
public class SearchServlet extends HttpServlet {

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
        String search = request.getParameter("txtSearch");
        PrintWriter out = response.getWriter();
        try {
            if (!search.equals("")) {
                HttpSession session = request.getSession(false);

                String fullPkmXML = (String) session.getAttribute("POKEMONLISTFULL");
                if (fullPkmXML == null) {
                    PokemonDAO pkmDAO = new PokemonDAO();
                    PokemonList list = pkmDAO.getAllPokemonBasicInfo();
                    fullPkmXML = JAXBHelper.marshallToString(list);
                    session.setAttribute("POKEMONLISTFULL", fullPkmXML);
                }
                XMLInputFactory factory = XMLInputFactory.newInstance();
                factory.setProperty(XMLInputFactory.IS_VALIDATING, false);
                factory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);

                XMLStreamReader reader = factory.createXMLStreamReader(new InputStreamReader(new ByteArrayInputStream(fullPkmXML.getBytes(StandardCharsets.UTF_8)), "UTF-8"));

                Pokemon pokemon = new Pokemon();
                PokemonList resultList = new PokemonList();
                String dexId = "";
                boolean isPokemon = false;
                boolean isPokemonMatch = false;
                boolean isIdMatch = false;
                while (reader.hasNext()) {
                    reader.next();

                    int eventType = reader.getEventType();

                    if (eventType == XMLStreamConstants.START_ELEMENT) {
                        String tagName = reader.getLocalName();
                        if (tagName.equals("pokemon")) {
                            isPokemon = true;
                        }
                        if (isPokemon && tagName.equals("nationalDexId")) {
                            reader.next();
                            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                                dexId = reader.getText();
                                if (reader.getText().equals(search)) {
                                    isIdMatch = true;
                                    pokemon.setNationalDexId(BigInteger.valueOf(Long.valueOf(dexId)));
                                }

                            }
                        }
                        if (isPokemon && tagName.equals("englishName")) {
                            reader.next();
                            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                                if (isIdMatch) {
                                    pokemon.setEnglishName(reader.getText());
                                }
                                if (!isIdMatch && reader.getText().toLowerCase().contains(search.toLowerCase())) {
                                    isPokemonMatch = true;
                                    pokemon.setNationalDexId(BigInteger.valueOf(Long.valueOf(dexId)));
                                    pokemon.setEnglishName(reader.getText());
                                }
                            }
                        }
                        if ((isPokemonMatch || isIdMatch) && tagName.equals("firstType")) {
                            reader.next();
                            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                                pokemon.setFirstType(reader.getText());
                            }
                        }
                        if ((isPokemonMatch || isIdMatch) && tagName.equals("secondType")) {
                            reader.next();
                            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                                pokemon.setSecondType(reader.getText());
                            }
                        }
                        if ((isPokemonMatch || isIdMatch) && tagName.equals("iconURI")) {
                            reader.next();
                            if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                                pokemon.setIconURI(reader.getText());
                                resultList.getPokemon().add(pokemon);
                                pokemon = new Pokemon();
                                isPokemonMatch = false;
                                isIdMatch = false;
                                isPokemon = false;
                            }
                        }
                    }
                }//End of hasNext
                String resultXML = JAXBHelper.marshallToString(resultList);
                request.setAttribute("SEARCHRESULT", resultXML);
            }
        } catch (JAXBException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("MainControllerServlet?btnAction=Pokedex&pokemonCount=search");
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
