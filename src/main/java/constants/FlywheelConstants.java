package constants;

import functions.BaseFunction;

public class FlywheelConstants {
    public static double FlywheelMountedAngleRadians = Math.PI/3;
    public static double FlywheelTRANSFORM = 1; //TODO MAKE PROPER
    public static double FuelWeight = 1; //kg
    public static double FlywheelRadius = 1; //meters
    public static BaseFunction FlywheelEfficiency = (value) -> 1; // a function 1-to-1
    

}
