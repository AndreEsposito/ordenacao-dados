import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner entrada = new Scanner(System.in);

            System.out.println("Qual arquivo vc deseja ordenar: ");
            String nomeArquivo = entrada.nextLine();

            int[] numeros = ManipulaArquivo.lerArquivo(nomeArquivo + ".txt");

            MergeSort mergeSort = new MergeSort();
            BubbleSort bubbleSort = new BubbleSort();
            QuickSort quickSort = new QuickSort();

            int[] numerosParaMergeSort = numeros.clone();
            int[] numerosParaBubbleSort = numeros.clone();
            int[] numerosParaQuickSort = numeros.clone();

            // CHAMADA DO ALGORITMO MERGESORT:
            long inicioMergeSort = System.nanoTime();
            mergeSort.mergeSort(numerosParaMergeSort, 0, numerosParaMergeSort.length - 1);
            long duracaoMergeSort = System.nanoTime() - inicioMergeSort;
            System.out.println("MergeSort levou " + duracaoMergeSort + " nanosegundos.");
            ManipulaArquivo.escreverArquivoOrdenado(String.format("GERADO_%s_ordenado_por_merge_sort.txt", nomeArquivo), numerosParaMergeSort);

            // CHAMADA DO ALGORITMO BUBBLESORTE:
            long inicioBubbleSort = System.nanoTime();
            bubbleSort.bubbleSort(numerosParaBubbleSort);
            long duracaoBubbleSort = System.nanoTime() - inicioBubbleSort;
            System.out.println("BubbleSort levou " + duracaoBubbleSort + " nanosegundos.");
            ManipulaArquivo.escreverArquivoOrdenado(String.format("GERADO_%s_ordenado_por_bubble_sort.txt", nomeArquivo), numerosParaBubbleSort);

            // CHAMADA DO ALGORITMO QUICKSORTE:
            long inicioQuickSort = System.nanoTime();
            quickSort.quickSort(numerosParaQuickSort, 0, numerosParaQuickSort.length - 1);
            long duracaoQuickSort = System.nanoTime() - inicioQuickSort;
            System.out.println("QuickSort levou " + duracaoQuickSort + " nanosegundos.");
            ManipulaArquivo.escreverArquivoOrdenado(String.format("GERADO_%s_ordenado_por_quick_sort.txt", nomeArquivo), numerosParaQuickSort);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
