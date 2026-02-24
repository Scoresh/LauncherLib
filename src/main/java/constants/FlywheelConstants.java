/**
 * Flywheel Constants are to be tuned in the robot. 
 * @blame Daniel Sabalakov
 * @todo Confirm measurements, integrate into wpilib by making a sample robot project.
 */

package constants;

import java.util.HashMap;
import java.util.function.DoubleSupplier;

import flywheelfunctions.FuelTimeFunction.FuelTimeAim;
import functions.BaseConstant;
import functions.BaseFunction;

public class FlywheelConstants {
    public static double FlywheelMountedAngleRadians = Math.PI/6;
    public static double[] FlywheelTRANSFORM = new double[]{0,0,0}; //TODO MAKE PROPER
    public static double FuelWeight = 0.226; //kg
    public static double FlywheelRadius = 0.0762; //meters
    public static BaseFunction FlywheelEfficiency = new BaseConstant(() -> 0.5); // a function 1-to-1, TUNABLE NUM
    public static HashMap<FuelTimeAim, Double> aimToDifference;
    static {
        aimToDifference = new HashMap<FuelTimeAim, Double>();
        aimToDifference.put(FuelTimeAim.GROUND, -0.3);
        aimToDifference.put(FuelTimeAim.HUB, 1.8288);
    }
    // TUNABLE (radian tuned)
    public static double RootFunctionTolerance = 0.005;

    // TUN
    public static DoubleSupplier dx = () -> -4;
    public static DoubleSupplier vx = () -> 0;
    public static DoubleSupplier dy = () -> -4;
    public static DoubleSupplier vy = () -> 0;
    


}
