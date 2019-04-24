public class Rectangle {
    private double kisa,uzun,x,y;

    public double getKisa() {
        return kisa;
    }

    public void setKisa(double S) {
        kisa = S;
    }

    public double getUzun() {
        return uzun;
    }

    public void setUzun(double L) {
        uzun = L;
    }

    public double getX() {
        return x;
    }

    public void setX(double S) {
        x = S;
    }

    public double getY() {
        return y;
    }

    public void setY(double L) {
        y = L;
    }

    public Rectangle(double kisa, double uzun) {
        this.kisa = kisa;
        this.uzun = uzun;
    }
    public void move(double deltaX,double deltaY){
        x+=deltaX;
        y+=deltaY;
    }
    public double getPerimeter(){
        return 2*(kisa+uzun);
    }
    public double getArea(){
        return kisa*uzun;
    }
}
