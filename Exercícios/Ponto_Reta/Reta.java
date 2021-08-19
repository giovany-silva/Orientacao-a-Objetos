
public class Reta {
    Ponto inicio=new Ponto(), fim=new Ponto();
    
    public Reta(int xInicio, int yInicio, int xFim, int yFim) {
        inicio.setX(xInicio);
        inicio.setY(yInicio);

        fim.setX(xFim);
        fim.setY(yFim);   
    }
    public Reta(Ponto ini ,Ponto fim) {
        inicio = ini;
        this.fim = fim;
    }
      
    public void setinicio(Ponto inicio) {
        this.inicio = inicio;
    }

    public Ponto getinicio() {
        return inicio;
    }
    public void setfim(Ponto fim) {
        this.fim = fim;
    }

    public Ponto getfim() {
        return fim;
    }
     public void setXinicial(int x) {
        this.inicio.setX(x);
    }
    public void setYinicial(int Y) {
        this.inicio.setY(Y);
    }

    public int getXinicial() {
        return inicio.getX();
    }
    public int getYinicial() {
        return inicio.getY();
    }
    public void setXYinicial(int x,int y) {
        this.inicio.setX(x);
        this.inicio.setY(y);
    }
    


    public void setXfinal(int x) {
        this.fim.setX(x);
    }
    public void setYfinal(int y) {
        this.fim.setY(y);
    }
    
    public void setfinal(int Y) {
        this.fim.setY(Y);
    }

    public int getXfinal() {
        return fim.getX();
    }
    public int getYfinal() {
        return fim.getY();
    }
    public void setXYfinal(int x,int y) {
        this.fim.setX(x);
        this.fim.setY(y);
    }
    public double tamanhoReta()
    {

    
        double distancia = Math.sqrt(Math.pow(  inicio.getX() - fim.getX()  ,2) + Math.pow(inicio.getY() - fim.getY() , 2));
    return distancia;
    }
    public String toString()
    {
        return "Reta comeca em:"+inicio+"termina em:"+fim;
    }

}