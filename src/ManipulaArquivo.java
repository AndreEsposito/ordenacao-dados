import java.io.*;
import java.util.ArrayList;

public class ManipulaArquivo {

    public static int[] lerArquivo(String nomeArquivo) throws IOException {
        try {
            ArrayList<Integer> numeros = new ArrayList<>();
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            while ((linha = leitor.readLine()) != null) {
                numeros.add(Integer.parseInt(linha.trim()));
            }
            leitor.close();

            return numeros.stream().mapToInt(i -> i).toArray();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
    }

    public static void escreverArquivoOrdenado(String nomeArquivo, int[] numeros) throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo));
        for (int numero : numeros) {
            escritor.write(numero + "\n");
        }
        escritor.close();
    }
}
