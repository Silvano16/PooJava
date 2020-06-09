package com.company;

public class Cesta {

    private Produto itens[] = new Produto[20];
    private int indice = 0;
    private double total;
    private double soma;
    private String endereco;
    private char entrega;
    private  double resl;



    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void adicionarItem(Produto produto){
        if(indice < 20) {
            this.itens[indice] = produto;
            indice++;
            this.total+=produto.getVlUnitProd();
        }
    }

    public void exibeLista(){
        for (Produto p: itens) {
            if(p!=null){
                p.imprimirEtiqueta();
            }
        }
    }

    public double calcularTotal(){
        return total;
    }

    public void limpar(){

    }






}