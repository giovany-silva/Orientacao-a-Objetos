public class Retangulo {

    public int largura = 0;
    public int altura = 0;
    public Ponto origem;

    // quatro construtores
    public Retangulo() {
        origem = new Ponto(0, 0);
    }

    public Retangulo(Ponto p) {
        origem = p;
    }

    public Retangulo(int w, int h) {
        origem = new Ponto(0, 0);
        largura = w;
        altura = h;
    }
    public Retangulo(Ponto p, int w, int h) {
        origem = p;
        largura = w;
        altura = h;
    }

    // método para movimentar o retângulo
    public void move(int x, int y) {
        origem.x = x;
        origem.y = y;
    }

    // método para computar a área do retângulo
    public int getArea() {
        return largura * altura;
    }
}
