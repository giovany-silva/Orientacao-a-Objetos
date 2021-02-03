
import static java.lang.System.exit;


public class TestaRetangulo {

    public static void main(String[] args) {

        Retangulo one, two, three, four;

        Ponto Ponto_two = new Ponto(50, 100),Ponto_four = new Ponto(150, 200);

        one = new Retangulo(0, 0);//passando largura e altura...

        two = new Retangulo(Ponto_two,0, 0);//invisível no ponto 50 100

        three = new Retangulo(100, 150);//tamanho 100 150 na origem

        four = new Retangulo(Ponto_four, 200, 300);

        one.move(1, 2);

        three.move(3, 4);

        System.out.println("Area dos Retangulos...\n");
        System.out.println("1 " + one.getArea() + "\n");
        System.out.println("2 " + two.getArea() + "\n");
        System.out.println("3 " + three.getArea() + "\n");
        System.out.println("4 " + four.getArea());
exit(0);
    }

}
