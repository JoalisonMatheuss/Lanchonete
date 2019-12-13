/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class Cliente {

    private int codCliente;
    private String nome;


    public Cliente(int codCliente, String nome){
        this.codCliente = codCliente;
        this.nome = nome;
    }

    public void setCodCliente(int codCliente){
        this.codCliente = codCliente;
    }

    public int getCodCliente(){
        return codCliente;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

}