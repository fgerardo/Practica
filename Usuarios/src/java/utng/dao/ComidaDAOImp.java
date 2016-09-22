/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.model.Comida;
import utng.util.utilDB;

/**
 *
 * @author Gerardo González gerardog3229@gmail.com
 */
public class ComidaDAOImp implements ComidaDAO{
  private Connection connection;
  
  public ComidaDAOImp(){
      connection=utilDB.getConnection();
  }
    @Override
    public void agregarComida(Comida comida) {
        try {
            String query = "INSERT INTO comida (tipo,descripcion, nombre,precio)" + "VALUES(?,?,?,?)";
            PreparedStatement co = connection.prepareStatement(query);
            co.setString(1, comida.getTipo());
            co.setString(2, comida.getDescripcion());
            co.setString(3, comida.getNombre());
            co.setInt(4, comida.getPrecio());
            co.executeUpdate();
            co.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarComida(int idComida) {
        try{
            String query = "DELETE FROM comida WHERE "
                    + " id_comida=?";
            PreparedStatement co = connection.prepareStatement(query);
            co.setInt(1, idComida);
            co.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarComida(Comida comida) {
        try{
            String query = "UPDATE comida SET tipo= ?"
                    + ", descripcion=?"
                    + ", nombre=?"
                    + ", precio=?"
                    + "WHERE id_comida=?";
            PreparedStatement co = connection.prepareStatement(query);
            co.setString(1, comida.getTipo());
            co.setString(2, comida.getDescripcion());
            co.setString(3, comida.getNombre());
            co.setInt(4, comida.getPrecio());
            co.setInt(5, comida.getIdComida());
            co.executeUpdate();
            co.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Comida> desplegarComidas() {
        List<Comida> comidas = new ArrayList<Comida>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM comida");
            while(rs.next()){
                Comida comida= new Comida(rs.getInt("id_comida"),
                rs.getString("tipo"),
                rs.getString("descripcion"),
                rs.getString("nombre"),
                rs.getInt("precio"));
                comidas.add(comida);
            }
            rs.close();
            statement.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return comidas;
    }

    @Override
    public Comida elegirComida(int idComida) {
        Comida comida=null;
        try{
            String query = " SELECT * FROM comida WHERE id_comida=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idComida);
            ResultSet rs= statement.executeQuery();
            
            if(rs.next()){
                comida= new Comida(
                rs.getInt("id_comida"),
                rs.getString("tipo"),
                rs.getString("descripcion"),
                rs.getString("nombre"),
                rs.getInt("precio"));
            }
            rs.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return comida;
    }
    
}
