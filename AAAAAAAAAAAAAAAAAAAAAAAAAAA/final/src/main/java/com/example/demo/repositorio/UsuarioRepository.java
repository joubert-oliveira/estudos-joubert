package com.example.demo.repositorio;

import com.example.demo.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByLogin(String login);

    Object findByLogin(String login);
}
