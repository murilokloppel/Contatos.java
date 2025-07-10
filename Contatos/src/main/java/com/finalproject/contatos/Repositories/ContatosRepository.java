package com.finalproject.contatos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.contatos.entities.Contatos;

public interface ContatosRepository  extends JpaRepository<Contatos, Long> {
    
    // Custom query methods can be defined here if needed
    // For example, to find contacts by name:
    // List<Contatos> findByNome(String nome);
    
}
