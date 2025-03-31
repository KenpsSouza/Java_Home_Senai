package vetores;

import java.util.ArrayList;
import java.util.Random;

public class SeparandoParesImpares {
    public static void main(String[] args) {
        // Criação de um vetor para armazenar 10 números inteiros
        int[] vetorOriginal = new int[10];
        ArrayList<Integer> pares = new ArrayList<>(); // Lista para armazenar números pares
        ArrayList<Integer> impares = new ArrayList<>(); // Lista para armazenar números ímpares
        Random random = new Random(); // Objeto para gerar números aleatórios

        // Preenchendo o vetor original com números aleatórios entre 1 e 100
        System.out.print("Vetor original: ");
        for (int i = 0; i < vetorOriginal.length; i++) {
            vetorOriginal[i] = random.nextInt(100) + 1; // Gera um número entre 1 e 100
            System.out.print(vetorOriginal[i] + " "); // Exibe o número gerado

            // Separando os números em pares e ímpares
            if (vetorOriginal[i] % 2 == 0) {
                pares.add(vetorOriginal[i]); // Adiciona o número à lista de pares
            } else {
                impares.add(vetorOriginal[i]); // Adiciona o número à lista de ímpares
            }
        }

        // Exibindo os números pares
        System.out.print("\nNúmeros pares: ");
        for (int par : pares) {
            System.out.print(par + " ");
        }

        // Exibindo os números ímpares
        System.out.print("\nNúmeros ímpares: ");
        for (int impar : impares) {
            System.out.print(impar + " ");
        }
    }
}


//Explicação do código:
//Criação do vetor original: Um vetor de inteiros com 10 posições é criado (int[] vetorOriginal = new int[10];).
//Listas para pares e ímpares: Duas listas (ArrayList) são usadas para armazenar os números pares e ímpares separadamente.
//Gerador de números aleatórios: Um objeto da classe Random é usado para preencher o vetor original com números aleatórios entre 1 e 100.
//Separação de pares e ímpares: Durante o preenchimento do vetor original, o código verifica se o número é par ou ímpar (usando numero % 2 == 0) e o adiciona à lista correspondente.
//Exibição dos resultados: Os números do vetor original, os pares e os ímpares são exibidos separadamente.