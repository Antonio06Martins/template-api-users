package br.com.antonio.template.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByIdadeBetween(
            Integer idadeInicial, Integer idadeFinal);
}
