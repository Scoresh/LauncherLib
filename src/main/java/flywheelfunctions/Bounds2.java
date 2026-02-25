package flywheelfunctions;


import functions.BaseFunction;

public class Bounds2 {

    /**
     * THIS METHOD ASSUMS THAT A FUNCTION HAS A FINITE DOMAIN THAT IS POSITIVE.
     * THIS METHOD IS ALSO NON-OPTIMZIED TO REDUCE COMPUTE TIME
     * @param f BaseFunction to determine the bounds of
     * @return [lower,upper] bounds
     */
    public static double[] determineFinitePositiveBoundForFuelFunctions(BaseFunction f) {
        double lowerBound, higherBound;
        // loop through
        double checkDoubleValue = 0.0;
        // first check
        while (!FlywheelRootEstimator2.conditionsMet(checkDoubleValue)) {
            checkDoubleValue+=5;
            if (checkDoubleValue > 1000)return null;
        }
        lowerBound = checkDoubleValue;
        while (FlywheelRootEstimator2.conditionsMet(checkDoubleValue)) {
            checkDoubleValue+=5;
            if (checkDoubleValue > 1000){break;};
        }
        higherBound = checkDoubleValue-=5;
        return new double[]{lowerBound,higherBound};
    }
}
