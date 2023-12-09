package br.feevale.projeto_pega_pet.service.visita;

import br.feevale.projeto_pega_pet.domain.Visita;
import br.feevale.projeto_pega_pet.domain.enums.StatusVisita;
import br.feevale.projeto_pega_pet.mapper.VisitaMapper;
import br.feevale.projeto_pega_pet.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarVisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    public Visita criar(String data, String hora) {
        Visita visita = VisitaMapper.toEntity(data, hora);
        visita.setStatus(StatusVisita.SOLICITADA);
        visita.setCdStatus(StatusVisita.SOLICITADA.codigo);
        visitaRepository.save(visita);
        return visita;
    }
}
