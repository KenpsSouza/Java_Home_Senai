package vetores;

import java.util.Scanner;

public class ContandoNumerosPares {
    public static void main(String[] args) {
        // Criação de um vetor para armazenar 15 números inteiros
        int[] numeros = new int[15];
        int totalPares = 0; // Variável para contar os números pares
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira os números
        System.out.println("Digite 15 números:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt(); // Armazena o número no vetor
        }

        // Exibe o vetor e conta os números pares
        System.out.print("Vetor: ");
        for (int numero : numeros) {
            System.out.print(numero + " "); // Exibe o número
            if (numero % 2 == 0) { // Verifica se o número é par
                totalPares++; // Incrementa o contador de números pares
            }
        }

        // Exibe o total de números pares
        System.out.println("\nTotal de números pares: " + totalPares);

        // Fecha o scanner para liberar recursos
        scanner.close();
    }
}


//Explicação do código:
//Criação do vetor: Um vetor de inteiros com 15 posições é criado (int[] numeros = new int[15];).
//Entrada do usuário: Um Scanner é usado para capturar os números digitados pelo usuário.
//Contador de pares: A variável totalPares é inicializada com 0 e será incrementada sempre que um número par for encontrado.
//Laço para exibir e contar pares: Um laço for-each percorre o vetor, exibe os números e verifica se cada número é par usando o operador % (resto da divisão por 2).
//Exibição do total de pares: Após o laço, o total de números pares é exibido.
//Fechamento do Scanner: O método scanner.close() é chamado para liberar os recursos.
