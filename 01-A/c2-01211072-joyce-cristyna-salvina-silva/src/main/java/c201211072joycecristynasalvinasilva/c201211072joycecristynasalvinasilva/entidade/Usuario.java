package c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Size(min = 4, max = 8)
    private String usuario;
    @Size(min = 10, max = 30)
    private String nome;
    @Size(min = 4, max = 8)
    private String senha;
    private Boolean autencicado = false;


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String pegarSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAutencicado() {
        return autencicado;
    }

    public void setAutencicado(Boolean autencicado) {
        this.autencicado = autencicado;
    }
}
