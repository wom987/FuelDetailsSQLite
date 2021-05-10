package com.example.examenpractico2.Entities;

public class Facturas {
    private  int id;
    private int factura;
    private String fecha;
    private double montoComp;
    private String tipoComb;
    private int kmt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMontoComp() {
        return montoComp;
    }

    public void setMontoComp(double montoComp) {
        this.montoComp = montoComp;
    }

    public String getTipoComb() {
        return tipoComb;
    }

    public void setTipoComb(String tipoComb) {
        this.tipoComb = tipoComb;
    }

    public int getKmt() {
        return kmt;
    }

    public void setKmt(int kmt) {
        this.kmt = kmt;
    }
}
