/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model.Entity;

/**
 * 
 * @author giova
 */
public class UsuarioPagina {

    private String id;
    private String nombre;
    private String apellido;
    private String clave;
    private String correo;

    public UsuarioPagina(String id, String nombre, String apellido, String clave, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.correo = correo;

    }

    public UsuarioPagina(String id, String nombre, String apellido, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public UsuarioPagina() {
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    public UsuarioPagina(String id) {
        this.id = id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

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
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + getId() + ", nombre=" + getNombre() + ", clave=" + getClave() + ", correo=" + getCorreo() + '}';
    }

    public boolean registrar() {
        boolean puedeRegistrar = false;
        return puedeRegistrar;
    }

    public UsuarioPagina iniciarSesion() {
        UsuarioPagina user = new UsuarioPagina();
        return user;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
