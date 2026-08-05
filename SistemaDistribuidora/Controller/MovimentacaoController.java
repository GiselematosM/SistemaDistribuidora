package Controller;

import Model.*;
import Exceptions.DistribuidoraException;

public class MovimentacaoController {
    private final Estoque estoque;
    private final EstoqueController estoqueController;

    public MovimentacaoController(Estoque estoque, EstoqueController estoqueController) {
        this.estoque = estoque;
        this.estoqueController = estoqueController;
    }

    public void registrarEntrada(String codigo, int quantidade) throws DistribuidoraException {
        estoqueController.sincronizarProdutos();
        Movimentacao entrada = new Entrada(codigo, quantidade);
        entrada.processar(estoque); 
    }

    public void registrarSaida(String codigo, int quantidade) throws DistribuidoraException {
        estoqueController.sincronizarProdutos();
        Movimentacao saida = new Saida(codigo, quantidade);
        saida.processar(estoque); 
    }
}