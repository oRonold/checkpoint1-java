package br.com.fiap.livraria.model.emprestimo.dto;

import br.com.fiap.livraria.model.emprestimo.Emprestimo;
import br.com.fiap.livraria.model.emprestimo.StatusEmprestimo;
import br.com.fiap.livraria.model.livro.dto.ListagemLivroDTO;
import br.com.fiap.livraria.model.usuario.dto.DetalhesUsuarioDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public record DetalhesEmprestimoDTO(Long codigo,
                                    @JsonFormat(pattern = "dd/MM/yyyy")
                                    LocalDate dataEmprestimo,
                                    @JsonFormat(pattern = "dd/MM/yyyy")
                                    LocalDate dataDevolucao, StatusEmprestimo status, DetalhesUsuarioDTO usuario, ArrayList<ListagemLivroDTO> livro) {

    public DetalhesEmprestimoDTO(Emprestimo emprestimo){
        this(emprestimo.getCodigo(), emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao(), emprestimo.getStatus(), new DetalhesUsuarioDTO(emprestimo.getUsuario()),
                new ArrayList<>(emprestimo.getLivros().stream().map(livro -> new ListagemLivroDTO(livro.getCodigo(), livro.getTitulo(), livro.getDetalhesLivro().getSinopse(), livro.getDetalhesLivro().getIsbn(), livro.getDetalhesLivro().getGenero())).collect(Collectors.toList())));
    }

}
