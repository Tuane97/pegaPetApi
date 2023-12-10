package br.feevale.projeto_pega_pet.mapper;

import br.feevale.projeto_pega_pet.controller.response.VisitaResponse;
import br.feevale.projeto_pega_pet.domain.Visita;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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


    public static LocalDate formatarData(String data) {
        SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoDesejado = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = data;
        try{
            Date dataOriginal = formatoOriginal.parse(data);
            dataFormatada = formatoDesejado.format(dataOriginal);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataFormatada, formatter);
    }
}
