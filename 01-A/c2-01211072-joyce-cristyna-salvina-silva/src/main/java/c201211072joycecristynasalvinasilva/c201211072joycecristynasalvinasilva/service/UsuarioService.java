package c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.service;

import c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.dto.NovoUsuario;
import c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.entidade.Usuario;
import c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
// Necessario um service para cada dto Criado;
    @Autowired
    private UsuarioRepository repository;

    public void save(NovoUsuario novoUsuario){
        Usuario usuario = new Usuario(); // Tem que instaciar a entidade original;
        usuario.setUsuario(novoUsuario.getUsuario());
        usuario.setNome(novoUsuario.getNome());
        usuario.setSenha(novoUsuario.getSenha());
        repository.save(usuario);
    }
}
