package Entidades;

import java.util.ArrayList;

public abstract class Paciente{
    private String nome,endereco;
    private ArrayList<Sessao> sessoes;

    public Paciente(String pNome,String pEndereco) {
        nome = pNome;
        endereco = pEndereco;
        sessoes = new ArrayList<>();
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public String getEndereco()
    {
        return endereco;
    }
    
    public ArrayList<Sessao> getSessoes()
    {
        return sessoes;
    }
    
    public String getDescricao()
    {
        String descricao = "";
        
        descricao += "O paciente "+nome+" reside em "+endereco+".";
        
        return descricao;
    }
    
    public abstract double calculaFaturamento(int pMes);
    
}
