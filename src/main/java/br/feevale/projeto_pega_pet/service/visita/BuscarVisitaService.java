package br.feevale.projeto_pega_pet.service.visita;

import br.feevale.projeto_pega_pet.controller.response.VisitaResponse;
import br.feevale.projeto_pega_pet.domain.Adotante;
import br.feevale.projeto_pega_pet.domain.Ong;
import br.feevale.projeto_pega_pet.domain.Visita;
import br.feevale.projeto_pega_pet.domain.enums.TipoUsuario;
import br.feevale.projeto_pega_pet.mapper.VisitaMapper;
import br.feevale.projeto_pega_pet.repository.AdotanteRepository;
import br.feevale.projeto_pega_pet.repository.OngRepository;
import br.feevale.projeto_pega_pet.repository.UsuarioRepository;
import br.feevale.projeto_pega_pet.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarVisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private AdotanteRepository adotanteRepository;


    public VisitaResponse buscar(Long visitaId) {
        Visita visita = visitaRepository.findById(visitaId).get();
        return VisitaMapper.toResponse(visita);
    }

    public Page<VisitaResponse> listar(Long usuarioId, TipoUsuario request, Pageable pageable) {
        Page<Visita> visitas;
        if(request == TipoUsuario.ADOTANTE){
            Adotante adotante= adotanteRepository.findByUsuarioId(usuarioId).get();
            visitas = visitaRepository.findByAdotante(adotante.getId(), pageable);
        } else {
            Ong ong= ongRepository.findByUsuarioId(usuarioId).get();
            visitas = visitaRepository.findByOng(ong.getId(), pageable);
        }

        return visitas.map(VisitaMapper::toResponse);

    }
}
