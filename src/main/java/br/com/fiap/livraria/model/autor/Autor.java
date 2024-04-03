package br.com.fiap.livraria.model.autor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "jv_tb_autor")
public class Autor {

    @Id
    @GeneratedValue
    @Column(name = "cd_autor")
    private Long codigo;

    @Column(name = "nm_autor", length = 100, nullable = false)
    private String nome;

}
