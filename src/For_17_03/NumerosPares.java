package For_17_03;

import java.util.Scanner; 

public class NumerosPares {

    public static void main(String[] args) {
    	
    	System.out.println("Olá, vamos verificar quantos números pares existem em certo intervalo! ");

    	Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = sc.nextInt();

        // Exibe os números pares usando um loop for
        System.out.println("Números pares de 0 até " + numero + ":");
        for (int i = 0; i <= numero; i++) {
            // Verifica se o número é par
            if (i % 2 == 0) {
                System.out.println(i); 
            }
        }

        sc.close();
    }
}
