package com.finalproject.contatos.dtos;

public record ContatosResponse(
    Long id,
    String nome,
    String email,
    String telefone,
    String endereco,
    String dataNascimento,
    String categoria,
    String redeSocial,
    String sexo,
    String tipo,
    String observacao
) {

    
}
