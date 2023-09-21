package Interfaces;

import java.util.List;

import Models.Produto;

public interface InterfaceProdutos {
    
    
    public void cadastrarProduto(String nome, double preco, int quantidade, String genero, String tipo,
            String tamanho);


    public String removerProduto(int i, int quantRemover);

    public String atualizarProduto(int i, int novaQuantidade, double novoPreco);

    public List<Produto> getProdutoCadastrados();


}