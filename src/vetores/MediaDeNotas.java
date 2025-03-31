package vetores;

import java.util.Scanner;

public class MediaDeNotas {
    public static void main(String[] args) {
        // Criação de um vetor para armazenar 6 notas
        double[] notas = new double[6];
        double soma = 0; // Variável para armazenar a soma das notas
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que insira as notas
        System.out.println("Digite as 6 notas do aluno:");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble(); // Armazena a nota no vetor
            soma += notas[i]; // Soma a nota
        }

        // Calcula a média das notas
        double media = soma / notas.length;

        // Exibe as notas
        System.out.print("Notas: ");
        for (double nota : notas) {
            System.out.print(nota + " ");
        }

        // Exibe a média e o resultado (Aprovado ou Reprovado)
        System.out.printf("\nMédia: %.2f\n", media);
        if (media >= 7) {
            System.out.println("Resultado: Aprovado");
        } else {
            System.out.println("Resultado: Reprovado");
        }

        // Fecha o scanner para liberar recursos
        scanner.close();
    }
}



//Explicação do código:
//Criação do vetor: Um vetor de double com 6 posições é criado para armazenar as notas do aluno.
//Entrada do usuário: Um Scanner é usado para capturar as notas digitadas pelo usuário.
//Cálculo da soma: Durante o preenchimento do vetor, as notas são somadas na variável soma.
//Cálculo da média: A média é calculada dividindo a soma pelo número de notas (soma / notas.length).
//Exibição das notas: As notas digitadas são exibidas.
//Verificação da média: O código verifica se a média é maior ou igual a 7. Se for, exibe "Aprovado"; caso contrário, exibe "Reprovado".
//Fechamento do Scanner: O método scanner.close() é chamado para liberar os recursos.