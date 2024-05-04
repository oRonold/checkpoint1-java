package br.com.fiap.livraria.model.livro;

import br.com.fiap.livraria.model.livro.dto.AtualizarLivroDTO;
import br.com.fiap.livraria.model.livro.dto.CadastrarLivroDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Setter

@Entity
@Table(name = "jv_tb_detalhes_livro")
@EntityListeners(AuditingEntityListener.class)
public class DetalhesLivro {

    @Id
    @GeneratedValue
    @Column(name = "cd_detalhes_livro")
    private Long codigo;

    @Column(name = "nr_isbn", length = 13, nullable = false, unique = true)
    private String isbn;

    @Column(name = "ds_sinopse", length = 100, nullable = false)
    private String sinopse;

    @Column(name = "dt_publicacao", nullable = false)
    private LocalDate dataPublicacao;

    @Column(name = "ds_genero", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToOne(mappedBy = "detalhesLivro", cascade = CascadeType.ALL)
    private Livro livro;

    public DetalhesLivro(CadastrarLivroDTO dto){
        this.isbn = dto.numeroIsbn();
        this.sinopse = dto.sinopse();
        this.dataPublicacao = dto.dataPublicacao();
        this.genero = dto.genero();
    }

    public void atualizar(AtualizarLivroDTO dto){
        if(dto.sinopse() != null){
            this.sinopse = dto.sinopse();
        }
    }


}
