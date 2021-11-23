/*
 
 */
package Reto1_ciclo4.Reto1.Repositorios;

import Reto1_ciclo4.Reto1.Interfaces.InterfazUsuario;
import Reto1_ciclo4.Reto1.Modelos.TablaUsuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Giovanny Vanegas
 */
@Repository
public class RepositorioUsuario {
    
    @Autowired
    private InterfazUsuario crudUsuario;
    
    public List<TablaUsuarios> getAll(){
        return (List<TablaUsuarios>) crudUsuario.findAll();
    }
    
    public Optional <TablaUsuarios> getUsuario (int id){
        return crudUsuario.findById(id);
    }
    
    public TablaUsuarios guardarUsuario(TablaUsuarios usuario) {
        return crudUsuario.save(usuario);
    }
    
    public boolean validarEmail(String email){
        Optional <TablaUsuarios> usuario = crudUsuario.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    public Optional <TablaUsuarios> validarUsuario(String email, String password) {
        return crudUsuario.findByEmailAndPassword(email, password);
    }
    
}
