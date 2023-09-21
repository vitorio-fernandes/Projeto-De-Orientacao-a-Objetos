package Interfaces;

import Models.Funcionario;


public interface InterfaceFuncionarios {

    public void adicionarFuncionario(String nome , String cpf);

    public void removerFuncionario(String cpfBusca);

    public void atualizarFuncionario(String cpfBusca, String cpfNovo, String nomeNovo);

    public Funcionario getListaEspecifica(String cpfBusca);

    
}