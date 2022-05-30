package br.com.antonio.template.usuario;

public class UsuarioResponse {

    private Long id;
    private String nome;
    private Integer idade;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.idade = usuario.getIdade();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }
}
