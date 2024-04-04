package br.com.fiap.livraria.model.editora;

import br.com.fiap.livraria.model.editora.dto.AtualizarEditoraDTO;
import br.com.fiap.livraria.model.editora.dto.CadastrarEditoraDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor

@Entity
@Table(name = "jv_tb_editora")
@EntityListeners(AuditingEntityListener.class)
public class Editora {

    @Id
    @GeneratedValue
    @Column(name = "cd_editora")
    private Long codigo;

    @Column(name = "nm_editora", length = 100, nullable = false)
    private String nome;

    @Column(name = "nr_telefone", length = 11, nullable = false)
    private String telefone;

    @Column(name = "ds_email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "tp_categoria", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaEditora categoria;

    public Editora(CadastrarEditoraDTO dto){
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
        this.categoria = dto.categoria();
    }

    public void atualizarInformacoes(AtualizarEditoraDTO dto){
        if(dto.nome() != null){
            this.nome = dto.nome();
        }
        if(dto.telefone() != null){
            this.telefone = dto.telefone();
        }
        if(dto.email() != null){
            this.email = dto.email();
        }
        if(dto.categoria() != null){
            this.categoria = dto.categoria();
        }
    }

}
