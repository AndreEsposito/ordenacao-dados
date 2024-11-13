import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManipulaArquivo {

    public static int[] lerArquivo(String nomeArquivo) throws IOException {
        try (BufferedReader leitor = Files.newBufferedReader(Paths.get(nomeArquivo))) {
            return leitor.lines()
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
    }

    public static void escreverArquivoOrdenado(String nomeArquivo, int[] numeros) throws IOException {
        List<String> linhas = Arrays.stream(numeros)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        Files.write(Paths.get(nomeArquivo), linhas);
    }
}
