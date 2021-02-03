public class TestaFracao
{


      public static void main(String[]args)
      {

/*
7/6 + 13/7 = 3 1/42
1/3 + 2/3 = 1
3 1/2 + 4 2/3 = 8 1/6
*/

      FracaoMista frac1,frac2;


      frac1=new FracaoMista(0,7,6);
      frac2=new FracaoMista(0,13,7);
      frac1.adiciona(frac2);
      frac1.Ajusta();
    
System.out.println(frac1.toString ());

frac1=new FracaoMista(0,1,3);
      frac2=new FracaoMista(0,2,3);
      frac1.adiciona(frac2);
      frac1.Ajusta();
      System.out.println("\n"+frac1.toString ());

      frac1=new FracaoMista(3,1,2);
      frac2=new FracaoMista(4,2,3);
      frac1.adiciona(frac2);
      frac1.Simplifica();
      frac1.Ajusta();
    
    
System.out.println("\n"+frac1.toString ());
         
      }



}