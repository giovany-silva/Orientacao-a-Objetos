public class Paciente extends Pessoa
{
     private int NroSUS;
    
    public void Paciente(String pNome,String pEndereco,String pSexo,int pIdade,int pNroSUS)
    { 
        super.Pessoa(pNome,pEndereco,pSexo,pIdade);
          this.NroSUS=pNroSUS;
 
    }
    
    void setNroSUS(int pNroSUS)
    {
       this.NroSUS=pNroSUS; 
        
    }
    int getNroSUS()
    {
       return NroSUS;
    }
    
}