package br.feevale.projeto_pega_pet.domain.enums;

public enum StatusProcessoAdocao {
    INICIADA(1), AGUARDANDO_VISITA(2), AGUARDANDO_APROVACAO(3), APROVADA(4), REPROVADA(5), CANCELADA(6);
    public int codigo;

    StatusProcessoAdocao(int codigo) {
        this.codigo = codigo;
    }
}
