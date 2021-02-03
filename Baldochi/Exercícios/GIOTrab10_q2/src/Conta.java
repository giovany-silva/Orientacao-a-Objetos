import java.util.*;

public class Conta
{
	private int nroConta;
	private String nomeCorrent;
    private double limite;
    private String senha;
    private String Tipo;
    private ArrayList<Transacao>transacoes=new ArrayList<Transacao>();

   public  Conta(int pNroConta,String pNomeCorrent,double pLimite,String pSenha)
	{
		nroConta=pNroConta;
		nomeCorrent=pNomeCorrent;
		limite=pLimite;
		senha=pSenha;
	
	}

    public int getNroConta()
    {
    	
    	return nroConta;
    }
    public String getNome()
    {
    	
    	return nomeCorrent;
    }
    public double getLimite()
    {
     	return limite;

    } 
    public String getSenha()
    {
    	
     return senha;

    }
    public ArrayList<Transacao> getTransacoes()
    {
    	
    	return transacoes;
    }
    public void adicionaDeposito(double pValor,Date pData, String pSenha, String pTipo, String pNomeDep)
    {

    	transacoes.add(new Deposito(pValor,pData,pSenha, pTipo, pNomeDep));

    }
        public boolean adicionaSaque(double pValor,Date pData, String pSenha)
    {
        if((calculaSaldo()+limite)<pValor||senha!=pSenha)return false;
       
    	transacoes.add(new Saque(pValor,pData,pSenha));
    	return true;
    }
        public boolean adicionaTransf(double pValor,Date pData, String pSenha,Conta pContaFav)
    {
        if((calculaSaldo()+limite)<pValor||senha!=pSenha)return false;
        
        //ArrayList<Transacao>aux;
        
        transacoes.add(new Transferencia(pValor,pData,pSenha,"D"));
        
        pContaFav.getTransacoes().add(new Transferencia(pValor,pData,pSenha,"C")); 
        
    	return true;
    	
    }
    public double calculaSaldo()
    {
        double saldo=limite;
            
            for(Transacao t:transacoes)
            {
               if(t instanceof Saque)
               {
                   Saque Saq=(Saque)t;
                  saldo-=Saq.getValor();
              
               }
               
               else if(t instanceof Transferencia)
               {
                   Transferencia transf=(Transferencia)t;
                if(transf.getTipo()=="C")   saldo+=transf.getValor();
               else saldo-=transf.getValor();
               }
               else
               {
                Deposito Dep=(Deposito)t;
                  saldo+=Dep.getValor();
              
               }
            }
    	
   return saldo;
    }
}