package com.example.demo.controle;

import com.example.demo.entidade.Usuario;
import com.example.demo.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity postUsuario(
            @RequestBody @Valid Usuario novoUsuario) {
        repository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticacao")
    public ResponseEntity autenticarUsuario(
            @RequestBody @Valid Usuario usuario) {
        if (repository.count() == 0) {
            return ResponseEntity.status(404).build();
        } else {
            for (int i = 1; i <= repository.count(); i++) {
                Usuario usuarioAtual = repository.findById(i).get();
                if (usuarioAtual.getLogin().equalsIgnoreCase(usuario.getLogin())
                        && usuarioAtual.senha().equalsIgnoreCase(usuario.senha())) {
                    usuario.setAutenticado(true);
                    repository.save(usuario);
                    return ResponseEntity.status(200).build();
                } else {
                    return ResponseEntity.status(404).build();
                }
            }
        }
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity getUsuarios() {
        if (repository.count() == 0) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @DeleteMapping("/autenticacao/{login}")
    public ResponseEntity deleteUsuario(
            @PathVariable String login) {
        if (repository.existsByLogin(login)) {
            Usuario usuarioAtual = (Usuario) repository.findByLogin(login);

            if (usuarioAtual.getAutenticado()) {
                usuarioAtual.setAutenticado(false);
                repository.save(usuarioAtual);
                return ResponseEntity.status(200).build();
            } else {
                return ResponseEntity.status(406).build();
            }
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
