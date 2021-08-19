package Controle;

import Limite.LimiteCorretor;
import Model.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;

public class ControleCorretor {

    private ArrayList<Corretor> listaCorretor = new ArrayList<>();
    LimiteCorretor limCorretor;
    ControlePrincipal controlePrincipal;
    ArrayList<Proposta> listaProposta;

    public ControleCorretor(ControlePrincipal controlePrincipal) {
        listaCorretor.add(new Corretor("1001", "Joao Santos", "joao@gmail.com", "999990001", "10001", 50));
        listaCorretor.add(new Corretor("1002", "Luiz Souza", "luiz@gmail.com", "999990002", "10002", 40));
        
        limCorretor = new LimiteCorretor(this);
        this.controlePrincipal = controlePrincipal;
    }
   
    public void gravaDados() throws Exception {
    FileOutputStream objFileOS = new FileOutputStream("Corretor.dat");
    ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
    objOS.writeObject(listaCorretor);
    objOS.flush();
    objOS.close();
  }
  public void recuperaDados() throws Exception {
    File objFile = new File("Corretor.dat");
    if (objFile.exists()) {
      FileInputStream objFileIS = new FileInputStream("Corretor.dat");
      ObjectInputStream objIS = new ObjectInputStream(objFileIS);
      listaCorretor= (ArrayList)objIS.readObject();
      objIS.close();
    }
  }
    public JPanel getPainelCorretor() {
        return limCorretor;
    }

    public void cadastrarCorretor(String cpf, String nome, String email, String fone,
            String creci, double percCorretagem) {
        listaCorretor.add(new Corretor(cpf, nome, email, fone, creci, percCorretagem));
    }

    public String visitasCorretor() {
        ArrayList<Imovel> listaImovel = controlePrincipal.getInstanciaControleImovel().getListaImovel();

        String visitas = "";
        //verifica quais imóveis ele visitou
        for (Imovel i : listaImovel) {

            ArrayList<Visita> listaVisita = i.getListaVisitas();
            //verifica quais visitas foram realizadas por ele no Imóvel
            for (Visita v : listaVisita) {

                visitas += v.getData() + " " + v.getComprador() + " " + v.getCorretor() + " "
                        + v.getEstado() + "\n";

            }

        }
        return visitas;
    }

    public ArrayList<Corretor> getListaCorretor() {
        return listaCorretor;
    }

    //Item 1
    public double calculaFatCorretores(Calendar dataIni, Calendar dataFim) {

        double FatCorretores = 0;

        ArrayList<Corretor> listaCorretor = getListaCorretor();
        ArrayList<Imovel> listaImovel = controlePrincipal.getInstanciaControleImovel().getListaImovel();

        for (Corretor c : listaCorretor) {

            //FatImoveis+=p.getValor()*i.getComissao();
            for (Imovel i : listaImovel) {

                listaProposta = i.getListaPropostas();

                for (Proposta p : listaProposta) {

                    //se data atual nao estiver antes da inicial e nem depois da final
                    if (!p.getData().before(dataIni) && !p.getData().after(dataFim)) {
                        if (i.aceitaProposta(p) && p.getCorretor().getNome() == c.getNome()) {
                            //porcentagem do total destinado a corretor
                            FatCorretores += p.getValor() * i.getComissao() * c.getPercCorretagem();
                            break;
                        }
                    }

                }
            }

        }
        return FatCorretores;
    }

    //Item 1
    public double calculaFatTotal(Calendar dataIni, Calendar dataFim) {
        double FatImobiliaria = 0;

        ArrayList<Imovel> listaImovel = controlePrincipal.getInstanciaControleImovel().getListaImovel();

        //FatImoveis+=p.getValor()*i.getComissao();
        for (Imovel i : listaImovel) {
            listaProposta = i.getListaPropostas();
            for (Proposta p : listaProposta) {
                if (!p.getData().before(dataIni) && !p.getData().after(dataFim)) {
                    if (i.aceitaProposta(p)) {
                        //porcentagem do total destinado a imobiliaria
                        FatImobiliaria += p.getValor() * i.getComissao();
                        break;
                    }
                }
            }
        }

        return FatImobiliaria;
    }

    //Item 1
    public double calculaFatCorretor(String nome, String creci, Calendar dataIni, Calendar dataFim) {
        double FatCorretor = 0;

        ArrayList<Corretor> listaCorretor = getListaCorretor();
        ArrayList<Imovel> listaImovel = controlePrincipal.getInstanciaControleImovel().getListaImovel();

        for (Corretor c : listaCorretor) {

            //FatImoveis+=p.getValor()*i.getComissao();
            if (c.getNome().equals(nome) && c.getCreci().equals(creci)) {
                for (Imovel i : listaImovel) {
                    listaProposta = i.getListaPropostas();
                    for (Proposta p : listaProposta) {
                        if (!p.getData().before(dataIni) && !p.getData().after(dataFim)) {
                            if (i.aceitaProposta(p) && p.getCorretor().getNome() == c.getNome()) {
                                //porcentagem do total destinado a corretor
                                FatCorretor += p.getValor() * i.getComissao() * c.getPercCorretagem();
                                break;
                            }
                        }
                    }
                }
                break;
            }

        }
        return FatCorretor;
    }

    //Item 2
    public double calculaFatTotalImobiliaria(Calendar dataIni, Calendar dataFim) {

        return calculaFatTotal(dataIni, dataFim) - calculaFatCorretores(dataIni, dataFim);

    }
}
