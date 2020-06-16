package com.company;

public class Secretaria extends Funcionario {

    private String telefone;
    private String ramal;

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getRamal() {
        return ramal;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

}
