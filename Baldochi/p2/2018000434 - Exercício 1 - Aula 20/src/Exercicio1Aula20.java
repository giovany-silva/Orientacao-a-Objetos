
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercicio1Aula20 extends JFrame implements ActionListener {

    private JPanel Painel;
    private Container contentPane;
    private ArrayList<JButton> numeros;
    private JButton J1, J2, J3, J4, J5, J6;
    private JButton B0, B1, B2, B3, B4, B5, B6, B7, B8, B9;
    JTextField T = new JTextField(30);
    private int estado,operando1,operando2;
    private float dividendo,divisor;

    public Exercicio1Aula20() {

        super("Testa Calculadora");
        //painel com texto
        JPanel p1 = new JPanel();
        T.setPreferredSize(new Dimension(240, 40));
        p1.add(T);

        //painel com números
        JPanel p2 = new JPanel();
        p2.setSize(200, 200);
        p2.setLayout(new GridLayout(4, 4, 5, 5));
        
            B0 = new JButton("" + 0);
            B0.setPreferredSize(new Dimension(60, 60));
            B0.addActionListener(this);
            p2.add(B0);
            
            B1 = new JButton("" + 1);
            B1.setPreferredSize(new Dimension(60, 60));
            B1.addActionListener(this);
            p2.add(B1);
            
            B2 = new JButton("" + 2);
            B2.setPreferredSize(new Dimension(60, 60));
            B2.addActionListener(this);
            p2.add(B2);
            
            B3 = new JButton("" + 3);
            B3.setPreferredSize(new Dimension(60, 60));
            B3.addActionListener(this);
            p2.add(B3);
            
            B4 = new JButton("" + 4);
            B4.setPreferredSize(new Dimension(60, 60));
            B4.addActionListener(this);
            p2.add(B4);
            
            B5 = new JButton("" + 5);
            B5.setPreferredSize(new Dimension(60, 60));
            B5.addActionListener(this);
            p2.add(B5);
            
            B6 = new JButton("" + 6);
            B6.setPreferredSize(new Dimension(60, 60));
            B6.addActionListener(this);
            p2.add(B6);
            
            B7 = new JButton("" + 7);
            B7.setPreferredSize(new Dimension(60, 60));
            B7.addActionListener(this);
            p2.add(B7);
            
            B8 = new JButton("" + 8);
            B8.setPreferredSize(new Dimension(60, 60));
            B8.addActionListener(this);
            p2.add(B8);
            
            B9 = new JButton("" + 9);
            B9.setPreferredSize(new Dimension(60, 60));
            B9.addActionListener(this);
            p2.add(B9);
            
            
        
        //botões de cálculo

        J1 = new JButton("+");
        J1.setPreferredSize(new Dimension(60, 60));
        J1.addActionListener(this);
        p2.add(J1);

        J2 = new JButton("-");
        J2.setPreferredSize(new Dimension(60, 60));
        J2.addActionListener(this);
        p2.add(J2);

        J3 = new JButton("x");
        J3.setPreferredSize(new Dimension(60, 60));
        J3.addActionListener(this);
        p2.add(J3);

        J4 = new JButton("/");
        J4.setPreferredSize(new Dimension(60, 60));
        J4.addActionListener(this);
        p2.add(J4);

        J5 = new JButton("=");
        J5.setPreferredSize(new Dimension(60, 60));
        J5.addActionListener(this);
        p2.add(J5);
        
        J6 = new JButton("C");
        J6.setPreferredSize(new Dimension(60, 60));
        J6.addActionListener(this);
        p2.add(J6);

        //painel principal
        this.Painel = new JPanel();

        this.Painel.add(p1);
        this.Painel.add(p2);

        this.add(Painel);

        this.setSize(375, 400);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==B0){
            T.setText(T.getText()+"0");
        }
        if(e.getSource()==B1){
            T.setText(T.getText()+"1");
        }
        if(e.getSource()==B2){
            T.setText(T.getText()+"2");
        }
        if(e.getSource()==B3){
            T.setText(T.getText()+"3");
        }
        if(e.getSource()==B4){
            T.setText(T.getText()+"4");
        }
        if(e.getSource()==B5){
            T.setText(T.getText()+"5");
        }
        if(e.getSource()==B6){
            T.setText(T.getText()+"6");
        }
        if(e.getSource()==B7){
            T.setText(T.getText()+"7");
        }
        if(e.getSource()==B8){
            T.setText(T.getText()+"8");
        }
        if(e.getSource()==B9){
            T.setText(T.getText()+"9");
        }
        if(e.getSource()==J1){
            operando1=Integer.parseInt(T.getText());
            estado = 1;
            T.setText("");
        }
        if(e.getSource()==J2){
            operando1=Integer.parseInt(T.getText());
            estado = 2;
            T.setText("");
        }
        if(e.getSource()==J3){
            operando1=Integer.parseInt(T.getText());
            estado = 3;
            T.setText("");
        }
        if(e.getSource()==J4){
            dividendo=Integer.parseInt(T.getText());
            estado = 4;
            T.setText("");
        }
        if(e.getSource()==J5){
            divisor=Float.parseFloat(T.getText());
            operando2=Integer.parseInt(T.getText());
            if(estado==1){
                T.setText(""+(operando1+operando2));
            }
            else{
                if(estado==2){
                    T.setText(""+(operando1-operando2));
                }
                else{
                    if(estado==3){
                        T.setText(""+(operando1*operando2));
                    }
                    else{
                        divisor=Float.parseFloat(T.getText());
                        T.setText(""+(dividendo/divisor));
                    }
                }
            }
        }
        if(e.getSource()==J6){
           T.setText(""); 
        }
    }
    
    public static void main(String args[]){
        new Exercicio1Aula20();
    }
}
