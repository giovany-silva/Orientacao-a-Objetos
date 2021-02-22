package Limites;

import Controladores.ControlePaciente;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LimiteCadastroParticular extends JFrame implements ActionListener{
     // objControlador para esta classe "se comunicar" com a Controle Principal
    private ControlePaciente objControlador;
    
    // declaracao dos paineis, labels, textFields e botoes
    private JPanel painel,p1,p2,p3,p4;
    private JLabel nomeJL,enderecoJL,cpfJL;
    private JTextField nomeTF,enderecoTF,cpfTF;
    private JButton cadastrar;
    
    // construtor do LimiteCadastroParticular passa um obj do tipo ControlePaciente como parametro
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
        // painel "painel" eh o principal desta interface cadastra particular
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
    }// ------------------- CONSTRUTOR TERMINA AQUI ------------------

    // ActionListener para o botao "Cadastrar Paciente"
    @Override
    public void actionPerformed(ActionEvent e) {
         // variaveis para receber os dados digitados
        String nome,endereco,cpf;
        
        // pega os dados digitados
        nome = nomeTF.getText();
        endereco = enderecoTF.getText();
        cpf = cpfTF.getText();
        
        // se um dos campos estiver vazio, retornar msg
        if(nome.isEmpty() || endereco.isEmpty() || cpf.isEmpty())
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!");
        else
        {   // caso todos os campos estejam preenchidos
            // chama a funcao adicionaParticular do controle e passa os parametros na ordem que esta na funcao
            objControlador.adicionaParticular(nome, endereco, cpf);
            JOptionPane.showMessageDialog(this, "Paciente particular cadastrado!");
            super.dispose();
        }
    }
}
