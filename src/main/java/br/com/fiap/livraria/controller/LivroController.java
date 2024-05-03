package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.model.livro.Livro;
import br.com.fiap.livraria.model.livro.dto.AtualizarLivroDTO;
import br.com.fiap.livraria.model.livro.dto.CadastrarLivroDTO;
import br.com.fiap.livraria.model.livro.dto.ExibirLivroDTO;
import br.com.fiap.livraria.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ExibirLivroDTO> cadastrar(@RequestBody CadastrarLivroDTO dto, UriComponentsBuilder builder){
        var livro = new Livro(dto);
        repository.save(livro);
        var uri = builder.path("/{id}").buildAndExpand(livro.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new ExibirLivroDTO(livro));
    }

    @GetMapping
    public ResponseEntity<Page<ExibirLivroDTO>> listar(@PageableDefault(sort = {"titulo"}) Pageable pageable){
        var page = repository.findAll(pageable).map(ExibirLivroDTO::new);
        return ResponseEntity.ok(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ExibirLivroDTO> buscarPorId(@PathVariable Long id){
        var livro = repository.getReferenceById(id);
        return ResponseEntity.ok(new ExibirLivroDTO(livro));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ExibirLivroDTO> atualizar(@RequestBody @Valid AtualizarLivroDTO dto, @PathVariable Long id){
        var livro = repository.getReferenceById(id);
        livro.atualizar(dto);
        return ResponseEntity.ok().body(new ExibirLivroDTO(livro));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        var post = repository.getReferenceById(id);
        repository.delete(post);
        return ResponseEntity.noContent().build();
    }

}
