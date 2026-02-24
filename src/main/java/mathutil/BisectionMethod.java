package mathutil;

import functions.BaseFunction;

public class BisectionMethod {
    /**
     * Calculate a solution to the root function f
     * How does the bisection method work, you ask? 
     * We split down the middle (bound1 - bound2)
     * According to the Intermediate Value Theorum, if the sign changes, every value must exist between the two bounds.
     * Hence, the root is between the two.
     * @param f root function
     * @param bounds bounds in which the function is finite
     * @param tolerance tolerance 
     * @return approximate to root
     */
    public static double calculate(BaseFunction f, double[] bounds, double tolerance) {
        double lowerBound = bounds[0];
        double upperBound = bounds[1];
        double midpoint = calculateMidpoint(lowerBound,upperBound);
        if (withinTolerance(f, midpoint, tolerance)) return midpoint;
        if (withinTolerance(f,lowerBound,tolerance)) return lowerBound;
        if (withinTolerance(f,upperBound,tolerance)) return upperBound;

        System.out.println(f.function(lowerBound));
        System.out.println(f.function(midpoint));
        System.out.println(f.function(upperBound));
        // first, check if there is a root between the two bounds
        if (!rootBetween(f, lowerBound, upperBound)) return Double.NaN;
        // calculate midpoint
        // if midpoint is within tolerance, simply return the midpoint
        // now crunch
        while (!withinTolerance(f, midpoint, tolerance)) {
            // if there is a root between, set upper bound to midpoint. 
            if (rootBetween(f,lowerBound,midpoint)) {
                upperBound = midpoint;
            }
            else {
                lowerBound = midpoint;
            }
            midpoint = calculateMidpoint(lowerBound, upperBound);
        }
        return midpoint;
    }

    public static double calculateMidpoint(double a, double b) {
        return (a + b) / 2;
    }

    public static boolean rootBetween(BaseFunction f, double a, double b) {
        return (Math.signum(f.function(a) * f.function(b)) < 0);
    }

    public static boolean withinTolerance(BaseFunction f, double estimate, double tolerance) {
        return Math.abs(f.function(estimate)) < tolerance;
    }
}
