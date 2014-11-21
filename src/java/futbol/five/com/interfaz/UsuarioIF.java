/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.interfaz;

import futbol.five.com.bean.Usuario;
import java.util.List;

/**
 *
 * @author Cesar
 */
public interface UsuarioIF {
    
    public boolean verificarUsuario(String usuario,String passw); 
    public boolean verificarAdministrador(String usuario,String passw);
    public void registrarUsuario(String usuario,String nombre,String apellido,String email,String proveedor,String ntelefono,String pass1,String fecha);    
    public boolean verificarSuscripcion(String iduser);
    public List<Usuario> listaEstandar(int ListaE);
    public List<Usuario> listaSolidaria(int ListaS);
    public void pagarPartido(int codPago, String organizador, int cancha, int horario,String fecha,int estandar,int solidaria);
    public void cancelarPartido(String organizador,String fecha,int cancha,int horario,int pago,int estandar,int solidaria);
    public void SalirEstandar(String usuario,int estandar);
    public void SalirSolidaria(String usuario,int solidaria);
    public boolean compararListas(int codEstandar,int codSolidaria);
}
