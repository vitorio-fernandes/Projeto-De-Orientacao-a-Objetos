package Models;

public class RoupaSuperior extends Produto{
    String tamanho;

    public RoupaSuperior() {}
    
    public RoupaSuperior(String nome, double preco, int quantidade, String genero, String tipo, String tamanho){
        super(nome, preco, quantidade, genero, tipo, tamanho);
    }

    @Override
	public String toString() {
        return String.format("ROUPA SUPERIOR: |NOME: %-10s |PREÇO = R$ %-10s |QUANTIDADE = %-10s | GENERO: = %s |", getNome(), getPreco(), getQuantidade(),getGenero());
	}
}
