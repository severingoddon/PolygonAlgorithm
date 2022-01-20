import java.util.ArrayList;

/**
 This class contains the polygon algorithm. It checks whether a given point
 is inside of a given polygon or not.

 visit "https://de.wikipedia.org/wiki/Punkt-in-Polygon-Test_nach_Jordan" to check the algorithm

 @author Severin Goddon
 **/

public class PolygonAlgo {

    private static int intersectionCount = 0;

    private static final Point pointToCheck = new Point(3,7); //type in a point to check whether it's in the polygon or not
    private static final Point referencePoint = new Point(14,9); //type in some random reference point

    public static void main(String[] args) {
        ArrayList<Gerade> polygon = new ArrayList<>();

        //polygon with 6 borders of form:
        //          E____________D
        //          \           /
        //          F\         /C
        //           /         \
        //          /           \
        //         A------------B
        polygon.add(new Gerade(3,3,9,3)); //AB
        polygon.add(new Gerade(9,3,8,6)); //BC
        polygon.add(new Gerade(8,6,11,9)); //CD
        polygon.add(new Gerade(11,9,3,9)); //DE
        polygon.add(new Gerade(3,9,5,6)); //EF
        polygon.add(new Gerade(5,6,3,3)); //FA

        if(!(doTest(polygon)%2==0)) System.out.println("Point is in polygon!");
        else System.out.println("Point is out of scope");

    }

    public static int doTest(ArrayList<Gerade> polygon){
        Gerade strahl = new Gerade(pointToCheck.getX(),pointToCheck.getY(),referencePoint.getX(),referencePoint.getY());
        for(Gerade g : polygon){
            double[] res = g.intersect(strahl);
            double x = res[0];
            double y = res[1];

            if ((x <= g.getX1() && x >= g.getX2() || x >= g.getX1() && x <= g.getX2()) && (x <= strahl.getX1() && x >= strahl.getX2() || x >= strahl.getX1() && x <= strahl.getX2())) { //check x condition
                if((y <= g.getY1() && y >= g.getY2() || y >= g.getY1() && y <= g.getY2()) && (y <= strahl.getY1() && y >= strahl.getY2() || y >= strahl.getY1() && y <= strahl.getY2()) ){ //check the y condition
                    intersectionCount ++;
                }
            }
        }
        System.out.println(intersectionCount);
        return intersectionCount;
    }
}
