
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Aluno extends JPanel implements ActionListener {
    private String Nome, nroMatric,Data;
   
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setNroMatric(String nroMatric) {
        this.nroMatric = nroMatric;
    }

    public void setData(String data) {
        this.Data = data;
    }

    public String getNome() {
        return Nome;
    }

    public String getNroMatric() {
        return nroMatric;
    }

    public String getData() {
        return Data;
    }

    public Aluno(String Nome, String nroMatric, String data) throws Exception {
      if (Integer.parseInt(data.substring(6, 10)) < 1950 || Integer.parseInt(data.substring(6, 10))> 2005) {
           
           throw new Exception("O ano de nascimento deve estar entre 1950  e 2005.");
      
    }
        this.Nome = Nome;
        this.nroMatric = nroMatric;
        this.Data = data;
    }

    public Aluno() {
    }
    
    // fazer a validação do ano de nascimento
    

    @Override
    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
