
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CriaDisciplina extends JPanel implements ActionListener  {
ControleApp ctrl;
ControleDisciplina ctrdisc;
   private JTextField textField,textField2;
   JButton button;
CriaDisciplina(ControleApp pCtrl)
{   ctrdisc=new ControleDisciplina();
ctrl = pCtrl;
        this.setSize(720, 480);
        this.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        
        JLabel label = new JLabel("Digite o nome da disciplina "),label2 = new JLabel("Digite o código da disciplina ");
        
        textField = new JTextField(20);
        textField.addActionListener(this);
        p.add(label);
        p.add(textField);
        
        textField2 = new JTextField(20);
        textField2.addActionListener(this);
        p.add(label2);
        p.add(textField2);
         button=new JButton("OK");
        p.add(button);
        button.addActionListener(this);
        this.add(p, BorderLayout.CENTER);
   button.addActionListener(new ActionListener()
{

    @Override
    public void actionPerformed(ActionEvent e) {
    //    ctrdisc.insereDisciplina();
    //seria o correto
        Disciplina d=new Disciplina(Integer.parseInt(textField2.getText()), textField.getText());
        ctrl.getListaDisciplina().add(d);
        JOptionPane.showMessageDialog(null,"Disciplina cadastrada!");
    }




});             
}
   

    @Override
    public void actionPerformed(ActionEvent e) {
      
    }
    
}
