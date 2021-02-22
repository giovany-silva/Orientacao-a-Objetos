package Entidades;

import java.util.ArrayList;

public abstract class Paciente{
    // atributos do paciente
    private String nome,endereco;
    
    // ArrayList do tipo Sessao para armazenar as sessoes feitas pelo paciente
    private ArrayList<Sessao> sessoes;
    
    // pega o obj de pacientes da ControlePaciente
    private ArrayList objPacientes;

    // construtor de Paciente
    public Paciente(String pNome,String pEndereco) {
        nome = pNome;
        endereco = pEndereco;
        sessoes = new ArrayList<>();
    }
    // get do nome do paciente
    public String getNome()
    {
        return nome;
    }
    // get do endereco do paciente
    public String getEndereco()
    {
        return endereco;
    }
    // get das sessoes do paciente
    public ArrayList<Sessao> getSessoes()
    {
        return sessoes;
    }
    // get descricao do paciente, para retornar o nome e o endereco do paciente
    public String getDescricao()
    {
        String descricao = "";
        
        descricao += "O paciente "+nome+" reside em "+endereco+".";
        
        return descricao;
    }
    // calcula faturamento abstract pois eh implementada de formas diferentes nas classes que extends paciente
    public abstract double calculaFaturamento(int pMes);
    
}
