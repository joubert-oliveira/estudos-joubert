import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploThrows {

    public static int divide(int numerador, int denominador) throws ArithmeticException {
        return numerador / denominador;
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int numerador, denominador, resultado;
        boolean continua = true;
        do {
            try {
                System.out.println("Digite o numerador (inteiro)");
                numerador = leitor.nextInt();
                System.out.println("Digite o denominador (inteiro)");
                denominador = leitor.nextInt();
                resultado = divide(numerador, denominador);
                System.out.println(numerador + "/" + denominador + "=" + resultado);
                continua = false;
            }
            catch (InputMismatchException erro) {
                System.out.println("Exceção:" + erro);
                leitor.nextLine();// descarta o que deveria ter sido lido
                System.out.println("Você deve digitar números inteiros. Tente novamente!");
            }
            catch (ArithmeticException erro) {
                System.out.println("Divisão por zero!");
                System.out.println("Denominador não pode ser zero. Tente novamente!");
            }
        } while (continua);
    }
}
