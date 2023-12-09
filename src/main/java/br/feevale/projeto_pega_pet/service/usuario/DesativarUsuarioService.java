package br.feevale.projeto_pega_pet.service.usuario;

import br.feevale.projeto_pega_pet.domain.Usuario;
import br.feevale.projeto_pega_pet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesativarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void desativar(Long request) {
        Usuario usuario = usuarioRepository.findById(request).get();
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);

    }
}
