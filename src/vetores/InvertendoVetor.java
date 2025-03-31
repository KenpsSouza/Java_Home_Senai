package vetores;

import java.util.Random;

public class InvertendoVetor {
    public static void main(String[] args) {
        // Criação de um vetor para armazenar 6 números inteiros
        int[] numeros = new int[6];
        Random random = new Random(); // Objeto para gerar números aleatórios

        // Preenchendo o vetor com números aleatórios entre 1 e 100
        System.out.print("Vetor original: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1; // Gera um número entre 1 e 100
            System.out.print(numeros[i] + " "); // Exibe o número gerado
        }

        // Exibindo o vetor invertido
        System.out.print("\nVetor invertido: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.print(numeros[i] + " "); // Exibe os números na ordem inversa
        }
    }
}


//Explicação do código:
//Criação do vetor: Um vetor de inteiros com 6 posições é criado (int[] numeros = new int[6];).
//Gerador de números aleatórios: Um objeto da classe Random é usado para preencher o vetor com números aleatórios entre 1 e 100.
//Exibição do vetor original: Um laço for percorre o vetor na ordem normal e exibe os números.
//Exibição do vetor invertido: Um laço for percorre o vetor de trás para frente (usando i = numeros.length - 1 até i >= 0) e exibe os números na ordem inversa.