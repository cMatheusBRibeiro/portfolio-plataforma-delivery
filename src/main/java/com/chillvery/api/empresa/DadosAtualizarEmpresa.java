package com.chillvery.api.empresa;

import com.chillvery.api.endereco.DadosEndereco;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Pattern;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.repository.query.Param;

public record DadosAtualizarEmpresa(
        @NotNull
        Long id,
        String razaoSocial,
        String nomeFantasia,

        @Pattern(regexp = "\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}\\-")
        String cnpj,

        @Embedded
        DadosEndereco endereco
) { }
