/**
 * @blame Daniel Sabalakov
 */
import flywheelfunctions.FlywheelRootEstimator;
import flywheelfunctions.FuelDistanceFunctions;
import flywheelfunctions.FuelTimeFunction;
import functions.BaseFunction;
import functions.BasicArithmeticUtil;
import mathutil.FunctionUtil;
import mathutil.GraphUtil;
import mathutil.LinearRegressionUtil;
import mathutil.Point;
import mathutil.AngleUtil;

public class Tester {
    
    public static void main(String[] args){
        System.out.println("Running Tester.java");
        runflywheeltests();
    }

    public static void runflywheeltests() {
        FlywheelRootEstimator es = new FlywheelRootEstimator();
        // GraphUtil g = new GraphUtil(FuelDistanceFunctions.getRootFunction(new FuelTimeFunction()));
        Point p = es.CalculateFlywheelRoot();
        if (p == null) {
            System.out.println("P is null");
            return;
        }
        System.out.println("Rads / second: " + p.getX());
        System.out.println("Degrees to point robot: " + AngleUtil.radsToDegrees(p.getY()));
        
    }


    public static void runArithmeticTests() {
        BaseFunction bf = BasicArithmeticUtil.multiply(
            (value) -> 5, 
            (value) -> 3);
        System.out.println(bf.function(0));
    }

    public static void testLinearRegression() {
        Point[] points = new Point[]{
            new Point(0,0),
            new Point(2,2),
            new Point(4,4),
            new Point(7,7),
            new Point(9,9)
        };
        var f1 = LinearRegressionUtil.LinearRegression(points);
        System.out.println(f1.function(10));
        points = new Point[]{
            new Point(0,0),
            new Point(1,2),
            new Point(2,4),
            new Point(3.5,7),
            new Point(4.5,9)
        };
        var f2 = LinearRegressionUtil.LinearRegression(points);
        System.out.println(f2.function(10));
        System.out.println(f1.function(10));
    }

    public static void eFunc() {
        BaseFunction aFUNction = (value) -> Math.pow(Math.E,value);
        var aFUNctionDERIV = FunctionUtil.nDeriviativeFunction(aFUNction, 6);
        System.out.println(aFUNctionDERIV.function(1));
    }
}
