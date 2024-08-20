import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String pathFolder = "D:\\";

        File folder = new File(pathFolder);

        if (folder.isDirectory()) {
            File files[] = folder.listFiles();

            if (files != null) {

                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
                            String line;

                            while ((line = read.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            System.out.println("Erro ao ler o arquivo: " + file.getName());
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("A pasta está vazia ou nao pode ser lida.");
            }
        } else {
            System.out.println("O caminho especificado não é um diretório.");
        }
    }
}