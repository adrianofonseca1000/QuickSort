
import java.util.Random;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class QuickSort {

    private static double tempoi;

    public static void main(String args[]) {
        int i, j, n, k;
        for (int cnt_tamanho = 1; cnt_tamanho <= 3; cnt_tamanho++) {
// define os três tamanhos dos vetores
            if (cnt_tamanho == 1) {
                n = 100;
            } else if (cnt_tamanho == 2) {
                n = 1000;
            } else {
                n = 10000;
            }
            int[] vet = new int[n];
            Random gerador = new Random();
// alimentar vetor aleatoriamente
            for (int qtvezes = 1; qtvezes <= 30; qtvezes++) {
                System.out.println(" ");
                System.out.println("Aguarde... Gerando vetor");
                for (k = 0; k
                        < n; k++) {
                    vet[k] = gerador.nextInt(n * 3);    // números diferentes (sementes)
                }
                System.out.println(" ");
                System.out.println("Vetor gerado:");
                for (k = 0; k < n; k++) {
                    System.out.print(vet[k] + " ");
                }
                int aux = 0, menor;
                int ctcomp = 0;                // contador de comparação
                int cttroca = 0; // contador de movimentação (troca)
                // aqui começa a ordenação quick sort
                // tempo em nano segundos neste momento      

                int inicio = 0, meio, fim = 0;

                if (inicio < fim) {
                    meio = partition(vet, inicio, fim);
                    quicksort(vet, inicio, meio);
                    quicksort(vet, meio + 1, fim);
                    ctcomp++;                    // contador de comparação
                }
                
                int pivo = vet[inicio];
                int topo = inicio;
                for (i = inicio + 1; i <= fim; i++) {
                    if (vet[i] < pivo) {
                        vet[topo] = vet[i];
                        vet[i] = vet[topo + 1];
                        cttroca += 3;              // contador de troca
                    }
                }

// aqui acaba a ordenação quick sort
                double tempof = System.nanoTime();
                double tempom = tempof - tempoi;

// tempom deve ser dividido por 10^9 para se ter o tempo de execuçãoem segundos
                tempom = tempom / 1000000000.0;
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Vetor ordenado:");
                for (i = 0; i < n; i++) {
                    System.out.print(vet[i] + " ");
                }
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Comparações executadas: " + ctcomp);
                System.out.println("Trocas executadas: " + cttroca);
                System.out.printf("Tempo gasto: %.10f\n", tempom);
                try {
// aberto para operações de saída através do objeto arq instanciado e criado a partir da classeFileWriter.
                    FileWriter arq = new FileWriter("dados_quick.txt", true);
// o objeto de gravação gravaArq é associado a um fluxo de saída de dados baseadoem caracteres através da classe PrinterWriter.
                    PrintWriter gravaArq = new PrintWriter(arq, true);
//gravaArq.write(qtvezes, ctcomp, cttroca, tempom);
                    gravaArq.printf("%2d ; %2d ; %2d ; %.10f ; %n", qtvezes, ctcomp, cttroca, tempom);
                    gravaArq.close();
                    arq.close();
                } catch (Exception e) {
                    System.out.println("ERRO-NÃO DEU CERTO");
                }
            }
        }
    }

    private static int[] quicksort(int[] vet, int inicio, int fim) {
        return null;


    }

    private static int partition(int[] vet, int inicio, int fim) {
        return 0;

}
}
