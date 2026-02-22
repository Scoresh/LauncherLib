package flywheelfunctions;

import constants.FlywheelConstants;
import mathutil.AngleUtil;
import mathutil.Point;

public class FlywheelRootEstimator {
    public FuelTimeFunction timeFunc;
    public double lastEstimate = 0.0;
    public double minimumEstimate = 0.0;
    public double smallestX = Double.MAX_VALUE;
    public double smallestY = Double.MAX_VALUE;
    public FlywheelRootEstimator(){
        timeFunc = new FuelTimeFunction();
    }
    // root = 0
    public Point CalculateFlywheelRoot(double angularVelocityRadiansPerSecond) {
        // check conditions
        while (!conditionsMet(lastEstimate)){
            // minimum
            lastEstimate+=0.1;
        }
        System.out.println("Minimm Estimate" + lastEstimate);
        minimumEstimate = lastEstimate;
        smallestX = minimumEstimate;
        var dfunc = FuelDistanceFunctions.getRootFunction(timeFunc);

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

            lastEstimate+=0.1;

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
        return null;
    }


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


    public boolean withinTolerance(double angularVelocityRadiansPerSecond) {
        return Math.abs(FuelDistanceFunctions.getRootFunction(timeFunc).function(angularVelocityRadiansPerSecond)) <= FlywheelConstants.RootFunctionTolerance; 
    }
}
