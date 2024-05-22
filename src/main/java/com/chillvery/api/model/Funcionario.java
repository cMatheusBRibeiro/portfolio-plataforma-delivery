package com.chillvery.api.model;

import com.chillvery.api.funcionario.DadosAtualizaFuncionario;
import com.chillvery.api.funcionario.DadosCadastroFuncionario;
import com.chillvery.api.funcionario.Tipo;
import com.chillvery.api.usuario.DadosAtualizaUsuario;
import com.chillvery.api.usuario.DadosCadastroUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "funcionario")
@Entity(name = "Funcionario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Funcionario extends Usuario {

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    public Funcionario(DadosCadastroFuncionario dadosCadastroFuncionario) {
        super(new DadosCadastroUsuario(dadosCadastroFuncionario));
        this.setTipo(dadosCadastroFuncionario.tipo());
    }

    public void atualizarInformacoes(DadosAtualizaFuncionario dadosAtualizaFuncionario) {
        if (dadosAtualizaFuncionario.tipo() != null) {
            this.setTipo(dadosAtualizaFuncionario.tipo());
        }

        this.atualizarInformacoes(new DadosAtualizaUsuario(dadosAtualizaFuncionario));
    }
}
