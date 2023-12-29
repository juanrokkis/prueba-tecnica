package com.moovia.rickymicroservice.persistence.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trazabilidad")
public class Trazabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora_consulta")
    private Timestamp fechaHoraConsulta;

    @Column(name = "recurso_solicitado")
    private String recursoSolicitado;

    @Column(name = "cuerpo_consulta")
    private String cuerpoConsulta;

    @Column(name = "respuesta_consulta")
    private String respuestaConsulta;

    @Column(name = "encabezados_consulta")
    private String encabezadosConsulta;

    @Column(name = "info_autenticacion")
    private String infoAutenticacion;

    @Column(name = "metodo_http")
    private String metodoHttp;

    @Column(name = "tiempo_total_procesamiento")
    private Integer tiempoTotalProcesamiento;

    @Column(name = "codigo_http_respuesta_cliente")
    private Integer codigoHttpRespuestaCliente;

    @Column(name = "codigo_http_respuesta_api_tullave")
    private Integer codigoHttpRespuestaApiTullave;

    @Column(name = "ip_cliente")
    private String ipCliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFechaHoraConsulta() {
        return fechaHoraConsulta;
    }

    public void setFechaHoraConsulta(Timestamp fechaHoraConsulta) {
        this.fechaHoraConsulta = fechaHoraConsulta;
    }

    public String getRecursoSolicitado() {
        return recursoSolicitado;
    }

    public void setRecursoSolicitado(String recursoSolicitado) {
        this.recursoSolicitado = recursoSolicitado;
    }

    public String getCuerpoConsulta() {
        return cuerpoConsulta;
    }

    public void setCuerpoConsulta(String cuerpoConsulta) {
        this.cuerpoConsulta = cuerpoConsulta;
    }

    public String getRespuestaConsulta() {
        return respuestaConsulta;
    }

    public void setRespuestaConsulta(String respuestaConsulta) {
        this.respuestaConsulta = respuestaConsulta;
    }

    public String getEncabezadosConsulta() {
        return encabezadosConsulta;
    }

    public void setEncabezadosConsulta(String encabezadosConsulta) {
        this.encabezadosConsulta = encabezadosConsulta;
    }

    public String getInfoAutenticacion() {
        return infoAutenticacion;
    }

    public void setInfoAutenticacion(String infoAutenticacion) {
        this.infoAutenticacion = infoAutenticacion;
    }

    public String getMetodoHttp() {
        return metodoHttp;
    }

    public void setMetodoHttp(String metodoHttp) {
        this.metodoHttp = metodoHttp;
    }

    public Integer getTiempoTotalProcesamiento() {
        return tiempoTotalProcesamiento;
    }

    public void setTiempoTotalProcesamiento(Integer tiempoTotalProcesamiento) {
        this.tiempoTotalProcesamiento = tiempoTotalProcesamiento;
    }

    public Integer getCodigoHttpRespuestaCliente() {
        return codigoHttpRespuestaCliente;
    }

    public void setCodigoHttpRespuestaCliente(Integer codigoHttpRespuestaCliente) {
        this.codigoHttpRespuestaCliente = codigoHttpRespuestaCliente;
    }

    public Integer getCodigoHttpRespuestaApiTullave() {
        return codigoHttpRespuestaApiTullave;
    }

    public void setCodigoHttpRespuestaApiTullave(Integer codigoHttpRespuestaApiTullave) {
        this.codigoHttpRespuestaApiTullave = codigoHttpRespuestaApiTullave;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public void setIpCliente(String ipCliente) {
        this.ipCliente = ipCliente;
    }

}
