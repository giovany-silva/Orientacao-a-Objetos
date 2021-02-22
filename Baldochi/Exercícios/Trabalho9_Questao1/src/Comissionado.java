
public class Comissionado extends Vendedor{
    private String nroCPF;
    private float comissao;

    public Comissionado(String pnroCPF, float pcomissao, int pcodigo, String pnome) {
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
    public String getDados(){
        String Dados = "Nome\tNúmero do CPF\t\n";
        
        for(int i = 0; i < vendas.size(); i++){
            Vendas v = vendas.get(i);
            
            if(v.getMesVenda == mesVenda && v.getAnoVenda == anoVenda){
                Dados += getNome()+ "\t" +getNroCPF()+ "\t\n";
            }
        }
        return Dados;
    }
    
}
