import java.util.ArrayList;
import java.util.List;

public class Empresa {

    // Atributos

    List <Funcionario> lista;

    // Construtor

    public Empresa() {
        this.lista = new ArrayList<>();
    }

    // Métodos

    // Método adicionaFunc
    public void adicionaFunc(Funcionario f){
        lista.add(f);
    }

    // Método exibeTodos
    public void exibeTodos(){
        System.out.println("Lista de funcionários:");
        for (Funcionario f : lista){
            System.out.println(f);
        }
    }

    // Método exibeTotalSalario
    public void exibeTotalSalario(){
        Double total = 0.0;

        for (Funcionario f : lista){
            total += f.calcSalario();
        }
        System.out.println(String.format("Total dos salários: R$ %.2f", total));
        System.out.printf("Total dos salários: R$ %.2f\n", total); // função básica da linguagem c para exibir na tela
    }

    // Método exibeHorista
    public void exibeHorista(){
        System.out.println("Lista dos horistas:");
        for (Funcionario f : lista){
            if(f instanceof Horista){ // instanceof é um operador
                System.out.println(f);
            }
        }
    }

    // Método buscaFunc
    public void buscaFunc(String cpf){
        Boolean achou = false;
        for (Funcionario f : lista){
            if (f.getCpf() == cpf){
                System.out.println(f);
                achou = true;
            }
        }
        if (!achou){
            System.out.println("Funcionário não encontrado");
        }
    }
    // toString()
}
