package br.com.antonio.template.usuario;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class UsuarioRequest {

    @NotBlank
    private String nome;

    @Positive
    @Min(value = 18)
    private Integer idade;

    public UsuarioRequest(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Usuario toModel() {
        return new Usuario(this.nome, this.idade);
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

}
