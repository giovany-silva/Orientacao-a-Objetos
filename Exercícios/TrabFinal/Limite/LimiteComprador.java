
package Limite;

import Controle.ControleComprador;
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

public class LimiteComprador extends JPanel implements ActionListener{
    //
    private ControleComprador objControladorComprador; 
    JLabel cpfJL, nomeJL, emailJL, foneJL, contatoJL;
    JTextField cpfTF, nomeTF, emailTF, foneTF, contatoTF;
    JButton cadastrar;
    JPanel painelComprador, painelCPF, painelNome, painelEmail, painelFone, painelContato;

    public LimiteComprador(ControleComprador objControladorComprador) {
        this.objControladorComprador = objControladorComprador;

        //
        cpfJL = new JLabel("CPF:");
        nomeJL = new JLabel("Nome:");
        emailJL = new JLabel("Email:");
        foneJL = new JLabel("Telefone:");
        contatoJL = new JLabel("Contato:");

        //
        cpfTF = new JTextField(15);
        nomeTF = new JTextField(50);
        emailTF = new JTextField(20);
        foneTF = new JTextField(15);
        contatoTF = new JTextField(20);
        
        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(this);
        
        painelComprador = new JPanel();
        painelComprador.setLayout(new BoxLayout(painelComprador, BoxLayout.Y_AXIS));

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
        painelContato = new JPanel();
        painelContato.setLayout(new FlowLayout());
        painelContato.setAlignmentX(0.5f);

        //
        painelCPF.add(cpfJL);
        painelCPF.add(cpfTF);
        painelNome.add(nomeJL);
        painelNome.add(nomeTF);
        painelEmail.add(emailJL);
        painelEmail.add(emailTF);
        painelFone.add(foneJL);
        painelFone.add(foneTF);
        painelContato.add(contatoJL);
        painelContato.add(contatoTF);

        painelComprador.add(painelCPF);
        painelComprador.add(Box.createVerticalGlue());
        painelComprador.add(painelNome);
        painelComprador.add(Box.createVerticalGlue());
        painelComprador.add(painelEmail);
        painelComprador.add(Box.createVerticalGlue());
        painelComprador.add(painelFone);
        painelComprador.add(Box.createVerticalGlue());
        painelComprador.add(painelContato);
        painelComprador.add(Box.createVerticalGlue());
        painelComprador.add(cadastrar);
        
        //super.setTitle("Cadastrar Comprador");
        super.add(painelComprador);
        super.setSize(1280, 720);
        //super.setAlwaysOnTop(true);
        //super.setResizable(false);
        //super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    public LimiteComprador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        String identificarContato = "";
        
        if(botaoAux.equals(cadastrar)){
            identificarCpf = cpfTF.getText();
            identificarNome = nomeTF.getText();
            identificarEmail = emailTF.getText();
            identificarFone = foneTF.getText();
            identificarContato = contatoTF.getText();
            
            if(identificarCpf.isEmpty() || identificarNome.isEmpty() || identificarEmail.isEmpty() || identificarFone.isEmpty() || identificarContato.isEmpty()){
                JOptionPane.showMessageDialog(this, "Não foram informados todos os campos");
                }
            else{
                objControladorComprador.cadastrarComprador(identificarCpf,identificarNome,identificarEmail,identificarFone,identificarContato);
                JOptionPane.showMessageDialog(this, "Vendedor cadastrado");
            }
        }
    }
    
}
