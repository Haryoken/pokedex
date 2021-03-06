/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkm.util.DatabaseHelper;
import pkm.xml.object.TypeInteractionList.xsd.TypeInteraction;
import pkm.xml.object.TypeInteractionList.xsd.TypeInteractionList;


/**
 *
 * @author DUCVINH
 */
public class TypeInteractionDAO {

    Connection connection = null;
    PreparedStatement statement = null;
    
    public TypeInteractionList getAllTypeInteraction() {
        String query = "SELECT * FROM tblTypeInteraction";
        TypeInteractionList typeInteractionList =  new TypeInteractionList();
        TypeInteraction interaction = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                interaction = new TypeInteraction();
                interaction.setAttackType(rs.getString("attackType"));
                interaction.setDefenseType(rs.getString("defenseType"));
                interaction.setEffect(rs.getString("effect"));
                interaction.setEffectMultipler(rs.getString("effectMultipler"));
                typeInteractionList.getTypeInteraction().add(interaction);
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
        return typeInteractionList;
    }
    public TypeInteractionList findByAttackType(String attackType) {
        String query = "SELECT * FROM tblTypeInteraction WHERE attackType=?";
        TypeInteractionList typeInteractionList =  new TypeInteractionList();
        TypeInteraction interaction = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            
            statement.setString(1, attackType);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                interaction = new TypeInteraction();
                interaction.setAttackType(rs.getString("attackType"));
                interaction.setDefenseType(rs.getString("defenseType"));
                interaction.setEffect(rs.getString("effect"));
                interaction.setEffectMultipler(rs.getString("effectMultipler"));
                typeInteractionList.getTypeInteraction().add(interaction);
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
        return typeInteractionList;
    }
    public TypeInteractionList findByDefenseType(String defenseType) {
        String query = "SELECT * FROM tblTypeInteraction WHERE defenseType=?";
        TypeInteractionList typeInteractionList =  new TypeInteractionList();
        TypeInteraction interaction = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            
            statement.setString(1, defenseType);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                interaction = new TypeInteraction();
                interaction.setAttackType(rs.getString("attackType"));
                interaction.setDefenseType(rs.getString("defenseType"));
                interaction.setEffect(rs.getString("effect"));
                interaction.setEffectMultipler(rs.getString("effectMultipler"));
                typeInteractionList.getTypeInteraction().add(interaction);
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
        return typeInteractionList;
    }
    public boolean isTypeInteractionExisted(TypeInteraction typeInteraction) {
        String query = "SELECT * FROM tblTypeInteraction WHERE attackType=? AND defenseType=?";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setString(1, typeInteraction.getAttackType());
            statement.setString(2, typeInteraction.getDefenseType());

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

    public boolean insertType(TypeInteraction typeInteraction) {

        String query = "INSERT INTO tblTypeInteraction(attackType,defenseType,effect,effectMultipler)"
                + " VALUES (?,?,?,?)";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setString(1, typeInteraction.getAttackType());
            statement.setString(2, typeInteraction.getDefenseType());
            statement.setString(3, typeInteraction.getEffect());
            statement.setString(4, typeInteraction.getEffectMultipler());
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
