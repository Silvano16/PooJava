package com.company;

public class Produto {

    private int idProd;
    private String descProd;
    private double vlUnitProd;
    private int qtdProd;

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public double getVlUnitProd() {
        return vlUnitProd;
    }

    public void setVlUnitProd(double vlUnitProd) {
        this.vlUnitProd = vlUnitProd;
    }

    public int getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }

    public void imprimirEtiqueta(){
        System.out.println("Codigo: " + idProd);
        System.out.println("Descricao: " + descProd.toUpperCase());
        System.out.println("Quantidade: " + qtdProd);
        System.out.println("Valor Unitario: " + vlUnitProd);
        System.out.println();

    }

    public boolean comprar(int qtdComprada){
        if(qtdComprada > 0){
            qtdProd+= qtdComprada;
            return  true;
        }
        return false;
    }

    public boolean vender(int qtdIng, int qtdVendida){
        if ((qtdIng*qtdVendida) > this.qtdProd){
            return false;
        }
        this.qtdProd -= (qtdIng*qtdVendida);
        return true;
    }

}