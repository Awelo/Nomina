/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author awelo
 */
public class Domicilio {
    private String calle;
    private String numExt;
    private String numInt;
    private String colonia;
    private String cp;
    private String ciudad;
    
    public Domicilio(){
        numInt="N/A";
        numExt="S/N";
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numExt
     */
    public String getNumExt() {
        return numExt;
    }

    /**
     * @param numExt the numExt to set
     */
    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    /**
     * @return the numInt
     */
    public String getNumInt() {
        return numInt;
    }

    /**
     * @param numInt the numInt to set
     */
    public void setNumInt(String numInt) {
        this.numInt = numInt;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
