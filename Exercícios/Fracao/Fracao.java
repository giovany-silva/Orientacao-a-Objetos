public class Fracao
{
  int numerador;
  int denominador;
  public Fracao ()
  {
    numerador = 0;
    denominador = 1;
  }
   public Fracao (int num, int den)
  {
    numerador = num;
    denominador = den;
  }
   
  public void adiciona (int nro)//adiciona uma parte inteira a fracao
  {
    numerador += nro * denominador;
  } 
  public void adiciona (Fracao frac)//adiciona essa fracao a esse numero
  {
      numerador = numerador * frac.denominador + denominador * frac.numerador;
    denominador *= frac.denominador;
  } 
  public void Simplifica()
  {
      int i=2,menor;
         
      if(numerador<denominador)menor=numerador;
      else menor=denominador;

        while(i<=menor)
        {
         if(numerador%i==0&&denominador%i==0)//se dividir ambos divida...
            {

                   numerador/=i;
                   denominador/=i;

            }
            else i++;//senao pule p o proximo divisor

        }




  }
  
  public String toString ()
  {
      if(denominador==1)return(Integer.toString(numerador));//se for inteiro retorne apenas o numerador

    return (Integer.toString(numerador) + "/" + Integer.toString(denominador));
    

  }
}