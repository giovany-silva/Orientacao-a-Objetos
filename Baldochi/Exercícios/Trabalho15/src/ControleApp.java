import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControleApp extends JFrame {

    private ArrayList<Funcionario> listaFun = new ArrayList();
    private ArrayList<Paciente> listaPac = new ArrayList();
    private ArrayList<Cirurgia> listaCirurgia = new ArrayList();

    public ControleApp() {

        super("Centro Cirúrgico");

        listaPac.add(new Paciente(1111, "Marcelo Siqueira"));
        listaPac.add(new Paciente(1112, "Suzana Silva"));
        listaPac.add(new Paciente(1113, "Maria Cintra"));
        listaFun.add(new Medico(1001, "Jose Souza", "Obstetricia"));
        listaFun.add(new Medico(1002, "Marcel Santos", "Cirurgia Geral"));
        listaFun.add(new Medico(1003, "Ana Silveira", "Cirurgia Geral"));
        listaFun.add(new Medico(1004, "Paulo Cruz", "Neurocirurgia"));
        listaFun.add(new Tecnico(1011, "Manoel Paz", "Enfermeiro"));
        listaFun.add(new Tecnico(1012, "Joana Oliveira", "Enfermeiro"));
        listaFun.add(new Tecnico(1013, "Marcos Cintra", "Instrumentador"));
        listaFun.add(new Tecnico(1014, "Cristina Santana", "Instrumentador"));

        JPanel cards = new JPanel(new CardLayout());
        this.getContentPane().add(cards, BorderLayout.CENTER);

        JPanel inicial = new JPanel(new BorderLayout());
        cards.add(inicial, "inicial");

        CriaCirurgia criaCirurgia = new CriaCirurgia(this, listaPac, listaFun);
        criaCirurgia.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(criaCirurgia, "formCadCirurgia");

        ConsultaCirurgia telaConsulta = new ConsultaCirurgia(listaPac, listaCirurgia);
        telaConsulta.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        cards.add(telaConsulta, "cadConCirurgia");

        JMenuBar menu = new JMenuBar();
        this.setJMenuBar(menu);
        JMenu cirurgiaMenu = new JMenu("Cirurgia");
        menu.add(cirurgiaMenu);
        JMenuItem cadCirurgia = new JMenuItem("Cadastrar");
        JMenuItem conCirurgia = new JMenuItem("Consultar");
        cirurgiaMenu.add(cadCirurgia);
        cirurgiaMenu.add(conCirurgia);

        cadCirurgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardCriaCirurgia = (CardLayout) (cards.getLayout());
                cardCriaCirurgia.show(cards, "formCadCirurgia");
            }
        });

        conCirurgia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardConCirurgia = (CardLayout) (cards.getLayout());
                cardConCirurgia.show(cards, "cadConCirurgia");

                String str = "";
                for (Cirurgia c : listaCirurgia) {
                    str += c.getPaciente().getNome() + "\n";
                    str += c.getTipoCirurgia() + "\n";
                    ArrayList<Funcionario> listaFun = c.getListaFun();
                    for (Funcionario f : listaFun) {
                        str += f.getNome() + "\n";
                    }
                    str += "\n";
                }
                //System.out.println(str);

            }
        });

        this.setSize(720, 480);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void insereCirurgia(Cirurgia c) {
        listaCirurgia.add(c);
    }

    public static void main(String[] args) {
        new ControleApp();
    }
}
