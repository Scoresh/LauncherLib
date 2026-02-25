/**
 * Flywheel Root Estimator takes all of the previously defines functions and estimates the angle at which the robot must point.
 * There is only **one** solution for each equation.  
 * @todo refactor
 * @blame Daniel Sabalakov
 */
package flywheelfunctions;

import constants.FlywheelConstants;
import functions.BaseFunction;
import mathutil.BisectionMethod;
import mathutil.Point;

/**
 * Flywheel Root Estimator takes all of the previously defines functions and estimates the angle at which the robot must point.
 * There is only **one** solution for each equation.  
 */
public class FlywheelRootEstimator2 {
    // Define a time function
    public static FuelTimeFunction timeFunc;
    /**
     * create an instance of the class. 
     * @todo implement either a single instance state. 
     */
    public FlywheelRootEstimator2(){
        timeFunc = new FuelTimeFunction();
    }
    // root = 0
    public Point CalculateFlywheelRoot() {
        // calculate lower and upper bounds
        double[] bounds = Bounds2.determineFinitePositiveBoundForFuelFunctions(FuelDistanceFunctions2.getRootFunction(timeFunc));
        
        if (bounds == null) return null;

        BaseFunction dfunc = FuelDistanceFunctions2.getRootFunction(timeFunc);
        double root = BisectionMethod.calculate(dfunc, bounds, FlywheelConstants.RootFunctionTolerance);
        
        double t = new FuelTimeFunction().function(root);

        double x = FlywheelConstants.dx.getAsDouble() - FlywheelConstants.vx.getAsDouble() * t;
        double y = FlywheelConstants.dy.getAsDouble() - FlywheelConstants.vy.getAsDouble() * t;

        // Compute angle safely
        double theta = Math.atan2(y, x);

        return new Point(root, theta);
    }

    /**
     * Check if conditions are met given an angular velocity
     * @param angularVelocityRadiansPerSecond angular velocity in rads/sec to pass in
     * @return whether or not the function actually will work. Checks to make sure that the timeFunction is real, makes sure it gives a positive time, and make sure that in the X and Y direction the inverse sine and cosine functions are fine.
     */
    public static boolean conditionsMet(double angularVelocityRadiansPerSecond) {        
        // If the quadratic is not real, return false.
        // if the time it takes for the flywheel to fly is less than 0, return false.
        if (timeFunc.function(angularVelocityRadiansPerSecond) < 0) return false;
        if (!timeFunc.real()) return false;
        return true;
    }

}
