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
import pkm.xml.object.PokemonAbilitiesList.xsd.PokemonAbilities;
import pkm.xml.object.PokemonAbilitiesList.xsd.PokemonAbilitiesList;



/**
 *
 * @author DUCVINH
 */
public class PokemonAbilitiesDAO {
    Connection connection = null;
    PreparedStatement statement = null;
    public PokemonAbilitiesList findByPokemonID(int pokemonID){
        String query = "SELECT * FROM tblPokemonAbilities WHERE pokemonId=?";
        PokemonAbilities pkmAbilities = null;
        PokemonAbilitiesList pkmAbilitiesList = new PokemonAbilitiesList();
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            
            statement.setInt(1, pokemonID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                pkmAbilities = new PokemonAbilities();
                pkmAbilities.setPokemonId(BigInteger.valueOf(rs.getInt("pokemonId")));
                pkmAbilities.setAbilityName(rs.getString("abilityName"));
                pkmAbilitiesList.getPokemonAbilities().add(pkmAbilities);
            }
        } catch (SQLException e) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
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
        return pkmAbilitiesList;
    }
    public boolean isPokemonAbilityExisted(PokemonAbilities pokemonAbility){
        String query = "SELECT * FROM tblPokemonAbilities WHERE pokemonId=? AND abilityName=?";
                
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            
            statement.setInt(1, Integer.parseInt(pokemonAbility.getPokemonId().toString()));
            statement.setString(2, pokemonAbility.getAbilityName());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
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
    public boolean insertPokemonAbility(PokemonAbilities pokemonAbilities) {

        String query = "INSERT INTO tblPokemonAbilities(pokemonId,abilityName)"
                + " VALUES (?,?)";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setInt(1, Integer.parseInt(pokemonAbilities.getPokemonId().toString()));
            statement.setString(2, pokemonAbilities.getAbilityName());

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
