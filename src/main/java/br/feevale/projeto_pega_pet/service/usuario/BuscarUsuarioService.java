package br.feevale.projeto_pega_pet.service.usuario;

import br.feevale.projeto_pega_pet.controller.response.UsuarioResponse;
import br.feevale.projeto_pega_pet.domain.Adotante;
import br.feevale.projeto_pega_pet.domain.Ong;
import br.feevale.projeto_pega_pet.domain.Usuario;
import br.feevale.projeto_pega_pet.domain.enums.TipoUsuario;
import br.feevale.projeto_pega_pet.mapper.UsuarioMapper;
import br.feevale.projeto_pega_pet.repository.AdotanteRepository;
import br.feevale.projeto_pega_pet.repository.OngRepository;
import br.feevale.projeto_pega_pet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private AdotanteRepository adotanteRepository;

    public UsuarioResponse buscar(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuario não encontrado"));

        UsuarioResponse usuarioResponse = UsuarioMapper.toResponse(usuario);

        if(usuario.getTipoUsuario() == TipoUsuario.ONG){
            Ong ong = ongRepository.findByUsuarioId(idUsuario)
                    .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuario não encontrado"));
            usuarioResponse.setCnpj(ong.getCnpj());

        } else {

            Adotante adotante = adotanteRepository.findByUsuarioId(idUsuario)
                    .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuario não encontrado"));
            usuarioResponse.setCnpj(adotante.getCaracteristicasInteresse());
        }

        return usuarioResponse;
    }

    public Page<UsuarioResponse> buscarPorNome(String text, Pageable pageable) {
        Page<Usuario> usuarios = usuarioRepository.findByNomeContainingIgnoreCaseAndAtivo(text, true, pageable);
        return usuarios.map(UsuarioMapper::toResponse);
    }
}
