package com.example.api_rest.controller;


import com.example.api_rest.models.UsuarioModel;
import com.example.api_rest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList <UsuarioModel> obtenerUsuarios(){
        return  usuarioService.obtenerusers();
    }
    @PostMapping()
    public UsuarioModel GuardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarusuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorid(@PathVariable("id") Long id){
        return this.usuarioService.obtenerUsuarioId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorprioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerporPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean check = this.usuarioService.eliminarUsuario(id);
        if (check){
            return "Usuario eliminado exitosamente";
        }else{
            return "No se pudo eliminar el usuario con el id "+id;
        }
    }


}
