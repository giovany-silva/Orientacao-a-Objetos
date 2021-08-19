package Limites;

import Controladores.ControlePaciente;
import Entidades.Paciente;
import Entidades.Particular;
import Entidades.Sessao;
import Entidades.Convenio;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LimiteImpressaoFicha extends JFrame implements ActionListener{

    // objControlador para esta classe "se comunicar" com a Controle Principal
    private ControlePaciente objControlador;
    // obj pacienteAux do tipo Paciente
    private Paciente pacienteAux;
    // criacao dos paineis, botoes, textAreas, etc
    private JPanel painel, painel2;
    private JLabel JL;
    private JButton Buscar;
    private JTextField TF;
    private JTextArea retorno;
    
    // construtor do LimiteImpressaoFicha passa um obj do tipo Controle Paciente como parametro
    public LimiteImpressaoFicha(ControlePaciente pController) {
        objControlador = pController;
        
        // criacao dos objetos do tipo JPanel
         // painel "painel" eh o principal desta interface impressao ficha
        painel = new JPanel(new BorderLayout(0, 10));
        painel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // criacao dos objetos JLabel
        JL = new JLabel("Informar o numero do CPF ou do cartao");
       
        // criacao do objeto botao 
        Buscar = new JButton("Buscar");
        Buscar.addActionListener(this);
        
        // criacao do objeto do tipo JTextField
        TF = new JTextField(20);
        
        // criacao do objeto do tipo JTextArea
        retorno = new JTextArea();
        
        // adicionar os objetos nos paineis
        painel2.add(JL);
        painel2.add(TF);
        painel2.add(Buscar);
        painel2.add(retorno);
        painel.add(painel2, BorderLayout.NORTH);
        
        retorno.setVisible(false);
        retorno.setSize(200, 200);
        
        super.setTitle("Ficha do paciente");
        super.add(painel);
        super.setSize(700, 500);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }// ---------------- CONSTRUTOR TERMINA AQUI -----------------
    
    // ActionListener para o botao "Buscar"
    public void actionPerformed(ActionEvent e){
        // criacao de um botao auxiliar 
        JButton botaoAux = (JButton) e.getSource();
        
        // criacao de uma string para verificar se foram informados dados
        String identificar = "";
        
        if(botaoAux.equals(Buscar)){
            // variavel recebe o dado digitado (cpf ou nroCartao)
            identificar = TF.getText();
            
            // se nao for informado nenhum dado, retorna msg
            if(identificar.isEmpty()){
                JOptionPane.showMessageDialog(this, "Nenhum dado foi informado");
                }
            else{
                // se os dados foram informados, chama a funcao buscaPaciente no Controle
                // e passa o dado informado como paramentro
                pacienteAux = objControlador.buscaPaciente(identificar);
                
                // verifica se o paciente existe
                if(pacienteAux != null){
                    TF.setEditable(false);
                    retorno.setEditable(false);
                    
                    // se o paciente existe chama a funcao retornaSessoes e passa o pacienteAux como parametro
                    String retornoSessoes = retornaSessoes(pacienteAux);
                    retorno.setText(retornoSessoes);
                    retorno.setVisible(true);
                }
                // se o paciente nao existir retorna msg
                else{
                    JOptionPane.showMessageDialog(this, "Paciente nao encontrado");
                }
            }
        }
    }
    // funcao para retornar sessoes, recebe um parametro ajuda
    public String retornaSessoes(Object ajuda){
        // criacao de string para retornar as sessoes
        String s = "";
        
        // se ajuda eh um convenio
        if(ajuda instanceof Convenio){
            // para passar o nome e o endereco do paciente
            s+=((Convenio) ajuda).getDescricao();
            
            s+="\nConvenio "+((Convenio) ajuda).getNomeConvenio()+ " Cartao "+((Convenio) ajuda).getNroCartao();
            s+="\nSessoes \n Data \t Tipo\n";
            // for para buscar as sessoes do tipo convenio
            for(Sessao se: ((Convenio) ajuda).getSessoes()){
                s+=se.getDia()+"/"+se.getMes()+"/"+se.getTipo()+"\n";
            }
        }
        // se ajuda for particular
        else if(ajuda instanceof Particular){
            // para passar o nome e o endereco do paciente
            s+=((Particular) ajuda).getDescricao();
            s+="\nCPF: "+((Particular) ajuda).getCpf();
            s+="\nSessoes\n";
            // for para pegar as sessoes do tipo particular
            for(Sessao se: ((Particular) ajuda).getSessoes()){
                s+="Data: "+se.getDia()+"/"+se.getMes()+"\t"+se.getTipo();
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Objeto incorreto");
        }
        s+="\n\n";
        
        return s;
    }

}
