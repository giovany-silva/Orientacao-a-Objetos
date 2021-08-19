import java.util.*;
public class Saque extends Transacao
{
	private String senha;

	public Saque(double pValor,Date pData,String pSenha)
	{
		super(pValor,pData);
		senha=pSenha;

	}
    public String getSenha()
    {
    	
    	return senha;
    }


}