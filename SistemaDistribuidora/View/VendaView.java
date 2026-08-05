package View;

import java.util.Scanner;
import Controller.VendaController;
import Exceptions.*;
import Util.LoggerService;

public class VendaView {
    private final Scanner sc;
    private final VendaController controller;

    public VendaView(VendaController controller) {
        this.controller = controller;
        this.sc = new Scanner(System.in);
    }

    public void exibirMenu() { 
        int opcao;
        do {
            System.out.println("\n---- MENU VENDAS ----");
            System.out.println("1. Iniciar nova compra");
            System.out.println("2. Adicionar item na compra");
            System.out.println("3. Cancelar compra atual");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Listar histórico de vendas");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); 

            switch(opcao) {
                case 1:
                    novaCompra();
                    break;
                case 2:
                    adicionar_itemVenda();
                    break;
                case 3:
                    System.out.println(controller.cancelarCompra());
                    break;
                case 4:
                    System.out.println(controller.finalizarVenda());
                    break;
                case 5:
                    controller.listarVendas();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
    }
        
    private void novaCompra(){
        try {

            System.out.print("Informe o nome do cliente: ");
            String nome = sc.nextLine();
            System.out.print("Informe o ID do Cliente: ");
            int idCliente= sc.nextInt();
            System.out.println(controller.iniciarNovaVenda(idCliente, nome));
            LoggerService.log("INFO", "Venda iniciada para o cliente: " + idCliente);

        } catch(ObrigatorioException e) {
            System.out.println("Erro: " + e.getMessage());
            LoggerService.log("ERROR", "Erro ao iniciar venda");
        }
    }

    private void adicionar_itemVenda() {
        System.out.print("Informe o código da bebida: ");
        String codigo = sc.nextLine();

        System.out.print("Informe a quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine(); 
        
        System.out.println(controller.addItemVenda(codigo, quantidade));
    }
}