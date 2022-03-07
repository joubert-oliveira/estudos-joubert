package athenatech.restapi.controller;

import athenatech.restapi.model.UsuarioModel;
import athenatech.restapi.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController{

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/api/list/usuario/recuperar-toda-lista")
    public List<UsuarioModel> listar() {
        return (List<UsuarioModel>) repository.findAll();
    }

    @GetMapping("/api/list/usuario/recuperar-lista/{indice}")
    public Optional<UsuarioModel> recuperarLinhaPorIndice(@PathVariable int indice) {
        return repository.findById(indice);
    }

    @PostMapping("/api/list/usuario/salvar-lista")
    public String postLinha(@RequestBody UsuarioModel usuario) {
        repository.save(usuario);
        return "Linha CADASTRADA com SUCESSO!";
    }

    @PutMapping("/api/list/usuario/atualizar/{indice}")
    public String atualizarLinhaPorIndice(@PathVariable Integer indice, @RequestBody UsuarioModel usuario){
        UsuarioModel usuarioAtual = repository.findById(indice).get();
        BeanUtils.copyProperties(usuario, usuarioAtual, "codigo");
        repository.save(usuarioAtual);
        return "Linha ATUALIZADA com SUCESSO!";
    }

    @DeleteMapping("/api/list/usuario/deletar/{indice}")
    public String removerPorIndice(@PathVariable int indice){
        repository.deleteAllById(Collections.singleton(indice));
        return "Linha REMOVIDA com SUCESSO!";
    }
}