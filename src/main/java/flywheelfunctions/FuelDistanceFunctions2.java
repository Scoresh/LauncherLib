/**
 * @blame Daniel Sabalakov
 */
package flywheelfunctions;

import constants.FlywheelConstants;
import functions.BaseFunction;
// TODO IMPLEMENT POSE3D IN REAL ROBOT PROJECT... USE ROBOTSTATE
public class FuelDistanceFunctions2 {
    
    /**
     * Return the root function (defined as f(x) - h(x))
     * @param t time function to avoid redundancy
     * @return Difference between the x and y functions
     */
    public static BaseFunction getRootFunction(FuelTimeFunction t) {
        return new BaseFunction() {
            @Override
            public double function(double omega) {

                // Time of flight for this angular velocity
                double time = t.function(omega);

                if (time <= 0 || Double.isNaN(time)) return Double.NaN;

                // Launch speed from flywheel
                double v = FuelVelocityOutOfLauncher
                            .getFuelVelocityDistanceFunction()
                            .function(omega);

                // Left side: projectile distance squared
                double projectileDistSq = (v * time) * (v * time);

                // Target relative position at time t
                double x = FlywheelConstants.dx.getAsDouble() - FlywheelConstants.vx.getAsDouble() * time;
                double y = FlywheelConstants.dy.getAsDouble() - FlywheelConstants.vy.getAsDouble() * time;

                // Right side: intercept distance squared
                double targetDistSq = x * x + y * y;

                return projectileDistSq - targetDistSq;
            }
        };
    }


}
