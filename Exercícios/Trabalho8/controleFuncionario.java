import java.util.ArrayList;

public class controleFuncionario {
    private ArrayList<Funcionario> listaFunc = new ArrayList<>();
    private limiteFuncionario objCLimFunc;

    public controleFuncionario() {
        this.objCLimFunc = new limiteFuncionario(this);
    }

    public void insereProfessor(int pcodigo, String pnome, String ptitulacao, double psalarioHora, int pnroAulas) {
        Professor prof = new Professor(pcodigo, pnome, ptitulacao, psalarioHora, pnroAulas);
        listaFunc.add(prof);
    }

    public void insereTecAdm(int pcodigo, String pnome, String funcao, double salario) {
        TecAdmin tec = new TecAdmin(pcodigo, pnome, funcao, salario);
        listaFunc.add(tec);
    }

    public void inserePonto(int codigo, int mes, int ano) {
        for (int i = 0; i < listaFunc.size(); i++) {
            Object obj = listaFunc.get(i);
            if (((Funcionario) obj).getCodigo() == codigo) {
                ((Funcionario) obj).adicionaPonto(mes, ano);
            }
        }
    }

    public void lancaFalta(int codigo, int mes, int ano, int numFalta){
        for(int i=0;i<listaFunc.size();i++){
            Funcionario f = listaFunc.get(i);
            if(f.getCodigo() == codigo){
                f.lancaFaltas(mes, ano, numFalta);
                return;
            } 
        }
    }
    
    public void lancaAtraso(int codigo, int mes, int ano, int numAtraso){
        for(int i=0;i<listaFunc.size();i++){
            Funcionario f = listaFunc.get(i);
            if(f.getCodigo() == codigo){
                f.lancaAtrasos(mes, ano, numAtraso);
                return;
            } 
        }
    }
    
    public void buscaFolha(int mes, int ano) {
        for (int i = 0; i < listaFunc.size(); i++) {
            Object obj = listaFunc.get(i);
            String aux = ((Funcionario) obj).imprimeFolha(mes, ano);
            System.out.println(aux);
        }
    }

    public static void main(String args[]) {
        new controleFuncionario();
    }
    
}