package vetores;

import java.util.Scanner;

public class MaiorMenorNumero {
    public static void main(String[] args) {
        // Criação de um vetor para armazenar 8 números inteiros
        int[] numeros = new int[8];
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira os números
        System.out.println("Digite 8 números:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt(); // Armazena o número no vetor
        }

        // Inicializa as variáveis maior e menor com o primeiro elemento do vetor
        int maior = numeros[0];
        int menor = numeros[0];

        // Percorre o vetor para encontrar o maior e o menor número
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i]; // Atualiza o maior número
            }
            if (numeros[i] < menor) {
                menor = numeros[i]; // Atualiza o menor número
            }
        }

        // Exibe o vetor
        System.out.print("Vetor: ");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        // Exibe o maior e o menor número
        System.out.println("\nMaior número: " + maior);
        System.out.println("Menor número: " + menor);

        // Fecha o scanner para liberar recursos
        scanner.close();
    }
}


//Explicação do código:
//Criação do vetor: Um vetor de inteiros com 8 posições é criado (int[] numeros = new int[8];).
//Entrada do usuário: Um Scanner é usado para capturar os números digitados pelo usuário.
//Inicialização de variáveis: As variáveis maior e menor são inicializadas com o primeiro elemento do vetor.
//Laço para encontrar maior e menor: Um laço for percorre o vetor para comparar e atualizar os valores de maior e menor.
//Exibição do vetor: Os números armazenados no vetor são exibidos.
//Exibição do maior e menor número: Os valores de maior e menor são exibidos ao final.
//Fechamento do Scanner: O método scanner.close() é chamado para liberar os recursos.