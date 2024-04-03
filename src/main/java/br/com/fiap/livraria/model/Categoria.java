package br.com.fiap.livraria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "jv_tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue
    @Column(name = "cd_categoria")
    private Long codigo;

    @Column(name = "nm_categoria", length = 100, nullable = false)
    private String nome;

}
