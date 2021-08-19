
package Limite;

import Controle.ControleCorretor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LimiteCorretor extends JPanel implements ActionListener{
    //
    private ControleCorretor objControladorCorretor; 
    JLabel cpfJL, nomeJL, emailJL, foneJL, creciJL, percCorretagemJL;
    JTextField cpfTF, nomeTF, emailTF, foneTF, creciTF, percCorretagemTF;
    JButton cadastrar;
    JPanel painelCorretor, painelCPF, painelNome, painelEmail, painelFone, painelCreci, painelpercCorretagem;

    public LimiteCorretor(ControleCorretor objControladorCorretor) {
        this.objControladorCorretor = objControladorCorretor;

        //
        cpfJL = new JLabel("CPF:");
        nomeJL = new JLabel("Nome:");
        emailJL = new JLabel("Email:");
        foneJL = new JLabel("Telefone:");
        creciJL = new JLabel("Contato:");
        percCorretagemJL = new JLabel("Porcentagem da Coretagem");

        //
        cpfTF = new JTextField(15);
        nomeTF = new JTextField(50);
        emailTF = new JTextField(20);
        foneTF = new JTextField(15);
        creciTF = new JTextField(20);
        percCorretagemTF = new JTextField(15);
        
        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(this);
        
        painelCorretor = new JPanel();
        painelCorretor.setLayout(new BoxLayout(painelCorretor, BoxLayout.Y_AXIS));
        
        //
        painelCPF = new JPanel();
        painelCPF.setLayout(new FlowLayout());
        painelCPF.setAlignmentX(0.5f);
        painelNome = new JPanel();
        painelNome.setLayout(new FlowLayout());
        painelNome.setAlignmentX(0.5f);
        painelEmail = new JPanel();
        painelEmail.setLayout(new FlowLayout());
        painelEmail.setAlignmentX(0.5f);
        painelFone = new JPanel();
        painelFone.setLayout(new FlowLayout());
        painelFone.setAlignmentX(0.5f);
        painelCreci = new JPanel();
        painelCreci.setLayout(new FlowLayout());
        painelCreci.setAlignmentX(0.5f);
        painelpercCorretagem = new JPanel();
        painelpercCorretagem.setLayout(new FlowLayout());
        painelpercCorretagem.setAlignmentX(0.5f);
        

        //
        painelCPF.add(cpfJL);
        painelCPF.add(cpfTF);
        painelNome.add(nomeJL);
        painelNome.add(nomeTF);
        painelEmail.add(emailJL);
        painelEmail.add(emailTF);
        painelFone.add(foneJL);
        painelFone.add(foneTF);
        painelCreci.add(creciJL);
        painelCreci.add(creciTF);
        painelpercCorretagem.add(percCorretagemJL);
        painelpercCorretagem.add(percCorretagemTF);
        
        

        painelCorretor.add(painelCPF);
        painelCorretor.add(Box.createVerticalGlue());
        painelCorretor.add(painelNome);
        painelCorretor.add(Box.createVerticalGlue());
        painelCorretor.add(painelEmail);
        painelCorretor.add(Box.createVerticalGlue());
        painelCorretor.add(painelFone);
        painelCorretor.add(Box.createVerticalGlue());
        painelCorretor.add(painelCreci);
        painelCorretor.add(Box.createVerticalGlue());
        painelCorretor.add(cadastrar);
        painelCorretor.add(painelpercCorretagem);
        painelCorretor.add(Box.createVerticalGlue());
        painelCorretor.add(cadastrar);
        
       // super.setTitle("Cadastrar Corretor");
        super.add(painelCorretor);
        super.setSize(1280, 720);
        //super.setAlwaysOnTop(true);
        //super.setResizable(false);
        //super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // criacao de um botao auxiliar 
        JButton botaoAux = (JButton) e.getSource();
        
        // criacao de uma string para verificar se foram informados dados
        String identificarCpf = "";
        String identificarNome = "";
        String identificarEmail = "";
        String identificarFone = "";
        String identificarCreci = "";
        String identificarCorretagem = "";
        
        if(botaoAux.equals(cadastrar)){
            identificarCpf = cpfTF.getText();
            identificarNome = nomeTF.getText();
            identificarEmail = emailTF.getText();
            identificarFone = foneTF.getText();
            identificarCreci = creciTF.getText();
            identificarCorretagem = percCorretagemTF.getText();
            
            if(identificarCpf.isEmpty() || identificarNome.isEmpty() || identificarEmail.isEmpty() || identificarFone.isEmpty() || identificarCreci.isEmpty() || identificarCorretagem.isEmpty()){
                JOptionPane.showMessageDialog(this, "Não foram informados todos os campos");
                }
            else{
                // criacao dessa variavel para converter de string para double
                double idCorretagem = Double.parseDouble(identificarCorretagem);
                
                objControladorCorretor.cadastrarCorretor(identificarCpf,identificarNome,identificarEmail,identificarFone,identificarCreci, idCorretagem);
                JOptionPane.showMessageDialog(this, "Vendedor cadastrado");
            }
        }
    }
}
