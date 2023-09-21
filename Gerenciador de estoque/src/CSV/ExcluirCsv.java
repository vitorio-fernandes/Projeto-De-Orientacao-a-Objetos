package CSV;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExcluirCsv {
    public String excluirConteudoProdutoCsv() {
        try {
            File arquivoCsv = new File("src/Banco de Dados/BD.csv");
            
            // Verifica se o arquivo existe
            if (arquivoCsv.exists()) {
                StringBuilder linhaCSV = new StringBuilder();
                FileWriter escritor = new FileWriter(arquivoCsv);
                linhaCSV.append("");
                escritor.write(linhaCSV.toString());
                escritor.close();
                return "Conteúdo do arquivo BD CSV excluído com sucesso.";
            } else {
                return "O arquivo BD CSV não existe.";
            }
        } catch (IOException e) {
            return "Erro ao excluir o conteúdo do arquivo BD CSV: " + e.getMessage();
        }
    }

    public String excluirConteudoFuncionarioCsv() {
        try {
            File arquivoCsv = new File("src/Banco de Dados/Funcionarios.csv");
            
            // Verifica se o arquivo existe
            if (arquivoCsv.exists()) {
                StringBuilder linhaCSV = new StringBuilder();
                FileWriter escritor = new FileWriter(arquivoCsv);
                linhaCSV.append("");
                escritor.write(linhaCSV.toString());
                escritor.close();
                return "Conteúdo do arquivo Funcionarios CSV excluído com sucesso.";
            } else {
                return "O arquivo Funcionarios CSV não existe.";
            }
        } catch (IOException e) {
            return "Erro ao excluir o conteúdo do arquivo Funcionarios CSV: " + e.getMessage();
        }
    }
}