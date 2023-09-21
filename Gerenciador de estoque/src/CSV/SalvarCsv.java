package CSV;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Models.Funcionario;
import Models.Produto;

public class SalvarCsv {
    public String salvarProdutosEmCSV(List<Produto> produtos) {
        try {
            FileWriter arquivo = new FileWriter("src/Banco de Dados/BD.csv", true); // O segundo argumento "true" permite adicionar ao arquivo existente
            BufferedWriter escritor = new BufferedWriter(arquivo);

            // Escreve os produtos na lista no arquivo CSV
            for (Produto produto : produtos) {
                // Use StringBuilder para construir a linha do CSV
                StringBuilder linhaCSV = new StringBuilder();
                linhaCSV.append(produto.getNome()).append(";");
                linhaCSV.append(produto.getTamanho()).append(";");
                linhaCSV.append(produto.getPreco()).append(";");
                linhaCSV.append(produto.getQuantidade()).append(";");
                linhaCSV.append(produto.getGenero()).append(";");
                linhaCSV.append(produto.getTipo()).append("\n");

                escritor.write(linhaCSV.toString());
            }

            // Fecha o BufferedWriter e o FileWriter
            escritor.close();
            arquivo.close();

            return "Produtos adicionados ao arquivo CSV em src/Banco de Dados/BD.csv";

        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao salvar os produtos em CSV: " + e.getMessage();
        }
    }

    public String salvarFuncionariosEmCSV(List<Funcionario> funcionarios) {
        try {
            FileWriter arquivo = new FileWriter("src/Banco de Dados/Funcionarios.csv", true); // O segundo argumento "true" permite adicionar ao arquivo existente
            BufferedWriter escritor = new BufferedWriter(arquivo);

            // Escreve os produtos na lista no arquivo CSV
            for (Funcionario funcionario : funcionarios) {
                // Use StringBuilder para construir a linha do CSV
                StringBuilder linhaCSV = new StringBuilder();
                
                linhaCSV.append(funcionario.getNome()).append(";");
                linhaCSV.append(funcionario.getCpf()).append("\n");

                escritor.write(linhaCSV.toString());
            }

            // Fecha o BufferedWriter e o FileWriter
            escritor.close();
            arquivo.close();

            return "Funcionarios adicionados ao arquivo CSV em src/Banco de Dados/Funcionarios.csv";

        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao salvar os Funcionarios em CSV: " + e.getMessage();
        }
    }
}