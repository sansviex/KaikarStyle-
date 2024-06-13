/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.dao;

/**
 *
 * @author giova
 */
import Model.Entity.Prenda;
import java.util.List;

public interface PrendaServices {

    List<Prenda> consultar();

    Prenda consultarPorId(String id);

    int agregar(Prenda prenda);

    int actualizar(Prenda prenda);

    int eliminar(String id);
}
