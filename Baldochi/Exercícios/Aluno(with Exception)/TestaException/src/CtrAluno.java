import java.util.*;

public class CtrAluno {
  private ArrayList<Aluno> listaAluno = new ArrayList();

  //Método de inserção
  public void insereAluno(int pidade,  String pNome) throws Exception {
    Aluno objAl = new Aluno(pidade, pNome);
    listaAluno.add(objAl);
  }

  //Método de composição dos dados do aluno utilizado para visualização
  private String getAluno(Aluno objAluno) {
    return "Idade: " + objAluno.getIdade()+
           "  Nome: " + objAluno.getNome();
  }

  //Método para obtenção das lista de alunos
  public String getListaAlunos() {
    String result = "";
    Aluno objAluno = null;
    for (int intIdx = 0; intIdx < listaAluno.size(); intIdx++) {
      objAluno = (Aluno)listaAluno.get(intIdx);
      result += getAluno(objAluno)+"\n";
    }
    if (result.equalsIgnoreCase(""))
      return "Não existem Alunos cadastradas.";
    else
      return result;
  }
  //Método para obtenção de um aluno
  public String getAluno(int pidade) {
    Aluno objAluno = null;
    for (int intIdx = 0; intIdx < listaAluno.size(); intIdx++) {
      objAluno = (Aluno)listaAluno.get(intIdx);
      if (objAluno.getIdade() == pidade)
        return getAluno(objAluno);
    }
    return "Não foi encontrado nenhum Aluno com a idade "+pidade+".";
  }
}
  