package br.com.fiap.livraria.model.editora.dto;

import br.com.fiap.livraria.model.editora.CategoriaEditora;
import br.com.fiap.livraria.model.editora.Editora;
import br.com.fiap.livraria.model.livro.Livro;
import br.com.fiap.livraria.model.livro.dto.ListagemLivroDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record DetalhesEditoraDTO(Long codigo, String nome, String telefone, String email, CategoriaEditora categoria, ArrayList<ListagemLivroDTO> livros) {

    public DetalhesEditoraDTO(Editora editora){
        this(editora.getCodigo(), editora.getNome(), editora.getTelefone(), editora.getEmail(), editora.getCategoria(),
                new ArrayList<>(editora.getLivro().stream().map(livro -> new ListagemLivroDTO(livro.getCodigo(),
                        livro.getTitulo(), livro.getDetalhesLivro().getSinopse(), livro.getDetalhesLivro().getSinopse(),
                        livro.getDetalhesLivro().getGenero())).collect(Collectors.toList())));
    }

}
