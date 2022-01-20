/**
 This class represents a straight line of form y = m*x + b
 It contains the intersect method, which calculates the intersection between two lines

 @author Severin Goddon
 **/

public class Gerade {

    public final double m, b;
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    public Gerade(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.m = (y2-y1)/(x2-x1);
        this.b = y2-m*x2;
    }

    public double[] intersect(Gerade line) { //linie = strahl
        double x = (line.b - this.b) / (this.m - line.m);
        double y = this.m * x + this.b;
        return new double[]{x,y};
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }


    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

}