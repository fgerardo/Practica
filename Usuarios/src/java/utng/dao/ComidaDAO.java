/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.dao;

import java.util.List;
import utng.model.Comida;

/**
 *
 * @author Gerardo González gerardog3229@gmail.com
 */
public interface ComidaDAO {
    void agregarComida(Comida comida);
    void borrarComida(int idComida);
    void cambiarComida(Comida comida);
    List<Comida> desplegarComidas();
    Comida elegirComida(int idComida);
}
