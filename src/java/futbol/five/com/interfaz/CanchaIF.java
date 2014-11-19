/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.interfaz;

import futbol.five.com.bean.Partido;
import java.util.List;

/**
 *
 * @author Samuel
 */
public interface CanchaIF {
    
      public List getCanchasDisponibles(String dia,String hora,String fecha);
      public void registrarPartido(String idUser,int codCancha,int codHorario,boolean suscripcion,String date);
      public Partido getdetallePartido(String idUser,int codCancha,int codHorario,String fecha);
      public List getPartidosDisponibles(String dia,String hora,String fecha);
      public List mantenimientoFechaPartido();
      public List mantenimientoListaEPartido();
      public void actualizarEstadoCaducado(Partido partido);
      public void actualizarEstadoLleno(Partido partido);
      public List obtenerNumTL(int codL);
      public boolean verficarListaEstandar(int codE);
      public boolean verficarListaSolidaria(int codS);
      public boolean verificarExisteLE(String idUser,int codE);
      public boolean verificarExisteLS(String idUser,int codE);
      public void insertarListaEstandar(String idUser,int codE);
      public void insertarListaSolidaria(String idUser,int codS);
      public List<Partido> listarPartidos(String iduser);
      public List<Partido> listarCompromisos(String iduser);
      public List<Partido> listarSolidarias(String iduser);
      public List<Partido> BuscarPartidos(String fecha,String dia);
      
      
             
}     
