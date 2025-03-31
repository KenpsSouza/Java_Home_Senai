package While_DoWhile_17_03;

public class ImprimirNumero {

    public static void main(String[] args) {
    	
    	System.out.println("Olá, apresentação dos números! ");
    	
        // Variável inicializad a com o valor 1, que será nosso ponto de partida
        int numero = 1;

        // Loop while: Continua enquanto a condição "numero <= 10" for verdadeira
        while (numero <= 10) {
            // Imprime o valor atual de "numero" no console
            System.out.println("Número: " + numero);

            // Incrementa o valor de "numero" em 1 a cada iteração
            numero++;
        }

        // Mensagem exibida quando o loop termina
        System.out.println("Contagem concluída!");
    }
}
