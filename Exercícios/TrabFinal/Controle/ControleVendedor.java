package Controle;

import Limite.LimiteVendedor;
import Model.Util;
import Model.Vendedor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ControleVendedor {

    private ArrayList<Vendedor> listaVendedor = new ArrayList<>();
    LimiteVendedor limVendedor;
    ControlePrincipal controlePrincipal;

    public ControleVendedor(ControlePrincipal controlePrincipal) {

        listaVendedor.add(new Vendedor("2001", "Marina Cintra", "marina@gmail.com", "888880001", Util.FONE));
        listaVendedor.add(new Vendedor("2002", "Andre Cruz", "andre@gmail.com", "888880002", Util.FONE));
        listaVendedor.add(new Vendedor("2003", "Felipe Antunes", "felipe@gmail.com", "888880003", Util.EMAIL));
        limVendedor = new LimiteVendedor(this);
        this.controlePrincipal = controlePrincipal;
    }
     public void gravaDados() throws Exception {
    FileOutputStream objFileOS = new FileOutputStream("Imovel.dat");
    ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
    objOS.writeObject(listaVendedor);
    objOS.flush();
    objOS.close();
  }
  public void recuperaDados() throws Exception {
    File objFile = new File("Vendedor.dat");
    if (objFile.exists()) {
      FileInputStream objFileIS = new FileInputStream("Vendedor.dat");
      ObjectInputStream objIS = new ObjectInputStream(objFileIS);
      listaVendedor= (ArrayList)objIS.readObject();
      objIS.close();
    }
  }

    public JPanel getPainelVendedor() {
        return limVendedor;
    }

    public ArrayList<Vendedor> getListaVendedor() {
        return listaVendedor;
    }

    public void cadastrarVendedor(String cpf, String nome, String email, String fone,
            String contatoPref) {
        listaVendedor.add(new Vendedor(cpf, nome, email, fone, contatoPref));
    }

}
