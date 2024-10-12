public class MergeSort {

    public void mergeSort(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            // Divide o array em duas partes
            mergeSort(array, esquerda, meio);
            mergeSort(array, meio + 1, direita);

            // Intercala as duas metades ordenadas
            intercalar(array, esquerda, meio, direita);
        }
    }

    public void intercalar(int[] array, int esquerda, int meio, int direita) {
        int tamanho1 = meio - esquerda + 1;
        int tamanho2 = direita - meio;

        int[] L = new int[tamanho1];
        int[] R = new int[tamanho2];

        for (int i = 0; i < tamanho1; i++) {
            L[i] = array[esquerda + i];
        }
        for (int j = 0; j < tamanho2; j++) {
            R[j] = array[meio + 1 + j];
        }

        int i = 0, j = 0;
        int k = esquerda;
        while (i < tamanho1 && j < tamanho2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < tamanho1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < tamanho2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
