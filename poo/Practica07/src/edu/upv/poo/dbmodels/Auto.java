/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upv.poo.dbmodels;


public class Auto {
    
    private int id;
    private String matricula;
    private String modelo;
    private String observaciones;
    private String color;
    private String marca;
    private double rentaPorDia;
    
    public int getAutoId() { return this.id; }

    public void setAutoId(int id) {
        this.id = id;
    }
    
    public String getMatricula(){return this.matricula;}
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
        
    public String getMarca(){return this.marca;}
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getModelo(){return this.modelo;}
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public String getObservaciones(){return this.observaciones;}
    
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }
    
    public String getColor(){return this.color;}
    
    public void setColor(String color){
        this.color = color;
    }
    
    public double getRentaPorDia(){return this.rentaPorDia;}
    
    public void setRentaPorDia(double rentaPorDia){
        this.rentaPorDia = rentaPorDia;
    }
    
    
    
    
    
}
