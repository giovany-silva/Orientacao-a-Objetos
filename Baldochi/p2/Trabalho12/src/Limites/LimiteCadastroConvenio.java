package Limites;

import Controladores.ControlePaciente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LimiteCadastroConvenio extends JFrame implements ActionListener{
    private ControlePaciente objControlador;
    private JPanel painel,p1,p2,p3,p4,p5;
    private JLabel nomeJL,enderecoJL,numConvenioJL,numCartaoJL;
    private JTextField nomeTF,enderecoTF,numConvenioTF,numCartaoTF;
    private JButton cadastrar;

    public LimiteCadastroConvenio(ControlePaciente pControle) {
        objControlador = pControle;
        
        //Criar os objetos do tipo JLabel
        nomeJL = new JLabel("Nome    :");
        enderecoJL = new JLabel("Endereço:");
        numConvenioJL = new JLabel("Nome Convênio:");
        numCartaoJL = new JLabel(  "Número Cartão:");
        
        //Criar os objetos do tipo TextField
        nomeTF = new JTextField(15);
        enderecoTF = new JTextField(15);
        numConvenioTF = new JTextField(11);
        numCartaoTF = new JTextField(11);
        
        //Criar JButton e adicionar Listener a ele
        cadastrar = new JButton("Cadastrar paciente");
        cadastrar.addActionListener(this);
        
        //Criar os paineis
        painel = new JPanel();
        painel.setLayout(new BoxLayout(painel,BoxLayout.Y_AXIS));
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        //Adicionar componentes aos paineis
        p1.add(nomeJL);
        p1.add(nomeTF);
        p2.add(enderecoJL);
        p2.add(enderecoTF);
        p3.add(numCartaoJL);
        p3.add(numCartaoTF);
        p4.add(numConvenioJL);
        p4.add(numConvenioTF);
        p5.add(cadastrar);
        painel.add(Box.createVerticalGlue());
        painel.add(p1);
        painel.add(p2);
        painel.add(p3);
        painel.add(p4);
        painel.add(p5);
        painel.add(Box.createVerticalGlue());
        
        super.setTitle("Cadastrar paciente de convênio");
        super.add(painel);
        super.setSize(600,400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome,endereco,numConvenio,numCartao;
        
        nome = nomeTF.getText();
        endereco = enderecoTF.getText();
        numConvenio = numConvenioTF.getText();
        numCartao = numCartaoTF.getText();
        
        if(nome.isEmpty() || endereco.isEmpty() || numConvenio.isEmpty() || numCartao.isEmpty())
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!");
        else
        {
            objControlador.adicionaConvenio(nome, endereco, numConvenio, numCartao);
            JOptionPane.showMessageDialog(this, "Paciente de convênio cadastrado!");
            super.dispose();
        }
    }
}
