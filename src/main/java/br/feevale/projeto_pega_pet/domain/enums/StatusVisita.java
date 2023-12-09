package br.feevale.projeto_pega_pet.domain.enums;

public enum StatusVisita {
    SOLICITADA(1), AGENDADA(2), CANCELADA(5), APROVADA(3), REPROVADA(4);
    public int codigo;

    StatusVisita(int codigo) {
        this.codigo = codigo;
    }
}
