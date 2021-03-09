package com.blogpessoal2.blogpessoal2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal2.blogpessoal2.models.Postagens;
import com.blogpessoal2.blogpessoal2.repository.PostagensRepository;

@RestController
@RequestMapping(value= "/postagens")
@CrossOrigin("*")
public class PostagensController {

		@Autowired
		private PostagensRepository repository;
		
		@GetMapping("/{id}")
		public ResponseEntity<Postagens> getById(@PathVariable long id){
			return repository.findById(id).map(obj-> ResponseEntity.ok(obj))
					.orElse(ResponseEntity.notFound().build());
		}
		
		
		
		
		
		
		
}
