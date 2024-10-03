import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;

public class Questao_03 {

    /*
    3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora de todos os dias de um ano, faça um programa, na linguagem que desejar, que calcule e retorne:

    - O menor valor de faturamento ocorrido em um dia do ano;
    - O maior valor de faturamento ocorrido em um dia do ano;
    - Número de dias no ano em que o valor de faturamento diário foi superior à média anual.

    a) Considerar o vetor já carregado com as informações de valor de faturamento.
    b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média.
    c) Utilize o algoritmo mais veloz que puder definir.

     */
    public static void main(String[] args) {
        // Supondo que o vetor faturamento já esteja carregado com 365 posições representando o ano
        double[] faturamento = { /* valores do faturamento diário do ano */ };

        // Variáveis para armazenar os resultados
        double menorFaturamento = MAX_VALUE;
        double maiorFaturamento = MIN_VALUE;
        double somaFaturamento = 0;
        int diasComFaturamento = 0;

        // Calcular o menor e maior faturamento, e a soma para cálculo da média
        for (double valor : faturamento) {
            if (valor > 0) {
                // Ignorando dias sem faturamento (finais de semana e feriados)

                if (valor < menorFaturamento) menorFaturamento = valor;
                if (valor > maiorFaturamento) maiorFaturamento = valor;

                somaFaturamento += valor;
                diasComFaturamento++;
            }
        }

        // Calcular a média anual (somente considerando dias com faturamento)
        double mediaAnual = somaFaturamento / diasComFaturamento;

        // Contar o número de dias com faturamento superior à média anual
        int diasAcimaDaMedia = 0;
        for (double valor : faturamento) {
            if (valor > 0 && valor > mediaAnual) {
                diasAcimaDaMedia++;
            }
        }

        // Exibir os resultados
        System.out.println("Menor faturamento do ano: " + menorFaturamento);
        System.out.println("Maior faturamento do ano: " + maiorFaturamento);
        System.out.println("Número de dias com faturamento acima da média anual: " + diasAcimaDaMedia);
    }
}
