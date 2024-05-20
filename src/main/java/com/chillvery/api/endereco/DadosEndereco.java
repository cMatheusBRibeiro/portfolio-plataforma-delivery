package com.chillvery.api.endereco;

import com.chillvery.api.model.Endereco;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
    @NotBlank
    @Pattern(regexp = "\\d{5}\\-?\\d{3}")
    String cep,

    @NotBlank
    String logradouro,

    @NotBlank
    String bairro,

    @NotBlank
    String cidade,

    @NotBlank
    String uf,

    @NotNull
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
