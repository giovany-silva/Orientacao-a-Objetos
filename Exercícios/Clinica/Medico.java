public class Medico extends Pessoa
{
  private String Especialidade;
 
  private Paciente[] Pacientes;
 
    public void Medico(String pNome,String pEndereco,String pSexo,int pIdade,String pEspecialidade,Paciente[] pPacientes)
    {
        super.Pessoa(pNome,pEndereco,pSexo,pIdade);
        this.Especialidade=pEspecialidade;
        this.Pacientes=pPacientes;
    }
    
    public String getEspecialidade()
    {
        return Especialidade;
        
    }
    
    public void setEspecialidade(String pEspecialidade)
    {
       this.Especialidade=pEspecialidade; 
    }
    public Paciente[] getPacientes()
    {
        
        return Pacientes;
        
    }
    public void setPacientes(Paciente[]pPacientes)
    {
        this.Pacientes=pPacientes;
        
    }
    public String listaPacientes()
    {
        String listaPacientes="Nome :\n";
     
       int i;
    
          for(i=0;i<Pacientes.length;i++)listaPacientes+=Pacientes[i].getNome();
    
     return listaPacientes;
    }
    
}