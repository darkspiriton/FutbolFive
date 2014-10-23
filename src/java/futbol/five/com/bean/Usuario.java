/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.bean;

import java.io.Serializable;


public class Usuario implements Serializable {
    
    private String user;
    private int nTarjeta;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
 
    private String fecha_nacimiento;
    private int puntos;
    private String nTelefono;
    private String proveedorT;

     public Usuario() {
    }
    public Usuario(String user, int nTarjeta, String nombre, String apellido, String correo, String contraseña, String fecha_nacimiento, int puntos, String nTelefono, String proveedorT) {
        this.user = user;
        this.nTarjeta = nTarjeta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.fecha_nacimiento = fecha_nacimiento;
        this.puntos = puntos;
        this.nTelefono = nTelefono;
        this.proveedorT = proveedorT;
    }
    
   

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getnTarjeta() {
        return nTarjeta;
    }

    public void setnTarjeta(int nTarjeta) {
        this.nTarjeta = nTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    public String getProveedorT() {
        return proveedorT;
    }

    public void setProveedorT(String proveedorT) {
        this.proveedorT = proveedorT;
    }
    
   
}
