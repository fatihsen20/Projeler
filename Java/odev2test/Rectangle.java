package com.company;

public class Rectangle {
    private double kisa,uzun,x,y;

    public double getKisa() {
        return kisa;
    }

    public void setKisa(double kisa) {
        this.kisa = kisa;
    }

    public double getUzun() {
        return uzun;
    }

    public void setUzun(double uzun) {
        this.uzun = uzun;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Rectangle(double kisa, double uzun, double x, double y) {
        this.kisa = kisa;
        this.uzun = uzun;
        this.x = x;
        this.y = y;
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
