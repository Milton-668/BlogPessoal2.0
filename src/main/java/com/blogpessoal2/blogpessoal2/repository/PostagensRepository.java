package com.blogpessoal2.blogpessoal2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal2.blogpessoal2.models.Postagens;

@Repository
public interface PostagensRepository extends JpaRepository<Postagens, Long>{
	public List<Postagens> findAllByTituloContainingIgnoreCase(String titulo);
}
