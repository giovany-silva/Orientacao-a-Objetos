
public class TecAdmin extends Funcionario {

    private double salarioMensal;
    private String funcao;

    public TecAdmin(int pCodigo, String pNome, String pfuncao, double psalarioMensal) {
        super(pCodigo, pNome);
        this.funcao = funcao;
        this.salarioMensal = psalarioMensal;
    }

    public double calculaSalario(int pMes, int pAno) {
        for (PontoFunc p : pontoMensal) {
            if(p.getAno()==pAno && p.getMes()==pMes) {

                return(salarioMensal - (salarioMensal / 30) * p.getNroFaltas());

            }

        }
        return 0;

    }

    public double calculaBonus(int pMes, int pAno) {

        for (PontoFunc p : pontoMensal) {
            if (p.getAno() == pAno && p.getMes() == pMes) {

                return calculaSalario(pMes, pAno) * (0.08 - 0.01 * p.getNroAtrasos());

            }

        }
        return 0;

    }
}