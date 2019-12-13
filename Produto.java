/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroReiDelas
 */
public class Produto {
    private int codProduto;
    private double custo;
    private String descricao;
    private double preco;
    private String nome;
    private double lucro;

    public Produto(int codProduto, String nome, String descricao, double custo){
        this.codProduto = codProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.lucro = 0.8;
        this.preco = (custo * lucro) + custo;
        
        
    }

    Produto(int aInt, String string, String string0, double aDouble, double aDouble0, double aDouble1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodProduto(){
        return codProduto;
    }

    public void setCodProduto(int codProduto){
        this.codProduto = codProduto;
    }

    public double getCusto(){
        return custo;
    }

    public void setCusto(double custo){
        this.custo = custo;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public double getLucro() {
 	return lucro;
    }

    public void setLucro(double lucro) {
 	this.lucro = lucro;
    }

}