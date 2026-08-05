package View;
import java.util.Scanner;
import Controller.ClienteController;
import Util.LoggerService;

public class ClienteView {
    private final Scanner sc;
    private final ClienteController clienteController;

    public ClienteView(ClienteController clienteController) {
        this.sc = new Scanner(System.in);
        this.clienteController = clienteController;
    }
    
    public void mensagem(String msg) {
        System.out.println(msg);
    }
    public void exibirMenu() {
        int op;
        do {
            System.out.println("\n---- MENU GERENCIAMENTO DE CLIENTES ----");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Atualizar nome");
            System.out.println("3. Atualizar CPF");
            System.out.println("4. Atualizar CEP");
            System.out.println("5. Remover cliente");
            System.out.println("6. Buscar cliente");
            System.out.println("7. Listar clientes");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch(op) {
                case 1:
                    cad_Cliente();
                    break;
                case 2:
                    atualizarNome();
                    break;
                case 3:
                    atualizarCpf();
                    break;
                case 4:
                    atualizarCep();
                    break;
                case 5:
                    removerCliente();
                    break;
                case 6: 
                    buscarCliente();
                    break;
                case 7:
                    listarClientes();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while(op != 0);
    }

    public void cad_Cliente() {
        System.out.print("Informe o nome: ");
        String nome = sc.nextLine();
        System.out.print("Informe o CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Informe o CEP: ");
        String cep = sc.nextLine();

        clienteController.cad_Cliente(nome, cpf, cep);
        LoggerService.log("INFO", "| Cliente cadastrado! | Nome: " + nome + " | CPF: " + cpf);
    }

    public void atualizarNome() {
        System.out.print("informe o ID do cliente: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Informe o novo nome: ");
        String novoNome = sc.nextLine();

        System.out.println(clienteController.alterarNome(id, novoNome));
        LoggerService.log("INFO", "Nome do cliente " + id + " atualizado para: " + novoNome);
    }

    public void atualizarCpf() {
        System.out.print("Informe o ID do cliente: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Informe o novo CPF: ");
        String novoCpf = sc.nextLine();

        System.out.println(clienteController.alterarCpf(id, novoCpf));
        LoggerService.log("INFO", "CPF do cliente " + id + " atualizado para: " + novoCpf);

    }

    public void atualizarCep() {
        System.out.print("Informe o ID do cliente: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Informe o novo CEP: ");
        String novoCep = sc.nextLine();

        System.out.println(clienteController.alterarCep(id, novoCep));
        LoggerService.log("INFO", "CEP do cliente " + id + " atualizado para: " + novoCep);
    }

    public void removerCliente() {
        System.out.print("Informe o ID do cliente a ser removido: ");
        int id = sc.nextInt();
        sc.nextLine();

        clienteController.remover_cliente(id);
        LoggerService.log("INFO", "Cliente " + id + " removido");
    }

    public void buscarCliente() {
        System.out.print("Informe o ID do cliente desejado: ");
        int id = sc.nextInt();
        sc.nextLine();

        clienteController.buscar_cliente(id);
        LoggerService.log("INFO", "Busca realizada pelo cliente ID: " + id);
    }

    public void listarClientes() {
        clienteController.listarClientes();
        LoggerService.log("INFO", "Clientes listados");
    }
}
