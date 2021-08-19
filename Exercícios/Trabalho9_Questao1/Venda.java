
public class Venda {
    private int codImovel, mesVenda, anoVenda;
    private double valorVenda;

    public Venda(int pcodImovel, int pmesVenda, int panoVenda, double pvalorVenda) {
        this.codImovel = pcodImovel;
        this.mesVenda = pmesVenda;
        this.anoVenda = panoVenda;
        this.valorVenda = pvalorVenda;
    }

    public int getCodImovel() {
        return codImovel;
    }

    public int getMesVenda() {
        return mesVenda;
    }

    public int getAnoVenda() {
        return anoVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }
    
    
}
