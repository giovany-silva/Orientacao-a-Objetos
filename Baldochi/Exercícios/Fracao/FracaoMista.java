public class FracaoMista extends Fracao
{
 int parteInteira;
  public FracaoMista ()
  {
    super ();
    parteInteira = 0;
  } public FracaoMista (int pa, int num, int den)
  {
    super (num, den);
    parteInteira = pa;
  } public String toString ()
  {
      
  if(numerador==0)return (Integer.toString(parteInteira));    
    return (parteInteira + " " + numerador + "/" + denominador);
  }
 
   
  public int getparteInteira()
  {
  return parteInteira;
  }
   public void adiciona (FracaoMista frac)//adiciona essa fracao a esse numero
  {
      parteInteira+=frac.getparteInteira();
       super.adiciona (frac);
  }
  public void Ajusta()
  {
    if(numerador>=denominador)parteInteira+=numerador/denominador;

    numerador=numerador%denominador;


  }
}