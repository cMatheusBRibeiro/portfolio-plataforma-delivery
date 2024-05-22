package com.chillvery.api.empresa;

import com.chillvery.api.endereco.DadosEndereco;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEmpresa(
        @NotBlank
        String razaoSocial,

        String nomeFantasia,

        @NotBlank
        @Pattern(regexp = "\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}\\-?\\d{2}")
        String cnpj,

        @Embedded
        @Valid
        DadosEndereco endereco
) {}
