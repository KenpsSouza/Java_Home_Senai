package vetores;

import java.util.Random;

public class SomaDosElementos {
    public static void main(String[] args) {
        // Criação de um vetor para armazenar 10 números inteiros
        int[] numeros = new int[10];
        int soma = 0; // Variável para armazenar a soma dos elementos
        Random random = new Random(); // Objeto para gerar números aleatórios

        // Preenchendo o vetor com números aleatórios entre 1 e 100
        System.out.print("Números gerados: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1; // Gera um número entre 1 e 100
            System.out.print(numeros[i] + " "); // Exibe o número gerado
            soma += numeros[i]; // Soma o número gerado
        }

        // Exibe a soma total dos números
        System.out.println("\nSoma total: " + soma);
    }
}


//Explicação do código:
//Criação do vetor: Um vetor de inteiros com 10 posições é criado (int[] numeros = new int[10];).
//Gerador de números aleatórios: Um objeto da classe Random é usado para gerar números aleatórios entre 1 e 100.
//Preenchimento do vetor: Um laço for preenche o vetor com números aleatórios e calcula a soma simultaneamente.
//Impressão dos números gerados: Os números gerados são exibidos na mesma linha.
//Cálculo da soma: A soma dos números é acumulada na variável soma.
//Exibição da soma total: Após o laço, a soma total é exibida.