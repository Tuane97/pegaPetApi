package br.feevale.projeto_pega_pet.service.processoAdocao;

import br.feevale.projeto_pega_pet.controller.response.ProcessoAdocaoResponse;
import br.feevale.projeto_pega_pet.domain.Adotante;
import br.feevale.projeto_pega_pet.domain.Ong;
import br.feevale.projeto_pega_pet.domain.ProcessoAdocao;
import br.feevale.projeto_pega_pet.mapper.ProcessoAdocaoMapper;
import br.feevale.projeto_pega_pet.repository.AdotanteRepository;
import br.feevale.projeto_pega_pet.repository.OngRepository;
import br.feevale.projeto_pega_pet.repository.ProcessoAdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarProcessoAdocaoService {

    @Autowired
    private AdotanteRepository adotanteRepository;

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private ProcessoAdocaoRepository processoAdocaoRepository;

    public Page<ProcessoAdocaoResponse> listarPorOng(Long usuarioId, Pageable pageable) {
        Ong ong = ongRepository.findByUsuarioId(usuarioId).get();
        Page<ProcessoAdocao> processosAdocao = processoAdocaoRepository.findAllByOngIdOrderByCdStatus(ong.getId(), pageable);
        return processosAdocao.map(ProcessoAdocaoMapper::toResponse);
    }

    public Page<ProcessoAdocaoResponse> listarPorAdotante(Long usuarioId, Pageable pageable) {
        Adotante adotante = adotanteRepository.findByUsuarioId(usuarioId).get();
        Page<ProcessoAdocao> processosAdocao = processoAdocaoRepository.findAllByAdotanteIdOrderByCdStatus(adotante.getId(), pageable);
        return processosAdocao.map(ProcessoAdocaoMapper::toResponse);
    }

    public ProcessoAdocaoResponse buscar(Long processoId) {
        ProcessoAdocao processoAdocao = processoAdocaoRepository.findById(processoId).get();
        return ProcessoAdocaoMapper.toResponse(processoAdocao);
    }
}
