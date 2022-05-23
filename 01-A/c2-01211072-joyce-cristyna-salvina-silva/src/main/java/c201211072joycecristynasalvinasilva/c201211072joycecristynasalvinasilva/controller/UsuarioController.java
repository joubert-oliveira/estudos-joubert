package c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.controller;

import c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.dto.NovoUsuario;
import c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.entidade.Usuario;
import c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.repository.UsuarioRepository;
import c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    UsuarioService service;

//    Refiz esse usando o dto, porém na prova tem que criar um novo. só pegar como base;
    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid NovoUsuario novoUsuario) {
        service.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticacao")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid Usuario usuario) {
        if(repository.existsByUsuario(usuario.getUsuario())) {
            Usuario usuarioDaVez = repository.findByUsuario(usuario.getUsuario());
            if (usuarioDaVez.getUsuario().equals(usuario.getUsuario()) &&
                    usuarioDaVez.pegarSenha().equals(usuario.pegarSenha())) {
                usuarioDaVez.setAutencicado(true);
                repository.save(usuarioDaVez);
                return ResponseEntity.status(200).body(usuarioDaVez);
            }
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping
    public ResponseEntity mostrarUsuarios() {
        if (repository.count() > 0) {
            return ResponseEntity.status(200).body(repository.findAll());
        }
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/autenticacao/{usuario}")
    public ResponseEntity deslogarUsuario(@PathVariable @Valid String usuario) {
        if(repository.existsByUsuario(usuario)) {
            Usuario usuarioDaVez = repository.findByUsuario(usuario);
                if (usuarioDaVez.getAutencicado().equals(true)) {
                    usuarioDaVez.setAutencicado(false);
                    repository.save(usuarioDaVez);
                    return ResponseEntity.status(200).body(usuarioDaVez);
                }
                return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(204).build();
    }

//    A INTENÇÃO DO CÓDIGO ABAIXO É PEGAR TODOS OS USUARIOS LOGADOS.
    @GetMapping("usuarios-autenticados")
    public ResponseEntity usuariosAutenticados(){
        List<Usuario> usuariosAutenticados = repository.findByAutencicadoTrue();
        if (usuariosAutenticados.size() > 0){
            return ResponseEntity.status(200).body(usuariosAutenticados);
        }
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/deletarUsuario/{idUsuario}")
    public ResponseEntity deletarUsuario(@PathVariable Integer idUsuario) {
        if(repository.existsById(idUsuario)){
            List<Usuario> usuarios = repository.removeByIdUsuario(idUsuario);
            return ResponseEntity.status(200).body(usuarios);
        }
        return  ResponseEntity.status(204).build();
    }
}
