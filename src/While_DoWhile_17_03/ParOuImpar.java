package While_DoWhile_17_03;

import java.util.Scanner; 

public class ParOuImpar {

    public static void main(String[] args) {
    	
    	System.out.println("Olá, vamos verificar se o número é par ou ímpar! ");
    	
        Scanner sc = new Scanner(System.in);

        // Inicializa a variável número
        int numero;

        // Loop while que continuará até o usuário digitar 0
        while (true) {
            // Pede ao usuário para digitar um número
            System.out.print("Digite um número, caso queira sair: (0 para sair): ");
            numero = sc.nextInt(); // Lê o número inserido

            // Verifica se o número digitado é 0 para encerrar o loop
            if (numero == 0) {
                System.out.println("Programa encerrado.");
                break; // Sai do loop
            }

            // Verifica se o número é par ou ímpar
            if (numero % 2 == 0) {
                System.out.println("O número " + numero + " é par.");
            } else {
                System.out.println("O número " + numero + " é ímpar.");
            }
        }

        sc.close();
    }
}
