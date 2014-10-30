/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.bean;

/**
 *
 * @author Mari
 */
public class Partido {
    private String organizador;
    private int codCancha;
    private int codHorario;
    private String descripcion;
    private String direccion;
    private String dia;
    private int horaInicio;
    private int horaFin;
    private int codPago;
    private int monto;
    private int comision;
    private String estadoPago;
    private int listaE;
    private int listaS;
    private String estadoPartido;
    private String fechaIns;
    private String fecha;
    
     public Partido() {

    }
    
    public Partido(String organizador, int codCancha, int codHorario, String descripcion, String direccion, String dia, int horaInicio, int horaFin, int codPago, int monto, int comision, String estadoPago, int listaE, int listaS, String estadoPartido, String fechaIns, String fecha) {
        this.organizador = organizador;
        this.codCancha = codCancha;
        this.codHorario = codHorario;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.codPago = codPago;
        this.monto = monto;
        this.comision = comision;
        this.estadoPago = estadoPago;
        this.listaE = listaE;
        this.listaS = listaS;
        this.estadoPartido = estadoPartido;
        this.fechaIns = fechaIns;
        this.fecha = fecha;
    }
    
    public Partido(String organizador, int codCancha, int codHorario, String descripcion, String direccion, String dia, int horaInicio, int horaFin, int listaE, int listaS) {
        this.organizador = organizador;
        this.codCancha = codCancha;
        this.codHorario = codHorario;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.listaE = listaE;
        this.listaS = listaS;
       
    }
    
    public Partido(String organizador, int codCancha, int codHorario,String fecha,int codPago,int listaE,int listaS){
        this.organizador=organizador;
        this.codCancha=codCancha;
        this.codHorario=codHorario;
        this.fecha=fecha;
        this.codPago=codPago;
        this.listaE=listaE;
        this.listaS=listaS;
    }
    
    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public int getCodCancha() {
        return codCancha;
    }

    public void setCodCancha(int codCancha) {
        this.codCancha = codCancha;
    }

    public int getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(int codHorario) {
        this.codHorario = codHorario;
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

    public int getCodPago() {
        return codPago;
    }

    public void setCodPago(int codPago) {
        this.codPago = codPago;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public int getListaE() {
        return listaE;
    }

    public void setListaE(int listaE) {
        this.listaE = listaE;
    }

    public int getListaS() {
        return listaS;
    }

    public void setListaS(int listaS) {
        this.listaS = listaS;
    }

    public String getEstadoPartido() {
        return estadoPartido;
    }

    public void setEstadoPartido(String estadoPartido) {
        this.estadoPartido = estadoPartido;
    }

    public String getFechaIns() {
        return fechaIns;
    }

    public void setFechaIns(String fechaIns) {
        this.fechaIns = fechaIns;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
