package For_17_03;

import java.util.Scanner; 

public class Fatorial {

    public static void main(String[] args) {

    	System.out.println("Olá, vamos verificar o fatorial! ");
    	
    	Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo para calcular o fatorial: ");
        int numero = sc.nextInt();

        // Verifica se o número é válido (positivo ou zero)
        if (numero < 0) {
            System.out.println("Número inválido! O fatorial só pode ser calculado para números não negativos.");
        } else {
            // Inicializa a variável para armazenar o resultado do fatorial
        	//Utilizei tipo long é para armazenar números inteiros pois, fatorial podem ser muito grandes, maiores do que o tipo int pode suportar
            long fatorial = 1; // Começa com 1, pois o fatorial é uma multiplicação

            // Loop para calcular o fatorial (de 1 até o número fornecido)
            for (int i = 1; i <= numero; i++) {
                fatorial *= i; // Multiplica o valor atual de 'fatorial' pelo número atual 'i'
            }

            System.out.println("O fatorial de " + numero + " é: " + fatorial);
        }

        sc.close();
    }
}

