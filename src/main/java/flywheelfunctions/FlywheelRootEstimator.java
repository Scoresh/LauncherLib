package flywheelfunctions;

import mathutil.Point;

public class FlywheelRootEstimator {
    public FuelTimeFunction timeFunc;
    public double lastEstimate = 0.0;
    public double minimumEstimate = 0.0;
    public double smallestDifferenceX = Double.MAX_VALUE;
    public double smallestDifferenceY = Double.MAX_VALUE;
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
        minimumEstimate = lastEstimate;
        smallestDifferenceX = minimumEstimate;
        var dfunc = FuelDistanceFunctions.getRootFunction(timeFunc);

        double currentX = minimumEstimate;
        while (conditionsMet(lastEstimate)){
            // run
            
        }
        System.out.println("Estimate finally has been met. Continuing...");
        System.out.println("X: " + lastEstimate);
        System.out.println("ANGLE: " + FuelDistanceFunctions.getXDirectionDistanceFunction(timeFunc).function(lastEstimate));
        
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
}
