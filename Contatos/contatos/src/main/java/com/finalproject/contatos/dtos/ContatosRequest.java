package com.finalproject.contatos.dtos;

public record ContatosRequest(
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