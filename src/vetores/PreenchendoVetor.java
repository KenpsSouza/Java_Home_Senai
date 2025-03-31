package vetores;

import java.util.Scanner;

public class PreenchendoVetor {
    public static void main(String[] args) {
        // Criação de um vetor para armazenar 5 números inteiros
        int[] numeros = new int[5];

        // Scanner para capturar a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Loop para preencher o vetor com os números fornecidos pelo usuário
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite um número: "); // Solicita ao usuário um número
            numeros[i] = scanner.nextInt(); // Armazena o número no vetor
        }

        // Exibe os números armazenados no vetor
        System.out.print("Números armazenados: ");
        for (int numero : numeros) {
            System.out.print(numero + " "); // Imprime cada número armazenado
        }

        // Fecha o scanner para liberar recursos
        scanner.close();
    }
}

//Explicação do código:
//Criação do vetor: Um vetor de inteiros com 5 posições é criado (int[] numeros = new int[5];).
//Entrada do usuário: Um Scanner é usado para capturar os números digitados pelo usuário.
//Laço for: Preenche o vetor com os números fornecidos pelo usuário.
//Impressão dos números: Um laço for-each é usado para imprimir os números armazenados no vetor.
//Fechamento do Scanner: O método scanner.close() é chamado para liberar os recursos do Scanner.