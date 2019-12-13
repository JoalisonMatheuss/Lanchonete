/**
 *
 * @author PedroReiDelas
 */
import java.util.List;
import java.util.ArrayList;

public class Comanda {
    private int numComanda;
    private double valorTotalVenda;
    private int codCliente;
    private static List<Item> itens = new ArrayList<>();
    

    public Comanda(int numComanda, int codCliente){
        this.numComanda = numComanda;
        this.valorTotalVenda = 0;
        this.codCliente = codCliente;
    }
    
    public void setNumComanda(int numComanda){
        this.numComanda = numComanda;
    }
    
    public int getNumComanda(){
        return numComanda;
    }

    public void setValorTotalVenda(double valorTotalVenda){
        this.valorTotalVenda = valorTotalVenda;
    }
    
    public double getValorTotalVenda(){
         double ValorTotalVenda = 0;
         for(int i = 0; i< itens.size(); i++){
             ValorTotalVenda = ((itens.get(i).getValorUnitario() * itens.get(i).getQtd()) + ValorTotalVenda);
         }
        return valorTotalVenda;
    }
    
    public void setCodCliente(int codCliente){
        this.codCliente = codCliente;
    }

    public int getCodCliente(){
        return codCliente;
    }
    
    public void adcionarItens(Item i){
    	itens.add(i);
    }

    public static int getLenItens() {
        return itens.size();
    }

    public void setItens(List<Item> itens) {
	this.itens = itens;
    }

}
