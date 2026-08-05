package Model;

public abstract class BebidaNaoAlcoolica extends Bebida {
    private final boolean contemAcucar;

    public BebidaNaoAlcoolica(String codigo, String nome, double preco, boolean contemAcucar) {
        super(codigo, nome, preco);
        this.contemAcucar = contemAcucar;
    }

    public boolean isContemAcucar() { 
        return contemAcucar;
    }

    @Override
    public boolean isAlcoolica() { return false; }
}
