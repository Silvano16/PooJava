package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GerenciarControlePonto {

    public static void main(String[] args) throws InterruptedException {

        Gerente gerente = new Gerente();
        gerente.setIdFuncionario(1);
        gerente.setNome("Edson Nascimento");
        gerente.setEmail("thekingofsoccer@king.com");
        gerente.setDocumento("598743564");
        gerente.setLogin("gerente123");
        gerente.setSenha("senha123");

        Operador operador = new Operador();
        operador.setIdFuncionario(2);
        operador.setNome("Ronaldo Nazario");
        operador.setEmail("fenomeno2002@soccer.com");
        operador.setDocumento("502656510");
        operador.setValorHora(3.9);

        Secretaria secretaria = new Secretaria();
        secretaria.setIdFuncionario(3);
        secretaria.setNome("Marta Vieira");
        secretaria.setEmail("khalesse@soccer.com");
        secretaria.setDocumento("012345678");
        secretaria.setRamal("010");
        secretaria.setTelefone("3350-3062");

        RegistroPonto r1 = new RegistroPonto();
        RegistroPonto r2 = new RegistroPonto();
        RegistroPonto r3 = new RegistroPonto();



        r1.setIdRegPonto(1);
        r1.setFunc(gerente);
        r1.setDataReg(LocalDate.now());
        r1.setHoraEntrada(LocalDateTime.now());
        Thread.sleep(1000);
        r1.setHoraSaida(LocalDateTime.now());

        r2.setIdRegPonto(2);
        r2.setFunc(secretaria);
        r2.setDataReg(LocalDate.now());
        r2.setHoraEntrada(LocalDateTime.now());
        Thread.sleep(1000);
        r2.setHoraSaida(LocalDateTime.now());

        r3.setIdRegPonto(3);
        r3.setFunc(operador);
        r3.setDataReg(LocalDate.now());
        r3.setHoraEntrada(LocalDateTime.now());
        Thread.sleep(1000);
        r3.setHoraSaida(LocalDateTime.now());

        System.out.println("===========================================");
        r1.apresentarRegistroPonto();
        System.out.println("===========================================");
        r2.apresentarRegistroPonto();
        System.out.println("===========================================");
        r3.apresentarRegistroPonto();
        System.out.println("===========================================");
        r1.apresentarRegistroPonto();
        System.out.println("===========================================");
        r2.apresentarRegistroPonto();
        System.out.println("===========================================");
        r3.apresentarRegistroPonto();
        System.out.println("===========================================");
    }
}



