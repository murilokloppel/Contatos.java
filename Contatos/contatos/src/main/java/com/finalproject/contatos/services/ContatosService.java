package com.finalproject.contatos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.contatos.Repositories.ContatosRepository;
import com.finalproject.contatos.dtos.ContatosMapper;  
import com.finalproject.contatos.dtos.ContatosRequest;
import com.finalproject.contatos.dtos.ContatosResponse;
import com.finalproject.contatos.entities.Contatos; 

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatosService {

    @Autowired
    private ContatosRepository repository;

    
    @Autowired
    private ContatosMapper mapper;

    public List<ContatosResponse> getAllContatos() {
        return repository.findAll().stream()
                         
                         .map(c -> mapper.toDTO(c))
                         .collect(Collectors.toList());
    }

    public ContatosResponse getContatosById(Long id){
        Contatos contatos = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Contato não cadastrado")
        );
        
        return mapper.toDTO(contatos);
    }

    public void delete (Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }
    public ContatosResponse save(ContatosRequest contatosRequest) {
       
        Contatos contatosEntity = new Contatos();
       
        contatosEntity.setNome(contatosRequest.nome());
        contatosEntity.setEmail(contatosRequest.email());
        contatosEntity.setTelefone(contatosRequest.telefone());
        contatosEntity.setEndereco(contatosRequest.endereco());
        contatosEntity.setDataNascimento(contatosRequest.dataNascimento());
        contatosEntity.setCategoria(contatosRequest.categoria());
        contatosEntity.setRedeSocial(contatosRequest.redeSocial());
        contatosEntity.setSexo(contatosRequest.sexo());
        contatosEntity.setTipo(contatosRequest.tipo());
        contatosEntity.setObservacao(contatosRequest.observacao());
        
        Contatos newContato = repository.save(contatosEntity);
      
        return mapper.toDTO(newContato);    }

    public void update(ContatosRequest contatosRequest, long id) {
        Contatos aux = repository.getReferenceById(id);

        aux.setNome(contatosRequest.nome());
        aux.setEmail(contatosRequest.email());
        aux.setTelefone(contatosRequest.telefone());
        aux.setEndereco(contatosRequest.endereco());
        aux.setDataNascimento(contatosRequest.dataNascimento());
        aux.setCategoria(contatosRequest.categoria());
        aux.setRedeSocial(contatosRequest.redeSocial());
        aux.setSexo(contatosRequest.sexo());
        aux.setTipo(contatosRequest.tipo());
        aux.setObservacao(contatosRequest.observacao());

        repository.save(aux);
    }

}