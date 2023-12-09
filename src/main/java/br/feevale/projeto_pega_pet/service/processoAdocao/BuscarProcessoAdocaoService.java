package br.feevale.projeto_pega_pet.service.processoAdocao;

import br.feevale.projeto_pega_pet.controller.response.ProcessoAdocaoResponse;
import br.feevale.projeto_pega_pet.domain.ProcessoAdocao;
import br.feevale.projeto_pega_pet.mapper.ProcessoAdocaoMapper;
import br.feevale.projeto_pega_pet.repository.ProcessoAdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarProcessoAdocaoService {

    @Autowired
    private ProcessoAdocaoRepository processoAdocaoRepository;

    public Page<ProcessoAdocaoResponse> listarPorOng(Long ongId, Pageable pageable) {
        Page<ProcessoAdocao> processosAdocao = processoAdocaoRepository.findAllByOngIdOrderByCdStatus(ongId, pageable);
        return processosAdocao.map(ProcessoAdocaoMapper::toResponse);
    }

    public Page<ProcessoAdocaoResponse> listarPorAdotante(Long adotanteId, Pageable pageable) {
        Page<ProcessoAdocao> processosAdocao = processoAdocaoRepository.findAllByAdotanteIdOrderByCdStatus(adotanteId, pageable);
        return processosAdocao.map(ProcessoAdocaoMapper::toResponse);
    }

    public ProcessoAdocaoResponse buscar(Long processoId) {
        ProcessoAdocao processoAdocao = processoAdocaoRepository.findById(processoId).get();
        return ProcessoAdocaoMapper.toResponse(processoAdocao);
    }
}
