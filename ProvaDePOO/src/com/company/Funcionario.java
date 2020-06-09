package com.company;

public class Funcionario {
    private int idFunc;
    private String nome;
    private String contato;
    private String fone;
    private String email;
    private String endereco;
    private String cargo;


    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public void imprimirFuncionario(){
        System.out.println("idForn = " + idFunc);
        System.out.println("nome = " + nome);
        System.out.println("contato = " + contato);
        System.out.println("fone = " + fone);
        System.out.println("email = " + email);
        System.out.println("Endereco = "+endereco);
        System.out.println("Cargo = "+cargo);
    }

}