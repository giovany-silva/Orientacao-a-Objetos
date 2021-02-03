
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LimiteAluno extends JFrame implements ActionListener {

    private CtrAluno ctrAluno;
    JMenuBar menu;
    JMenuItem cadAluno, conAluno;
    JPanel p, P1, P2;
    JTextField textField1, textField2, textField3, textField4, textField5;
    JLabel label1, label2, label3, label4, label5;
    JButton ok;
    
    private int dia, mes, ano;
    
    public LimiteAluno() {

        super("Trabalho 13");
        ctrAluno = new CtrAluno();

        JPanel cards = new JPanel(new CardLayout());
        this.getContentPane().add(cards, BorderLayout.CENTER);

        JPanel inicial = new JPanel(new BorderLayout());
        cards.add(inicial, "inicial");

        inicial.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        //cards.add(, "formCadTurma");

        //ConsultaTurma telaConsulta = new ConsultaTurma(listaDisciplina, listaTurma);
        // P1
        P1 = new JPanel();
        cards.add(P1, "CadAluno");

// usar para cadastrar
        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5 = new JTextField(20);

        textField1.addActionListener(this);
        textField2.addActionListener(this);
        textField3.addActionListener(this);
        textField4.addActionListener(this);
        textField5.addActionListener(this);

        label1 = new JLabel("Nome");
        label2 = new JLabel("Numero de matricula");
        label3 = new JLabel("Dia do nascimento");
        label4 = new JLabel("Mes do nascimento");
        label5 = new JLabel("Ano do nascimento");

        P1.add(label1);
        P1.add(textField1);
        
        P1.add(label2);
        P1.add(textField2);
        P1.add(label3);
        P1.add(textField3);
        P1.add(label4);
        P1.add(textField4);
        P1.add(label5);
        P1.add(textField5);
        
        ok=new JButton("OK");
        ok.addActionListener(this);
        P1.add(ok);
        

        //cria painel para consultar aluno
        P2 = new JPanel();

        //P2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(P2, "ConAluno");
    
        JPanel p = new JPanel();
        

        p.setLayout(new FlowLayout());

        JTextArea textArea = new JTextArea();
        label4 = new JLabel("Alunos");

        P2.add(label4);
        P2.add(textArea);

        //this.add(P2, BorderLayout.CENTER);
        //this.setSize(720, 480);
        //this.setLayout(new BorderLayout());
//deixar visivel
        //painel aluno termina aki
        menu = new JMenuBar();
        this.setJMenuBar(menu);
        JMenu turmaMenu = new JMenu("Aluno");
        menu.add(turmaMenu);
        cadAluno = new JMenuItem("Cadastrar");
        conAluno = new JMenuItem("Listar");
        turmaMenu.add(cadAluno);
        turmaMenu.add(conAluno);
        
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        dia = Integer.parseInt(textField3.getText().toString());
         mes = Integer.parseInt(textField4.getText().toString());
         ano = Integer.parseInt(textField5.getText().toString());
                
         
         String data=dia+"/"+mes+"/"+ano;
                try {
                    ctrAluno.insereAluno(textField2.getText(), textField1.getText(),data);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null,"O ano de nascimento deve estar entre 1950  e 2005");           
 }
                
            }
        });
        cadAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardListaAluno = (CardLayout) (cards.getLayout());
                cardListaAluno.show(cards, "CadAluno");
                P1.setVisible(true);
                
            }
        });
        // textArea para menu
        conAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(ctrAluno.listaAlunos());
                CardLayout cardListaAluno = (CardLayout) (cards.getLayout());
                cardListaAluno.show(cards, "ConAluno");
                P2.setVisible(true);

            }
        });
        this.setSize(720, 480);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
