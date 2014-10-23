/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.servlet;


import futbol.five.com.singleton.Singleton;
import futbol.five.com.singleton.SingletonFecha;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mari
 */
public class ListarPartidos extends HttpServlet {@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String hora = request.getParameter("hora");
                String fecha = request.getParameter("fecha");
                HttpSession ses = request.getSession();   
                
                SingletonFecha gestorFecha = SingletonFecha.getSingletonFecha();
                
                if (gestorFecha.validarFecha(fecha)==true){
                    Singleton gestor = Singleton.getSingleton();
                    ses.setAttribute("fechaPartido", fecha);
                    ses.setAttribute("listaPartidos", gestor.getPartidosDisponibles(gestorFecha.obtenerDia(fecha), hora, fecha));

                    RequestDispatcher rd;  
                    rd = request.getRequestDispatcher("/verPartidos.jsp");
                    rd.forward(request, response); 
                }else{
                    ses.removeAttribute("fechaPartido");
                    ses.removeAttribute("listaPartidos");
                    ses.setAttribute("fechaInvalida", "SOLO SE PUEDE RESERVAR CON UN PERIODO DE 7 DIAS MAXIMO. POR FAVOR INGRESE UNA FECHA VALIDA");
                                   
                    RequestDispatcher rd;  
                    rd = request.getRequestDispatcher("/verPartidos.jsp");
                    rd.forward(request, response);
                }
                
                
                
    }
    
}
