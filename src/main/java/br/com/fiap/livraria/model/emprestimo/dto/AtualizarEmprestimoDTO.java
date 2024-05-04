package br.com.fiap.livraria.model.emprestimo.dto;

import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AtualizarEmprestimoDTO(
        @Future
        LocalDate dataDevolucao) {
}
