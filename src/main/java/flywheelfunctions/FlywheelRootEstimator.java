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
import mathutil.Point;

/**
 * Flywheel Root Estimator takes all of the previously defines functions and estimates the angle at which the robot must point.
 * There is only **one** solution for each equation.  
 */
public class FlywheelRootEstimator {
    // Define a time function
    public FuelTimeFunction timeFunc;
    // define some variables. 
    public double lastEstimate = 0.0;
    public double minimumEstimate = 0.0;
    public double smallestX = Double.MAX_VALUE;
    public double smallestY = Double.MAX_VALUE;
    /**
     * create an instance of the class. 
     * @todo implement either a single instance state. 
     */
    public FlywheelRootEstimator(){
        timeFunc = new FuelTimeFunction();
    }
    // root = 0
    public Point CalculateFlywheelRoot(double angularVelocityRadiansPerSecond) {
        // check conditions
        while (!conditionsMet(lastEstimate)){
            // minimum
            lastEstimate+=0.1;
            if (lastEstimate > 1000){ System.out.println("No such passing element." + lastEstimate);return null;};
        }
        System.out.println("Minimm Estimate" + lastEstimate);
        minimumEstimate = lastEstimate;
        smallestX = minimumEstimate;
        BaseFunction dfunc = FuelDistanceFunctions.getRootFunction(timeFunc);

        double currentX = minimumEstimate;
        double currentY;
        while (conditionsMet(lastEstimate)){
            // run
            currentX = lastEstimate;
            currentY = dfunc.function(lastEstimate);
            if (Math.abs(currentY) < Math.abs(smallestY)){
                smallestX = currentX;
                smallestY = currentY;
            }
            // tune
            lastEstimate+=0.1;
            // over 1000 radians per second, break... 
            if (lastEstimate > 1000) break;
            
        }   
        // check if in tolerance
        if (withinTolerance(smallestX)) {
            System.out.println("The smallestX is within tolerance");            

            System.out.println("SMALLEST X: " + smallestX);
            System.out.println("ANGLE X: " + FuelDistanceFunctions.getXDirectionDistanceFunction(timeFunc).function(smallestX));
            System.out.println("ANGLE Y: " + FuelDistanceFunctions.getYDirectionDistanceFunction(timeFunc).function(smallestX));
            System.out.println("ROOT: " + FuelDistanceFunctions.getRootFunction(timeFunc).function(smallestX));

            System.out.println("UTIL CALCULATED ANGLE FINAL: " + AngleUtil.radsToDegrees(AngleUtil.getAngle0to2PI(FuelDistanceFunctions.getXDirectionDistanceFunction(timeFunc).function(smallestX), FuelDistanceFunctions.getYDirectionDistanceFunction(timeFunc).function(smallestX))));

        }
        else {            
            System.out.println("NOT IN TOLERANCE..." + smallestX);
            System.out.println("SMALLEST X: " + smallestX);
            System.out.println("ANGLE X: " + FuelDistanceFunctions.getXDirectionDistanceFunction(timeFunc).function(smallestX));
            System.out.println("ANGLE Y: " + FuelDistanceFunctions.getYDirectionDistanceFunction(timeFunc).function(smallestX));
            System.out.println("ROOT: " + FuelDistanceFunctions.getRootFunction(timeFunc).function(smallestX));
            System.out.println("UTIL CALCULATED ANGLE FINAL: " + AngleUtil.radsToDegrees(AngleUtil.getAngle0to2PI(FuelDistanceFunctions.getXDirectionDistanceFunction(timeFunc).function(smallestX), FuelDistanceFunctions.getYDirectionDistanceFunction(timeFunc).function(smallestX))));
        }
        // @todo add return state...
        return null;
    }

    /**
     * Check if conditions are met given an angular velocity
     * @param angularVelocityRadiansPerSecond angular velocity in rads/sec to pass in
     * @return whether or not the function actually will work. Checks to make sure that the timeFunction is real, makes sure it gives a positive time, and make sure that in the X and Y direction the inverse sine and cosine functions are fine.
     */
    public boolean conditionsMet(double angularVelocityRadiansPerSecond) {        
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

    /**
     * Checks to see if the two angles produced are similar enough to be within tolerance. Within ~2.78 degrees
     * @param angularVelocityRadiansPerSecond Angular velocity to pass in
     * @return Whether or not the two angles are simliar enough to be within a predefined tolerance.
     */
    public boolean withinTolerance(double angularVelocityRadiansPerSecond) {
        return Math.abs(FuelDistanceFunctions.getRootFunction(timeFunc).function(angularVelocityRadiansPerSecond)) <= FlywheelConstants.RootFunctionTolerance; 
    }
}
