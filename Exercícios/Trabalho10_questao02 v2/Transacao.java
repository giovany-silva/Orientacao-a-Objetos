import java.util.*;
public abstract class Transacao{ 
	
    private double valor;
    private Date data;
    
    public Transacao(double pValor,Date pData)//talvez tem retorno de transacao
    {
    	
    valor=pValor;
    data=pData;
    
    }
    public double getValor()
    {
    	
    	return valor;
    }
    public Date getData()
    {
    	return data;
    
    }
}