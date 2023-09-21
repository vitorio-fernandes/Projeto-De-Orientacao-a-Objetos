package Repository;

import java.util.List;

import CSV.LeituraCsv;
import Interfaces.InterfaceProdutos;
import Models.Produto;
import Models.RoupaInferior;
import Models.RoupaSuperior;

public class ProdutosRepository implements InterfaceProdutos {
    LeituraCsv leituraCsv = new LeituraCsv();

    public List<Produto> produtoCadastrados = leituraCsv.getProdutos();
    
    // Faz a cópia da Lista ja lida do Csv

    public void cadastrarProduto(String nome, double preco, int quantidade, String genero, String tipo,
            String tamanho) {// Cadastrar os produtos e add na Lista já com a cópia
        if (tamanho.equals("P") || tamanho.equals("M") || tamanho.equals("G") || tamanho.equals("GG")) {
            RoupaSuperior superior = new RoupaSuperior(nome, preco, quantidade, genero, tipo, tamanho);
            produtoCadastrados.add(superior);
        } else {
            RoupaInferior inferior = new RoupaInferior(nome, preco, quantidade, genero, tipo, tamanho);
            produtoCadastrados.add(inferior);
        }

    }

    public String removerProduto(int i, int quantRemover) {
        Produto x = produtoCadastrados.get(i);

        if (quantRemover < x.getQuantidade()) {
            x.setQuantidade(x.getQuantidade() - quantRemover);
            produtoCadastrados.set(i, x);
            return "Quantidade removida com sucesso";

        } else if (quantRemover == x.getQuantidade()) {
            produtoCadastrados.remove(i);
            return "Produto removido com sucesso";
        } else {
            return "Quantidade que deseja remover maior que a Quantidade no estoque";

        }
    }

    public String atualizarProduto(int i, int novaQuantidade, double novoPreco) {
        Produto x = produtoCadastrados.get(i);

        if (novaQuantidade != 0 && novoPreco != 0) {
            x.setQuantidade(novaQuantidade);
            x.setPreco(novoPreco);

            produtoCadastrados.set(i, x);
            return "Produto modificado com sucesso";
        } else {
            return "Entrada incorreta Produto não modificado";
        }
    }


    public List<Produto> getProdutoCadastrados() {
        return produtoCadastrados;
    }

}
