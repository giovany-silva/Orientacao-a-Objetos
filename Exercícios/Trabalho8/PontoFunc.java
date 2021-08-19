
public class PontoFunc {
    private int mes, ano, nroFaltas, nroAtrasos;

    public PontoFunc(int mes, int ano) {
        this.mes = mes;
        this.ano = ano;
    }

    public PontoFunc(int pMes, int pAno, int pNroFaltas, int pNroAtrasos) {
        this.mes = pMes;
        this.ano = pAno;
        this.nroFaltas = pNroFaltas;
        this.nroAtrasos = pNroAtrasos;
    }
    public void  lancaFaltas(int pNroFaltas)
    {
       this.nroFaltas = pNroFaltas;
    
    }
    public void  lancaAtrasos(int pNroAtrasos)
    {
       this.nroAtrasos = pNroAtrasos;
    
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getNroFaltas() {
        return nroFaltas;
    }

    public int getNroAtrasos() {
        return nroAtrasos;
    }
    
}