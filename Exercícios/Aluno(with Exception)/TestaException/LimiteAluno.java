import javax.swing.*;
public class LimiteAluno  {
  //Instancia o Controlador
  private CtrAluno objCtrAl = new CtrAluno();

  public void capturaDados() {
    int escolha = 0;
    String escolhaInformada = "";
    //Variáveis utilizadas para recuperar as informações da interface do usuário
    int Idade = 0;
    String nome = "";
 

    do {
      do {
        try {
          escolhaInformada =
            JOptionPane.showInputDialog(
                 "Escolha uma opção do menu:\n"+
                 "[1] Adiciona Aluno\n"+
                 "[2] Lista Alunos\n"+
                 "[3] Finaliza");
          escolha = Integer.parseInt(escolhaInformada);
        } catch (Exception exc) {}
      } while ((escolha < 1) || (escolha > 3));
       switch (escolha) {
        case 1:
          try {

             //Requisita o Nome
             nome = JOptionPane.showInputDialog ("Informe o nome");
             //Requisita a Idade
             Idade = Integer.parseInt(
                              JOptionPane.showInputDialog ("Informe a idade"));
              //Adiciona o objeto para a lista de aluno
              objCtrAl.insereAluno(Idade, nome);
          } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage(), "Erro",
                JOptionPane.ERROR_MESSAGE);
          }
          break;
        case 2:
          JOptionPane.showMessageDialog(null,
            objCtrAl.getListaAlunos(), "Relação de Alunos",
            JOptionPane.INFORMATION_MESSAGE);
          break;
        case 3:
          System.exit(0);
      }
    } while (true);
  }
  public static void main (String par[]) {
    LimiteAluno objLimAl = new LimiteAluno();
    objLimAl.capturaDados();
  }
}