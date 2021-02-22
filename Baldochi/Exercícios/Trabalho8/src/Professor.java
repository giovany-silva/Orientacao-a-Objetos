
public class Professor extends Funcionario {

private String titulacao;
private double salarioHora;
private int nroAulas;

    public Professor(int pCodigo,String pNome,String ptitulacao, double salarioHora, int nroAulas) {
        super(pCodigo,pNome);
        this.titulacao = titulacao;
        this.salarioHora = salarioHora;
        this.nroAulas = nroAulas;
    }
    public double calculaSalario(int pMes,int pAno)
    {
           for(PontoFunc p:pontoMensal)
          {
                if(p.getAno()==pAno&&p.getMes()==pMes)
                {

                 return salarioHora * nroAulas - salarioHora * p.getNroFaltas();


                }
          
          
          }
     
    return 0;
    
    
    }
      public double calculaBonus(int pMes,int pAno)
      {
          
          for(PontoFunc p:pontoMensal)
          {
                if(p.getAno()==pAno&&p.getMes()==pMes)
                {

                     return calculaSalario(pMes,pAno)*0.1 -0.01*p.getNroAtrasos();


                }
          
          
          }
          return 0;
      
      }  
      

    
}