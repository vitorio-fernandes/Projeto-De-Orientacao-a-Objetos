package Repository;

import java.util.List;
import java.util.Scanner;

import CSV.LeituraCsv;
import Interfaces.InterfaceFuncionarios;
import Models.Funcionario;

public class FuncionariosRepository implements InterfaceFuncionarios{
    LeituraCsv leituraCsv = new LeituraCsv();
    Scanner entrada = new Scanner(System.in);
    
    public List<Funcionario> funcionarios = leituraCsv.getFuncionario();

    public void adicionarFuncionario(String nome , String cpf){
        Funcionario funcionario = new Funcionario(nome, cpf);
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(String cpfBusca){
        Funcionario x = getListaEspecifica(cpfBusca);
        funcionarios.remove(x);
    }

    public void atualizarFuncionario(String cpfBusca, String cpfNovo, String nomeNovo){
        Funcionario x = getListaEspecifica(cpfBusca);

        int index = funcionarios.indexOf(x);

        Funcionario novoFuncionario = new Funcionario();

        novoFuncionario.setCpf(cpfNovo);
        novoFuncionario.setNome(nomeNovo);
        
        funcionarios.set(index, novoFuncionario);
    }

    public Funcionario getListaEspecifica(String cpfBusca) {
        for (Funcionario i : funcionarios){
            if (cpfBusca.equals(i.getCpf())){
                return i;
            }
        }
        return null;
    }

    public List<Funcionario> getLista(){
        return funcionarios;
    }
}
