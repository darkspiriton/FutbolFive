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
                PreparedStatement pstmt5 = null;
                
                String sql4 = "INSERT INTO `futbolfive`.`partido` (`organizador`, `cod_cancha`, `cod_horario`, `fecha`, `cod_pago`, `lista_estandar`, `lista_solidaria`, `estado_partido`,`fecha_inscripcion`) VALUES (?,?,?,?,?,?,?,?,?);";
		String sql1 = "INSERT INTO `futbolfive`.`pago` (`cod_pago`, `monto`, `comision`, `estado_pago`) VALUES (?,?,?,?);";
		String sql2 = "INSERT INTO `futbolfive`.`lista_estandar` (`cod_lista_e`, `estado_lista_e`) VALUES (?,?);";
                String sql3 = "INSERT INTO `futbolfive`.`lista_solidaria` (`cod_lista_s`, `estado_lista_s`) VALUES (?,?);";
                String sql5 = "INSERT INTO `futbolfive`.`detalle_lista_estandar` (`user`, `cod_lista_e`) VALUES (?, ?);";
                
		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                        pstmt2 = con.prepareStatement(sql2);
                        pstmt3 = con.prepareStatement(sql3);
                        pstmt4 = con.prepareStatement(sql4);
                        pstmt5 = con.prepareStatement(sql5);                               
                       
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
                                                
                        pstmt5.setString(1,idUser);
                        pstmt5.setInt(2, id);
                        
                        pstmt1.executeUpdate();
                        pstmt2.executeUpdate();
                        pstmt3.executeUpdate();
                        pstmt4.executeUpdate();    
                        pstmt5.executeUpdate();
                        	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt1.close();
                                pstmt2.close();
                                pstmt3.close();
                                pstmt4.close();
                                pstmt5.close();
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

    @Override
    public List mantenimientoFechaPartido() {
                
                List<Partido> lpartidos= new <Partido>ArrayList();
                
                ManejadorFechas diaAux = new ManejadorFechas();
                String diaActual = diaAux.getFechaActual(); 
                
                ResultSet rs = null;
                Connection con = null;
                PreparedStatement pstmt1 = null;
                
                
		String sql1 = "SELECT ORGANIZADOR,COD_CANCHA,COD_HORARIO,FECHA,COD_PAGO,LISTA_ESTANDAR,LISTA_SOLIDARIA FROM PARTIDO\n" +
                              "WHERE ESTADO_PARTIDO=\"disponible\" AND FECHA<= ?\n" +
                              "ORDER BY FECHA;";
		
                
		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                        pstmt1.setString(1, diaActual);
                        rs=pstmt1.executeQuery();			
                        
                        while(rs.next()){
                            lpartidos.add(new Partido(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7)));                    
                        }
                        
                        
                        	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt1.close();
                                rs.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

        return lpartidos;
    }

    @Override
    public List mantenimientoListaEPartido() {
                List<Partido> lpartidos= new <Partido>ArrayList();

                ResultSet rs = null;
                Connection con = null;
                PreparedStatement pstmt1 = null;
                
                
		String sql1 = "SELECT COUNT(DLE.USER),P.ORGANIZADOR,P.COD_CANCHA,P.COD_HORARIO,P.FECHA,P.COD_PAGO,P.LISTA_ESTANDAR,P.LISTA_SOLIDARIA\n" +
                              "FROM PARTIDO P\n" +
                              "INNER JOIN LISTA_ESTANDAR LE ON P.LISTA_ESTANDAR=LE.COD_LISTA_E\n" +
                              "INNER JOIN DETALLE_LISTA_ESTANDAR DLE ON LE.COD_LISTA_E=DLE.COD_LISTA_E\n" +
                              "WHERE LE.ESTADO_LISTA_E=\"disponible\"\n" +
                              "GROUP BY P.LISTA_ESTANDAR\n" +
                              "HAVING COUNT(DLE.USER)>10;";
		
                
		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                        rs=pstmt1.executeQuery();			
                        
                        while(rs.next()){
                            lpartidos.add(new Partido(rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8)));                    
                        }
                        
                        
                        	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt1.close();
                                rs.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

        return lpartidos;
    }

    @Override
    public void actualizarEstadoCaducado(Partido partido) {
               
                Connection con = null;
                PreparedStatement pstmt1 = null;
                PreparedStatement pstmt2 = null;
                PreparedStatement pstmt3 = null;
                PreparedStatement pstmt4 = null;
                               
		String sql1 = "UPDATE PARTIDO SET ESTADO_PARTIDO=\"caducado\"\n" +
                              "WHERE ORGANIZADOR=? and COD_CANCHA=? and COD_HORARIO=? and FECHA=?;";
                String sql2 = "UPDATE PAGO SET ESTADO_PAGO=\"caducado\"\n" +
                              "WHERE COD_PAGO=?;";
                String sql3 = "UPDATE LISTA_ESTANDAR SET ESTADO_LISTA_E=\"caducado\"\n" +
                               "WHERE COD_LISTA_E=?;";
                String sql4 = "UPDATE LISTA_SOLIDARIA SET ESTADO_LISTA_S=\"caducado\"\n" +
                              "WHERE COD_LISTA_S=?;";

		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                        pstmt1.setString(1, partido.getOrganizador());
                        pstmt1.setInt(2,partido.getCodCancha());
                        pstmt1.setInt(3,partido.getCodHorario());
                        pstmt1.setString(4, partido.getFecha());
                        
                        pstmt2 = con.prepareStatement(sql2);
                        pstmt2.setInt(1, partido.getCodPago());
                        
                        pstmt3 = con.prepareStatement(sql3);
                        pstmt3.setInt(1,partido.getListaE());
                        
                        pstmt4 = con.prepareStatement(sql4);
                        pstmt4.setInt(1, partido.getListaS());
                        
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
    public void actualizarEstadoLleno(Partido partido) {
                Connection con = null;
                PreparedStatement pstmt1 = null;
                PreparedStatement pstmt2 = null;
                
                               
		String sql1 = "UPDATE LISTA_ESTANDAR SET ESTADO_LISTA_E=\"lleno\" WHERE COD_LISTA_E=?;";
                String sql2 = "UPDATE LISTA_SOLIDARIA SET ESTADO_LISTA_S=\"lleno\" WHERE COD_LISTA_S=?;";
                
		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                        pstmt1.setInt(1, partido.getListaE());
                        
                        
                        pstmt2 = con.prepareStatement(sql2);
                        pstmt2.setInt(1, partido.getListaS());
                        
                                           
                        pstmt1.executeUpdate();
                        pstmt2.executeUpdate();
                       
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt1.close();
                                pstmt2.close();
                                
                                
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
        
    }

    @Override
    public List obtenerNumTL(int codL) {
                List<String> lnumbers= new <String>ArrayList();

                ResultSet rs1 = null;
                ResultSet rs2 = null;
                Connection con = null;
                PreparedStatement pstmt1 = null;
                PreparedStatement pstmt2 = null;
                
                
		String sql1 = "SELECT TELEFONO FROM USUARIO\n" +
                              "INNER JOIN DETALLE_LISTA_ESTANDAR DLE ON USUARIO.USER= DLE.USER\n" +
                              "WHERE DLE.COD_LISTA_E=?;";
                String sql2 = "SELECT TELEFONO FROM USUARIO\n" +
                              "INNER JOIN DETALLE_LISTA_SOLIDARIA DLS ON USUARIO.USER= DLS.USER\n" +
                              "WHERE DLS.COD_LISTA_S=?;";
		
                
		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                        pstmt2 = con.prepareStatement(sql2);
                        pstmt1.setInt(1, codL);
                        pstmt2.setInt(1, codL);
                        rs1=pstmt1.executeQuery();	
                        rs2=pstmt2.executeQuery();
                        
                        while(rs1.next()){
                            lnumbers.add(rs1.getString(1));                            
                            while(rs2.next()){
                                lnumbers.add(rs2.getString(1));
                            }
                            
                        }
                        
                        
                        	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt1.close();
                                pstmt2.close();
                                rs1.close();
                                rs2.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

        return lnumbers;
    }

    @Override
    public boolean verficarListaEstandar(int codE) {
                Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
                boolean hayEspacio=false;
                
		String sql ="SELECT COUNT(USER) FROM DETALLE_LISTA_ESTANDAR WHERE COD_LISTA_E=?;";                
		
		try {
			con = mysql.getConnection();
			// preparo la sentencia sql
			pstmt = con.prepareStatement(sql);
			// si hay parametros para el sql lo seteo
			
			pstmt.setInt(1,codE);    
                        
                        // ejecuto la sentencia
			rs = pstmt.executeQuery();
			
			// proceso el resultset
                        while(rs.next()){
                            int cantidad = rs.getInt(1);
                            if(cantidad<=10){
                                hayEspacio=true;
                            }
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
		
		return hayEspacio;
    }

    @Override
    public boolean verficarListaSolidaria(int codS) {        
                Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
                boolean hayEspacio=false;
                
		String sql ="SELECT COUNT(USER) FROM DETALLE_LISTA_SOLIDARIA WHERE COD_LISTA_S=?;";                
		
		try {
			con = mysql.getConnection();
			// preparo la sentencia sql
			pstmt = con.prepareStatement(sql);
			// si hay parametros para el sql lo seteo
			
			pstmt.setInt(1,codS);    
                        
                        // ejecuto la sentencia
			rs = pstmt.executeQuery();
			
			// proceso el resultset
                        while(rs.next()){
                            int cantidad = rs.getInt(1);
                            if(cantidad<=10){
                                hayEspacio=true;
                            }
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
		
		return hayEspacio;
    }

    @Override
    public void insertarListaEstandar(String idUser, int codE) {
        
                Connection con = null;
                PreparedStatement pstmt1 = null;                
                               
		String sql1 = "INSERT INTO `futbolfive`.`detalle_lista_estandar` (`user`, `cod_lista_e`) VALUES (?, ?);";                
                
		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);   
                        pstmt1.setString(1, idUser);
                        pstmt1.setInt(2, codE);
                    
                        pstmt1.executeUpdate();
                        
                       
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {	
				pstmt1.close();       
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
    }

    @Override
    public void insertarListaSolidaria(String idUser, int codS) {
        
                Connection con = null;
                PreparedStatement pstmt1 = null;                
                               
		String sql1 = "INSERT INTO `futbolfive`.`detalle_lista_solidaria` (`user`, `cod_lista_s`) VALUES (?, ?);";                
                
		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);   
                        pstmt1.setString(1, idUser);
                        pstmt1.setInt(2, codS);
                    
                        pstmt1.executeUpdate();
                        
                       
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {	
				pstmt1.close();       
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
    }

    @Override
    public boolean verificarExisteLE(String idUser, int codE) {       
             
                Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
                boolean existe=false;
                
		String sql ="SELECT COUNT(USER) FROM DETALLE_LISTA_ESTANDAR WHERE COD_LISTA_E=? AND USER=?;";                
		
		try {
			con = mysql.getConnection();
			// preparo la sentencia sql
			pstmt = con.prepareStatement(sql);
			// si hay parametros para el sql lo seteo
			
			pstmt.setInt(1,codE);    
                        pstmt.setString(2, idUser);
                        
                        // ejecuto la sentencia
			rs = pstmt.executeQuery();
			
			// proceso el resultset
                        while(rs.next()){
                            int cantidad = rs.getInt(1);
                            if(cantidad != 0){
                                existe=true;
                            }
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
		
		return existe;
    }

    @Override
    public boolean verificarExisteLS(String idUser, int codE) {
        Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
                boolean existe=false;
                
		String sql ="SELECT COUNT(USER) FROM DETALLE_LISTA_SOLIDARIA WHERE COD_LISTA_S=? AND USER=?;";                
		
		try {
			con = mysql.getConnection();
			// preparo la sentencia sql
			pstmt = con.prepareStatement(sql);
			// si hay parametros para el sql lo seteo
			
			pstmt.setInt(1,codE);    
                        pstmt.setString(2, idUser);
                        
                        // ejecuto la sentencia
			rs = pstmt.executeQuery();
			
			// proceso el resultset
                        while(rs.next()){
                            int cantidad = rs.getInt(1);
                            if(cantidad != 0){
                                existe=true;
                            }
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
		
		return existe;
    }

    @Override
    public List<Partido> listarPartidos(String iduser) {
        
         Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
     
        
                String sql1="SELECT P.ORGANIZADOR,P.COD_CANCHA,P.COD_HORARIO,C.DESCRIPCION,C.DIRECCION,H.DIA,H.HORA_INICIO,H.HORA_FIN,P.COD_PAGO,PG.MONTO,PG.COMISION,PG.ESTADO_PAGO,P.LISTA_ESTANDAR,P.LISTA_SOLIDARIA,P.ESTADO_PARTIDO,P.FECHA_INSCRIPCION,P.FECHA\n" +
                            "FROM PARTIDO P INNER JOIN PAGO PG ON  P.COD_PAGO=PG.COD_PAGO\n" +
                            "INNER JOIN  DETALLE_CANCHA_HORARIO D1 ON P.COD_CANCHA=D1.COD_CANCHA AND P.COD_HORARIO=D1.COD_HORARIO\n" +
                            "INNER JOIN HORARIO H ON D1.COD_HORARIO=H.COD_HORARIO\n" +
                            "INNER JOIN CANCHA C ON D1.COD_CANCHA=C.COD_CANCHA\n" +
                            "WHERE P.ORGANIZADOR=? and p.estado_partido='disponible';";
                
                List<Partido> lorganizado= new <Partido>ArrayList();
                
                 try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql1);		
			pstmt.setString(1,iduser);  
                      
                        
			rs = pstmt.executeQuery();
                        
			while ( rs.next() ) {
                             
				lorganizado.add( new Partido( rs.getString(17),
                                                              rs.getInt(2),
                                                              rs.getInt(3),
                                                              rs.getString(1),
                                                              rs.getInt(13),
                                                              rs.getInt(14),
                                                              rs.getString(4),
                                                              rs.getString(5),
                                                              rs.getString(6),
                                                              rs.getInt(7),
                                                              rs.getInt(8),
                                                              rs.getString(15),
                                                              rs.getString(12),
                                                              rs.getInt(9)
                                                              
                                                        ));
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

           
        return lorganizado; 
        
    }

    @Override
    public List<Partido> listarCompromisos(String iduser) {
     
         Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
     
        
                
                
                
                String sql1="SELECT  pg.estado_pago,p.estado_partido,p.lista_estandar,p.lista_solidaria,p.organizador,C.DESCRIPCION,C.DIRECCION,H.DIA,H.HORA_INICIO,H.HORA_FIN\n" +
                            "FROM detalle_lista_estandar dle\n" +
                            "inner join lista_estandar le\n" +
                            "on dle.cod_lista_e=le.cod_lista_e\n" +
                            "inner join partido p\n" +
                            "on le.cod_lista_e=p.lista_estandar\n" +
                            "INNER JOIN  DETALLE_CANCHA_HORARIO D1 ON P.COD_CANCHA=D1.COD_CANCHA AND P.COD_HORARIO=D1.COD_HORARIO\n" +
                            "INNER JOIN HORARIO H ON D1.COD_HORARIO=H.COD_HORARIO\n" +
                            "INNER JOIN CANCHA C ON D1.COD_CANCHA=C.COD_CANCHA\n" +
                            "inner join pago pg on p.cod_pago=pg.cod_pago\n" +
                            "where dle.user=? and p.estado_partido='disponible' and p.organizador not in(select organizador from partido where organizador=? );";
                
                
                List<Partido> lcompromisos= new <Partido>ArrayList();
                
                 try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql1);		
			pstmt.setString(1,iduser);  
                        pstmt.setString(2,iduser);
                        
			rs = pstmt.executeQuery();
                        
			while ( rs.next() ) {
                             
				lcompromisos.add( new Partido( rs.getString(1),
                                                               rs.getString(2),
                                                               rs.getInt(3),
                                                               rs.getInt(4),
                                                               rs.getString(5),
                                                               rs.getString(6),
                                                               rs.getString(7),
                                                               rs.getString(8),
                                                               rs.getInt(9),
                                                               rs.getInt(10)
                                                              
                                                        ));
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

           
        return lcompromisos; 
        
        
    }

    @Override
    public List<Partido> listarSolidarias(String iduser) {
       
         Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
     
        
                String sql1="SELECT pg.estado_pago,p.estado_partido,p.lista_solidaria,p.lista_estandar, p.organizador,C.DESCRIPCION,C.DIRECCION,H.DIA,H.HORA_INICIO,H.HORA_FIN\n" +
                            "FROM detalle_lista_solidaria dls\n" +
                            "inner join lista_solidaria ls\n" +
                            "on dls.cod_lista_s=ls.cod_lista_s\n" +
                            "inner join partido p\n" +
                            "on ls.cod_lista_s=p.lista_solidaria\n" +
                            "INNER JOIN  DETALLE_CANCHA_HORARIO D1 ON P.COD_CANCHA=D1.COD_CANCHA AND P.COD_HORARIO=D1.COD_HORARIO\n" +
                            "INNER JOIN HORARIO H ON D1.COD_HORARIO=H.COD_HORARIO\n" +
                            "INNER JOIN CANCHA C ON D1.COD_CANCHA=C.COD_CANCHA\n" +
                            "inner join pago pg on p.cod_pago=pg.cod_pago\n" +
                            "where dls.user=? and p.estado_partido='disponible';";
                
                List<Partido> lcompromisos= new <Partido>ArrayList();
                
                 try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql1);		
			pstmt.setString(1,iduser);  
                      
                        
			rs = pstmt.executeQuery();
                        
			while ( rs.next() ) {
                             
				lcompromisos.add( new Partido(rs.getString(1),
                                                              rs.getString(2),
                                                               rs.getInt(3),
                                                               rs.getInt(4),
                                                               rs.getString(5),
                                                              rs.getString(6),
                                                              rs.getString(7),
                                                              rs.getString(8),
                                                              rs.getInt(9),
                                                              rs.getInt(10)
                                                              
                                                        ));
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

           
        return lcompromisos; 
        
        
        
        
    }

    @Override
    public List<Partido> BuscarPartidos(String fecha, String dia) {
          Connection con = null;
		ResultSet rs = null;
                ResultSet rs2 = null;
		PreparedStatement pstmt = null;
                
                PreparedStatement pstmt2=null;
     
        
                String sql1="SELECT p.organizador,c1.descripcion,c1.direccion,h1.dia,h1.hora_inicio,h1.hora_fin\n" +
                            "FROM cancha c1 inner join detalle_cancha_horario d1 on c1.cod_cancha=d1.cod_cancha\n" +
                            "inner join horario h1 on d1.cod_horario=h1.cod_horario\n" +
                            "inner join partido p on d1.cod_horario=p.cod_horario and d1.cod_cancha=p.cod_cancha\n" +
                            "where h1.dia=? and (c1.cod_cancha,h1.cod_horario)\n" +
                            "in (SELECT cod_cancha,cod_horario FROM partido where estado_partido='disponible' and fecha=?);\n";
                
                String sql3="select lista_estandar,lista_solidaria from partido\n" +
                            "where estado_partido='disponible' and fecha=?;";
                List<Partido> ldisponibles= new <Partido>ArrayList();
                
                try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql1);
                        pstmt2=con.prepareStatement(sql3);
			pstmt.setString(1,dia);  
                        pstmt.setString(2,fecha);
                        pstmt2.setString(1,fecha);
                        String orga="nulo";
			rs = pstmt.executeQuery();
                        rs2=pstmt2.executeQuery();
			while ( rs.next() ) {
                                rs2.next();
				ldisponibles.add( new Partido( orga,1,2,
                                                               rs.getString(1),
                                                               rs2.getInt(1),
                                                               rs2.getInt(2),
                                                              rs.getString(2),
                                                              rs.getString(3),
                                                              rs.getString(4),
                                                              rs.getInt(5),
                                                              rs.getInt(6),
                                                              orga,
                                                              orga,2
                                                              
                                                        ));
                                
                                String sql2="SELECT cod_pago FROM partido where estado_partido='disponible' and fecha='2014-11-18';";
                                
                                
                                
                                
                                
                        }
                        rs2.next();
                        
			
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

           
        return ldisponibles; 
        
        
        
        
    }

    
    
}
