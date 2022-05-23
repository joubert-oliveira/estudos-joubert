package c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.dto;

import javax.validation.constraints.Size;

public class NovoUsuario {
// É apenas uma entidade baseada em outra com os atributos que você quer que tenha;
    @Size(min = 4, max = 8)
    private String usuario;
    @Size(min = 10, max = 30)
    private String nome;
    @Size(min = 4, max = 8)
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
