package Limite;

import Controle.ControleVendedor;
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

public class LimiteVendedor extends JPanel implements ActionListener {

    //
    private ControleVendedor objControladorVendedor;
    JLabel cpfJL, nomeJL, emailJL, foneJL, contatoJL;
    JTextField cpfTF, nomeTF, emailTF, foneTF, contatoTF;
    JButton cadastrar;
    JPanel painelVendedor, painelCPF, painelNome, painelEmail, painelFone, painelContato;

    public LimiteVendedor(ControleVendedor objControladorVendedor) {
        this.objControladorVendedor = objControladorVendedor;

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
        painelVendedor = new JPanel();
        painelVendedor.setLayout(new BoxLayout(painelVendedor, BoxLayout.Y_AXIS));

        painelCPF = new JPanel();
        painelCPF.setLayout(new FlowLayout());
        //painelCPF.setAlignmentX(0.5f);
        //painelCPF.setAlignmentY(5.0f);
        painelNome = new JPanel();
        painelNome.setLayout(new FlowLayout());
        painelNome.setAlignmentX(0.5f);
        painelNome.setAlignmentY(1.0f);
        painelEmail = new JPanel();
        painelEmail.setLayout(new FlowLayout());
        painelEmail.setAlignmentX(0.5f);
        painelEmail.setAlignmentY(10.0f);

        painelFone = new JPanel();
        painelFone.setLayout(new FlowLayout());
        painelFone.setAlignmentX(0.5f);
        painelFone.setAlignmentY(5.0f);
        painelContato = new JPanel();
        painelContato.setLayout(new FlowLayout());
        painelContato.setAlignmentX(0.5f);
        painelContato.setAlignmentX(5.0f);
        cadastrar.setAlignmentX(0.5f);
        cadastrar.setAlignmentX(5.0f);

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

        painelVendedor.add(painelCPF);
        painelVendedor.add(Box.createVerticalGlue());
        painelVendedor.add(painelNome);
        painelVendedor.add(Box.createVerticalGlue());
        painelVendedor.add(painelEmail);
        painelVendedor.add(Box.createVerticalGlue());
        painelVendedor.add(painelFone);
        painelVendedor.add(Box.createVerticalGlue());
        painelVendedor.add(painelContato);
        painelVendedor.add(Box.createVerticalGlue());
        painelVendedor.add(cadastrar);

        //this.setTitle("Cadastrar Vendedor");
        this.add(painelVendedor);
        this.setSize(1280, 720);
        //this.setAlwaysOnTop(true);
        //super.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setVisible(true);
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

        if (botaoAux.equals(cadastrar)) {
            identificarCpf = cpfTF.getText();
            identificarNome = nomeTF.getText();
            identificarEmail = emailTF.getText();
            identificarFone = foneTF.getText();
            identificarContato = contatoTF.getText();

            if (identificarCpf.isEmpty() || identificarNome.isEmpty() || identificarEmail.isEmpty() || identificarFone.isEmpty() || identificarContato.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não foram informados todos os campos");
            } else {
                objControladorVendedor.cadastrarVendedor(identificarCpf, identificarNome, identificarEmail, identificarFone, identificarContato);
                JOptionPane.showMessageDialog(this, "Vendedor cadastrado");
            }
        }
    }
}
