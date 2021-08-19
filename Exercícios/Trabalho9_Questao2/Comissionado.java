
public class Comissionado extends Vendedor {

    private String nroCPF;
    private float comissao;

    public Comissionado(int pcodigo, String pnome, String pnroCPF, float pcomissao) {
        super(pcodigo, pnome);
        this.nroCPF = pnroCPF;
        this.comissao = pcomissao;
    }

    public String getNroCPF() {
        return nroCPF;
    }

    public float getComissao() {
        return comissao;
    }

    @Override
    public String getDados() {
        String Dados = "Nome\tNúmero do CPF\t\n";

        for (int i = 0; i < vendas.size(); i++) {
            Dados += getNome() + "\t" + getNroCPF() + "\t\n";
        }
        return Dados;
    }
    
    @Override
    public double calculaRenda(int pMes, int pAno) {
        double imovelVendido = 0;
        for (int i = 0; i < vendas.size(); i++) {
            Venda venda = vendas.get(i);

            if (venda.getMesVenda() == pMes && venda.getAnoVenda() == pAno) {
                imovelVendido += (getComissao() * venda.getValorVenda())/100;
            }
        }
        return imovelVendido;
    }
}
