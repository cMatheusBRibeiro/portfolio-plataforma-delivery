package com.chillvery.api.endereco;

import com.chillvery.api.model.Endereco;
import jakarta.persistence.Embeddable;

public record DadosEndereco(
    String cep,
    String logradouro,
    String bairro,
    String cidade,
    String uf,
    Integer numero,
    String complemento
) {
    public DadosEndereco(Endereco endereco) {
        this(
            endereco.getCep(),
            endereco.getLogradouro(),
            endereco.getBairro(),
            endereco.getCidade(),
            endereco.getUf(),
            endereco.getNumero(),
            endereco.getComplemento()
        );
    }
}
