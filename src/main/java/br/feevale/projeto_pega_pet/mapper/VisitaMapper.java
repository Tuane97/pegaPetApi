package br.feevale.projeto_pega_pet.mapper;

import br.feevale.projeto_pega_pet.controller.response.VisitaResponse;
import br.feevale.projeto_pega_pet.domain.Visita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VisitaMapper {

    public static Visita toEntity(String data, String hora) {
        return Visita.builder()
                .hora(LocalTime.parse(hora))
                .data(VisitaMapper.formatarData(data))
        .build();
    }

    public static VisitaResponse toResponse(Visita visita) {
        return VisitaResponse.builder()
                .id(visita.getId())
                .status(visita.getStatus())
                .data(visita.getData())
                .hora(visita.getHora())
                .observacao(visita.getObservacao())
                .build();
    }


    public static LocalDate formatarData(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }
}
