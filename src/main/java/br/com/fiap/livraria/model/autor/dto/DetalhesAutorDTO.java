package br.com.fiap.livraria.model.autor.dto;

import br.com.fiap.livraria.model.autor.Autor;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetalhesAutorDTO(Long codigo, String nome, String email, String biografia,
                               @JsonFormat(pattern = "dd/MM/yyyy")
                               LocalDate dataNascimento,
                               @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                               LocalDateTime dataCadastro) {

    public DetalhesAutorDTO(Autor autor){
        this(autor.getCodigo(), autor.getNome(), autor.getEmail(), autor.getBiografia(),
                autor.getDataNascimento(), autor.getDataCadastro());
    }

}
