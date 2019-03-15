package com.company;

public class Point {
    private double x;
    private double y;

public Point(double x,double y){
    this.x=x;
    this.y=y;
}
public double getX(){
    return x;
}
public void setX(double x){
    this.x=x;
}
    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y=y;
    }
    public double iki_uzaklik(double x1,double y1){
    double uzaklik=Math.sqrt((Math.pow(x-x1,2))+Math.pow(y-y1,2));
    return uzaklik;
    }


}