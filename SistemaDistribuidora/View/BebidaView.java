package View;

import Controller.BebidaController;
import Model.Bebida;
import Util.LoggerService;
import java.util.List;
import java.util.Scanner;

public class BebidaView {

    private final BebidaController controller;
    private final Scanner scanner;

    public BebidaView(BebidaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU CADASTRO DE BEBIDAS ---");
            System.out.println("1. Cadastrar Cerveja");
            System.out.println("2. Cadastrar Refrigerante");
            System.out.println("3. Listar todas as Bebidas");
            System.out.println("4. Remover bebida");
            System.out.println("5. Atualizar preço de bebida");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCerveja();
                    break;
                case 2:
                    cadastrarRefrigerante();
                    break;
                case 3:
                    listarBebidas();
                    break;
                case 4:
                    excluirBebida();
                    break;
                case 5:
                    atualizarPrecoBebida();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrarCerveja() {

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Teor Alcoólico (%): ");
        double teor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Tipo da Cerveja (Ex: IPA, Pilsen): ");
        String tipo = scanner.nextLine();

        controller.cadastrarCerveja(codigo, nome, preco, teor, tipo);
        System.out.println("Cerveja cadastrada com sucesso!");

        LoggerService.log("INFO", "| Cerveja cadastrada! | Código: " + codigo + " | Nome: " + nome + " | Preço: " + preco );
    }

    private void cadastrarRefrigerante() {

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Contém açúcar? (S/N): ");
        boolean acucar = scanner.nextLine().equalsIgnoreCase("S");

        System.out.print("Sabor: ");
        String sabor = scanner.nextLine();

        controller.cadastrarRefrigerante(codigo, nome, preco, acucar, sabor);
        System.out.println("Refrigerante cadastrado com sucesso!");

        LoggerService.log("INFO", "| Refrigerante cadastrado! | Código: " + codigo + " | Nome: " + nome + " | Preço: " + preco );
    }

    private void listarBebidas() {

        List<Bebida> bebidas = controller.obterTodasBebidas();
        if (bebidas.isEmpty()) {
            System.out.println("Nenhuma bebida cadastrada.");
        } else {
            System.out.println("\n--- LISTA DE BEBIDAS ---");
            for (Bebida b : bebidas) {
                System.out.println(b.getDescricaoBebida());
            }
        }

        LoggerService.log("INFO", "Bebidas listadas");
    }

    public void excluirBebida() {
        System.out.print("Informe o código da bebida: ");
        String codigo = scanner.nextLine();

        if(controller.excluirBebida(codigo)) {
            System.out.println("Bebida removida!");
        } else {
            System.out.println("Não foi possível remover a bebida!");
        }

        LoggerService.log("INFO", "Bebida de código: " + codigo + " excluída");
            
    }
    public void atualizarPrecoBebida() {
        System.out.print("Informe o código da bebida: ");
        String codigo = scanner.nextLine();

        System.out.print("Informe o novo preço: ");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine();

        System.out.println(controller.atualizarPreco(codigo, novoPreco));
        
        LoggerService.log("INFO", "Preço da bebida " + codigo + " atualizado para: " + novoPreco);
    }
}