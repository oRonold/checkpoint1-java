package br.com.fiap.livraria.controller;

import br.com.fiap.livraria.model.autor.Autor;
import br.com.fiap.livraria.model.autor.dto.AtualizarAutorDTO;
import br.com.fiap.livraria.model.autor.dto.CadastrarAutorDTO;
import br.com.fiap.livraria.model.autor.dto.DetalhesAutorDTO;
import br.com.fiap.livraria.model.autor.dto.ListagemAutorDTO;
import br.com.fiap.livraria.repository.AutorRepository;
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
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ListagemAutorDTO> cadastrar(@RequestBody @Valid CadastrarAutorDTO dto, UriComponentsBuilder builder){
        var autor = new Autor(dto);
        repository.save(autor);
        var uri = builder.path("/{id}").buildAndExpand(autor.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new ListagemAutorDTO(autor));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemAutorDTO>> listar(@PageableDefault(sort = {"nome"}) Pageable pageable){
        var page = repository.findAll(pageable).map(ListagemAutorDTO::new);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesAutorDTO> buscarPorId(@PathVariable Long id){
        var autor = repository.getReferenceById(id);
        return ResponseEntity.ok().body(new DetalhesAutorDTO(autor));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesAutorDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarAutorDTO dto){
        var autor = repository.getReferenceById(id);
        autor.atualizar(dto);
        return ResponseEntity.ok().body(new DetalhesAutorDTO(autor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        var autor = repository.getReferenceById(id);
        repository.deleteById(autor.getCodigo());
        return ResponseEntity.noContent().build();
    }

}
