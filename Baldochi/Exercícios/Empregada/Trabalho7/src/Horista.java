/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Horista extends EmpDomestica {
    private int horasTrabalhadas, valorPorHora;
    
    public Horista(String nome1, int telefone1, int horas, int valor) {
        super(nome1, telefone1);
        horasTrabalhadas = horas;
        valorPorHora = valor;
    }
    
    public double getSalario(){
        return horasTrabalhadas * valorPorHora;
    }
    
}
