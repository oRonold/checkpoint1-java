package br.com.fiap.livraria.model.emprestimo.dto;

import br.com.fiap.livraria.model.autor.dto.ListagemUsuarioDTO;
import br.com.fiap.livraria.model.emprestimo.Emprestimo;
import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record DetalhesEmprestimoUsuarioDTO(Long codigo,
                                           @JsonFormat(pattern = "dd/MM/yyyy")
                                           LocalDate dataEmprestimo,
                                           @JsonFormat(pattern = "dd/MM/yyyy")
                                           LocalDate dataDevolucao, StatusEmprestimo status, ListagemUsuarioDTO usuario) {

    public DetalhesEmprestimoUsuarioDTO(Emprestimo emprestimo){
        this(emprestimo.getCodigo(), emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao(), emprestimo.getStatus(), new ListagemUsuarioDTO(emprestimo.getUsuario()));
    }

}
