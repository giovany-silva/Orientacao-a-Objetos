
import java.util.ArrayList;

public abstract class Vendedor {

    private int codigo;
    private String nome;

    ArrayList<Venda> vendas = new ArrayList<>();

    public Vendedor(int pcodigo, String pnome) {
        this.codigo = pcodigo;
        this.nome = pnome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public void adicionaVenda(int pCodImovel, int pMes, int pAno, double pValor) {
        Venda venda = new Venda(pCodImovel, pMes, pAno, pValor);
        
        vendas.add(venda);
    }

    public abstract String getDados();

    public abstract double calculaRenda(int pMes, int pAno);
}
