/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.bean;

import java.io.Serializable;

/**
 *
 * @author Samuel
 */
public class Cancha implements Serializable{
    
    private int codCancha;
    private String descripcion;
    private String direccion;
    private String dia;
    private int horaInicio;
    private int horaFin;
    private int codHorario;
    
    public Cancha() {

    }

    public Cancha(int codCancha, String descripcion, String direccion, String dia, int horaInicio, int horaFin, int codHorario) {
        this.codCancha = codCancha;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.codHorario = codHorario;
    }

    public int getCodCancha() {
        return codCancha;
    }

    public void setCodCancha(int codCancha) {
        this.codCancha = codCancha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public int getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(int cod_horario) {
        this.codHorario = cod_horario;
    }
    

}
