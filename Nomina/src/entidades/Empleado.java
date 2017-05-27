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
public class Empleado {
    private String nombre;
    private String apepat;
    private String apemat;
    private int cargo;
    private String telefono;
    private String email;
    private String imagen="/recursos/imagen.png";

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apepat
     */
    public String getApepat() {
        return apepat;
    }

    /**
     * @param apepat the apepat to set
     */
    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    /**
     * @return the apemat
     */
    public String getApemat() {
        return apemat;
    }

    /**
     * @param apemat the apemat to set
     */
    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    /**
     * @return the cargo
     */
    public int getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
