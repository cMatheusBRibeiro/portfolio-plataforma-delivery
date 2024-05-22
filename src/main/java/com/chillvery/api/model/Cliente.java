package com.chillvery.api.model;

import com.chillvery.api.cliente.DadosAtualizaCliente;
import com.chillvery.api.cliente.DadosCadastroCliente;
import com.chillvery.api.usuario.DadosAtualizaUsuario;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "cliente")
@Entity(name = "Cliente")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cliente extends Usuario {

    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroCliente dadosCadastroCliente) {
        super(dadosCadastroCliente);
        this.endereco = new Endereco(dadosCadastroCliente.endereco());
    }

    public void atualizarInformacoes(DadosAtualizaCliente dadosAtualizaCliente) {
        this.atualizarInformacoes(new DadosAtualizaUsuario(dadosAtualizaCliente));

        if (dadosAtualizaCliente.endereco() != null) {
            this.endereco.atualizarEndereco(dadosAtualizaCliente.endereco());
        }
    }
}
