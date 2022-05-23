package c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.repository;

import c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsuario(String usuario);

    List<Usuario> removeByIdUsuario(int idUsuario);

    List<Usuario> findByAutencicadoTrue();

    boolean existsByUsuario(String usuario);

}
