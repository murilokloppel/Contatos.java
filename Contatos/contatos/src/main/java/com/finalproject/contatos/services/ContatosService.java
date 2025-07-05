package com.finalproject.contatos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.contatos.Repositories.ContatosRepository;
import com.finalproject.contatos.dtos.ContatosMapper;
import com.finalproject.contatos.dtos.ContatosResponse;
import com.finalproject.contatos.entities.Contatos;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatosService {
    
    @Autowired
    private ContatosRepository repository;

    public List<ContatosResponse> getAllContatos() {
        return repository.findAll().stream()
                         .map( c -> ContatosMapper.toDTO(c))
                         .collect(Collectors.toList());
    }

    public ContatosResponse getContatosById(Long id){
        Contatos contatos = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Contato não cadastrado")
        );
        return ContatosMapper.toDTO(contatos);
    }

    public void delete (Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }
    public ContatosResponse save(Contatos contatos) {
        Contatos newContato = repository.save(contatos);
        return ContatosMapper.toDTO(newContato);
    }

    public void update(ContatosResponse contatos, long id) {
        
        Contatos aux = repository.getReferenceById(id);

        aux.setNome(contatos.nome());
        aux.setEmail(contatos.email());     
        aux.setTelefone(contatos.telefone());
        aux.setEndereco(contatos.endereco());
        aux.setDataNascimento(contatos.dataNascimento());
        aux.setCategoria(contatos.categoria()); 
        aux.setRedeSocial(contatos.redeSocial());
        aux.setSexo(contatos.sexo());
        aux.setTipo(contatos.tipo());
        aux.setObservacao(contatos.observacao());
        
        repository.save(aux);
    }

}    
