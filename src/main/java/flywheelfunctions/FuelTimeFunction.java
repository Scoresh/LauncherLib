package flywheelfunctions;

import functions.BaseFunction;
import functions.HeightPhysicsFunction;
import flywheelfunctions.FuelVelocityOutOfLauncher;
public class FuelTimeFunction {
    public static BaseFunction getTimeFunction() {
        return (angularRotationRadiansPerSecond) -> FuelVelocityOutOfLauncher.getFuelVelocityVerticalFunction().function(angularRotationRadiansPerSecond) * 1;
    }
}
