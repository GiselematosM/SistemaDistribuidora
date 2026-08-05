package Model;
import java.io.Serializable;

public class ItemVenda implements Serializable {
    private final Bebida bebidaItem;
    private int quantidade;
    private final double precoUnt;

    public ItemVenda(Bebida bebidaItem,int quantidade, double precoUnt){
        this.bebidaItem = bebidaItem;
        this.precoUnt = precoUnt;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnt() {
        return precoUnt;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Bebida getBebidaItem() {
        return bebidaItem;
    }

    public double calculoSubTotal(){
        double somaS;
        somaS=getQuantidade()*getPrecoUnt();
        return somaS;
    }

    public String toString() {
        return "\n| Item: " + getBebidaItem().getNome() +
                "\n| Quantidade: " + getQuantidade() +
                "\n| Preço unitário: " + getPrecoUnt() +
                "\n| Total do item: " + calculoSubTotal();

    }

}