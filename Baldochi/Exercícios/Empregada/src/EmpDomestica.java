/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public abstract class EmpDomestica {

    private String nome;
    private int telefone;
    
    public EmpDomestica(String nme , int tel) {
        nome = nme;
        telefone = tel;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getnome() {
        return nome;
    }

    public void settelefone(int telefone) {
        this.telefone = telefone;
    }

    public int gettelefone() {
        return telefone;
    }
    
    public abstract double getSalario();
}
