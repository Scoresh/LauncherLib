package flywheelfunctions;
import functions.BaseFunction;
import constants.FlywheelConstants;

public class FuelVelocityOutOfLauncher {
    
    public static BaseFunction getFuelVelocityFunction() {
        return (angularRotationRadiansPerSecond) -> angularRotationRadiansPerSecond * FlywheelConstants.FlywheelRadius
                * FlywheelConstants.FlywheelEfficiency.function(angularRotationRadiansPerSecond);
    }

    public static double MountedAngleCosine = Math.cos(FlywheelConstants.FlywheelMountedAngleRadians);
    public static BaseFunction getFuelVelocityVerticalFunction() {
        return (value) -> getFuelVelocityFunction().function(value) * MountedAngleCosine;
    } 

    public static double MountedAngleSine = Math.sin(FlywheelConstants.FlywheelMountedAngleRadians);
    public static BaseFunction getFuelVelocityDistanceFunction() {
        return (value) -> getFuelVelocityFunction().function(value) * MountedAngleSine;
    } 
}   
