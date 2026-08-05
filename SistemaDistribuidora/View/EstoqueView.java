package View;

import Controller.EstoqueController;
import Model.Bebida;
import Util.LoggerService;
import Exceptions.DistribuidoraException;
import java.util.Map;
import java.util.Scanner;

public class EstoqueView {
    private final EstoqueController controller;
    private final Scanner scanner;

    public EstoqueView(EstoqueController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU CONTROLE DE ESTOQUE ---");
            System.out.println("1. Visualizar Estoque Atual");
            System.out.println("2. Consultar Disponibilidade por Código");
            System.out.println("3. Ajustar Quantidade Manualmente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    visualizarEstoque();
                    break;
                case 2:
                    consultarDisponibilidade();
                    break;
                case 3:
                    ajustarManual();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void visualizarEstoque() {
        System.out.println("\n--- ESTOQUE ATUAL ---");
        Map<String, Bebida> produtos = controller.getEstoque().getProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado no estoque ainda.");
            return;
        }
        for (String codigo : produtos.keySet()) {
            Bebida b = produtos.get(codigo);
            int qtd = controller.consultarDisponibilidade(codigo);
            System.out.println(b.getDescricaoBebida() + " | Qtd em Estoque: " + qtd);
        }
        LoggerService.log("INFO", "Estoque visualizado");
    }

    private void consultarDisponibilidade() {
        System.out.print("Digite o código da bebida: ");
        String codigo = scanner.nextLine();
        Bebida b = controller.obterBebida(codigo);
        
        if (b != null) {
            int qtd = controller.consultarDisponibilidade(codigo);
            System.out.println("\nProduto: " + b.getNome() + " | Quantidade Disponível: " + qtd);
        } else {
            System.out.println("Bebida não encontrada.");
        }
        LoggerService.log("INFO", "Disponibilidade de bebida: " + codigo + " consultada");
    }

    private void ajustarManual() {
        System.out.print("Digite o código da bebida: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite a nova quantidade: ");
        int qtd = scanner.nextInt();
        scanner.nextLine();

        try {

            controller.ajustarEstoqueManual(codigo, qtd);
            System.out.println("Estoque atualizado com sucesso!");
            LoggerService.log("INFO", "Estoque da bebida " + codigo + " ajustado manualmente");
            
        } catch (DistribuidoraException e) {
            System.out.println("Erro: " + e.getMessage());
            LoggerService.log("ERROR", "Erro ao ajustar manualmente estoque da bebida " + codigo);
        }
    }
}