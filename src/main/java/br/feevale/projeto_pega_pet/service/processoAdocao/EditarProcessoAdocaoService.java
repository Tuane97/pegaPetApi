package br.feevale.projeto_pega_pet.service.processoAdocao;

import br.feevale.projeto_pega_pet.controller.request.EditarProcessoAdocaoRequest;
import br.feevale.projeto_pega_pet.domain.ProcessoAdocao;
import br.feevale.projeto_pega_pet.domain.enums.StatusProcessoAdocao;
import br.feevale.projeto_pega_pet.domain.enums.StatusVisita;
import br.feevale.projeto_pega_pet.repository.AnimalRepository;
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
    private AnimalRepository animalRepository;

    @Autowired
    private VisitaRepository visitaRepository;

    public void editar(EditarProcessoAdocaoRequest request, Long processoId) {
        ProcessoAdocao processoAdocao = processoAdocaoRepository.findById(processoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Processo de adoção não foi encontrado"));

        if(request.getStatus() == StatusProcessoAdocao.APROVADA
        && processoAdocao.getVisita().getStatus() != StatusVisita.APROVADA){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Visita não foi aprovada ou ainda está pendente");
        }

        if (request.getStatus() == StatusProcessoAdocao.CANCELADA || request.getStatus() == StatusProcessoAdocao.REPROVADA){
            processoAdocao.getVisita().setStatus(StatusVisita.valueOf(request.getStatus().toString()));
            processoAdocao.getVisita().setCdStatus(StatusVisita.valueOf(request.getStatus().toString()).codigo);
            visitaRepository.save(processoAdocao.getVisita());
        }

        if(request.getStatus() == StatusProcessoAdocao.APROVADA){
            processoAdocao.getAnimal().setAdotante(processoAdocao.getAdotante());
            processoAdocao.getAnimal().setDisponivel(false);
        }

        processoAdocao.setStatus(StatusProcessoAdocao
                .valueOf(request.getStatus().toString()));

        processoAdocao.setDetalhe(request.getObservacao());

        processoAdocaoRepository.save(processoAdocao);

    }
}
