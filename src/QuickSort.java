public class QuickSort {

    public void quickSort(int[] array, int baixo, int alto) {
        if (baixo < alto) {
            int indiceParticao = particionar(array, baixo, alto);

            quickSort(array, baixo, indiceParticao - 1);
            quickSort(array, indiceParticao + 1, alto);
        }
    }

    public int particionar(int[] array, int baixo, int alto) {
        int pivo = array[alto];
        int i = (baixo - 1);

        for (int j = baixo; j < alto; j++) {
            if (array[j] < pivo) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[alto];
        array[alto] = temp;

        return i + 1;
    }
}
