package com.finalproject.contatos.controllers;

import java.util.List;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.contatos.dtos.ContatosResponse;
import com.finalproject.contatos.entities.Contatos;
import com.finalproject.contatos.services.ContatosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("contatos")
public class ContatosController {

    @Autowired
    private ContatosService service;

    @GetMapping
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public ResponseEntity<List<ContatosResponse>> getContatos() {
        return ResponseEntity.ok(service.getAllContatos());
    }
    @GetMapping("{id}")
    public ResponseEntity<ContatosResponse> getContatos(@PathVariable long id){
        return ResponseEntity.ok(service.getContatosById(id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContatos(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("path")
    public ResponseEntity<ContatosResponse> saveContatos(@Validated @RequestBody Contatos contatos) {
        ContatosResponse newContato = service.save(contatos);
        URI location = URI.create("/contatos/" + newContato.id());
        return ResponseEntity.created(location).body(newContato);
    
    }
    @PostMapping("{id}")
    public ResponseEntity<Void> updateContatos(@PathVariable long id,
                                               @Validated @RequestBody ContatosResponse contatos) {
        service.update(contatos, id); 
        return ResponseEntity.ok().build();
    }      
}
