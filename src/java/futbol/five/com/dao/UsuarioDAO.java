/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import futbol.five.com.bean.Usuario;
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
    
}
