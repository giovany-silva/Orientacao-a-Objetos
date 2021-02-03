package trabalho_13;

import java.io.Serializable;

public class Aluno implements Serializable {

    private String nome, nroMatricula;
    private int dia, mes, ano;

    public Aluno(String nome, String nroMatricula, int dia, int mes, int ano) {
        this.nome = nome;
        this.nroMatricula = nroMatricula;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(String nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
