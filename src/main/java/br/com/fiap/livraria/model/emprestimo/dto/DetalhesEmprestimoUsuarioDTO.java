package br.com.fiap.livraria.model.emprestimo.dto;

import br.com.fiap.livraria.model.autor.dto.ListagemUsuarioDTO;
import br.com.fiap.livraria.model.emprestimo.Emprestimo;
import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;
import br.com.fiap.livraria.model.livro.dto.ListagemLivroDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public record DetalhesEmprestimoUsuarioDTO(Long codigo,
                                           @JsonFormat(pattern = "dd/MM/yyyy")
                                           LocalDate dataEmprestimo,
                                           @JsonFormat(pattern = "dd/MM/yyyy")
                                           LocalDate dataDevolucao, StatusEmprestimo status, ListagemUsuarioDTO usuario,
                                           ArrayList<ListagemLivroDTO> livro) {

    public DetalhesEmprestimoUsuarioDTO(Emprestimo emprestimo){
        this(emprestimo.getCodigo(), emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao(), emprestimo.getStatus(),
                new ListagemUsuarioDTO(emprestimo.getUsuario()),
                new ArrayList<>(emprestimo.getLivros().stream().map(livro -> new ListagemLivroDTO(livro.getCodigo(), livro.getTitulo(), livro.getDetalhesLivro().getSinopse(), livro.getDetalhesLivro().getIsbn(), livro.getDetalhesLivro().getGenero())).collect(Collectors.toList())));
    }

}
