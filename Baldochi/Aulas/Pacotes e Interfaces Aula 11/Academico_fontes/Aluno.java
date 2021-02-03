
public class Aluno extends Pessoa {

    private String aCurso;

    public void setCurso(String pCurso) {
        //Realiza o controle para verificar se o curso é válido
        if ((!pCurso.equalsIgnoreCase(Util.CC))
                && (!pCurso.equalsIgnoreCase(Util.SI))) {
            System.out.println("O curso informado não é válido!!!");
        } else {
            aCurso = pCurso;
        }
    }

    public String getCurso() {
        return aCurso;
    }

}
