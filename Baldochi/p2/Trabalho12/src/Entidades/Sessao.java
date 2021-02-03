package Entidades;

public class Sessao{

    private int dia, mes;
    private String tipo;
    
    public static final String ORTOPEDICA = "Ortopedica";
    public static final String RESPIRATORIA = "Respiratoria";
    public static final String PILATES = "Pilates";

    public Sessao(int pDia, int pMes, String pTipo) throws Exception
    {
        dia = pDia;
        mes = pMes;
        this.setTipo(pTipo);
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setTipo(String pTipo) throws Exception {
        if(pTipo.equals(ORTOPEDICA) || pTipo.equals(RESPIRATORIA) || pTipo.equals(PILATES))
            tipo = pTipo;
        else
            throw new Exception("O tipo de sessão informado é inválido");
    }
    
    public int getDia()
    {
        return dia;
    }
    
    public int getMes()
    {
        return mes;
    }
    
    public String getTipo()
    {
        return tipo;
    }

}
