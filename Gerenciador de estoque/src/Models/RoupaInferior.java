package Models;

public class RoupaInferior extends Produto {

    public RoupaInferior() {}

    public RoupaInferior(String nome, double preco, int quantidade, String genero, String tipo, String tamanho) {
        super(nome, preco, quantidade, genero, tipo, tamanho);
    }

    @Override
    public String toString() {
        return String.format("ROUPA INFERIOR: |NOME: %-10s |PREÇO = R$ %-10s |QUANTIDADE = %-10s | GENERO: = %s |", getNome(), getPreco(), getQuantidade(),getGenero());
    }
}
