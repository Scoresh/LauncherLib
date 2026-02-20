package constants;

import java.util.HashMap;

import flywheelfunctions.FuelTimeFunction.FuelTimeAim;
import functions.BaseConstant;
import functions.BaseFunction;

public class FlywheelConstants {
    public static double FlywheelMountedAngleRadians = Math.PI/3;
    public static double[] FlywheelTRANSFORM = new double[]{0,0,0}; //TODO MAKE PROPER
    public static double FuelWeight = 1; //kg
    public static double FlywheelRadius = 0.1; //meters
    public static BaseFunction FlywheelEfficiency = new BaseConstant(() -> 1); // a function 1-to-1
    public static HashMap<FuelTimeAim, Double> aimToDifference;
    static {
        aimToDifference = new HashMap<FuelTimeAim, Double>();
        aimToDifference.put(FuelTimeAim.GROUND, -0.3);
        aimToDifference.put(FuelTimeAim.HUB, 1.5);
    }
    
    


}
