package While_DoWhile_17_03;

import java.util.Scanner; 

public class TabuadaDeUmNumero {

    public static void main(String[] args) {
    	
    	System.out.println("Olá, vamos observar uma tabuada! ");
    	
        Scanner sc = new Scanner(System.in);

        int numero;

        System.out.print("Digite um número para ver sua tabuada: ");
        numero = sc.nextInt();

        // Variável que controlará o contador da tabuada
        int contador = 1;

        // Utiliza o do-while para gerar a tabuada
        do {
            // Calcula o resultado e exibe no console
            System.out.println(numero + " x " + contador + " = " + (numero * contador));
            contador++; // Incrementa o contador
        } while (contador <= 10); // Condição para continuar o loop até o número 10

        sc.close();

        System.out.println("Tabuada concluída!");
    }
}
