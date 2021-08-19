public class Deposito extends Transferencia
{
private String nomeDep;

public Deposito(double pValor ,Date pData,String pNomeDep)// a verificar
{
	super(pValor,pData);
   nomeDep=pNomeDep;
}
public String getNomeDep()
{
	
	return nomeDep;
}


}