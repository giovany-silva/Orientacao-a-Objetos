import java.util.*;
//tudo que estah com nextLine e println trocar por jOptionPane ,remover scanner
public class limiteConta
{
    controleConta ctrConta;
    
    public limiteConta(controleConta objPcontroleConta)
    {
        ctrConta=objPcontroleConta;
        capturaDados();
    }
    public void capturaDados()
    {
        
        String escolhaInformada;
        int escolha;
        
        while(true){
        System.out.println("1-criar conta 2-deposito 3-saque 4 -trans 5- extrato 6- sair");
         Scanner sc = new Scanner(System.in);
        escolhaInformada=sc.nextLine();
        escolha=Integer.parseInt(escolhaInformada);
                switch(escolha)
                {
                    
                 case 1:{
                               criaConta();
                                break;
                        }
                                   
                case 2:{
                            fazDeposito();
                            break;
                        }
                case 3:{
                            fazSaque();            
                            break;
                        }
                case 4:{
                            fazTransferencia();
                            break;
                        }
                case 5:{
                            imprimeExtrato();
                                      break;
                        }
                 case 6:{
                            sair();
                            break;
                        }
                
                }
        
        }
        
    }
    
    
    public void criaConta()
    {
                 Scanner sc = new Scanner(System.in);
        
         int NroConta;
         
                String nomeCorrent;
                double limiteConta;
                String senha;
                System.out.println("conta,nome,limite,senha");
                
                NroConta=Integer.parseInt(sc.nextLine());
                nomeCorrent=sc.nextLine();
                limiteConta=Double.parseDouble(sc.nextLine());
                senha=sc.nextLine();
                ctrConta.criaConta(NroConta,nomeCorrent,limiteConta,senha);
    }
    
    public void  fazDeposito()
    {
        int NroConta;
         Scanner sc = new Scanner(System.in);
        double Valor;
        Date Data=new Date(); 
        String NomeDep;
    System.out.println("Digite nro con ,val,data,NomeDep");
        NroConta=Integer.parseInt(sc.nextLine());
        Valor=Double.parseDouble(sc.nextLine());;
     
        NomeDep=sc.nextLine();
        if(!ctrConta.realizaDeposito(NroConta,Valor,Data,NomeDep))
        {
            
            System.out.println("Nao foi possivel realizar deposito!");
            
        }//retorna um bool
    }
    public void fazSaque()
    {
      
         Scanner sc = new Scanner(System.in);
    
    System.out.println("Digite nro con ,val,Senha");
        
          Date Data=new Date(); 
        
          int NroConta=Integer.parseInt(sc.nextLine());
        
          double Valor=Double.parseDouble(sc.nextLine());
        
         String Senha=sc.nextLine();
    
  
     if(!ctrConta.realizaSaque(NroConta,Valor,Data,Senha))
     {
                     System.out.println("Nao foi possivel realizar saque!");
         
     }//retorna um bool  
     
    }
    public void fazTransferencia()
    {
        Scanner sc = new Scanner(System.in);
            System.out.println("Digite nro conta deb,cred ,val,Senha");
        int NroContadeb=Integer.parseInt(sc.nextLine());
        int NroContacred=Integer.parseInt(sc.nextLine());
        double Valor=Double.parseDouble(sc.nextLine());;
        Date Data=new Date();
        String Senha=sc.nextLine();
        
        if(!ctrConta.realizaTransferencia(NroContadeb,NroContacred,Valor,Data,Senha))
        {
            System.out.println("Nao foi possivel realizar transferencia!");
        }
    }
    public void imprimeExtrato()
    {
        System.out.println("Digite nro conta ");
                Scanner sc = new Scanner(System.in);
        int NroConta=Integer.parseInt(sc.nextLine());
        if(!ctrConta.imprimeExtrato(NroConta))
        {
            System.out.println("Nao foi possivel imprimir extrato!");    
        
        }
        
    }
    public void sair()
    {
        System.out.println("Saindo do sistema!");
        try {
            Thread.sleep(5000);//coloquei soh para sair em 5s pfv nao coloquem isso
            } catch (InterruptedException ex){}
        
        System.exit(0);
    }
}