/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author giova
 */
public class Prenda {

    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    // Constructor vacío
    public Prenda() {
    }

    // Constructor con todos los atributos
    public Prenda(String id, String nombre, String descripcion, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Prenda{"
                + "id='" + id + '\''
                + ", nombre='" + nombre + '\''
                + ", descripcion='" + descripcion + '\''
                + ", precio=" + precio
                + ", stock=" + stock
                + '}';
    }

    // Métodos adicionales
    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
        }
    }

    public void reducirStock(int cantidad) {
        if (cantidad > 0 && this.stock >= cantidad) {
            this.stock -= cantidad;
        }
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            this.precio = this.precio - (this.precio * porcentaje / 100);
        }
    }

    public double calcularPrecioConDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            return this.precio - (this.precio * porcentaje / 100);
        }
        return this.precio;
    }
}
