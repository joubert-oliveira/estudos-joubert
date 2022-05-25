import java.util.ArrayList;
import java.util.List;

public class Escola {

    // Atributos
    private String nome;
    private List<Alunos> Aluno;

    // Construtor
    public Escola(String nome) {
        this.nome = nome;
        Aluno = new ArrayList<Alunos>();
    }

    // Métodos
    public void adicionaAluno(Alunos a){
        Aluno.add(a);
    }

    public void exibeTodos(){
        System.out.println("Lista de Alunos");
        for (Alunos a : Aluno){
            System.out.println(a);
        }
    }

    public void exibeAlunoGraduacao(){
        System.out.println("\nAlunos Graduação");
        for (Alunos a : Aluno){
            if (a instanceof AlunoGraduacao){
                System.out.println(a);
            }
        }
    }

    public void exibeAprovados(){
        System.out.println("\nAprovados");
        for (Alunos a : Aluno){
            if (a.calculaMedia() >= 6){
                System.out.println(a);
            }
        }
    }

    public void buscaAluno(Integer ra){
        System.out.println("\nBuscar Aluno");
        Boolean achou = false;
        for (Alunos a : Aluno){
            if (a.getRa() == ra){
                System.out.println(a);
                achou = true;
            }
        }
        if (!achou){
            System.out.println("Aluno não encontrado");
        }
    }
}
