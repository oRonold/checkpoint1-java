package br.com.fiap.livraria.model.emprestimo.dto;

import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CriarEmprestimoDTO(LocalDate dataEmprestimo, LocalDate dataDevolucao, StatusEmprestimo status) {
}
