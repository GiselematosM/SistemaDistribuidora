package View;

import Controller.MovimentacaoController;
import Exceptions.DistribuidoraException;
import java.util.Scanner;

public class MovimentacaoView {
    private final MovimentacaoController controller;
    private final Scanner scanner;

    public MovimentacaoView(MovimentacaoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n---- MENU MOVIMENTAÇÃO DE ESTOQUE ----");
            System.out.println("1. Registrar Entrada (Aumentar estoque)");
            System.out.println("2. Registrar Saída (Diminuir estoque)");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    realizarEntrada();
                    break;
                case 2:
                    realizarSaida();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void realizarEntrada() {
        System.out.print("Código da bebida: ");
        String codigo = scanner.nextLine();
        System.out.print("Quantidade de entrada: ");
        int qtd = scanner.nextInt();
        scanner.nextLine();

        try {

            controller.registrarEntrada(codigo, qtd);
            System.out.println("Entrada registrada com sucesso!");

        } catch (DistribuidoraException e) {
            System.out.println("Erro ao processar entrada: " + e.getMessage());
        }
    }

    private void realizarSaida() {
        System.out.print("Código da bebida: ");
        String codigo = scanner.nextLine();
        System.out.print("Quantidade de saída: ");
        int qtd = scanner.nextInt();
        scanner.nextLine();

        try {

            controller.registrarSaida(codigo, qtd);
            System.out.println("Saída registrada com sucesso!");

        } catch (DistribuidoraException e) {
            System.out.println("Operação Cancelada: " + e.getMessage());
        }
    }
}