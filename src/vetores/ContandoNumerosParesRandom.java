package vetores;

import java.util.Random;

public class ContandoNumerosParesRandom {
    public static void main(String[] args) {
        // Criação de um vetor para armazenar 15 números inteiros
        int[] numeros = new int[15];
        int totalPares = 0; // Variável para contar os números pares
        Random random = new Random(); // Objeto para gerar números aleatórios

        // Preenchendo o vetor com números aleatórios entre 1 e 100
        System.out.print("Vetor: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1; // Gera um número entre 1 e 100
            System.out.print(numeros[i] + " "); // Exibe o número gerado
            if (numeros[i] % 2 == 0) { // Verifica se o número é par
                totalPares++; // Incrementa o contador de números pares
            }
        }

        // Exibe o total de números pares
        System.out.println("\nTotal de números pares: " + totalPares);
    }
}

//Explicação do código:
//Gerador de números aleatórios: Um objeto da classe Random é usado para gerar números aleatórios entre 1 e 100.
//Preenchimento do vetor: Um laço for preenche o vetor com números aleatórios e exibe os números gerados.
//Contador de pares: Durante o preenchimento, o código verifica se o número gerado é par (usando numero % 2 == 0) e incrementa o contador totalPares.
//Exibição do total de pares: Após o laço, o total de números pares é exibido.