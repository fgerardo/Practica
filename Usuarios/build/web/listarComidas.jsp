<%-- 
    Document   : listarComidas
    Created on : 22-sep-2016, 13:38:46
    Author     : Gerardo González gerardog3229@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Comidas</title>
    </head>
    <body>
         <table>
            <thead>
                <tr>
                    <th>id Comida</th>
                    <th>tipo de comida</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Descripcion</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="comida" items="${comidas}">
                    <tr>
                        <td>${comida.idComida}</td>
                        <td>${comida.tipo}</td>
                        <td>${comida.nombre}</td>
                        <td>${comida.precio}</td>
                        <td>${comida.descripcion}</td>
                        <td><a href="ComidaController?action=cambiar&idComida=${comida.idComida}">Cambiar</a></td>
                        <td><a href="ComidaController?action=borrar&idComida=${comida.idComida}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="ComidaController?action=agregar">Nueva Comida</a>
        </p>
    </body>
</html>
