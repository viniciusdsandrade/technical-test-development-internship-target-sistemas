import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in); // Scanner declarado como atributo estático

    public static void main(String[] args) {

        // 1) Verificar se um número pertence à sequência de Fibonacci
        verificarFibonacci();

        // 2) Verificar a ocorrência da letra 'a' em uma string
        verificarLetraA();

        // 3) Valor da variável SOMA
        calcularSoma();

        // 4) Lógica e próximo elemento
        System.out.println("a) 1, 3, 5, 7, 9 (Sequência de números ímpares)");
        System.out.println("b) 2, 4, 8, 16, 32, 64, 128 (Multiplicação por 2)");
        System.out.println("c) 0, 1, 4, 9, 16, 25, 36, 49 (Quadrados dos números naturais)");
        System.out.println("d) 4, 16, 36, 64, 100 (Quadrados dos números pares)");
        System.out.println("e) 1, 1, 2, 3, 5, 8, 13 (Sequência de Fibonacci)");
        System.out.println("f) 2, 10, 12, 16, 17, 18, 19, 200 (Números que começam com a letra 'D')");

        // 5) Interruptores e Lâmpadas (respondido diretamente)
        System.out.println("Para descobrir qual interruptor controla cada lâmpada:");
        System.out.println("1. Ligue o interruptor 1 e deixe-o ligado por alguns minutos.");
        System.out.println("2. Desligue o interruptor 1 e ligue o interruptor 2.");
        System.out.println("3. Entre na sala das lâmpadas.");

        System.out.println("Identificação:");
        System.out.println("* Lâmpada acesa: Interruptor 2.");
        System.out.println("* Lâmpada apagada e quente: Interruptor 1.");
        System.out.println("* Lâmpada apagada e fria: Interruptor 3.");

        scanner.close(); // Scanner fechado apenas uma vez ao final do programa
    }

    public static void verificarFibonacci() {
        System.out.print("Informe um número para verificar na sequência de Fibonacci: ");
        int numero = scanner.nextInt(); // Scanner reutilizado

        int a = 0, b = 1, c = 0;
        boolean pertence = false;

        while (c < numero) {
            c = a + b;
            a = b;
            b = c;
            if (c == numero) {
                pertence = true;
                break;
            }
        }

        if (pertence) {
            System.out.println(numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(numero + " não pertence à sequência de Fibonacci.");
        }
    }

    public static void verificarLetraA() {
        System.out.print("Informe uma string para verificar a ocorrência da letra 'a': ");
        String string = scanner.nextLine(); // Scanner reutilizado

        int contador = 0;
        for (int i = 0; i < string.length(); i++) {
            char caractere = string.charAt(i);
            if (caractere == 'a' || caractere == 'A') {
                contador++;
            }
        }

        if (contador > 0) {
            System.out.println("A string contém a letra 'a' (maiúscula ou minúscula).");
            System.out.println("Quantidade de vezes que a letra 'a' aparece: " + contador);
        } else {
            System.out.println("A string não contém a letra 'a'.");
        }
    }

    public static void calcularSoma() {
        int INDICE = 12;
        int SOMA = 0;
        int K = 1;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        System.out.println("O valor da variável SOMA é: " + SOMA);
    }
}