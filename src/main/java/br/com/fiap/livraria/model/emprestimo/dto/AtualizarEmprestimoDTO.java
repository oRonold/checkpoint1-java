package br.com.fiap.livraria.model.emprestimo.dto;

import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;
import jakarta.validation.constraints.NotNull;

public record AtualizarEmprestimoDTO(
        @NotNull
        Long codigo, StatusEmprestimo status) {
}
