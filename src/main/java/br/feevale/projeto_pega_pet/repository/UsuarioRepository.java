package br.feevale.projeto_pega_pet.repository;

import br.feevale.projeto_pega_pet.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
