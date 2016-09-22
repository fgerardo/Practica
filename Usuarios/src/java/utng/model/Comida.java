/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

/**
 *
 * @author Gerardo González gerardog3229@gmail.com
 */
public class Comida {
    private int idComida;
    private String tipo;
    private String descripcion;
    private String nombre;
    private int precio;

    public Comida(int idComida, String tipo, String descripcion, String nombre, int precio) {
        this.idComida = idComida;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public Comida(){
        this(0,"","","",0);
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Comida{" + "idComida=" + idComida + ", tipo=" + tipo + ", descripcion=" + descripcion + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
    
}
