import javax.transaction.Transactional;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Query para atualizar o preço de algum carro
    @Transactional
    @Modifying
    @Query("update Usuario u set u.autenticado = ?2 where u.idUsuario = ?1")
    void atualizarAutenticacao(int codigo, boolean vendido);


    List<Usuario> findCarroByAutenticadoTrue();
}
