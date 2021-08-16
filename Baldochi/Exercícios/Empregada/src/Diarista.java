/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Diarista extends EmpDomestica {

    private int diasTrabalhados;
    private double valorPorDia;

    public Diarista(String nome2, int telefone2, int dias, int valor) {
        super(nome2, telefone2);
        diasTrabalhados = dias;
        valorPorDia = valor;
    }

    public double getSalario() {
        return diasTrabalhados * valorPorDia;
    }

}
