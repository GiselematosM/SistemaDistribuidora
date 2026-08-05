package Model;

public abstract class BebidaAlcoolica extends Bebida {
    private final double teorAlcoolico;

    public BebidaAlcoolica(String codigo, String nome, double preco, double teorAlcoolico) {
        super(codigo, nome, preco);
        this.teorAlcoolico = teorAlcoolico;
    }

    public double getTeorAlcoolico() { 
        return teorAlcoolico; 
    }

    @Override
    public boolean isAlcoolica() { 
        return true;
    }
}