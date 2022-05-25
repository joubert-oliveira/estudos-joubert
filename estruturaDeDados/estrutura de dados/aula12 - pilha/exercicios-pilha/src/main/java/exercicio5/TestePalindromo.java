package exercicio5;

public class TestePalindromo {

    public boolean ehPalindromo(String frase){

        String fraseSemEspaco = frase.replace(" ", "");

        fraseSemEspaco = fraseSemEspaco.replace("-", "");

        fraseSemEspaco = fraseSemEspaco.toUpperCase();

        PilhaObj<Character> p = new PilhaObj<Character>(fraseSemEspaco.length());

        for(int i=0; i< fraseSemEspaco.length(); i++){

            p.push(fraseSemEspaco.charAt(i));

        }

        for(int i = 0; i < fraseSemEspaco.length(); i++){

            if(p.peek() != fraseSemEspaco.charAt(i)){

                return false;

            }
            p.pop();
        }

        return true;
    }

}
