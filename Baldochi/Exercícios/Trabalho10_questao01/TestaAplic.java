import java.util.*;
public class TestaAplic
{
  public static void main (String[] args)
  {
    Conta c1 = new Conta (1234, "Jose da Silva", 1000, "senha1");
      c1.adicionaDeposito (5000, new Date (), "AntonioMaia");
    if (!c1.adicionaSaque (2000, new Date (), "senha1"))System.out.println ("NC#o foi possC-vel realizar o saque no valor de 2000");
    if (!c1.adicionaSaque (1000, new Date (), "senha-errada"))	// deve falhar
    System.out.println("NC#o foi possC-vel realizar o saque no valor de 1000");
    Conta c2 = new Conta(4321, "Joao de Deus", 1000, "senha2");//-------c2.adiciona
    c2.adicionaDeposito(3000, new Date(), "Maria da Cruz");if(!c2.adicionaSaque(1500, new Date(), "senha2"));
    System.out.println("NC#o foi possC-vel realizar o saque no valor de 1500");if(!c2.adicionaTransf(5000, new Date(), "senha2", c1))    // deve falhar
    System.out.println("NC#o foi possC-vel realizar a transfno valor de 5000");if(!c2.adicionaTransf(800, new Date(), "senha2", c1))
    System.out.println("NC#o foi possC-vel realizar a transfno valor de 800");  //------
    System.out.println("---------");
    System.out.println("Saldo de c1 = " + c1.calculaSaldo());// deve imprimir 4800
    System.out.println("Saldo de c2 = " + c2.calculaSaldo());// deve imprimir 1700
      
  }
    
}
