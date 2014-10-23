/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.dao;

import futbol.five.com.interfaz.UsuarioIF;
import futbol.five.com.metodo.ConnectionMySQL;
import static futbol.five.com.metodo.Encriptar.encriptaEnMD5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mari
 */
public class UsuarioDAO implements UsuarioIF{
    ConnectionMySQL mysql = new ConnectionMySQL();

    @Override
    public boolean verificarUsuario(String usuario, String passw) {
      
		String nickAux;
		String sql = "SELECT * FROM USUARIO";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs= null;
		boolean existe=false;
		con = mysql.getConnection();
		usuario=usuario.toLowerCase();
			
		try {
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				nickAux=rs.getString(1);
				
				if (usuario.equals(nickAux) && rs.getString(6).equals(encriptaEnMD5(passw))){					
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
    
}