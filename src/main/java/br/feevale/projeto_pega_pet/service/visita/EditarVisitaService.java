package br.feevale.projeto_pega_pet.service.visita;

import br.feevale.projeto_pega_pet.controller.request.VisitaRequest;
import br.feevale.projeto_pega_pet.domain.ProcessoAdocao;
import br.feevale.projeto_pega_pet.domain.Visita;
import br.feevale.projeto_pega_pet.domain.enums.StatusProcessoAdocao;
import br.feevale.projeto_pega_pet.domain.enums.StatusVisita;
import br.feevale.projeto_pega_pet.repository.ProcessoAdocaoRepository;
import br.feevale.projeto_pega_pet.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class EditarVisitaService {

    @Autowired
    VisitaRepository visitaRepository;

    @Autowired
    ProcessoAdocaoRepository processoAdocaoRepository;

    public void editar(VisitaRequest request, Long visitaId) {

        Visita visita = visitaRepository.findById(visitaId).get();


        if (getStatusFinais().contains(visita.getStatus())){
            throw new ResponseStatusException(BAD_REQUEST, "Visita já foi finalizada");
        }

        visita.setStatus(StatusVisita.valueOf(request.getStatus().toString()));
        visita.setCdStatus(StatusVisita.valueOf(request.getStatus().toString()).codigo);
        visita.setObservacao(request.getObservacao());

        ProcessoAdocao processoAdocao = processoAdocaoRepository.findByVisitaId(visita.getId()).get();

        if (StatusVisita.AGENDADA == request.getStatus()){
            processoAdocao.setStatus(StatusProcessoAdocao.AGUARDANDO_VISITA);
            processoAdocao.setCdStatus(StatusProcessoAdocao.AGUARDANDO_VISITA.codigo);

        } else if (StatusVisita.APROVADA == request.getStatus()){
            processoAdocao.setStatus(StatusProcessoAdocao.AGUARDANDO_APROVACAO);
            processoAdocao.setCdStatus(StatusProcessoAdocao.AGUARDANDO_APROVACAO.codigo);

        } else {
            processoAdocao.setStatus(StatusProcessoAdocao.valueOf(request.getStatus().toString()));
            processoAdocao.setCdStatus(StatusProcessoAdocao.valueOf(request.getStatus().toString()).codigo);
            processoAdocao.setDetalhe("Visita foi cancelada ou reprovada");
        }

        visitaRepository.save(visita);
        processoAdocaoRepository.save(processoAdocao);

    }

    public List<StatusVisita> getStatusFinais(){
        List<StatusVisita> statusfinais = new ArrayList<>();
        statusfinais.add(StatusVisita.APROVADA);
        statusfinais.add(StatusVisita.REPROVADA);
        statusfinais.add(StatusVisita.CANCELADA);

        return statusfinais;
    }

}
