/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkm.util.DatabaseHelper;
import pkm.xml.object.PokemonMovesList.xsd.PokemonMoves;
import pkm.xml.object.PokemonMovesList.xsd.PokemonMovesList;


/**
 *
 * @author DUCVINH
 */
public class PokemonMovesDAO {
    Connection connection = null;
    PreparedStatement statement = null;
    
    public PokemonMovesList findByPokemonId(int pokemonId){
        String query = "SELECT * FROM tblPokemonMoves WHERE pokemonId=?";
        PokemonMovesList pokemonMovesList = new PokemonMovesList();
        PokemonMoves pkmMoves = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            
            statement.setInt(1, pokemonId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                pkmMoves = new PokemonMoves();
                pkmMoves.setPokemonId(BigInteger.valueOf(Long.valueOf(pokemonId)));
                pkmMoves.setMoveName(rs.getString("moveName"));
                pkmMoves.setLearntByLevelUp(BigInteger.valueOf(Long.valueOf(rs.getInt("learntByLevelUp"))));
                pokemonMovesList.getPokemonMoves().add(pkmMoves);
            }
        } catch (SQLException e) {
            Logger.getLogger(PokemonMovesDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonMovesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PokemonMovesDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PokemonMovesDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pokemonMovesList;
    }
    public boolean isPokemonAbilityExisted(PokemonMoves pokemonMoves){
        String query = "SELECT * FROM tblPokemonMoves WHERE pokemonId=? AND moveName=?";
                
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            
            statement.setInt(1, Integer.parseInt(pokemonMoves.getPokemonId().toString()));
            statement.setString(2, pokemonMoves.getMoveName());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(PokemonMovesDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonMovesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PokemonMovesDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PokemonMovesDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    public boolean insertPokemonMove(PokemonMoves pokemonMoves) {

        String query = "INSERT INTO tblPokemonMoves(pokemonId,moveName,learntByLevelUp) VALUES (?,?,?)";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setInt(1, Integer.parseInt(pokemonMoves.getPokemonId().toString()));
            statement.setString(2, pokemonMoves.getMoveName());
            statement.setInt(3, Integer.parseInt(pokemonMoves.getLearntByLevelUp().toString()));

            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
