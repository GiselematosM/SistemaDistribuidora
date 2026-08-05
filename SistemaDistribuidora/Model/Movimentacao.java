package Model;

import java.util.Date;
import Exceptions.DistribuidoraException;
import java.io.Serializable;

public abstract class Movimentacao implements Serializable {
    protected String codigoBebida;
    protected int quantidade;
    protected Date data;

    public Movimentacao(String codigoBebida, int quantidade) {
        this.codigoBebida = codigoBebida;
        this.quantidade = quantidade;
        this.data = new Date(); 
    }

    public int getQuantidade() { 
        return quantidade; 
    }

    public abstract void processar(Estoque estoque) throws DistribuidoraException;
}