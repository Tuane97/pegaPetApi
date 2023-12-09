package br.feevale.projeto_pega_pet.service.usuario;

import br.feevale.projeto_pega_pet.controller.request.CriarUsuarioRequest;
import br.feevale.projeto_pega_pet.domain.Adotante;
import br.feevale.projeto_pega_pet.domain.Contato;
import br.feevale.projeto_pega_pet.domain.Ong;
import br.feevale.projeto_pega_pet.domain.Usuario;
import br.feevale.projeto_pega_pet.domain.enums.TipoUsuario;
import br.feevale.projeto_pega_pet.mapper.AdotanteMapper;
import br.feevale.projeto_pega_pet.mapper.ContatoMapper;
import br.feevale.projeto_pega_pet.mapper.OngMapper;
import br.feevale.projeto_pega_pet.mapper.UsuarioMapper;
import br.feevale.projeto_pega_pet.repository.AdotanteRepository;
import br.feevale.projeto_pega_pet.repository.ContatoRepository;
import br.feevale.projeto_pega_pet.repository.OngRepository;
import br.feevale.projeto_pega_pet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;


@Service
public class CriarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private AdotanteRepository adotanteRepository;


    @Autowired
    private ContatoRepository contatoRepository;


    @Transactional
    public void criar(CriarUsuarioRequest request) {
        Usuario usuario = UsuarioMapper.toEntity(request);

        usuario.setSenha(Base64.getEncoder().encodeToString(request.getSenha().getBytes()));

        usuarioRepository.save(usuario);
        Usuario usuarioSalvo = usuarioRepository.findByEmail(request.getEmail()).get();

        Contato contato = ContatoMapper.toEntity(request.getNrContato(), usuarioSalvo);
        usuario.getContatos().add(contato);
        contatoRepository.save(contato);

        if(request.getTipoUsuario() == TipoUsuario.ONG){
            Ong ong = OngMapper.toFirstEntity(usuarioSalvo, request.getCnpj());
            ongRepository.save(ong);
        } else {
            Adotante adotante = AdotanteMapper.toFirstEntity(usuarioSalvo, request.getCaracteristicasInteresse());
            adotanteRepository.save(adotante);
        }
    }
}
