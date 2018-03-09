/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkm.util.DatabaseHelper;
import pkm.xml.object.PokemonList.xsd.Pokemon;
import pkm.xml.object.PokemonStatsList.xsd.PokemonStats;


/**
 *
 * @author DUCVINH
 */
public class PokemonStatsDAO {
    
    Connection connection = null;
    PreparedStatement statement = null;
    public PokemonStats findById(int id) {
        ResultSet rs = null;
        String query = "SELECT * FROM tblPokemonStats WHERE pokemonId=?";
        PokemonStats pkmStats = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                pkmStats = new PokemonStats();
                pkmStats.setBaseHP(BigInteger.valueOf(Long.valueOf(rs.getInt("baseHP"))));
                pkmStats.setAttack(BigInteger.valueOf(Long.valueOf(rs.getInt("attack"))));
                pkmStats.setDefense(BigInteger.valueOf(Long.valueOf(rs.getInt("defense"))));
                pkmStats.setSpAttack(BigInteger.valueOf(Long.valueOf(rs.getInt("spAttack"))));
                pkmStats.setSpDefense(BigInteger.valueOf(Long.valueOf(rs.getInt("spDefense"))));
                pkmStats.setSpeed(BigInteger.valueOf(Long.valueOf(rs.getInt("speed"))));                     
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pkmStats;
    }
    public boolean insertPokemonStats(PokemonStats pkmStats) {

        String query = "INSERT INTO tblPokemonStats(pokemonId,baseHP,attack,defense,spAttack,spDefense,speed)"
                + " VALUES (?,?,?,?,?,?,?)";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setInt(1, Integer.parseInt(pkmStats.getPokemonId().toString()));
            statement.setInt(2, Integer.parseInt(pkmStats.getBaseHP().toString()));
            statement.setInt(3, Integer.parseInt(pkmStats.getAttack().toString()));
            statement.setInt(4, Integer.parseInt(pkmStats.getDefense().toString()));
            statement.setInt(5, Integer.parseInt(pkmStats.getSpAttack().toString()));
            statement.setInt(6, Integer.parseInt(pkmStats.getSpDefense().toString()));
            statement.setInt(7, Integer.parseInt(pkmStats.getSpeed().toString()));

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
