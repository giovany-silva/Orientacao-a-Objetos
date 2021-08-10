import java.util.*;
public class Transferencia extends Transacao
{
	
private String senha;
private String tipo;
	public Transferencia(double pValor,Date pData,String pSenha,String pTipo)
	{
		super(pValor,pData);
	    senha=pSenha;
	    tipo=pTipo;

	}
	public String getSenha()
	{
		
		return senha;
	}

	public String getTipo()
	{
		return tipo;

	}
}