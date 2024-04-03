package br.com.fiap.livraria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "jv_tb_editora")
public class Editora {

    @Id
    @GeneratedValue
    @Column(name = "cd_editora")
    private Long codigo;

    @Column(name = "nm_editora", length = 100, nullable = false)
    private String nome;

}
