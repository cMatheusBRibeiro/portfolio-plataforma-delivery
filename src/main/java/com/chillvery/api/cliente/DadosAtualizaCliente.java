package com.chillvery.api.cliente;

import com.chillvery.api.endereco.DadosEndereco;
import jakarta.persistence.Embedded;

public record DadosAtualizaCliente(
    String nome,
    String login,
    String senha,
    String email,
    String telefone,
    @Embedded
    DadosEndereco endereco
) {
}
