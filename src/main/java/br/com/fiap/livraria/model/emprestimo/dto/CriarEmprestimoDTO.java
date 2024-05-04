package br.com.fiap.livraria.model.emprestimo.dto;

import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CriarEmprestimoDTO(
        @NotNull
        Long idUSuario,
        @NotNull
        @Future
        LocalDate dataDevolucao,
        @NotNull
        StatusEmprestimo status) {
}
