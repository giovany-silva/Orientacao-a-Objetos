import java.util.*;
public class ExemploThrow {
  private Vector v = new Vector();
  public ExemploThrow() throws Exception {
    v.add("Disciplina 1");
    v.add("Disciplina 2");
    imprimeVetor();
  }
  public void imprimeVetor() throws Exception {
    System.out.println("O número de elementos do vetor é "+v.size());
    try {
      for (int i = 0; i <= v.size(); i++) {
        System.out.println(v.elementAt(i).toString());
      }
    } catch (ArrayIndexOutOfBoundsException exc) {
      throw new Exception("Índice fora do limite -> "+exc.getMessage());
    } finally  {
      System.out.println("Processo finalizado");
    }
  }
  public static void main (String par[]) {
    try {
      ExemploThrow explthrow = new ExemploThrow();
    } catch (Exception exc) {
      System.out.println(exc.getMessage());
    }
  }
}