package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.editora.dto.DetalhesEditoraDTO;
import br.com.fiap.livraria.model.livro.Genero;
import br.com.fiap.livraria.model.livro.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetalhesLivroDTO(Long codigo, String titulo, String sinopse, String isbn,
                               @JsonFormat(pattern = "dd/MM/yyyy")
                               LocalDate dataPublicacao,
                               Genero genero,
                               @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                               LocalDateTime dataCadastro, DetalhesEditoraDTO editora) {

    public DetalhesLivroDTO(Livro livro){
        this(livro.getCodigo(), livro.getTitulo(), livro.getDetalhesLivro().getSinopse(), livro.getDetalhesLivro().getIsbn(),
                livro.getDetalhesLivro().getDataPublicacao(), livro.getDetalhesLivro().getGenero(), livro.getDataCadastro(), new DetalhesEditoraDTO(livro.getEditora()));
    }
}
