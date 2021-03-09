package com.blogpessoal2.blogpessoal2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal2.blogpessoal2.models.Postagens;
import com.blogpessoal2.blogpessoal2.repository.PostagensRepository;

@RestController
@RequestMapping(value = "/postagens")
@CrossOrigin("*")
public class PostagensController {

	@Autowired
	private PostagensRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagens>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{titulo}/{titulo}")
	public ResponseEntity<List<Postagens>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagens> getById(@PathVariable long id) {
		return repository.findById(id).map(obj -> ResponseEntity.ok(obj)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Postagens> post(@RequestBody Postagens postagens) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagens));
	}
	
	@PutMapping
	public ResponseEntity<Postagens> put (@RequestBody Postagens postagens){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagens));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}

}
