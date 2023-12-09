package br.feevale.projeto_pega_pet.service.processoAdocao;

import br.feevale.projeto_pega_pet.controller.request.EditarProcessoAdocaoRequest;
import br.feevale.projeto_pega_pet.domain.ProcessoAdocao;
import br.feevale.projeto_pega_pet.domain.enums.StatusProcessoAdocao;
import br.feevale.projeto_pega_pet.domain.enums.StatusVisita;
import br.feevale.projeto_pega_pet.repository.ProcessoAdocaoRepository;
import br.feevale.projeto_pega_pet.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EditarProcessoAdocaoService {

    @Autowired
    private ProcessoAdocaoRepository processoAdocaoRepository;

    @Autowired
    private VisitaRepository visitaRepository;

    public void editar(EditarProcessoAdocaoRequest request, Long processoId) {
        ProcessoAdocao processoAdocao = processoAdocaoRepository.findById(processoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Processo de adoção não foi encontrado"));

        if(request.getStatusProcessoAdocao() == StatusProcessoAdocao.APROVADA
        && processoAdocao.getVisita().getStatus() != StatusVisita.APROVADA){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Visita não foi aprovada ou ainda está pendente");
        }

        if (request.getStatusProcessoAdocao() == StatusProcessoAdocao.CANCELADA || request.getStatusProcessoAdocao() == StatusProcessoAdocao.REPROVADA){
            processoAdocao.getVisita().setStatus(StatusVisita.valueOf(request.getStatusProcessoAdocao().toString()));
            processoAdocao.getVisita().setCdStatus(StatusVisita.valueOf(request.getStatusProcessoAdocao().toString()).codigo);
            visitaRepository.save(processoAdocao.getVisita());
        }

        processoAdocao.setStatus(StatusProcessoAdocao
                .valueOf(request.getStatusProcessoAdocao().toString()));

        processoAdocao.setDetalhe(request.getDetalhes());

        processoAdocaoRepository.save(processoAdocao);

    }
}
