package Controle;

import Limite.LimiteComprador;
import Model.Comprador;
import Model.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ControleComprador {

    private ArrayList<Comprador> listaComprador = new ArrayList<>();
    LimiteComprador limComprador;
    ControlePrincipal controlePrincipal;

    public ControleComprador(ControlePrincipal controlePrincipal) {
        listaComprador.add(new Comprador("3001", "Ana Carvalho", "ana@gmail.com", "777770001", Util.FONE));
        listaComprador.add(new Comprador("3002", "Caio Oliveira", "caio@gmail.com", "777770002", Util.EMAIL));
        listaComprador.add(new Comprador("3003", "Pedro Silva", "pedro@gmail.com", "777770003", Util.FONE));
        listaComprador.add(new Comprador("3004", "Clara Maia", "clara@gmail.com", "777770004", Util.EMAIL));
        limComprador = new LimiteComprador(this);
        this.controlePrincipal = controlePrincipal;
    }

    public void gravaDados() throws Exception {
    FileOutputStream objFileOS = new FileOutputStream("Comprador.dat");
    ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
    objOS.writeObject(listaComprador);
    objOS.flush();
    objOS.close();
  }
  public void recuperaDados() throws Exception {
    File objFile = new File("Comprador.dat");
    if (objFile.exists()) {
      FileInputStream objFileIS = new FileInputStream("Comprador.dat");
      ObjectInputStream objIS = new ObjectInputStream(objFileIS);
      listaComprador= (ArrayList)objIS.readObject();
      objIS.close();
    }
  }
    public JPanel getPainelComprador() {
        return limComprador;
    }

    public void cadastrarComprador(String cpf, String nome, String email, String fone,
            String contatoPref) {
        listaComprador.add(new Comprador(cpf, nome, email, fone, contatoPref));
    }
}
