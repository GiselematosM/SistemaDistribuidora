package View;

import Controller.RelatorioController;
import java.util.Scanner;

public class RelatorioView {
    private final RelatorioController controller;
    private final Scanner scanner;

    public RelatorioView(RelatorioController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n---- MENU RELATÓRIOS ----");
            System.out.println("1. Valor Financeiro Total em Estoque");
            System.out.println("2. Alerta de Itens com Baixo Estoque");
            System.out.println("3. Faturamento Bruto de Vendas");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    double valorEstoque = controller.calcularValorTotalEstoque();
                    System.out.printf("\nValor total investido em mercadoria: R$ %.2f\n", valorEstoque);
                    break;
                case 2:
                    System.out.print("Defina o limite mínimo de estoque para o alerta: ");
                    int limite = scanner.nextInt();
                    controller.verificarProdutosBaixoEstoque(limite);
                    break;
                case 3:
                    double faturamento = controller.calcularFaturamentoTotalVendas();
                    System.out.printf("\nFaturamento total acumulado em vendas: R$ %.2f\n", faturamento);
                    break;
                case 0:
                    System.out.println("Retornando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}