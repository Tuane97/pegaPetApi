package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.Usuario;
import br.feevale.projeto_pega_pet.domain.enums.TipoUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Page<Usuario> findByNomeContainingIgnoreCaseAndAtivo(String text, boolean ativo, Pageable pageable);

    Page<Usuario> findAllByTipoUsuario(TipoUsuario tipoUsuario, Pageable pageable);
}
