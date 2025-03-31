package vetores;

import java.util.Random;

public class ComparandoDoisVetores {
    public static void main(String[] args) {
        // Criação de dois vetores para armazenar 5 números inteiros cada
        int[] vetorA = new int[5];
        int[] vetorB = new int[5];
        Random random = new Random(); // Objeto para gerar números aleatórios

        // Preenchendo os vetores com números aleatórios entre 1 e 10
        System.out.print("Vetor A: ");
        for (int i = 0; i < vetorA.length; i++) {
            vetorA[i] = random.nextInt(10) + 1; // Gera um número entre 1 e 10
            System.out.print(vetorA[i] + " "); // Exibe o número gerado para o vetor A
        }

        System.out.print("\nVetor B: ");
        for (int i = 0; i < vetorB.length; i++) {
            vetorB[i] = random.nextInt(10) + 1; // Gera um número entre 1 e 10
            System.out.print(vetorB[i] + " "); // Exibe o número gerado para o vetor B
        }

        // Comparando os elementos dos dois vetores na mesma posição
        System.out.println("\nNúmeros iguais nas mesmas posições:");
        for (int i = 0; i < vetorA.length; i++) {
            if (vetorA[i] == vetorB[i]) { // Verifica se os elementos na mesma posição são iguais
                System.out.println("Posição " + (i + 1) + ": " + vetorA[i]);
            }
        }
    }
}


//Explicação do código:
//Criação dos vetores: Dois vetores de inteiros com 5 posições cada são criados (int[] vetorA e int[] vetorB).
//Gerador de números aleatórios: Um objeto da classe Random é usado para preencher os vetores com números aleatórios entre 1 e 10.
//Preenchimento e exibição dos vetores: Dois laços for preenchem os vetores e exibem os números gerados.
//Comparação dos vetores: Um laço for percorre os dois vetores e verifica se os elementos na mesma posição são iguais.
//Exibição dos resultados: Para cada posição onde os elementos são iguais, a posição e o valor são exibidos.
