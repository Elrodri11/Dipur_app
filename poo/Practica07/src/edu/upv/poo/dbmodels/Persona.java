package edu.upv.poo.dbmodels;

import java.time.LocalDateTime;

/**
 *
 * @author luisroberto
 */
public class Persona {
    
    private int id;
    private String identificacion;
    private String correoElectronico;
    private String numTarjeta;
    private String rfc;
    private String tipoIdentificacion;
    private int tipoUsuario;
    private String contrasena;

    public int getPersonaId() { return this.id; }

    public void setPersonaId(int id) {
        this.id = id;
    }
    

    public String getIdentificacion() { return this.identificacion; }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreoElectronico() { return this.correoElectronico; }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumTarjeta() { return this.numTarjeta; }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getRfc() { return this.rfc; }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTipoIdentificacion() { return this.tipoIdentificacion;}

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

}
