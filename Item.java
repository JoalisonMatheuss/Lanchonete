/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroReiDelas
 */
public class Item {
    private Produto produto;
    private double valorUnitario;
    private int qtd;
    private int numComanda;

    public Item(Produto produto, int numComanda, int qtd){
        this.produto = produto;
        this.numComanda = numComanda;
        this.valorUnitario = getProduto().getPreco();
        this.qtd = qtd;

    }

    public Produto getProduto(){
        return produto;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public void setValorUnitario(double valorUnitario){
        this.valorUnitario  = valorUnitario;
    }

    public double getValorUnitario(){
        valorUnitario = (getProduto().getPreco());
        return valorUnitario;
    }

    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public int getQtd(){
        return qtd;
    }
   
    public void setNumComanda(int numComanda){
        this.numComanda = numComanda;
    }

    public int getNumComanda(){
        return numComanda;
    }
}
