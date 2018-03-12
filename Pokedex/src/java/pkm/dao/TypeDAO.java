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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkm.util.DatabaseHelper;
import pkm.xml.object.PokemonList.xsd.Pokemon;
import pkm.xml.object.TypeList.xsd.Type;
import pkm.xml.object.TypeList.xsd.TypeList;

/**
 *
 * @author DUCVINH
 */
public class TypeDAO {
    Connection connection = null;
    PreparedStatement statement = null;
    
    public boolean isTypeExisted(Type type){
        String query = "SELECT * FROM tblType where typeLabel ='"
                + type.getTypeLabel()+ "'";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
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
    public boolean isTypeExisted(String typeLabel){
        String query = "SELECT * FROM tblType where typeLabel ='"
                +typeLabel+ "'";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
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
    public boolean insertType(Type type) {

        String query = "INSERT INTO tblType(typeLabel)"
                + " VALUES (?)";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setString(1, type.getTypeLabel());

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
    public List<Type> getAllType(){
        List<Type> typeList  = new ArrayList<>();
        String query = "SELECT * FROM tblType";
        Type type = null;
        try{
             connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                type = new Type();
                type.setTypeLabel(rs.getString(1));
                typeList.add(type);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeList;
    }
    public TypeList getAllTypes(){
        TypeList typeList  = new TypeList();
        String query = "SELECT * FROM tblType";
        Type type = null;
        try{
             connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                type = new Type();
                type.setTypeLabel(rs.getString(1));
                typeList.getPokemonType().add(type);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeList;
    }
}
