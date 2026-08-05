package Model;

import java.io.Serializable;

public abstract class Bebida implements Serializable {

    private String codigo;
    private String nome;
    private double preco;

    public Bebida(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String getCodigo() { 
        return codigo; 
    }

    public void setCodigo(String codigo) { 
        this.codigo = codigo; 
    }

    public String getNome() { 
        return nome; 
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public double getPreco() { 
        return preco; 
    }

    public void setPreco(double preco) { 
        this.preco = preco; 
    }

    public abstract String getDescricaoBebida();

    public abstract boolean isAlcoolica();
}