public class Ponto
{
    private int x, y;
    public Ponto()
    {
        this.x = 0;
        this.y = 0;
    }
    public Ponto(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }
    
    //Operacao toString da classe Ponto
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}