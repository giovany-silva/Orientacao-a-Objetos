/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Mensalista extends EmpDomestica {

    private double valorMensal;

    public Mensalista(String nome3, int telefone3, int valor) {
        super(nome3, telefone3);
        valorMensal = valor;
    }

    public double getSalario() {
        return valorMensal;
    }

}
