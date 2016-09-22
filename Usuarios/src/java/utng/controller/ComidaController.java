/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dao.ComidaDAO;
import utng.dao.ComidaDAOImp;
import utng.dao.UsuarioDAOImp;
import utng.model.Comida;

/**
 *
 * @author Gerardo González gerardog3229@gmail.com
 */
public class ComidaController extends HttpServlet{
    private static final String LISTA_COMIDAS = "/listarComidas.jsp";
    private static final String AGREGAR_O_CAMBIAR = "/comidas.jsp";
    private ComidaDAO dao;
    
    public ComidaController() {
        dao = new ComidaDAOImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_COMIDAS;
            int idComida = Integer.parseInt(request.getParameter("idComida"));
            dao.borrarComida(idComida);
            request.setAttribute("comidas", dao.desplegarComidas());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_O_CAMBIAR;
            int idComida = Integer.parseInt(request.getParameter("idComida"));
            Comida comida = dao.elegirComida(idComida);
            request.setAttribute("comida", comida);
            
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_O_CAMBIAR;
        } else {
            forward = LISTA_COMIDAS;
            request.setAttribute("comidas", dao.desplegarComidas());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Comida comida = new Comida();
        String idComida = request.getParameter("idComida");
       comida.setNombre(request.getParameter("nombre"));
        comida.setTipo(request.getParameter("tipo"));
        comida.setDescripcion(request.getParameter("descripcion"));
        comida.setPrecio(Integer.parseInt(request.getParameter("precio")));
        if (idComida == null || idComida.isEmpty()) {
            dao.agregarComida(comida);
        } else {
            comida.setIdComida(Integer.parseInt(idComida));
            dao.cambiarComida(comida);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_COMIDAS);
        request.setAttribute("comidas", dao.desplegarComidas());
        view.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
