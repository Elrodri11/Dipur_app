/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upv.poo.dbmodels;


public class Usuario {
    private String nombre;
    private String contrasena;
    private int superUsuario;
    private int id;
    
    public int getUsuarioId() { return this.id; }

    public void setUsuarioId(int id) {
        this.id = id;
    }
    
    public String getContrasena() { return this.contrasena; }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
        
    public String getNombre() { return this.nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
            
    public int getSuperUsuario() { return this.superUsuario; }

    public void setSuperUsuario(int superUsuario) {
        this.superUsuario = superUsuario;
    }
    
    
    
}


