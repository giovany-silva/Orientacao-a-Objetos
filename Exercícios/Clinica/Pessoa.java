public abstract class Pessoa {
  private String aNome = "", aEndereco = "", aSexo = ""; 
  private int aIdade = 0;  //Atributos do tipo int

     public void Pessoa(String pNome,String pEndereco,String pSexo,int pIdade)
    {
        this.aNome=pNome;
        this.aEndereco=pEndereco;
        this.aSexo=pSexo;
        this.aIdade=pIdade;
    }
    
  public void setNome(String pNome) {
    aNome = pNome;
  }

  public void setEndereco(String pEndereco) {
    aEndereco = pEndereco;
  }

 public void setSexo(String pSexo) {
    if ((!pSexo.equalsIgnoreCase(Util.MASCULINO)) &&
        (!pSexo.equalsIgnoreCase(Util.FEMININO))) {S
      System.out.println("O conteúdo informado para"+ 
        " o atributo sexo não é válido");
    } else {
      aSexo = pSexo;
    }
  }
public void setIdade(int pIdade)  {
    //Determina uma regra de validação do atributo idade,  
    //evitando que qualquer valor seja atributo
    if ((pIdade < Util.MIN_IDADE) || (pIdade > Util.MAX_IDADE)) {
      System.out.println("Idade deve ser maior ou igual a "+
                        Util.MIN_IDADE  +" e menor ou igual "+
                        Util.MAX_IDADE);
    } else {
      aIdade = pIdade;
    }
  }

  public String getNome() {   return aNome;  }

  public String getEndereco()  {    return aEndereco;   }

  public String getSexo() {   return aSexo;  }

  public int getIdade() {   return aIdade;  }

  
  public String getDescricao() {
    String mensagem = aNome+" reside na "+aEndereco+
                       " e possui "+aIdade+" anos de idade";
    if (aSexo.equalsIgnoreCase(Util.MASCULINO))
      return mensagem = "O Sr. "+mensagem;
    else
      return mensagem = "A Sra. "+mensagem;
  }
}
