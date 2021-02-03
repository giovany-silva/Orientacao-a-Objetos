public class Aluno {
  private int Idade;
  private String nome;

  public Aluno(int pidade, String pNome) throws Exception{
    setIdade(pidade);
    setNome(pNome);
    
  }
  //Métodos de atribuição
  public void setIdade(int pidade) throws Exception  {
     if ((pidade < 15) || (pidade > 90)) {
      throw new Exception("A idade deve estar entrte 15 e 90.");
    }
      Idade = pidade; 
  }

  public void setNome(String pNome) { nome = pNome;   }

  //Métodos de recuperação
  public int getIdade() { return Idade;   }
  public String getNome() { return nome;  }
}