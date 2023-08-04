/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upv.poo.dbmodels;

public class Prestamo {
    private int idAuto;
    private int idCliente;
    private String fechaRenta;
    private String lugarDeRenta;
    private String finalRenta;
    private double monto;
    
    public int getIdAuto(){return this.idAuto;}
    
    public void setIdAuto(int idAuto){
        this.idAuto = idAuto;
    }
    
    public int getIdCliente(){return this.idCliente;}
    
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }
    
    public String getFechaRenta(){return this.fechaRenta;}
    
    public void setFechaRenta(String fechaRenta){this.fechaRenta = fechaRenta;}
    
        
    public String getFinalRenta(){return this.finalRenta;}
    
    public void setFinalRenta(String finalRenta){this.finalRenta = finalRenta;}
    
    public String getLugarDeRenta(){return this.lugarDeRenta;}
    
    public void setLugarDeRenta(String lugarDeRenta){this.lugarDeRenta = lugarDeRenta;}
    
    public double getMonto(){return this.monto;}
    
    public void setMonto(double monto){this.monto = monto;}
    
    
    
}



