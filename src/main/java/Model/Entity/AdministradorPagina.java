/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giova
 */
public class AdministradorPagina {

    private String claveAcceso;
    private String id;

    public AdministradorPagina() {
    }

    public AdministradorPagina(String claveAcceso, String id) {
        this.claveAcceso = claveAcceso;
        this.id = id;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UsuarioPagina iniciarSesion() {
        UsuarioPagina user = new UsuarioPagina();
        return user;
    }

    @Override
    public String toString() {
        return "AdministradorPagina{" + "claveAcceso=" + claveAcceso + ", id=" + id + '}';
    }

    // Métodos CRUD para Prenda
    public boolean agregarPrenda(List<Prenda> inventario,Prenda prenda) {
        return inventario.add(prenda);
    }

    public Prenda consultarPrenda(List<Prenda> inventario, String id) {
        for (Prenda prenda : inventario) {
            if (prenda.getId().equals(id)) {
                return prenda;
            }
        }
        return null;
    }

    public boolean actualizarPrenda(List<Prenda> inventario, Prenda prendaActualizada) {
        for (int i = 0; i < inventario.size(); i++) {
            Prenda prenda = inventario.get(i);
            if (prenda.getId().equals(prendaActualizada.getId())) {
                inventario.set(i, prendaActualizada);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPrenda(List<Prenda> inventario, String id) {
        return inventario.removeIf(prenda -> prenda.getId().equals(id));
    }

    public List<Prenda> listarPrendas(List<Prenda> inventario) {
        return new ArrayList<>(inventario);
    }
}
