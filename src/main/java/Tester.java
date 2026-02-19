
import functions.BaseFunction;
import mathutil.FunctionUtil;

public class Tester {
    public static double RADIUS_FLYWHEEL = .02;
    public static double EFFICIENCY = 1;
    public static double ANGLE = Math.PI/3;
    public static double ChangeZ = 1.5;
    public static double Velocity_X = 0;
    public static double Velocity_Y = 0;
    public static double ChangeX = 4;
    public static double ChangeY = 4;
    public static void main(String[] args){
        System.out.println("Running Tester.java");
        BaseFunction aFUNction = (value) -> Math.pow(Math.E,value);
        var aFUNctionDERIV = FunctionUtil.nDeriviativeFunction(aFUNction, 6);
        System.out.println(aFUNctionDERIV.function(1));
    
    }
}
