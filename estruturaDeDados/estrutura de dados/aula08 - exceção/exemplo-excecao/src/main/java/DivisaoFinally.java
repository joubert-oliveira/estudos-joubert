import javax.swing.*;

public class DivisaoFinally {
    public static void main(String[] args) {

        // JOptionPane.showInputDialog -- inserir dados (Scanner)
        String snum1 = JOptionPane.showInputDialog("Digite o primeiro número");
        if (snum1 == null){
            System.exit(0);
        }

        String snum2 = JOptionPane.showInputDialog("Digite o segundo número");
        if (snum2 == null){
            System.exit(0);
        }

        // JOptionPane.showMessageDialog -- mostrar dados (Sout)
        try {
            int num1 = Integer.valueOf(snum1);
            int num2 = Integer.valueOf(snum2);
            JOptionPane.showMessageDialog(null, "Divisão = " + (num1 / num2));
        }
        catch (ArithmeticException erro){
            JOptionPane.showMessageDialog(null, "Erro de divisão por zero!\n" + erro.toString(),"Erro", JOptionPane.ERROR_MESSAGE);
        }
        catch (NumberFormatException erro){
            JOptionPane.showMessageDialog(null, "Digite apenas números inteiros!\n" + erro.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            JOptionPane.showMessageDialog(null, "Final de execução!");
        }
        System.exit(0);
    }
}
