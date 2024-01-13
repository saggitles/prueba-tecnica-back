package com.example.demo.controllers;

import com.example.demo.models.Usuarios;
import com.example.demo.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping(value = "/get")
    public ResponseEntity<?> getUsuario(){
        List<Usuarios> usuarios = usuariosRepository.findAll();
        return ResponseEntity.ok(usuarios);
}

    @PostMapping(value = "/create")
    public ResponseEntity<?> createUsuario(@RequestBody Usuarios usuario){
        usuariosRepository.save(usuario);
        return ResponseEntity.ok("post ");
    }
}