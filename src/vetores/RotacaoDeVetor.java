package vetores;

import java.util.Scanner;

public class RotacaoDeVetor {
    public static void main(String[] args) {
        // Criação de um vetor para armazenar 5 números inteiros
        int[] vetor = new int[5];
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira os números
        System.out.println("Digite 5 números:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetor[i] = scanner.nextInt(); // Armazena o número no vetor
        }

        // Exibe o vetor original
        System.out.print("Vetor original: ");
        for (int numero : vetor) {
            System.out.print(numero + " ");
        }

        // Realiza a rotação para a direita
        int ultimo = vetor[vetor.length - 1]; // Armazena o último elemento do vetor
        for (int i = vetor.length - 1; i > 0; i--) {
            vetor[i] = vetor[i - 1]; // Move os elementos para a direita
        }
        vetor[0] = ultimo; // Coloca o último elemento na primeira posição

        // Exibe o vetor rotacionado
        System.out.print("\nVetor rotacionado: ");
        for (int numero : vetor) {
            System.out.print(numero + " ");
        }

        // Fecha o scanner para liberar recursos
        scanner.close();
    }
}


//Explicação do código:
//Criação do vetor: Um vetor de inteiros com 5 posições é criado (int[] vetor = new int[5];).
//Entrada do usuário: Um Scanner é usado para capturar os números digitados pelo usuário.
//Exibição do vetor original: Os números digitados são exibidos na ordem original.
//Rotação para a direita:
//O último elemento do vetor é armazenado em uma variável temporária (ultimo).
//Um laço for percorre o vetor de trás para frente, movendo os elementos para a direita.
//O último elemento armazenado é colocado na primeira posição.
//Exibição do vetor rotacionado: O vetor atualizado é exibido.
//Fechamento do Scanner: O método scanner.close() é chamado para liberar os recursos.
