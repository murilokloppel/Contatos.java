package com.finalproject.contatos.controllers;

import java.util.List;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*; 

import com.finalproject.contatos.dtos.ContatosRequest;  
import com.finalproject.contatos.dtos.ContatosResponse; 
import com.finalproject.contatos.services.ContatosService; 


@RestController
@RequestMapping("/api/contatos")
@CrossOrigin(origins = "http://localhost:4200") 
public class ContatosController {

    @Autowired
    private ContatosService service;

    
    @GetMapping
    public ResponseEntity<List<ContatosResponse>> getAllContatos() {
        return ResponseEntity.ok(service.getAllContatos());
    }

    
    @GetMapping("{id}")
    public ResponseEntity<ContatosResponse> getContatosById(@PathVariable long id){
        return ResponseEntity.ok(service.getContatosById(id));
    }

    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContato(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build(); 
    }

    // 
    @PostMapping
    public ResponseEntity<ContatosResponse> createContato(@Validated @RequestBody ContatosRequest contatosRequest) {
        ContatosResponse newContato = service.save(contatosRequest);
        URI location = URI.create("/api/contatos/" + newContato.id()); 
        return ResponseEntity.created(location).body(newContato); 
    }

    
    @PutMapping("{id}")
    public ResponseEntity<Void> updateContato(@PathVariable long id,
                                              @Validated @RequestBody ContatosRequest contatosRequest) {
        service.update(contatosRequest, id);
        return ResponseEntity.ok().build(); //  
    }
}