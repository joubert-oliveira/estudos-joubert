package c201211072joycecristynasalvinasilva.c201211072joycecristynasalvinasilva.entidade;

import javax.persistence.*;

@Entity
public class ClasseRelacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClasseRelacionamento;

    private String nomeClasseRelacionamento;

//   É aqui que é feito o relacionando com a anotação @ManyToOne / @OneToOne e etc...
    @ManyToOne
    private Usuario idUsuario;

    public int getIdClasseRelacionamento() {
        return idClasseRelacionamento;
    }

    public void setIdClasseRelacionamento(int idClasseRelacionamento) {
        this.idClasseRelacionamento = idClasseRelacionamento;
    }

    public String getNomeClasseRelacionamento() {
        return nomeClasseRelacionamento;
    }

    public void setNomeClasseRelacionamento(String nomeClasseRelacionamento) {
        this.nomeClasseRelacionamento = nomeClasseRelacionamento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
