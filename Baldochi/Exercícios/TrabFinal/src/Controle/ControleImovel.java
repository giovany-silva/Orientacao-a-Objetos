package Controle;

import Limite.LimiteImovel;
import Model.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JPanel;

public class ControleImovel {

    private ArrayList<Imovel> listaImovel = new ArrayList<>();
    LimiteImovel limImovel;
    ControlePrincipal controlePrincipal;

    public ControleImovel(ControlePrincipal controlePrincipal) {
      //  listaImovel.add(new Imovel(101, Util.CASA, "Casa 3 quartos", "casa-101.jpg", 700000, 5, "05/12/2019", 2001));
       // listaImovel.add(new Imovel(102, Util.CASA, "Casa alto padrao", "casa-102.jpg", 1200000, 4, "05/12/2019", 2002));
       // listaImovel.add(new Imovel(103, Util.APTO, "Apto 3 quartos", "apto-103.jpg", 400000, 5, "05/12/2019", 2003));
       // listaImovel.add(new Imovel(104, Util.APTO, "Apto 2 quartos", "apto-104.jpg", 300000, 4, "05/12/2019", 2001));
        this.controlePrincipal = controlePrincipal;
        limImovel = new LimiteImovel(this, this.controlePrincipal);

    }
   
    public void gravaDados() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("Imovel.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(listaImovel);
        objOS.flush();
        objOS.close();
    }

    public void recuperaDados() throws Exception {
        File objFile = new File("Imovel.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("Imovel.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            listaImovel = (ArrayList) objIS.readObject();
            objIS.close();
        }
    }
    public JPanel getPainelImovel() {
        return limImovel;
    }

    public void cadastraImovel(int codigo, String tipo, String descricao, String arquivoFoto,
            double preco, double comissao, Calendar dataInclusao, Vendedor vendedor) {
        listaImovel.add(new Imovel(codigo, tipo, descricao, arquivoFoto, preco, comissao, dataInclusao, vendedor));
    }

    public ArrayList<Imovel> getListaImovel() {
        return listaImovel;
    }
      //item 6 com arraylist
    /*public ArrayList<Imovel> imovelPorVendedor(String cpf) {
     ArrayList<Imovel> imovelVendedor = new ArrayList<>();
     for (Imovel i : listaImovel) {
     if (cpf.equals(i.getVendedor().getCpf())) {
     imovelVendedor.add(i);
     }
     }
     return imovelVendedor;
     }*/

    //falta mexer no limiteImovel ou limitePrincipal ou controlePrincipal
    //item 6
    public String imovelPorVendedor(String cpf) {
        String imovelVendedor = "";
        //percorre os imoveis
        for (Imovel i : listaImovel) {
            //compara cpf digitado com o do vendedor
            if (cpf.equals(i.getVendedor().getCpf())) {
                imovelVendedor += "Código: " + i.getCodigo()+"        "+"Estado: "
                        + i.getEstado() + "\n";
                //break;
            }
        }
        return imovelVendedor;
    }

    //item 3 feito com arraylist
    //tem que receber datas como parametro
    /*public ArrayList<Imovel> visitasCorretor(String corretor) {
     ArrayList<Imovel> visCorretor = new ArrayList<>();
     //falta checar datas
     //percorre imoveis
     for (Imovel i : listaImovel) {
     //percorre cada visita do imovel acima
     for (Visita v : i.getListaVisitas()) {
     if (corretor.equals(v.getCorretor().getNome())) {
     visCorretor.add(i);
     //falta devolver nome dos compradores da visita
     //visCorretor.add(v.getComprador());
     }
     }
     }
     return visCorretor;
     }*/
    //item 3
    //tem que receber datas como parametro
    public String visitasCorretor(String corretor, Calendar dataIni, Calendar dataFim) {
        String visCorretor = "";
        //falta checar datas
        //percorre imoveis
        for (Imovel i : listaImovel) {
            //percorre cada visita do imovel acima

            for (Visita v : i.getListaVisitas()) {
                //compara nome digitado com nome do corretor
                if (!v.getData().before(dataIni) && !v.getData().after(dataFim)) {
                    if (corretor.equals(v.getCorretor().getNome())) {
                        visCorretor += "Código: " + i.getCodigo() + "Comprador: "
                                + v.getComprador() + "\n";
                        //break;
                    }
                }
            }
        }
        return visCorretor;
    }

    //item 4
    //tem que receber datas como parametro
    public String eventosImovel(Calendar dataIni, Calendar dataFim, int codigo) {
        String lisVisitas = "";
        String propImovel = "";
        //falta checar datas
        //percorre imoveis
        for (Imovel i : listaImovel) {
            //compara codigo dos imoveis

            if (codigo == i.getCodigo()) {
                //percorre lista de visitas e add na string

                for (Visita v : i.getListaVisitas()) {
                    //Deve ser tudo string
                    if (!v.getData().before(dataIni) && !v.getData().after(dataFim)) {
                        lisVisitas += "Data: " + v.getData() + "Corretor: " + v.getCorretor().getNome()
                                + "Comprador: " + v.getComprador().getNome() + "\n";
                    }
                }
                //percorre lista de proposta e add na string
                for (Proposta p : i.getListaPropostas()) {
                    propImovel += "Comprador: " + p.getComprador().getNome() + "Corretor: " + p.getCorretor().getNome()
                            + "Valor: " + p.getValor() + "\n";
                }
                //break;
            }
        }
        return "Visitas\n" + lisVisitas + "\n\n\n" + "Propostas\n" + propImovel;
    }

    //item 5
    //precisa receber datas como parametro
    public String relatorioVendas(Calendar dataIni, Calendar dataFim) {
        String vendidos = "";
        //falta checar datas
        //percorre os imoveis
        for (Imovel i : listaImovel) {
            //checa se está vendido
            if (i.getEstado().equals(Util.VENDIDO)) {
                //percorre as propostas
                for (Proposta p : i.getListaPropostas()) {
                    if (!p.getData().before(dataIni) && !p.getData().after(dataFim)) {

                        if (i.aceitaProposta(p)) {

                            vendidos += "Código: " + i.getCodigo() + " Tipo: " + i.getTipo() + "Descrição: "
                                    + i.getDescricao() + "Arquivo Foto: " + i.getArquivoFoto() + "Preço: "
                                    + i.getPreco() + "Comissão: " + i.getComissao() + "Data inclusão: "
                                    + i.getDataInclusao() + "Vendedor: " + i.getVendedor()
                                    + "Valor de Venda: " + p.getValor() + "\n";
                            break;
                        }
                    }
                }
                //break;
            }
        }
        return vendidos;
    }
}
