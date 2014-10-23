/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.metodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mari
 */
public class CantidadPartidos {
    ConnectionMySQL mysql = new ConnectionMySQL();
    public int obtenerId(){
        
                int cant=0;
		String sql = "SELECT count(*) FROM futbolfive.partido;";
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs= null;
		
		
			
		try {
			con = mysql.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()){
                            cant=rs.getInt(1);
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
		
		return cant+1;  
    }
}
