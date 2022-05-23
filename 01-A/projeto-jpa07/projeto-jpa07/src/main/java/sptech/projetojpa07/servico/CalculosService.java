package sptech.projetojpa07.servico;

public class CalculosService {


    public Double calcularInss(Double salarioBruto) {
        if (salarioBruto < 500) {
            throw new IllegalArgumentException("Salário deve ser a partir de 500");
        }

        if (salarioBruto > 2000) {
            return salarioBruto * 0.1;
        }
        return salarioBruto * 0.05;
    }

    public boolean receberAuxilio(double salario, int dependentes) {
        if (salario < 500 || dependentes <= 0) {
            throw new IllegalArgumentException("O salário deve ser a partir de 500 e os dependendetes a partir de 0");
        }
        if (salario < 2000 || (salario < 4000 && dependentes > 3)) {
            return true;
        }
        return false;
    }

    /*
    O Auxilio emergnecial deve ser concedido somente se o salário for menor que 2000 ou
    se tiver mais de 3 dependentes e o salário for menor que 4000.
    Caso o salário for menor que 500 ou o número de filhos for menor que 0, lance uma IllegalArgumentException
    com a mensagem "O salário deve ser a partir de 500 e os dependendetes a partir de 0.
    */
}
