package Models;

abstract public class Produto  {
    
    private String nome;
    private double preco;
    private int quantidade;
    private String genero;
    private String tipo;
    private String tamanho;

    public Produto(String nome, double preco, int quantidade, String genero, String tipo, String tamanho) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.genero = genero;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    Produto(){}

    public void setQuantidade(int pQuantidade) {
        this.quantidade = pQuantidade;
    }

    public void setPreco(double pPreco){
        this.preco = pPreco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getGenero() {
        return genero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTamanho(){
        return tamanho;
    }
    
    
    @Override
	public String toString() {
		return "PRODUTO [ nome= " + getNome() + ", PREÇO= " + getPreco() + ", Quantidade= " + getQuantidade() + " ]";
	}
}
