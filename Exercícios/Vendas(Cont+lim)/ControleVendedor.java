
import java.util.*;
import javax.swing.*;

public class ControleVendedor {

    private ArrayList<Vendedor> vendedores = new ArrayList<>();
    private LimiteVendedor objLimVendedor;

    public ControleVendedor() {
        this.objLimVendedor = new LimiteVendedor(this);
    }


    public void insereContratado(int pcodigo, String pnome, double psalarioFixo, String pnroCartTrabalho) {
        Contratado contr = new Contratado(pcodigo, pnome, psalarioFixo, pnroCartTrabalho);
        vendedores.add(contr);
    }

    public void insereComissionado(int pcodigo, String pnome, String pnroCPF, float pcomissao) {
        Comissionado comis = new Comissionado(pcodigo, pnome, pnroCPF, pcomissao);
        vendedores.add(comis);
    }

    public void insereVenda(int pCodigo, int pCodImovel, int pMes, int pAno, double pValor) {
        for (Vendedor v : vendedores) {
            if (v.getCodigo() == pCodigo) {
                v.adicionaVenda(pCodImovel, pMes, pAno, pValor);
            }
        }
    }

    public JTextArea imprimeFolha(int pMes, int pAno) {
        int flag = 1;
        JTextArea texto = new JTextArea();
        String result = "Mês: " + pMes + " | Ano: " + pAno + "\n";
        for (Vendedor v : vendedores) {
            for (Venda ve : v.getVendas()) {
                if (pMes == ve.getMesVenda() && pAno == ve.getAnoVenda()) {
                    result += "\n" + v.getNome() + " obteve a renda de : " + v.calculaRenda(pMes, pAno);
                    flag = 0;
                    break;
                }
            }
        }
        if (flag == 1) {
            result += "\nNão existem vendas registradas nesse período!";
        }
        texto.setText(result);
        return texto;
    }

    public static void main(String args[]) {
        new ControleVendedor();
    }
}
