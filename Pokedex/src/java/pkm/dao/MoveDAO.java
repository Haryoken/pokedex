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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkm.util.DatabaseHelper;
import pkm.xml.object.MoveList.xsd.Move;
import pkm.xml.object.MoveList.xsd.MoveList;
import pkm.xml.object.PokemonMovesList.xsd.PokemonMoves;




/**
 *
 * @author DUCVINH
 */
public class MoveDAO {

    Connection connection = null;
    PreparedStatement statement = null;
    public MoveList findByMovePokemonId(int pokemonId) {
        String query = "Select * from tblMove where name IN (Select moveName from tblPokemonMoves where pokemonId = ? )";
        MoveList moveList = new MoveList();
        
        Move move = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            
            
            statement.setInt(1, pokemonId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                move = new Move();
                move.setName(rs.getString("name"));
                move.setPower(rs.getString("power"));
                move.setPp(BigInteger.valueOf(Long.valueOf(rs.getInt("pp"))));
                move.setAccuracy(rs.getString("accuracy"));
                move.setCategory(rs.getString("category"));
                move.setType(rs.getString("type"));
                moveList.getMove().add(move);
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
        return moveList;
    }
    public boolean isMoveExisted(String moveName) {
        String query = "SELECT * FROM tblMove where name =?";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            
            statement.setString(1, moveName);
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
    public boolean isMoveExisted(Move move) {
        String query = "SELECT * FROM tblMove where name =?";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            
            statement.setString(1, move.getName());
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

    public boolean insertMove(Move move) {

        String query = "INSERT INTO tblMove(name,type,category,power,accuracy,pp,generationAppearance)"
                + " VALUES (?,?,?,?,?,?,?)";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setString(1, move.getName());
            statement.setString(2, move.getType());
            statement.setString(3, move.getCategory());
            statement.setString(4, move.getPower());
            statement.setString(5, move.getAccuracy());
            statement.setInt(6, Integer.parseInt(move.getPp().toString()));
            statement.setString(7, move.getGenerationAppearance());

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
