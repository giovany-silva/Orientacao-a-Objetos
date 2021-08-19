import java.util.*;
import javax.*;

public class Deposito extends Transacao
{
private String nomeDep;

public Deposito(double pValor ,Date pData,String pNomeDep)
{
	super(pValor,pData);
   nomeDep=pNomeDep;
}
public String getNomeDep()
{
	
	return nomeDep;
}


}