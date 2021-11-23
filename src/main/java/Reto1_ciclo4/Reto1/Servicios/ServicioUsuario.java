/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto1_ciclo4.Reto1.Servicios;

import Reto1_ciclo4.Reto1.Modelos.TablaUsuarios;
import Reto1_ciclo4.Reto1.Repositorios.RepositorioUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Giovanny Vanegas
 */
@Service
public class ServicioUsuario {
    
    @Autowired
    private RepositorioUsuario usuarioCrud;
    
    
    public List<TablaUsuarios> getAll(){
        return usuarioCrud.getAll();
    }
    
    public Optional <TablaUsuarios> getUsuario(int id){
        return usuarioCrud.getUsuario(id);
    }
    
    
    public TablaUsuarios registroUsuario( TablaUsuarios usuario){
        if (usuario.getId()== null) {
            if (validarEmail(usuario.getEmail()) == false ) {
                return usuarioCrud.guardarUsuario(usuario);
            }
            else{
                return usuario;
            }
        } else{
            return usuario;
        }
    }
    
    public boolean validarEmail(String email) {
        return usuarioCrud.validarEmail(email);
              
    }
    
    public TablaUsuarios validarUsuario ( String email, String password) {
        Optional<TablaUsuarios> usuario = usuarioCrud.validarUsuario(email , password);
        
        if (usuario.isEmpty()) {
            
            return new TablaUsuarios(email, password, "NO DEFINIDO" );
            
        }
        else {
            return usuario.get();
        }
    
    }

}