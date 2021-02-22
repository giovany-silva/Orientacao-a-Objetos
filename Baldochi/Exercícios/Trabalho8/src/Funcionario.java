import java.util.*;

public abstract class Funcionario {
    private int Codigo;
    private String Nome;
    ArrayList<PontoFunc> pontoMensal=new ArrayList<PontoFunc>();
    
    public Funcionario(int pcodigo, String pNome){
        Codigo = pcodigo;
        Nome = pNome;
}

    public int getCodigo() {
        return Codigo;
    }

    public String getNome() {
        return Nome;
    }
    public void adicionaPonto(int pMes,int pAno)
    {
        
      pontoMensal.add(new PontoFunc(pMes, pAno,0, 0));
    
    
    }
      public void  lancaFaltas(int pMes,int pAno,int pNroFaltas)
    {

        
           for(PontoFunc p:pontoMensal)
          {
                if(p.getAno()==pAno&&p.getMes()==pMes)
                {

                  p.lancaFaltas(pNroFaltas);

                 break;

                }
          
          
          }
   
    
    
    }
    public void  lancaAtrasos(int pMes, int pAno, int pNroAtrasos)
    {
        
           for(PontoFunc p:pontoMensal)
          {
                if(p.getAno()==pAno&&p.getMes()==pMes)
                {

                  p.lancaAtrasos(pNroAtrasos);

                 break;

                }
          
          
          }
    
          
    
    }

    public ArrayList<PontoFunc> getPontoMensal() {
        return pontoMensal;
    }
      public String  imprimeFolha(int pMes,int pAno)
    {
        
  
         return getNome()+" " +Integer.toString(getCodigo())+"   "+calculaSalario(pMes,pAno);
          
          
         
    
    }
      public abstract double calculaSalario(int pMes,int pAno);
      public abstract double calculaBonus(int pMes,int pAno);
      
      
      
      
    
}