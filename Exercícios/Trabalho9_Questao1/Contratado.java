
public class Contratado extends Vendedor{
    private String nroCartTrabalho;
    private double salarioFixo;
    private static final float comissao = 0;

    public Contratado(String pnroCartTrabalho, double psalarioFixo, int pcodigo, String pnome) {
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
    public String getDados(){
        String Dados = "Nome\tNúmero da Carteira\t\n";
        
        for(int i = 0; i < vendas.size(); i++){
            Vendas ve = vendas.get(i);
            
            if(ve.getMesVenda == mesVenda && ve.getAnoVenda == anoVenda){
                Dados += getNome()+ "\t" +getNroCartTrabalho()+ "\t\n";
            }
        }
        return Dados;
    }
    public double calculaRenda(int pMes, int pAno){
        for(int i = 0; i < vendas.size(); i++){
            Venda venda = vendas.get(i);
            
            if(venda.getMesVenda() == mesVenda && venda.getAnoVenda() == anoVenda){
                //nao sei oq vai fazer aqui dentro
            }
        }
        return valorVenda + (0.01 * valorVenda);
    }
    
}
