<%-- 
    Document   : comida
    Created on : 22-sep-2016, 13:32:51
    Author     : Gerardo González gerardog3229@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comida Casera</title>
    </head>
    <body>
        <form action="ComidaController" method="post">
            <fieldset>
                <div>
                    <label>ID de Comida: </label>
                    <input type="text" name="idComida" value="${comida.idComida}"
                           placeholder="idComida"
                           readonly="readonly"/>
                </div>
                <div>
                    <label>Tipo de comida: </label>
                    <input type="text" name="tipo" value="${comida.tipo}"
                           placeholder="tipo"/>
                </div>

                <div>
                    <label>Nombre de Comida: </label>
                    <input type="text" name="nombre" value="${comida.nombre}"
                           placeholder="Nombre de Comida"/>
                </div>
                <div>
                    <label>Precio: </label>
                    <input type="text" name="precio" value="${comida.precio}"
                           placeholder="Precio de la comida"/>
                </div>
                <div>       
                    <label>Descripción: </label>
                    <input type="text" name="descripcion" value="${comida.descripcion}"
                           placeholder="Descripcion de la Comida"/>
                </div>
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>
        </form>
    </body>
</html>
