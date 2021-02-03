package trabalho_13;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LimiteAluno extends JFrame {

    private CrtAluno objCtrPrincipal;
    public JPanel cards;

    public LimiteAluno(CrtAluno objCtrPrin) {
        // Criação da JFrame
        super("Alunos");
        this.setSize(900, 400);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        objCtrPrincipal = objCtrPrin;

        // Listener para fechar e serializar os dados --------------------------
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    objCtrPrincipal.finalize();
                    System.exit(0);
                } catch (Exception y) {
                    System.exit(0);
                }

            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        //----------------------------------------------------------------------

        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);

        JMenu AlunoMenu = new JMenu("Aluno");
        menu.add(AlunoMenu);

        //----------------------------------------------------------------------
        JMenuItem cadAluno = new JMenuItem("Cadastrar");
        AlunoMenu.add(cadAluno);

        JMenuItem ListaAluno = new JMenuItem("Listar Alunos");
        AlunoMenu.add(ListaAluno);

        // Cards de ações ------------------------------------------------------
        cards = new JPanel(new CardLayout());
        this.add(cards, BorderLayout.CENTER);

        JPanel inicial = new JPanel(new BorderLayout());
        cards.add(inicial, "Tela Principal");

        JPanel auxiliar = new JPanel();
        auxiliar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cards.add(auxiliar, "Auxiliar");

        // Cards para adicionar ------------------------------------------------ 
        // Painel do cadastrar aluno 
        JPanel p1 = new JPanel(new FlowLayout());

        JLabel textnome = new JLabel("Digite o nome:");
        JLabel textmatricula = new JLabel("Digite a matricula:");
        JLabel textdia = new JLabel("Digite Dia de nascimento:");
        JLabel textmes = new JLabel("Digite Mês de nascimento:");
        JLabel textano = new JLabel("Digite Ano de nascimento:");

        JTextField Nome = new JTextField(30);
        JTextField Matricula = new JTextField(20);
        JTextField dia = new JTextField(6);
        JTextField mes = new JTextField(6);
        JTextField ano = new JTextField(6);

        JButton Cadastrar = new JButton("Cadastrar");
        p1.add(textnome);
        p1.add(Nome);
        p1.add(textmatricula);
        p1.add(Matricula);
        p1.add(textdia);
        p1.add(dia);
        p1.add(textmes);
        p1.add(mes);
        p1.add(textano);
        p1.add(ano);
        p1.add(Cadastrar);
        cards.add(p1, "Cadastrar Aluno");

        Cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(ano.getText()) > 1950 && Integer.parseInt(ano.getText()) < 2005) {
                        objCtrPrincipal.CriaAluno(Nome.getText(), Matricula.getText(), Integer.parseInt(dia.getText()), Integer.parseInt(mes.getText()), Integer.parseInt(ano.getText()));
                        JOptionPane.showMessageDialog(null, "Cadastro correto!");
                    } else {
                        JOptionPane.showMessageDialog(null, "A idade tem que ser entre 1950 e 2005, digite novamente!");
                        Matricula.setText("");
                        dia.setText("");
                        mes.setText("");
                        ano.setText("");
                    }

                } catch (Exception t) {
                    JOptionPane.showMessageDialog(null, "Erro! Tente novamente !");

                    Matricula.setText("");
                    dia.setText("");
                    mes.setText("");
                    ano.setText("");

                }
            }
        });

        //Painel da Busca
        JPanel p2 = new JPanel(new FlowLayout());

        JTextArea area = new JTextArea();
        p2.add(area);

        cards.add(p2, "Listar Alunos");

        // Ações dos submenus -----------------------------------------------------
        cadAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardAluno = (CardLayout) (cards.getLayout());
                cardAluno.show(cards, "Cadastrar Aluno");
            }
        });

        ListaAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText(objCtrPrincipal.Listagem());
                CardLayout ListaAluno = (CardLayout) (cards.getLayout());
                ListaAluno.show(cards, "Listar Alunos");
            }
        });

    }
}
