import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotBlank
    @Length(min = 4, max = 12)
    private String login;

    @NotBlank
    @Length(min = 4, max = 8)
    private String senha;

    @NotBlank
    @Length(min = 10, max = 30)
    private String nome;

    @NotNull
    private boolean autenticado;

    // Metodos
    public boolean autenticar(String login, String senha) {
        autenticado = login.equals(this.login) && senha.equals(this.senha);
        return autenticado;
    }

    // Getters e Setters

    public Integer buscaIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

}
