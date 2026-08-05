package Model;

public class Refrigerante extends BebidaNaoAlcoolica {
    private final String sabor;

    public Refrigerante(String codigo, String nome, double preco, boolean contemAcucar, String sabor) {
        super(codigo, nome, preco, contemAcucar);
        this.sabor = sabor;
    }

    public String getSabor() { 
        return sabor; 
    }

    @Override
    public String getDescricaoBebida() {
        String acucar = isContemAcucar() ? "Com Açúcar" : "Zero Açúcar";
        return String.format("[Refrigerante de %s] %s | Cod: %s | Preço: R$%.2f | %s",
                getSabor(), getNome(), getCodigo(), getPreco(), acucar);
    }
}