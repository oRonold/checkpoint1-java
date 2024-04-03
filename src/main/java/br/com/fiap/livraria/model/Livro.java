package br.com.fiap.livraria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "jv_tb_livro")
public class Livro {

    @Id
    @GeneratedValue
    @Column(name = "cd_livro")
    private Long codigo;

    @Column(name = "nm_titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "nr_isbn", length = 30, nullable = false)
    private String isbn;

}
