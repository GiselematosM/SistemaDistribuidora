package View;
import java.util.Scanner;
import Controller.FornecedorController;

public class FornecedorView {
    private final Scanner sc;
    private final FornecedorController fornecedorController;

    public FornecedorView(FornecedorController fornecedorController) {
        this.sc = new Scanner(System.in);
        this.fornecedorController = fornecedorController;
    }
    
    public int lerId() {
        System.out.print("Informe o ID do fornecedor desejado: ");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }
    public String lerBebida() {
        System.out.print("Informe o código da bebida desejada: ");
        return sc.nextLine();
    }

    public void mensagem(String msg) {
        System.out.println(msg);
    }

    public void menu_atulizar_fornecedor() {
        int op;
        do {
            System.out.println("\n---- MENU GERENCIAMENTO DE FORNECEDORES ----");
            System.out.println("1. Cadastrar Fornecedor");
            System.out.println("2. Atualizar nome");
            System.out.println("3. Atualizar CNPJ");
            System.out.println("4. Atualizar endereço");
            System.out.println("5. Associar bebida");
            System.out.println("6. Desassociar bebida");
            System.out.println("7. Remover fornecedor");
            System.out.println("8. Buscar fornecedor");
            System.out.println("9. Listar fornecedores");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch(op) {
                case 1:
                    cad_fornecedor();
                    break;
                case 2: 
                    atualizarNome();
                    break;
                case 3:
                    atualizarCnpj();
                    break;
                case 4:
                    atualizarCep();
                    break;
                case 5:
                    fornecedorController.associar_bebidaFornecedor();
                    break;
                case 6:
                    desassociar_bebida();
                    break;
                case 7:
                    remover_fornecedor();
                    break;
                case 8:
                    buscarFornecedor();
                    break;
                case 9:
                    fornecedorController.listarFornecedores();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválido!");
            }
        }while(op != 0);
        
    }

    public void cad_fornecedor() {
        System.out.print("Informe o nome: ");
        String nome = sc.nextLine();

        System.out.print("Informe o CNPJ: ");
        String cnpj = sc.nextLine();

        System.out.print("Informe o CEP: ");
        String cep = sc.nextLine();

        fornecedorController.cad_fornecedor(nome, cnpj, cep);
    }

    public void atualizarNome() {
        System.out.print("informe o ID do fornecedor: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Informe o novo nome: ");
        String novoNome = sc.nextLine();

        System.out.println(fornecedorController.alterarNome(id, novoNome));
    }
    public void atualizarCnpj() {
        System.out.print("Informe o ID do fornecedor: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Informe o novo CNPJ: ");
        String novoCpf = sc.nextLine();

        System.out.println(fornecedorController.alterarCnpj(id, novoCpf));

    }
    public void atualizarCep() {
        System.out.print("Informe o ID do fornecedor: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Informe o novo CEP: ");
        String novoCep = sc.nextLine();

        System.out.println(fornecedorController.alterarCep(id, novoCep));
    }
    public void desassociar_bebida() {
        System.out.print("Informe o ID do fornecedor: ");
        int idFornecedor = sc.nextInt();
        sc.nextLine();

        System.out.print("Informe o código da bebida: ");
        String codigoBebida = sc.nextLine();

        fornecedorController.desassociarBebida(idFornecedor, codigoBebida);
    }
    public void remover_fornecedor() {
        System.out.print("Informe o ID do fornecedor a ser removido: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        fornecedorController.remover_fornecedor(id);
    }
    public void buscarFornecedor() {
        System.out.print("Informe o ID do fornecedor: ");
        int id = sc.nextInt();
        sc.nextLine();

        fornecedorController.buscar_fornecedor(id);
    }

}
