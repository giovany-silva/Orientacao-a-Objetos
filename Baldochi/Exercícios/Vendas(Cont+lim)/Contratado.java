
public class Contratado extends Vendedor {

    private String nroCartTrabalho;
    private double salarioFixo;
    private static final float comissao = 0;

    public Contratado(int pcodigo, String pnome, double psalarioFixo, String pnroCartTrabalho) {
        super(pcodigo, pnome);
        this.nroCartTrabalho = pnroCartTrabalho;
        this.salarioFixo = psalarioFixo;
    }

    public String getNroCartTrabalho() {
        return nroCartTrabalho;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    @Override
    public String getDados() {
        String Dados = "Nome\tNúmero da Carteira\t\n";
        for (int i = 0; i < vendas.size(); i++) {
            Dados += getNome() + "\t" + getNroCartTrabalho() + "\t\n";
        }
        return Dados;
    }

    @Override
    public double calculaRenda(int pMes, int pAno) {
        double imovelVendido = 0;
        for (int i = 0; i < vendas.size(); i++) {
            Venda venda = vendas.get(i);
            if (venda.getMesVenda() == pMes && venda.getAnoVenda() == pAno) {
                imovelVendido += venda.getValorVenda();
            }
        }
        return (getSalarioFixo() + (0.01 * imovelVendido));
    }

}
