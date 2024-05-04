package br.com.fiap.livraria.model.livro.dto;

import br.com.fiap.livraria.model.editora.dto.DetalhesEditoraDTO;
import br.com.fiap.livraria.model.livro.DetalhesLivro;
import br.com.fiap.livraria.model.livro.Genero;
import br.com.fiap.livraria.model.livro.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ListagemLivroDTO(Long codigo, String titulo, String sinopse, String isbn, Genero genero) {

    public ListagemLivroDTO(Livro livro){
        this(livro.getCodigo(), livro.getTitulo(), livro.getDetalhesLivro().getSinopse(), livro.getDetalhesLivro().getIsbn(),livro.getDetalhesLivro().getGenero());
    }

}
