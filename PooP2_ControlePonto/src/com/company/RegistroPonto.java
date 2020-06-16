package com.company;

import javax.naming.Name;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegistroPonto {

    private long idRegPonto;
    private Funcionario func;
    private LocalDate dataReg;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    int vez = 1;

    public void setIdRegPonto(long idRegPonto) {
        this.idRegPonto = idRegPonto;
    }

    public long getIdRegPonto() {
        return idRegPonto;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setDataReg(LocalDate dataReg) {
        this.dataReg = dataReg;
    }

    public LocalDate getDataReg() {
        return dataReg;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void apresentarRegistroPonto() {
        System.out.println("Funcionario: " + func.getClass().getSimpleName() + " " + func.getNome());
        System.out.println("Data de registro: " + getDataReg());
        System.out.println("Hora de entrada: " + getHoraEntrada());
        if (vez % 2 != 0){
            System.out.println("Hora de saida: " + null);
        }else{
            System.out.println("Hora de saida: " + getHoraSaida());
        }
        vez++;
    }

}
