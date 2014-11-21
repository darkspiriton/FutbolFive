/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import futbol.five.com.bean.Usuario;
import futbol.five.com.interfaz.CanchaIF;
import futbol.five.com.interfaz.UsuarioIF;
import futbol.five.com.metodo.ConnectionMySQL;
import static futbol.five.com.metodo.Encriptar.encriptaEnMD5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mari
 */
public class UsuarioDAO implements UsuarioIF{
    ConnectionMySQL mysql = new ConnectionMySQL();

    @Override
    public boolean verificarUsuario(String usuario, String passw) {
      
		String nickAux;
		String sql = "SELECT USER, CONTRASEÑA FROM USUARIO WHERE USER=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs= null;
		boolean existe=false;
		con = mysql.getConnection();
		usuario=usuario.toLowerCase();
			
		try {
			
			pstmt = con.prepareStatement(sql);
                        pstmt.setString(1, usuario);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				nickAux=rs.getString(1);
				
				if (usuario.equals(nickAux) && rs.getString(2).equals(encriptaEnMD5(passw))){					
						existe=true;
						break;				
				} 
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
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
    public void registrarUsuario(String usuario, String nombre, String apellido, String email, String proveedor, String ntelefono, String pass1, String fecha) {
                Connection con = null;
		int puntos = 1;
                
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO usuario (`user`, `nombre`, `apellido`, `correo`, `contraseña`, `fecha_nacimiento`, `puntos_reputacion`, `telefono`, `proveedor_telefonico`) VALUES (?,?,?,?, md5(?), ?,?, ?, ?);";
				
		try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql);
			
		        pstmt.setString(1,usuario.toLowerCase());
                        pstmt.setString(2,nombre);
                        pstmt.setString(3,apellido);
                        pstmt.setString(4,email.toLowerCase());
              		pstmt.setString(5,pass1);
			pstmt.setString(6, fecha);
                        pstmt.setInt(7,puntos);
                        pstmt.setString(8,ntelefono);
                        pstmt.setString(9,proveedor);
			
			
                        pstmt.executeUpdate();
			
			// proceso el resultset
			
			
		} catch (SQLException e) {
			e.printStackTrace();
                    
		} finally {
			try {
				
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
    }

    @Override
    public boolean verificarSuscripcion(String iduser) {
        boolean suscripcion=false;
        
        
        
        return suscripcion;
    }

    @Override
    public boolean verificarAdministrador(String usuario, String passw) {
        
                String nickAux;
		String sql = "SELECT USER,CONTRASEÑA FROM ADMIN WHERE USER=?";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs= null;
		boolean existe=false;
		con = mysql.getConnection();
		usuario=usuario.toLowerCase();
			
		try {
			
			pstmt = con.prepareStatement(sql);
                        pstmt.setString(1, usuario);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				nickAux=rs.getString(1);
				
				if (usuario.equals(nickAux) && rs.getString(2).equals(encriptaEnMD5(passw))){					
						existe=true;
						break;				
				} 
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
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
    public List<Usuario> listaEstandar(int ListaE) {
       
          Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
     
        
                String sql1="select distinct u.user,u.nombre,u.apellido,u.correo,u.telefono from lista_estandar le\n" +
                            "inner join detalle_lista_estandar dle\n" +
                            "on le.cod_lista_e=dle.cod_lista_e\n" +
                            "inner join usuario u\n" +
                            "on dle.user=u.user\n" +
                            "where le.cod_lista_e=?;";
                
                List<Usuario> lestandar= new <Usuario>ArrayList();
                
                 try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql1);		
			pstmt.setInt(1,ListaE);  
                      
                        
			rs = pstmt.executeQuery();
                        
			while ( rs.next() ) {
                             
				lestandar.add( new Usuario(   rs.getString(1),
                                                              rs.getString(2),
                                                              rs.getString(3),
                                                              rs.getString(4),
                                                              rs.getString(5)
                                                              
                                                              
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

           
        return lestandar; 
        
        
        
        
    }

    @Override
    public List<Usuario> listaSolidaria(int ListaS) {
       
        Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
     
        
                String sql1="select distinct u.user,u.nombre,u.apellido,u.correo,u.telefono from lista_solidaria ls\n" +
                            "inner join detalle_lista_solidaria dls\n" +
                            "on ls.cod_lista_s=dls.cod_lista_s\n" +
                            "inner join usuario u\n" +
                            "on dls.user=u.user\n" +
                            "where ls.cod_lista_s=?;";
                
                List<Usuario> lestandar= new <Usuario>ArrayList();
                
                 try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql1);		
			pstmt.setInt(1,ListaS);  
                      
                        
			rs = pstmt.executeQuery();
                        
			while ( rs.next() ) {
                             
				lestandar.add( new Usuario(   rs.getString(1),
                                                              rs.getString(2),
                                                              rs.getString(3),
                                                              rs.getString(4),
                                                              rs.getString(5)
                                                              
                                                              
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

           
        return lestandar; 
        
        
        
        
        
    }

    @Override
    public void pagarPartido(int codPago, String organizador, int cancha,int horario,String fecha, int estandar,int solidaria) {
       
        
        
        
                Connection con = null;
                PreparedStatement pstmt1 = null;
                PreparedStatement pstmt2 = null;
                PreparedStatement pstmt3 = null;
                PreparedStatement pstmt4 = null;
                               
		String sql1 = "UPDATE pago \n" +
                              "SET estado_pago ='pagado'\n" +
                              "WHERE cod_pago = ?";
          
                String sql2=  "update partido set estado_partido='pagado' where organizador=? and cod_cancha=? and cod_horario=? and fecha=?";
                
                String sql3=  "update lista_estandar set estado_lista_e='pagado' where cod_lista_e=?";
                                
                String sql4= "update lista_solidaria set estado_lista_s='pagado' where cod_lista_s=?";
                
                
                
                
                
                
                
                
                
		try {
			con = mysql.getConnection();
                        
                        
			pstmt1 = con.prepareStatement(sql1);
                        pstmt1.setInt(1,codPago);
                        pstmt1.executeUpdate();
                        
                          
			pstmt2 = con.prepareStatement(sql2);
                        pstmt2.setString(1,organizador);
                        pstmt2.setInt(2,cancha);
                        pstmt2.setInt(3,horario);
                        pstmt2.setString(4,fecha);
                        pstmt2.executeUpdate();
                        
                        
                        pstmt3 = con.prepareStatement(sql3);
                        pstmt3.setInt(1,estandar);
                        pstmt3.executeUpdate();
                        
                        pstmt4 = con.prepareStatement(sql4);
                        pstmt4.setInt(1,solidaria);
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
    public void cancelarPartido(String organizador, String fecha, int cancha, int horario,int pago,int estandar,int solidaria) {
       
        
        
                Connection con = null;
                PreparedStatement pstmt1 = null;
                PreparedStatement pstmt2 = null;
                PreparedStatement pstmt3 = null;
                PreparedStatement pstmt4 = null;
                
                
		String sql1 = "UPDATE partido\n" +
                              "SET estado_partido ='cancelado'\n" +
                              "WHERE organizador =? and fecha=?  and cod_cancha=? and cod_horario=?;";

                String sql2=  "update pago set estado_pago='cancelado' where cod_pago=?";
                
                String sql3=  "update lista_estandar set estado_lista_e='cancelado' where cod_lista_e=?";
                                
                String sql4= "update lista_solidaria set estado_lista_s='cancelado' where cod_lista_s=?";
                
                
                
		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                       
                        pstmt1.setString(1,organizador);
                        pstmt1.setString(2,fecha);
                        pstmt1.setInt(3,cancha);
                        pstmt1.setInt(4,horario);
                        pstmt1.executeUpdate();
                        
                        
                        pstmt2 = con.prepareStatement(sql2);
                        pstmt2.setInt(1,pago);
                        pstmt2.executeUpdate();
                        
                        
                        pstmt3 = con.prepareStatement(sql3);
                        pstmt3.setInt(1,estandar);
                        pstmt3.executeUpdate();
                        
                        pstmt4 = con.prepareStatement(sql4);
                        pstmt4.setInt(1,solidaria);
                        pstmt4.executeUpdate();
                        
                        
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				pstmt1.close();
                                pstmt2.close();
                                pstmt3.close();
                                
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
        
        
        
        
        
    }

    @Override
    public void SalirEstandar(String usuario,int estandar) {
        
                Connection con = null;
                PreparedStatement pstmt1 = null;
                
                               
		String sql1 = "DELETE FROM detalle_lista_Estandar\n" +
                               "WHERE  user = ? and cod_lista_e=?;";

		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                       
                        pstmt1.setString(1,usuario);
                        pstmt1.setInt(2,estandar);
                        
                        
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
    public void SalirSolidaria(String usuario, int solidaria) {
       
        
           Connection con = null;
                PreparedStatement pstmt1 = null;
                
                               
		String sql1 = "DELETE FROM detalle_lista_Solidaria\n" +
                               "WHERE  user = ? and cod_lista_s=?;";

		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                       
                        pstmt1.setString(1,usuario);
                        pstmt1.setInt(2,solidaria);
                        
                        
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
    public boolean compararListas(int codEstandar ,int codSolidaria ) {
        
        
         Connection con = null;
         PreparedStatement pstmt1 = null;
         PreparedStatement pstmt2 = null;       
         int contador1=0;
         int contador2=0;
         boolean valor=true;
         ResultSet rs = null;
         
		String sql1 = "SELECT * FROM futbolfive.detalle_lista_estandar\n" +
                               "where cod_lista_e=?;";
                
                String sql2 = "SELECT * FROM futbolfive.detalle_lista_solidaria\n" +
                              "where cod_lista_s=?;";

		try {
			con = mysql.getConnection();
                        
			pstmt1 = con.prepareStatement(sql1);
                        pstmt2 = con.prepareStatement(sql2);
                       
                        pstmt1.setInt(1,codEstandar);
                        pstmt2.setInt(1,codSolidaria);
                        
                        
                        rs = pstmt1.executeQuery();
                        
			while ( rs.next() ) {
                            
                            contador1=contador1+1;    
                        }
                        
                        rs=pstmt2.executeQuery();
                        
                        
                        while ( rs.next() ) {
                            
                            contador2=contador2+1;    
                        }
                        
                        if(contador1+contador2>=10){
                            
                             valor= true;
                            
                        }else
                        {
                             valor= false;
                        }
            
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
        
        return valor;
        
       
    }

   
    
       
    
    
}
