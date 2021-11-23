/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto1_ciclo4.Reto1.Interfaces;

import Reto1_ciclo4.Reto1.Modelos.TablaUsuarios;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author giolo
 */
public interface InterfazUsuario extends CrudRepository<TablaUsuarios,Integer>{
    Optional<TablaUsuarios> findByEmail(String email);
    Optional<TablaUsuarios> findByEmailAndPassword(String email, String password);
    
}
