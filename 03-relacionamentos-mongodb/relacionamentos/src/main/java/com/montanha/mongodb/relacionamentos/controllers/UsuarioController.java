package com.montanha.mongodb.relacionamentos.controllers;

import com.montanha.mongodb.relacionamentos.models.Perfil;
import com.montanha.mongodb.relacionamentos.models.Usuario;
import com.montanha.mongodb.relacionamentos.repositories.UsuarioRepository;
import com.montanha.mongodb.relacionamentos.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        if (usuario.getPerfil() != null && usuario.getPerfil().getId() == null) {
            Perfil perfilSalvo = perfilRepository.save(usuario.getPerfil());
            usuario.setPerfil(perfilSalvo);
        }
        return usuarioRepository.save(usuario);
    }
}
