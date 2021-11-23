/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto1_ciclo4.Reto1.Controladores;

import Reto1_ciclo4.Reto1.Modelos.TablaUsuarios;
import Reto1_ciclo4.Reto1.Servicios.ServicioUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Giovanny Vanegas
 */
@RestController
@RequestMapping("api/user")
@CrossOrigin("*")
public class ControlUsuario {
    
    @Autowired
    private ServicioUsuario userServicio;
    
    @GetMapping("/all")
    public List<TablaUsuarios> getAll(){
        return userServicio.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public TablaUsuarios registroUsuario(@RequestBody TablaUsuarios usuario) {
        return userServicio.registroUsuario(usuario);
    }
    
    
    @GetMapping("/{email}/{password}")
    public TablaUsuarios validarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userServicio.validarUsuario(email, password);
    }
    
    @GetMapping ("/{email}")
    public boolean  validarEmail(@PathVariable("email") String email) {
        return userServicio.validarEmail(email);
    }
    
    
}
