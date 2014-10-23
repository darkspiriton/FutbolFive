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
             
}     
