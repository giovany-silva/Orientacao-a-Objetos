package trabalho_13;

import java.io.Serializable;

public class Aluno implements Serializable {

    // atributos dos alunos
    private String nome, nroMatricula;
    private int dia, mes, ano;

    // construtor do aluno, recebe os dados informados e coloca nas variaveis
    public Aluno(String nome, String nroMatricula, int dia, int mes, int ano) {
        this.nome = nome;
        this.nroMatricula = nroMatricula;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    // get para o nome
    public String getNome() {
        return nome;
    }
    // set para o nome
    public void setNome(String nome) {
        this.nome = nome;
    }
    // get para o NrodeMatric
    public String getNroMatricula() {
        return nroMatricula;
    }
    // set para o NrodeMatric
    public void setNroMatricula(String nroMatricula) {
        this.nroMatricula = nroMatricula;
    }
    // get para o dia
    public int getDia() {
        return dia;
    }
    // set para o dia
    public void setDia(int dia) {
        this.dia = dia;
    }
    // get para o mes
    public int getMes() {
        return mes;
    }
    // set para o mes
    public void setMes(int mes) {
        this.mes = mes;
    }
    // get para o ano
    public int getAno() {
        return ano;
    }
    // set para o ano
    public void setAno(int ano) {
        this.ano = ano;
    }
}
