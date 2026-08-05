package View;

import Controller.ConsultaBebidaController;
import Model.Bebida;
import Util.LoggerService;

import java.util.List;
import java.util.Scanner;

public class ConsultaBebidaView {
    private final ConsultaBebidaController controller;
    private final Scanner scanner;

    public ConsultaBebidaView(ConsultaBebidaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- MENU DE CONSULTA DE BEBIDAS ---");
            System.out.println("1. Buscar por Código");
            System.out.println("2. Buscar por Nome");
            System.out.println("3. Filtrar por Tipo (Alcoólica/Não Alcoólica)");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    buscarPorCodigo();
                    break;
                case 2:
                    buscarPorNome();
                    break;
                case 3:
                    buscarPorTipo();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void buscarPorCodigo() {
        System.out.print("Digite o código da bebida: ");
        String codigo = scanner.nextLine();

        Bebida b = controller.buscarPorCodigo(codigo);

        if (b != null) {
            System.out.println("\nBebida Encontrada:");
            System.out.println(b.getDescricaoBebida());
            LoggerService.log("INFO", "Bebida " + codigo + " buscada");
        } else {
            System.out.println("\nNenhuma bebida encontrada com o código: " + codigo);
            LoggerService.log("ERROR", "Busca realizada por bebida inexistente, código: " + codigo);
        }
        
    }

    private void buscarPorNome() {
        System.out.print("Digite o nome (ou parte dele): ");
        String nome = scanner.nextLine();
        List<Bebida> resultados = controller.buscarPorNome(nome);

        exibirResultadosLista(resultados);
        LoggerService.log("INFO", "Bebida " + nome + " buscada");
    }

    private void buscarPorTipo() {
        System.out.println("1. Alcoólicas");
        System.out.println("2. Não Alcoólicas");
        System.out.print("Escolha: ");
        
        int tipo = scanner.nextInt();
        scanner.nextLine();

        boolean isAlcoolica = (tipo == 1);
        List<Bebida> resultados = controller.buscarPorTipo(isAlcoolica);

        exibirResultadosLista(resultados);
        LoggerService.log("INFO", "Busca realizada pelo filtro 'alcoólicas / não alcoólicas'");
    }

    private void exibirResultadosLista(List<Bebida> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("\nNenhuma bebida encontrada para essa busca.");
        } else {
            System.out.println("\n--- RESULTADOS DA BUSCA ---");
            for (Bebida b : resultados) {
                System.out.println(b.getDescricaoBebida());
            }
        }
    }
}