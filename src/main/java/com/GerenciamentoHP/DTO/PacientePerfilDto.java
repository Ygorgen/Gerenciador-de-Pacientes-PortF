package com.GerenciamentoHP.DTO;

import java.time.LocalDate;

public record PacientePerfilDto(
        String nome,
        Integer rg,
        LocalDate dataNascimento,
        String plano) {

}
