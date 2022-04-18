import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity postUsuario(@RequestBody @Valid Usuario novoUsuario) {
        repository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticacao/{login}/{senha}")
    public ResponseEntity logonUsuario(@PathVariable String login,
                                       @PathVariable String senha) {
        for (Usuario usuarioAtual : repository.findAll()) {
            if (usuarioAtual.autenticar(login, senha)) {
                repository.atualizarAutenticacao(usuarioAtual.buscaIdUsuario(), true);
                return ResponseEntity.status(200).body(usuarioAtual);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/listar")
    public ResponseEntity listarTodos() {
        if (repository.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @DeleteMapping("/usuarios/autenticacao/{login}")
    public ResponseEntity logoffUsuario(@PathVariable String login) {

        for (Usuario usuarioAtual : repository.findAll()) {
            if (usuarioAtual.getLogin().equals(login)) {
                if (usuarioAtual.isAutenticado()) {
                    usuarioAtual.setAutenticado(false);
                    return ResponseEntity.status(200).build();
                } else {
                    return ResponseEntity.status(406).build();
                }
            }
        }
        return ResponseEntity.status(404).build();
    }

    // ENDPOINT EXTRA
    // ESSE RETORNA UMA LISTA DOS USUARIOS QUE ESTÃO AUTENTICADOS
    @GetMapping("/listar-autenticados")
    public ResponseEntity listarAutenticados() {
        List<Usuario> usuariosAutenticados = repository.findCarroByAutenticadoTrue();
        if (usuariosAutenticados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuariosAutenticados);
    }

    // ESSE FAZ O DOWNLOAD DE UMA ARQUIVO CSV COM OS DADOS DOS USUARIOS
    @GetMapping("/relatorio")
    public ResponseEntity relatorioDeUsuarios() {

        List<Usuario> lista = repository.findAll();
        String relatorio = "";
        for (Usuario usuario : lista) {
            relatorio += "" +
                    "Código do Usuário: " + usuario.buscaIdUsuario() +
                    "\nNome: " + usuario.getNome() +
                    "\nLogin: " + usuario.getLogin() +
                    "\nUsuário Autenticado? " + (usuario.isAutenticado() ? "Sim" : "Não") +
                    "\n----------------------------------------------" +
                    "\n";
        }

        return ResponseEntity
                .status(200)
                .header("content-type", "text/txt")
                .header("content-disposition", "filename=usuario.txt")
                .body(relatorio);
    }
}