package vetores;

import java.util.Scanner;

public class MultiplicacaoPorNumero {
    public static void main(String[] args) {
        // Criação de um vetor para armazenar 5 números inteiros
        int[] numeros = {2, 4, 6, 8, 10}; // Vetor inicial com valores fixos
        Scanner scanner = new Scanner(System.in);

        // Exibe o vetor original
        System.out.print("Vetor original: ");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        // Solicita ao usuário um número para multiplicar
        System.out.print("\nDigite um número para multiplicar: ");
        int multiplicador = scanner.nextInt();

        // Multiplica cada elemento do vetor pelo número digitado
        System.out.print("Novo vetor: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] *= multiplicador; // Multiplica o elemento pelo número
            System.out.print(numeros[i] + " "); // Exibe o novo valor
        }

        // Fecha o scanner para liberar recursos
        scanner.close();
    }
}


//Explicação do código:
//Criação do vetor: Um vetor de inteiros com 5 posições é criado e inicializado com valores fixos (int[] numeros = {2, 4, 6, 8, 10};).
//Exibição do vetor original: Um laço for-each percorre o vetor e exibe os números.
//Entrada do usuário: Um Scanner é usado para capturar o número digitado pelo usuário.
//Multiplicação dos elementos: Um laço for percorre o vetor, multiplica cada elemento pelo número digitado e atualiza o vetor.
//Exibição do novo vetor: Após a multiplicação, os novos valores do vetor são exibidos.
//Fechamento do Scanner: O método scanner.close() é chamado para liberar os recursos.