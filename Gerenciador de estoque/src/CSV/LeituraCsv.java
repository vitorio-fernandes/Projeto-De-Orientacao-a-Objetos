package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Models.Funcionario;
import Models.Produto;
import Models.RoupaInferior;
import Models.RoupaSuperior;



//Nessa Função só vai ler os CSV's e retornar uma lista de produtos e funcionarios
public class LeituraCsv {

    List<Produto> produtoGeral = new ArrayList<>();

    List<Funcionario> funcionarios = new ArrayList<>();

    public void lerDados() {// Ler dados do arquivos csv's dos Produtos
        try (BufferedReader br = new BufferedReader(new FileReader("src/Banco de Dados/BD.csv"))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] vect = linha.split(";");
                if (vect.length >= 6) {
                    String nome = vect[0];
                    String tamanho = vect[1];
                    String preco = vect[2];
                    String quantidade = vect[3];
                    String genero = vect[4];
                    String tipo = vect[5];

                    if (tamanho.equals("P") || tamanho.equals("M") || tamanho.equals("G") || tamanho.equals("GG")) {
                        RoupaSuperior superior = new RoupaSuperior(nome, Double.parseDouble(preco),
                                Integer.parseInt(quantidade), genero, tipo, tamanho);
                        produtoGeral.add(superior);
                    } else {
                        RoupaInferior inferior = new RoupaInferior(nome, Double.parseDouble(preco),
                                Integer.parseInt(quantidade), genero, tipo,tamanho);
                        produtoGeral.add(inferior);
                    }
                }
                linha = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    public void lerFuncionarios() {// Ler dados do arquivos do csv de Funcionarios
        try (BufferedReader br = new BufferedReader(new FileReader("src/Banco de Dados/Funcionarios.csv"))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] vect = linha.split(";");
                if (vect.length >= 2) {
                    String nome = vect[0];
                    String cpf = vect[1];
                    Funcionario funcionario = new Funcionario(nome, cpf);
                    funcionarios.add(funcionario);
                }
                linha = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    public List<Funcionario> getFuncionario() {
        lerFuncionarios();
        return funcionarios;
    }

    public List<Produto> getProdutos() {
        lerDados();
        return produtoGeral;
    }

}
