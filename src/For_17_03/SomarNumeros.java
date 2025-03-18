package For_17_03;

import java.util.Scanner; 

public class SomarNumeros {

    public static void main(String[] args) {
    	
    	System.out.println("Olá, vamos somar todos os números até o intervalo escolhido! ");
    	
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int numero = sc.nextInt();

        // Inicializa a variável para armazenar a soma
        int soma = 0;

        // Loop for para somar os números de 1 até o número fornecido
        for (int i = 1; i <= numero; i++) {
            soma += i; // Adiciona o valor de i à variável soma
        }

        System.out.println("A soma dos números de 1 até " + numero + " é: " + soma);

        sc.close();
    }
}
