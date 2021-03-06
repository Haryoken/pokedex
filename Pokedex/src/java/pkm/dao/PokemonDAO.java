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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkm.util.DatabaseHelper;
import pkm.xml.object.PokemonList.xsd.Pokemon;
import pkm.xml.object.PokemonList.xsd.PokemonList;

/**
 *
 * @author DUCVINH
 */
public class PokemonDAO {

    Connection connection = null;
    PreparedStatement statement = null;
    public PokemonList searchByType(String type) {
        ResultSet rs = null;
        String query = "SELECT nationalDexId,englishName,firstType,secondType,iconURI FROM tblPokemon where firstType=? OR secondType=?";
        PokemonList pokemonList = new PokemonList();
        Pokemon pkm = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            
            statement.setString(1, type);
            statement.setString(2, type);
            rs = statement.executeQuery();
            while (rs.next()) {
                pkm = new Pokemon();
                pkm.setNationalDexId(BigInteger.valueOf(Long.parseLong(String.valueOf(rs.getInt("nationalDexId")))));
                pkm.setEnglishName(rs.getString("englishName"));
                pkm.setFirstType(rs.getString("firstType"));
                pkm.setSecondType(rs.getString("secondType"));
                pkm.setIconURI(rs.getString("iconURI"));
                pokemonList.getPokemon().add(pkm);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokemonList;
    }
    public Pokemon findById(int id) {
        ResultSet rs = null;
        String query = "SELECT * FROM tblPokemon WHERE nationalDexId=?";
        Pokemon pkm = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                pkm = new Pokemon();
                pkm.setNationalDexId(BigInteger.valueOf(Long.parseLong(String.valueOf(rs.getInt("nationalDexId")))));
                pkm.setEnglishName(rs.getString("englishName"));
                pkm.setJapaneseName(rs.getString("japaneseName"));
                pkm.setRomajiName(rs.getString("romajiName"));
                pkm.setPictureURI(rs.getString("pictureURI"));
                pkm.setGrowthRate(rs.getString("growthRate"));
                pkm.setFirstType(rs.getString("firstType"));
                pkm.setSecondType(rs.getString("secondType"));
                pkm.setIconURI(rs.getString("iconURI"));
                int baseExp = rs.getInt("baseExp");
                if (baseExp > 0) {
                    pkm.setBaseExp(BigInteger.valueOf(Long.valueOf(baseExp)));
                }

                int baseHappiness = rs.getInt("baseHappiness");
                if (baseHappiness > 0) {
                    pkm.setBaseHappiness(BigInteger.valueOf(Long.valueOf(baseHappiness)));
                }

                double catchRate = rs.getDouble("catchRate");
                if (catchRate > 0) {
                    pkm.setCatchRate(BigDecimal.valueOf(catchRate));
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pkm;
    }

    public PokemonList getAllPokemonBasicInfo() {
        ResultSet rs = null;
        String query = "SELECT * FROM tblPokemon";
        PokemonList pokemonList = new PokemonList();
        Pokemon pkm = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                pkm = new Pokemon();
                pkm.setNationalDexId(BigInteger.valueOf(Long.parseLong(String.valueOf(rs.getInt("nationalDexId")))));
                pkm.setEnglishName(rs.getString("englishName"));
                pkm.setFirstType(rs.getString("firstType"));
                pkm.setSecondType(rs.getString("secondType"));
                pkm.setIconURI(rs.getString("iconURI"));
                pokemonList.getPokemon().add(pkm);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokemonList;
    }

    public PokemonList getGenIBasicInfo() {
        ResultSet rs = null;
        String query = "SELECT * FROM tblPokemon WHERE nationalDexId < 152";
        PokemonList pokemonList = new PokemonList();
        Pokemon pkm = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                pkm = new Pokemon();
                pkm.setNationalDexId(BigInteger.valueOf(Long.parseLong(String.valueOf(rs.getInt("nationalDexId")))));
                pkm.setEnglishName(rs.getString("englishName"));
                pkm.setFirstType(rs.getString("firstType"));
                pkm.setSecondType(rs.getString("secondType"));
                pkm.setIconURI(rs.getString("iconURI"));
                pokemonList.getPokemon().add(pkm);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokemonList;
    }

    public List<Pokemon> getPokemonBeforeGenVII() {
        ResultSet rs = null;
        String query = "SELECT * FROM tblPokemon WHERE nationalDexId < 722";
        List<Pokemon> pokemonList = new ArrayList<>();
        Pokemon pkm = null;
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                pkm = new Pokemon();
                pkm.setNationalDexId(BigInteger.valueOf(Long.parseLong(String.valueOf(rs.getInt("nationalDexId")))));
                pkm.setEnglishName(rs.getString("englishName"));
                pokemonList.add(pkm);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokemonList;
    }

    public boolean isExistedInDB(Pokemon pokemon) {
        String query = "SELECT * FROM tblPokemon where nationalDexId ='"
                + pokemon.getNationalDexId() + "'";
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

    public boolean isExistedInDB(int id) {

        String query = "SELECT * FROM tblPokemon where nationalDexId ='"
                + id + "'";
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

    public boolean insertPokemon(Pokemon pokemon) {
        String query = "INSERT INTO tblPokemon(nationalDexId,englishName,isLegendary,iconURI,firstType,secondType)"
                + " VALUES (?,?,?,?,?,?)";
        if (pokemon.getSecondType() == null) {
            query = "INSERT INTO tblPokemon(nationalDexId,englishName,isLegendary,iconURI,firstType)"
                    + " VALUES (?,?,?,?,?)";
        }

        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setInt(1, Integer.parseInt(pokemon.getNationalDexId().toString()));
            statement.setString(2, pokemon.getEnglishName());
            statement.setBoolean(3, false);
            statement.setString(4, pokemon.getIconURI());
            statement.setString(5, pokemon.getFirstType());
            if (pokemon.getSecondType() != null) {
                statement.setString(6, pokemon.getSecondType());
            }

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

    public boolean update_JapanseseName_RomajiName_PictureURI(Pokemon pokemon) {
        String query = "UPDATE tblPokemon SET japaneseName=?, romajiName=?, pictureURI=? WHERE nationalDexId= '"
                + pokemon.getNationalDexId() + "'";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setString(1, pokemon.getJapaneseName());
            statement.setString(2, pokemon.getRomajiName());
            statement.setString(3, pokemon.getPictureURI());
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

    public boolean update_catchRate_baseXP_baseHappiness(Pokemon pokemon) {
        String query = "UPDATE tblPokemon SET catchRate=?, baseExp=? WHERE nationalDexId= '"
                + pokemon.getNationalDexId() + "'";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setBigDecimal(1, pokemon.getCatchRate());
            statement.setInt(2, Integer.parseInt(pokemon.getBaseExp().toString()));

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

    public boolean updateGrowthRate(Pokemon pokemon) {
        String query = "UPDATE tblPokemon SET growthRate=? WHERE nationalDexId=?";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setString(1, pokemon.getGrowthRate());
            statement.setInt(2, Integer.parseInt(pokemon.getNationalDexId().toString()));
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

    public boolean updateBaseHappiness(Pokemon pokemon) {
        String query = "UPDATE tblPokemon SET baseHappiness=? WHERE nationalDexId= '"
                + pokemon.getNationalDexId() + "'";
        try {
            connection = DatabaseHelper.getConnection();
            statement = connection.prepareStatement(query);

            statement.setInt(1, Integer.parseInt(pokemon.getBaseHappiness().toString()));

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
