/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.servlet;

import futbol.five.com.bean.Partido;
import futbol.five.com.dao.CanchaDAO;
import futbol.five.com.interfaz.CanchaIF;
import futbol.five.com.singleton.SingletonFecha;
import futbol.five.com.singleton.SingletonPartidos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Samuel
 */
@WebServlet(name = "BuscarPartidos", urlPatterns = {"/BuscarPartidos"})
public class BuscarPartidos extends HttpServlet {
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String fecha= request.getParameter("fecha");
        HttpSession ses = request.getSession();
       
        
        SingletonFecha gestorFecha = SingletonFecha.getSingletonFecha();
        
                if (gestorFecha.validarFecha(fecha)==true){
                    
                            String dia=gestorFecha.obtenerDia(fecha);
                            SingletonPartidos PartidosDisponibles = SingletonPartidos.getPartidos();                            
                            ses.setAttribute("listaPartidos",PartidosDisponibles.buscarPartidosSingleton(fecha, dia)); 
                            ses.removeAttribute("fechaInvalida");
                            RequestDispatcher rd;  
                            rd = request.getRequestDispatcher("/verPartidos.jsp");
                            rd.forward(request, response);
                                 
              
                } else {
                    ses.removeAttribute("listaPartidos");
                    ses.setAttribute("fechaInvalida", "SOLO SE PUEDE RESERVAR CON UN PERIODO DE 7 DIAS MAXIMO. POR FAVOR INGRESE UNA FECHA VALIDA");
                    RequestDispatcher rd;  
                    rd = request.getRequestDispatcher("/verPartidos.jsp");
                    rd.forward(request, response);                 
                }              
        
        
    }



}
