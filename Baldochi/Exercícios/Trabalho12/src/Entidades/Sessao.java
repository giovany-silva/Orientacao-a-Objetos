package Entidades;

public class Sessao{
    // atributos das sessoes
    private int dia, mes;
    private String tipo;
    
    // atributos estaticos dos tipos das sessoes e entre "" a maneira que devem ser digitadas
    public static final String ORTOPEDICA = "Ortopedica";
    public static final String RESPIRATORIA = "Respiratoria";
    public static final String PILATES = "Pilates";

    // construtor da sessao, pode ter excecao por causa do tipo
    public Sessao(int pDia, int pMes, String pTipo) throws Exception
    {
        dia = pDia;
        mes = pMes;
        // chama o set do Tipo para conferir se o tipo passado esta certo
        this.setTipo(pTipo);
    }
    // set do dia da sessao
    public void setDia(int dia) {
        this.dia = dia;
    }
    // set do mes da sessao
    public void setMes(int mes) {
        this.mes = mes;
    }
    // set do tipo da sessao, precisa passar o tipo como parametro
    public void setTipo(String pTipo) throws Exception {
        // if para comparar o tipo da sessao passada como parametro com os tipos defeinidos
        if(pTipo.equals(ORTOPEDICA) || pTipo.equals(RESPIRATORIA) || pTipo.equals(PILATES))
            // se o tipo estiver correto ele eh jogado na variavel "tipo"
            tipo = pTipo;
        else
            // caso o tipo nao esteja correto eh retornado uma msg
            throw new Exception("O tipo de sessão informado é inválido");
    }
    // get do dia da sessao
    public int getDia()
    {
        return dia;
    }
    // get do mes da sessao
    public int getMes()
    {
        return mes;
    }
    // get do tipo da sessao
    public String getTipo()
    {
        return tipo;
    }

}
