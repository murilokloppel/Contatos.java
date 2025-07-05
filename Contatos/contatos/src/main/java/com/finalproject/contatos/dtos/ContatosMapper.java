package com.finalproject.contatos.dtos;

import com.finalproject.contatos.entities.Contatos;

public class ContatosMapper {
    public static ContatosResponse toDTO(Contatos contatos) {
        return new ContatosResponse(
            null, // ID will be set by the database
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
    public static Contatos toEntity(ContatosRequest request) {        
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
