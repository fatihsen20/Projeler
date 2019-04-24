public class Point {
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x1) {
        x = x1;
    }

    public double getY() {
        return y;
    }

    public void setY(double y1) {
        y = y1;
    }
    public double uzaklik(Point c){
        double deger=Math.sqrt(Math.pow((x-c.x),2)+Math.pow((y-c.y),2));
        return deger;
    }
    public Point findClosest(Point[] pointArray){
        double min=uzaklik(pointArray[0]);
        int sayac=0;
        for (int i = 0; i <pointArray.length ; i++) {
            if (uzaklik(pointArray[i]) < min){
                min = uzaklik(pointArray[i]);
                sayac=i;
            }
        }
        return pointArray[sayac];
    }
    public static Point findFurthest(Point[] pointArray){
        double max=Math.sqrt(Math.pow(pointArray[0].getX(),2)+Math.pow(pointArray[0].getY(),2));
        int sayac=0;
        for (int i = 0; i <pointArray.length ; i++) {
            if (Math.sqrt(Math.pow(pointArray[i].getX(),2)+Math.pow(pointArray[i].getY(),2))>max){
                max=Math.sqrt(Math.pow(pointArray[i].getX(),2)+Math.pow(pointArray[i].getY(),2));
                sayac=i;
            }
        }
        return pointArray[sayac];
    }
}
