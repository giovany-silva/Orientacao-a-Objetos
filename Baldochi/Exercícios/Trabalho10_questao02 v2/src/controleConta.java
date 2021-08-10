import java.util.*;
import javax.*;
public class controleConta
{
    ArrayList<Conta>listadeContas=new ArrayList<Conta>();
    
    private limiteConta limCon;
    
    public controleConta()
    {
        limCon = new limiteConta(this);
        
    }
    public void criaConta(int pNroConta,String pNomeCorrent,double pLimite,String pSenha)
    {
        
        listadeContas.add(new Conta(pNroConta,pNomeCorrent,pLimite,pSenha));
    }
    
    
    public boolean realizaSaque(int pNroConta,double pValor,Date pData,String pSenha)
    {
       boolean sucessfull=false;
        for(Conta c:listadeContas)
        {
            
            if(c.getNroConta()==pNroConta)
            {
              c.adicionaSaque(pValor,pData,pSenha);    
              break;
            }
            
            
        }
        return sucessfull;//o sucessfull indica se deu certo a operacao de busca e validade de saldo
    }
    
        public boolean realizaDeposito(int pNroConta,double pValor,Date pData, String pNomeDep)
    {
            boolean sucessfull=false;
        for(Conta c:listadeContas)
        {
            
            if(c.getNroConta()==pNroConta)
            {
              c.adicionaDeposito(pValor,pData, pNomeDep);    
               sucessfull=true;
        
              break;
            }
            
            
        }
    return sucessfull; //o sucessfull indica se deu certo a operacao de busca 
    }
    
        public boolean realizaTransferencia(int pNroContadeb,int pNroContacred,double pValor,Date pData,String pSenha)
    {
     
      boolean sucessfull=false;
   Conta ContaFav=null;
            for(Conta c:listadeContas)
        {
            
            if(c.getNroConta()==pNroContacred)//varre para achar a conta credito
            {
              ContaFav=c;   
               sucessfull=true;
        
              break;
            }
            
            
        }
      if(!sucessfull)return sucessfull; //se nao achou retorna falso
      for(Conta c:listadeContas)
        {
            
            if(c.getNroConta()==pNroContadeb)
            {
              c.adicionaTransf(pValor,pData,pSenha,ContaFav);    
               
        
              break;
            }
            
            
        }
        
        return sucessfull;//o sucessfull indica se deu certo a operacao de busca e validade de saldo
    }
    public boolean imprimeExtrato(int pNroConta)
    {
            boolean sucessfull=false;
        for(Conta c:listadeContas)
        {
            
            if(c.getNroConta()==pNroConta)
            {
    System.out.println("Nome do Correntista:"+c.getNome()+"              Saldo :"+c.calculaSaldo()+"Senha:"+c.getSenha());
    
    ArrayList<Transacao>aux=c.getTransacoes();
    for(Transacao t:aux)
        {
            if(t instanceof Saque)
               {
                 System.out.println("Saque no valor de:"+t.getValor()+"Data do Saque:  "+t.getData());
              
               }
               
               else if(t instanceof Transferencia)
               {
                   Transferencia transf=(Transferencia)t;
                 System.out.println("Transferencia("+ transf.getTipo()+") no valor de:"+t.getValor()+"Data da Transferencia:  "+t.getData());
               }
               else
               {
                System.out.println("Deposito no valor de:"+t.getValor()+"Data do Deposito:  "+t.getData());
               }
            
            
        }
               sucessfull=true;
        
              break;
            }
            
            
        }
    return sucessfull; //o sucessfull indica se deu certo a operacao de busca 
    }
    
    	public static void main(String[]args) {
		new controleConta();
	}
}