import java.util.*;
public class Deposito extends Transferencia
{
private String nomeDep;

public Deposito(double pValor ,Date pData,String pSenha, String pTipo, String pNomeDep)// a verificar
{
	super(pValor,pData, pSenha, pTipo);
   nomeDep=pNomeDep;
}
public String getNomeDep()
{
	
	return nomeDep;
}


}