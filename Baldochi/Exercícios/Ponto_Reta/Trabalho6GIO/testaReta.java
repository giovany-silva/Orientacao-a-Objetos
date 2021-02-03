public class testaReta {

    public static void main(String[] agrs) {
        Ponto p1, p2;
        p1 = new Ponto(1, 2);
        p2 = new Ponto(2, 3);

        Reta r1 = new Reta(p1, p2);
        
        System.out.printf("\n"+r1.toString()+"\nTamanho da reta 1 :%.2f\n", r1.tamanhoReta());

        Reta r2 = new Reta(1, 2, 3, 4);
        r2.toString();
        System.out.printf("\nTamanho da reta 2 :%.2f\n", r2.tamanhoReta());

        p1.setX(5);
        p1.setY(6);
        p2.setX(10);
        p2.setY(11);

        r1.setinicio(p1);
        r1.setfim(p2);
        r1.toString();
        System.out.printf("\nMudou de coordenadas...\n"+r1.toString()+"\nTamanho da reta 1 :%.2f\n", r1.tamanhoReta());
        
        r2.setXinicial(11);
        r2.setYinicial(12);
        r2.setXfinal(13);
        r2.setYfinal(18);
        System.out.printf("\n"+r2.toString()+"\nTamanho da reta 2 :%.2f\n", r2.tamanhoReta());
        
    }

}