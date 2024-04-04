package br.com.fiap.livraria.model.emprestimo.dto;

import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;

public record AtualizarEmprestimoDTO(Long codigo, StatusEmprestimo status) {
}
