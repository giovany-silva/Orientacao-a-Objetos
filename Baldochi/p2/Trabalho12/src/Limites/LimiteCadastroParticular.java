package Limites;

import Controladores.ControlePaciente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LimiteCadastroParticular extends JFrame implements ActionListener{
    private ControlePaciente objControlador;
    private JPanel painel,p1,p2,p3,p4;
    private JLabel nomeJL,enderecoJL,cpfJL;
    private JTextField nomeTF,enderecoTF,cpfTF;
    private JButton cadastrar;

    public LimiteCadastroParticular(ControlePaciente pControle) {
        objControlador = pControle;
        
        //Criar os objetos do tipo JLabel
        nomeJL = new JLabel("Nome    :");
        enderecoJL = new JLabel("Endereço:");
        cpfJL = new JLabel("Num. CPF:");
        
        //Criar os objetos do tipo TextField
        nomeTF = new JTextField(15);
        enderecoTF = new JTextField(15);
        cpfTF = new JTextField(15);
        
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
        
        //Adicionar componentes aos paineis
        p1.add(nomeJL);
        p1.add(nomeTF);
        p2.add(enderecoJL);
        p2.add(enderecoTF);
        p3.add(cpfJL);
        p3.add(cpfTF);
        p4.add(cadastrar);
        painel.add(Box.createVerticalGlue());
        painel.add(p1);
        painel.add(p2);
        painel.add(p3);
        painel.add(p4);
        painel.add(Box.createVerticalGlue());
        
        super.setTitle("Cadastrar paciente particular");
        super.add(painel);
        super.setSize(600,400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome,endereco,cpf;
        
        nome = nomeTF.getText();
        endereco = enderecoTF.getText();
        cpf = cpfTF.getText();
        
        if(nome.isEmpty() || endereco.isEmpty() || cpf.isEmpty())
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!");
        else
        {
            objControlador.adicionaParticular(nome, endereco, cpf);
            JOptionPane.showMessageDialog(this, "Paciente particular cadastrado!");
            super.dispose();
        }
    }
}
