/**
 * Flywheel Root Estimator takes all of the previously defines functions and estimates the angle at which the robot must point.
 * There is only **one** solution for each equation.  
 * @todo refactor
 * @blame Daniel Sabalakov
 */
package flywheelfunctions;

import constants.FlywheelConstants;
import functions.BaseFunction;
import mathutil.AngleUtil;
import mathutil.BisectionMethod;
import mathutil.Point;

/**
 * Flywheel Root Estimator takes all of the previously defines functions and estimates the angle at which the robot must point.
 * There is only **one** solution for each equation.  
 */
public class FlywheelRootEstimator {
    // Define a time function
    public static FuelTimeFunction timeFunc;
    /**
     * create an instance of the class. 
     * @todo implement either a single instance state. 
     */
    public FlywheelRootEstimator(){
        timeFunc = new FuelTimeFunction();
    }
    // root = 0
    public Point CalculateFlywheelRoot() {
        // calculate lower and upper bounds
        double[] bounds = Bounds.determinefinitePositiveBoundForFuelFunctions(FuelDistanceFunctions.getRootFunction(timeFunc));
        if (bounds == null) return null;

        BaseFunction dfunc = FuelDistanceFunctions.getRootFunction(timeFunc);
        double root = BisectionMethod.calculate(dfunc, bounds, FlywheelConstants.RootFunctionTolerance);
        return new Point(root, AngleUtil.getAngle0to2PI(
            FuelDistanceFunctions.getXDirectionDistanceFunction(timeFunc).function(root), 
            FuelDistanceFunctions.getYDirectionDistanceFunction(timeFunc).function(root)));
    }

    /**
     * Check if conditions are met given an angular velocity
     * @param angularVelocityRadiansPerSecond angular velocity in rads/sec to pass in
     * @return whether or not the function actually will work. Checks to make sure that the timeFunction is real, makes sure it gives a positive time, and make sure that in the X and Y direction the inverse sine and cosine functions are fine.
     */
    public static boolean conditionsMet(double angularVelocityRadiansPerSecond) {        
        // If the quadratic is not real, return false.
        if (!timeFunc.real()) return false;
        // if the time it takes for the flywheel to fly is less than 0, return false.
        if (timeFunc.function(angularVelocityRadiansPerSecond) < 0) return false;
        if (Double.isNaN(
            FuelDistanceFunctions.getXDirectionDistanceFunction(timeFunc).function(angularVelocityRadiansPerSecond)
        )) return false;
        if (Double.isNaN(
            FuelDistanceFunctions.getYDirectionDistanceFunction(timeFunc).function(angularVelocityRadiansPerSecond)
        )) return false;
        return true;
    }

}
