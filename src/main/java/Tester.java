package src.main.java;
import src.main.java.functions.XFunction;
import src.main.java.functions.YFunction;
import src.main.java.mathutil.NewtonRaphsonMethod;

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
        System.out.println("Testing Function");
        XFunction f1 = new XFunction(RADIUS_FLYWHEEL, EFFICIENCY, ANGLE, ChangeZ, Velocity_X, ChangeX);
        YFunction f2 = new YFunction(RADIUS_FLYWHEEL, EFFICIENCY, ANGLE, ChangeZ, Velocity_Y, ChangeY);
        System.out.println("X: " + NewtonRaphsonMethod.Calculate(f1,f2)[0] + " Angle " + NewtonRaphsonMethod.Calculate(f1,f2)[1]);
    }
}
