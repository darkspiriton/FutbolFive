/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.dao;

import futbol.five.com.bean.Cancha;
import futbol.five.com.bean.Partido;
import futbol.five.com.interfaz.CanchaIF;
import futbol.five.com.metodo.CantidadPartidos;
import futbol.five.com.metodo.ConnectionMySQL;
import futbol.five.com.metodo.ManejadorFechas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class CanchaDAO implements CanchaIF {

    ConnectionMySQL mysql = new ConnectionMySQL();
    
    
    @Override
    public List getCanchasDisponibles(String dia, String hora, String fecha) {
                Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
                int horaI=Integer.parseInt(hora);
                
		String sql ="SELECT c1.cod_cancha,c1.descripcion,c1.direccion,h1.dia,h1.hora_inicio,h1.hora_fin,h1.cod_horario\n" +
                            "FROM cancha c1 inner join detalle_cancha_horario d1 on c1.cod_cancha=d1.cod_cancha\n" +
                            "inner join horario h1 on d1.cod_horario=h1.cod_horario\n" +
                            "where h1.dia=? and h1.hora_inicio=? and (c1.cod_cancha,h1.cod_horario)\n" +
                            "not in (SELECT cod_cancha,cod_horario FROM partido where estado_partido=\"disponible\"and fecha=?);";

                List<Cancha> lcanchas= new <Cancha>ArrayList();
		
		try {
			con = mysql.getConnection();
			// preparo la sentencia sql
			pstmt = con.prepareStatement(sql);
			// si hay parametros para el sql lo seteo
			
			pstmt.setString(1,dia);    
                        pstmt.setInt(2,horaI);
                        pstmt.setString(3, fecha);
                        // ejecuto la sentencia
			rs = pstmt.executeQuery();
			
			// proceso el resultset
			while ( rs.next() ) {
				lcanchas.add( new Cancha( rs.getInt(1),
                                                        rs.getString(2),
                                                        rs.getString(3),
                                                        rs.getString(4),
                                                        rs.getInt(5),
                                                        rs.getInt(6),
                                                        rs.getInt(7)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lcanchas;
        
        
    }

    @Override
    public void registrarPartido(String idUser, int codCancha, int codHorario, boolean suscripcion,String fecha) {
                
                int comisionPago=2;
                if (suscripcion==true){
                    comisionPago=0;
                }
                int montoPago=30;
                String estadoPago="pendiente";
                String estado="disponible";
                CantidadPartidos cant = new CantidadPartidos();
                int id=cant.obtenerId(); 
                
                ManejadorFechas diaAux = new ManejadorFechas();
                String diaActual1 = diaAux.getFechaActual(); 
                
                Connection con = null;
                
		PreparedStatement pstmt1 = null;
                PreparedStatement pstmt2 = null;
                PreparedStatement pstmt3 = null;
                PreparedStatement pstmt4 = null;
                
		String sql1 = "INSERT INTO `futbolfive`.`pago` (`cod_pago`, `monto`, `comision`, `estado_pago`) VALUES (?,?,?,?);";
		String sql2 = "INSERT INTO `futbolfive`.`lista_estandar` (`cod_lista_e`, `estado_lista_e`) VALUES (?,?);";
                String sql3 = "INSERT INTO `futbolfive`.`lista_solidaria` (`cod_lista_s`, `estado_lista_s`) VALUES (?,?);";
                String sql4 = "INSERT INTO `futbolfive`.`partido` (`organizador`, `cod_cancha`, `cod_horario`, `fecha`, `cod_pago`, `lista_estandar`, `lista_solidaria`, `estado_partido`,`fecha_inscripcion`) VALUES (?,?,?,?,?,?,?,?,?);";
                
		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                        pstmt2 = con.prepareStatement(sql2);
                        pstmt3 = con.prepareStatement(sql3);
                        pstmt4 = con.prepareStatement(sql4);
                       
                        pstmt1.setInt(1,id);
                        pstmt1.setInt(2, montoPago);
                        pstmt1.setInt(3, comisionPago);
                        pstmt1.setString(4, estadoPago);
                        
                        pstmt2.setInt(1, id);
                        pstmt2.setString(2, estado);
                        
                        pstmt3.setInt(1, id);
                        pstmt3.setString(2, estado);
                        
                        pstmt4.setString(1,idUser);
                        pstmt4.setInt(2, codCancha);
                        pstmt4.setInt(3, codHorario);
                        pstmt4.setString(4, fecha);
                        pstmt4.setInt(5, id);
                        pstmt4.setInt(6, id);
                        pstmt4.setInt(7, id);
                        pstmt4.setString(8, estado);
                        pstmt4.setString(9, diaActual1);
                        
			pstmt1.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();
                        	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt1.close();
                                pstmt2.close();
                                pstmt3.close();
                                pstmt4.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
    }

    @Override
    public Partido getdetallePartido(String idUser, int codCancha, int codHorario, String fecha) {
        Partido partido= new Partido();
        Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
                             
		String sql ="SELECT P.ORGANIZADOR,P.COD_CANCHA,P.COD_HORARIO,C.DESCRIPCION,C.DIRECCION,H.DIA,H.HORA_INICIO,H.HORA_FIN,P.COD_PAGO,PG.MONTO,PG.COMISION,PG.ESTADO_PAGO,P.LISTA_ESTANDAR,P.LISTA_SOLIDARIA,P.ESTADO_PARTIDO,P.FECHA_INSCRIPCION,P.FECHA\n" +
                            "FROM PARTIDO P INNER JOIN PAGO PG ON  P.COD_PAGO=PG.COD_PAGO\n" +
                            "INNER JOIN  DETALLE_CANCHA_HORARIO D1 ON P.COD_CANCHA=D1.COD_CANCHA AND P.COD_HORARIO=D1.COD_HORARIO\n" +
                            "INNER JOIN HORARIO H ON D1.COD_HORARIO=H.COD_HORARIO\n" +
                            "INNER JOIN CANCHA C ON D1.COD_CANCHA=C.COD_CANCHA\n" +
                            "WHERE P.ORGANIZADOR=? AND P.COD_CANCHA=? AND P.COD_HORARIO=? AND P.FECHA=?;";
	
		try {
			con = mysql.getConnection();
			
			pstmt = con.prepareStatement(sql);
						
			pstmt.setString(1,idUser);    
                        pstmt.setInt(2,codCancha);
                        pstmt.setInt(3,codHorario);
                        pstmt.setString(4, fecha);
                       
			rs = pstmt.executeQuery();
			
			// proceso el resultset
			while ( rs.next() ) {
				partido = new Partido(  rs.getString(1),
                                                        rs.getInt(2),
                                                        rs.getInt(3),
                                                        rs.getString(4),
                                                        rs.getString(5),
                                                        rs.getString(6),
                                                        rs.getInt(7),
                                                        rs.getInt(8),
                                                        rs.getInt(9),
                                                        rs.getInt(10),
                                                        rs.getInt(11),
                                                        rs.getString(12),
                                                        rs.getInt(13),
                                                        rs.getInt(14),
                                                        rs.getString(15),
                                                        rs.getString(16),
                                                        rs.getString(17));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
        
        return partido;
    }

    @Override
    public List getPartidosDisponibles(String dia, String hora, String fecha) {
        Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
                int horaI=Integer.parseInt(hora);
                String sql = "SELECT DISTINCT p1.organizador,c1.cod_cancha,h1.cod_horario,c1.descripcion,c1.direccion,h1.dia,h1.hora_inicio,h1.hora_fin,p1.lista_estandar,p1.lista_solidaria\n" +
                            "FROM partido p1 inner join detalle_cancha_horario d1 on p1.cod_cancha=d1.cod_cancha\n" +
                            "inner join cancha c1 on d1.cod_cancha=c1.cod_cancha\n" +
                            "inner join horario h1 on d1.cod_horario=h1.cod_horario\n" +
                            "where h1.dia=? and h1.hora_inicio=? and (c1.cod_cancha,h1.cod_horario) \n" +
                            "not in (SELECT cod_cancha,cod_horario FROM partido where estado_partido=\"disponible\"and fecha=?);";  
                
                List<Partido> lpartidos= new <Partido>ArrayList();		
		try {
			con = mysql.getConnection();
			// preparo la sentencia sql
			pstmt = con.prepareStatement(sql);
			// si hay parametros para el sql lo seteo			
			pstmt.setString(1,dia);    
                        pstmt.setInt(2,horaI);
                        pstmt.setString(3, fecha);
                        // ejecuto la sentencia
			rs = pstmt.executeQuery();			
			// proceso el resultset
			while ( rs.next() ) {
				lpartidos.add( new Partido( rs.getString(1),
                                                        rs.getInt(2),
                                                        rs.getInt(3),
                                                        rs.getString(4),
                                                        rs.getString(5),
                                                        rs.getString(6),
                                                        rs.getInt(7),
                                                        rs.getInt(8),
                                                        rs.getInt(9),
                                                        rs.getInt(10)));
                        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lpartidos;        
    }
    
}
