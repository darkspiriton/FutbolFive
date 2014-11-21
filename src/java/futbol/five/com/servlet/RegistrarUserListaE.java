/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.servlet;

import futbol.five.com.singleton.RegistrarLista;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cesar
 */
public class RegistrarUserListaE extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        String idUser = request.getParameter("idUser");
        String codLE = request.getParameter("ListaE");
        
        //detalle_lista_estandar
        //crear un metodo para verificar si hay espacio en la lista codLE debe regresar un boolean
        RegistrarLista registrar = RegistrarLista.getRegistrarLista();
        
        
        if(registrar.verificarEspacioEstandar(codLE)==true){            
            
            //Crear un metodo para insertar el usuario idUser a la lista codLE
            if(registrar.insertarListaEstandar(codLE, idUser)==true){
                //remuevo el archivo de sesion
                ses.removeAttribute("ESTADO_LISTA"); 
            }else{
                ses.setAttribute("ESTADO_LISTA",idUser + " no se puede registrar porque ya esta registrado");
            }
                         
        }else{
            //muestro un error que la lista esta completa 
            ses.setAttribute("ESTADO_LISTA",idUser + " la lista estandar ya esta completa");
            
        }        
        RequestDispatcher rd = request.getRequestDispatcher("/verPartidos.jsp");
        rd.forward(request, response);
        
    }

}
