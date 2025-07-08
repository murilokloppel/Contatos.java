package com.finalproject.contatos.dtos;

import org.springframework.stereotype.Component;

import com.finalproject.contatos.entities.Contatos;

@Component
public class ContatosMapper {
    public ContatosResponse toDTO(Contatos contatos) {
        return new ContatosResponse(
            contatos.getId(), 
            contatos.getNome(),
            contatos.getEmail(),
            contatos.getTelefone(),
            contatos.getEndereco(),
            contatos.getDataNascimento(),
            contatos.getCategoria(),
            contatos.getRedeSocial(),
            contatos.getSexo(),
            contatos.getTipo(),
            contatos.getObservacao()
        );
    }
    public Contatos toEntity(ContatosRequest request) {        
            Contatos contatos = new Contatos();            
            contatos.setNome(request.nome()); 
            contatos.setEmail(request.email());
            contatos.setTelefone(request.telefone());
            contatos.setEndereco(request.endereco());
            contatos.setDataNascimento(request.dataNascimento());
            contatos.setCategoria(request.categoria());
            contatos.setRedeSocial(request.redeSocial());
            contatos.setSexo(request.sexo());
            contatos.setTipo(request.tipo());
            contatos.setObservacao(request.observacao());
            return contatos;
    }
   
}
