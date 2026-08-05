package Model;
import java.util.ArrayList;
import java.io.Serializable;

public class Venda implements Serializable {
    private final int codigoVenda;
    private final ArrayList<ItemVenda> itens;
    private final Cliente cliente;
    private boolean finalizada;

    public Venda(int codigoVenda, Cliente cliente) {
        this.codigoVenda = codigoVenda;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.finalizada = false;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }


    public boolean addItem(ItemVenda item){
        if(!this.finalizada){
            this.itens.add(item);
            return true;
        }else{
            return false;
        }
    }

    public double calculoTotalVenda(){
        double soma = 0;
        for (ItemVenda item : this.itens){
            soma += item.calculoSubTotal();
        }
        return soma;
    }


    public String toString() {
        return "\n| Venda n° " + getCodigoVenda() +
               "\n| Cliente: " + getCliente().getNome();
    }
}