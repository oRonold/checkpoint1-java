package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.model.livro.Livro;
import br.com.fiap.livraria.model.livro.dto.AtualizarLivroDTO;
import br.com.fiap.livraria.model.livro.dto.CadastrarLivroDTO;
import br.com.fiap.livraria.model.livro.dto.DetalhesLivroDTO;
import br.com.fiap.livraria.repository.LivroRepository;
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
    public ResponseEntity<DetalhesLivroDTO> cadastrar(@RequestBody CadastrarLivroDTO dto, UriComponentsBuilder builder){
        var livro = new Livro(dto);
        repository.save(livro);
        var uri = builder.path("/{id}").buildAndExpand(livro.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesLivroDTO(livro));
    }

    @GetMapping
    public ResponseEntity<Page<DetalhesLivroDTO>> listar(@PageableDefault(sort = {"titulo"}) Pageable pageable){
        var page = repository.findAll(pageable).map(DetalhesLivroDTO::new);
        return ResponseEntity.ok(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesLivroDTO> buscarPorId(@PathVariable Long id){
        var livro = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesLivroDTO(livro));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetalhesLivroDTO> atualizar(@RequestBody AtualizarLivroDTO dto){
        var livro = repository.getReferenceById(dto.codigo());
        livro.atualizar(dto);
        return ResponseEntity.ok().body(new DetalhesLivroDTO(livro));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        var livro = repository.getReferenceById(id);
        repository.deleteById(livro.getCodigo());
        return ResponseEntity.noContent().build();
    }

}
