package com.example.api_rest.services;

import com.example.api_rest.models.UsuarioModel;
import com.example.api_rest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuariorepository;

    public ArrayList<UsuarioModel> obtenerusers(){
       return (ArrayList<UsuarioModel>) usuariorepository.findAll();
    }

    public UsuarioModel guardarusuario(UsuarioModel usuario){
        return usuariorepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerUsuarioId(Long id){
        return usuariorepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerporPrioridad(Integer prioridad){
        return  usuariorepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuariorepository.deleteById(id);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

}
