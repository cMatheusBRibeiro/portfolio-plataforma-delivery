package com.chillvery.api.model;

import com.chillvery.api.cliente.DadosCadastroCliente;
import com.chillvery.api.usuario.DadosAtualizaUsuario;
import com.chillvery.api.usuario.DadosCadastroUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "ativo")
    private Boolean ativo;

    public Usuario(DadosCadastroUsuario dadosCadastroUsuario) {
        this.setNome(dadosCadastroUsuario.nome());
        this.setLogin(dadosCadastroUsuario.login());
        this.setSenha(dadosCadastroUsuario.senha());
        this.setEmail(dadosCadastroUsuario.email());
        this.setTelefone(dadosCadastroUsuario.telefone());
        this.setAtivo(true);
    }

    public Usuario(DadosCadastroCliente dadosCadastroCliente) {
        this.setNome(dadosCadastroCliente.nome());
        this.setLogin(dadosCadastroCliente.login());
        this.setSenha(dadosCadastroCliente.senha());
        this.setEmail(dadosCadastroCliente.email());
        this.setTelefone(dadosCadastroCliente.telefone());
        this.setAtivo(true);
    }

    public void remover() {
        this.setAtivo(false);
    }

    public void atualizarInformacoes(DadosAtualizaUsuario dadosAtualizaUsuario) {
        if (dadosAtualizaUsuario.nome() != null) {
            this.setNome(dadosAtualizaUsuario.nome());
        }

        if (dadosAtualizaUsuario.login() != null) {
            this.setLogin(dadosAtualizaUsuario.login());
        }

        if (dadosAtualizaUsuario.email() != null) {
            this.setEmail(dadosAtualizaUsuario.email());
        }

        if (dadosAtualizaUsuario.telefone() != null) {
            this.setTelefone(dadosAtualizaUsuario.telefone());
        }
    }
}
