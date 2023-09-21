package Models;

import java.util.Scanner;

import CSV.ExcluirCsv;
import CSV.LeituraCsv;
import CSV.SalvarCsv;
import Interfaces.InterfaceProdutos;
import Repository.FuncionariosRepository;
import Repository.ProdutosRepository;

public class Menu {
    Scanner entrada = new Scanner(System.in);
    
    LeituraCsv lerCsv = new LeituraCsv();
    ExcluirCsv excluir = new ExcluirCsv();
    SalvarCsv salvarCsv = new SalvarCsv();

    InterfaceProdutos produtosRepository = new ProdutosRepository();
    FuncionariosRepository funcionariosRepository = new FuncionariosRepository();
    
    Funcionario funcionario = new Funcionario();
    Dono dono = new Dono();
    
    void menuPrincipal(){
        System.out.print("\u001B[31m");
        System.out.println("-------------------------------");
        System.out.println("Gerenciamento de Estoque\n");
        System.out.print("\u001B[0m");
        System.out.println("1 - Menu Funcionario");
        System.out.println("2 - Menu Produto");
        System.out.println("0 - Sair");
        System.out.print("\u001B[31m");
        System.out.println("-------------------------------");
        System.out.print("\u001B[0m");
        funcoesMenuPrincipal();
    }

    void menuFuncionario(){
        System.out.println("-------------------------------");
        System.out.println("Menu Funcionario\n");
        System.out.println("1 - Cadastrar Funcionarios");
        System.out.println("2 - Atualizar Funcionario");
        System.out.println("3 - Remover Funcionario");
        System.out.println("4 - Listar Funcionarios");
        System.out.println("0 - Voltar");
        System.out.println("-------------------------------");
        funcoesMenuFuncionario();
    }
    
    void menuProdutos(){
        System.out.println("-------------------------------");
        System.out.println("Menu Produto\n");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Atualizar Produto");
        System.out.println("3 - Remover Produto");
        System.out.println("4 - Listar Produto");
        System.out.println("0 - Voltar");
        System.out.println("-------------------------------");
        funcoesMenuProduto();
    }
    
    void funcoesMenuPrincipal(){
        int entradaMenu = entrada.nextInt();
        
        switch (entradaMenu) {
            case 1:
            String antibug = entrada.nextLine();

            System.out.println("Para acessar as opções do Menu Funcionario digite a senha correta: ");
            String senhaDigitada = entrada.nextLine();

            if(dono.getSenha().equals(senhaDigitada)){
                System.out.println("Senha correta acessando Menu...........");
                System.out.println("Bem Vindo " + dono.getNome() + "!");
                menuFuncionario();
                

            }else{
                System.out.println("Senha incorreta");
            }
            break;
            
            case 2:
            menuProdutos();
            break;
            
            case 0:
            System.out.println("\n---------------------------------------------------------------------------------");
            excluir.excluirConteudoProdutoCsv();
            excluir.excluirConteudoFuncionarioCsv();
            salvarCsv.salvarProdutosEmCSV(produtosRepository.getProdutoCadastrados());
            salvarCsv.salvarFuncionariosEmCSV(funcionariosRepository.getLista());
            System.out.println("---------------------------------------------------------------------------------\n");
            System.exit(0);
            break;
            
            default:
            System.out.println("Opção digitada invalida");
            break;
        }
    }
    
   boolean mostrarFuncionarios(){
        if(funcionariosRepository.getLista().isEmpty()){
            System.out.println("Nenhum funcionário cadastrado.");
            return false;
        }
        else{
            for (int i = 0; i < funcionariosRepository.getLista().size(); i++){
                System.out.println(funcionariosRepository.getLista().get(i)+"\n");
            }
            return true;
        }
    }
    
    void funcoesMenuFuncionario(){
        int entradaMenu = entrada.nextInt();
        String antibug = entrada.nextLine();
        
        switch (entradaMenu) {
            case 1:
            //criar funcionario
            System.out.println("Digite o nome do Funcionário: ");
            String nome = entrada.nextLine();
            System.out.println("Digite o CPF do Funcionário: ");
            String cpf = entrada.nextLine();
            funcionariosRepository.adicionarFuncionario(nome, cpf);
            System.out.println("Funcionário cadastrado com sucesso!");
            break;
            
            case 2:
            //atualizar funcionario
            if(mostrarFuncionarios()){
            System.out.println("Insira o CPF do Funcionario que deseja atualizar: ");
            String cpfBusca = entrada.nextLine();
            System.out.println("Insira o novo CPF do Funcionario: ");
            String cpfNovo = entrada.nextLine();
            System.out.println("Insira o novo Nome do Funcionario");
            String nomeNovo = entrada.nextLine();
            funcionariosRepository.atualizarFuncionario(cpfBusca, cpfNovo, nomeNovo);
            System.out.println("Funcionário atualizado com sucesso!");
            }
            break;
            
            case 3:
            //remover funcionario
            if(mostrarFuncionarios()){
            System.out.println("Insira o CPF do Funcionario que deseja remover: ");
            String cpfBusca1 = entrada.nextLine();
            funcionariosRepository.removerFuncionario(cpfBusca1);
            }
            break;
            
            case 4:
            //listar funcionarios
            mostrarFuncionarios();
            break;
            
            case 0:
            //voltar
            menuPrincipal();
            break;
            
            default:
            System.out.println("Opção invalida digitada");
                break;
        }
    }

    boolean mostrarProdutos(){
        if(produtosRepository.getProdutoCadastrados().isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return false;
        }
        else{
            for (int i = 0; i < produtosRepository.getProdutoCadastrados().size(); i++){
                System.out.println((i+1 + " ") + produtosRepository.getProdutoCadastrados().get(i)+"\n");
            }
            return true;
        }
    }
        
    void funcoesMenuProduto(){
            int entradaMenu = entrada.nextInt();

            String antiBug = entrada.nextLine();
            
            switch (entradaMenu) {
                case 1:
                //criar roupa

                System.out.println("Digite o nome do Produto:");
                String nome = entrada.nextLine();
                System.out.println("Digite o preço do Produto:");
                double preco = entrada.nextDouble();
                System.out.println("Digite a quantidade do Produto:");
                int quantidade = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Digite o gênero do Produto: [M - F]");
                String genero = entrada.nextLine();
                System.out.println("Digite o tipo do Produto:");
                String tipo = entrada.nextLine();
                System.out.println("Digite o tamanho do Produto:[P - M - G- GG] ou [34 - 36 - 38 - 40]");
                String tamanho = entrada.nextLine();
                produtosRepository.cadastrarProduto(nome, preco, quantidade, genero, tipo, tamanho);
                System.out.println("Produto cadastrado com sucesso!");
                
                break;
                
            case 2:
                //atualizar roupa
                if(mostrarProdutos()){
                    System.out.println("Insira o numero do Produto que deseja atualizar: ");
                    int indexProduto = entrada.nextInt()-1;
                    System.out.println("Insira a nova Quantidade do Produto: ");
                    int novaQuantidade = entrada.nextInt();
                    System.out.println("Insira o novo Preco do Produto: [Valor decimal]");
                    double novoPreco = entrada.nextDouble();

                    System.out.println(produtosRepository.atualizarProduto(indexProduto, novaQuantidade, novoPreco));
                }
                break;

            case 3:
                //remover roupa
                if(mostrarProdutos()){
                    System.out.println("Insira o numero do Produto que deseja remover: ");
                    int indexProduto1 = entrada.nextInt()-1;

                    System.out.println("Quantas unidadades deseja remover: ");
                    int quantidadeRemover = entrada.nextInt();

                    System.out.println(produtosRepository.removerProduto(indexProduto1, quantidadeRemover));
                }
                break;

            case 4:
                mostrarProdutos();
                //produtosRepository.mostrarProdutos();
                break;

            case 0:
                menuPrincipal();
                break;

            default:
            System.out.println("Opção invalida digitada");
                break;
        }
    }
}