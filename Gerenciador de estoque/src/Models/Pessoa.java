package Models;

abstract public class Pessoa {
    String nome;
    String cpf;

    Pessoa (){}
    
    Pessoa (String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getNome() {
        return nome;
    }

    @Override
	public String toString() {
		return ">>Nome: " + getNome() + "   >> CPF: " + getCpf() + "\n";
	}
}

