package Model;

public class Cerveja extends BebidaAlcoolica {
    private final String tipoCerveja;

    public Cerveja(String codigo, String nome, double preco, double teorAlcoolico, String tipoCerveja) {
        super(codigo, nome, preco, teorAlcoolico);
        this.tipoCerveja = tipoCerveja;
    }

    @Override
    public String getDescricaoBebida() {
        return String.format("[Cerveja %s] %s | Cod: %s | Preço: R$%.2f | Teor Alcoólico: %.1f%%",
                tipoCerveja, getNome(), getCodigo(), getPreco(), getTeorAlcoolico());
    }
}