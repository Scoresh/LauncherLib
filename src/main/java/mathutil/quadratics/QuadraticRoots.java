/**
 * @blame Daniel Sabalakov
 */
package mathutil.quadratics;

import functions.QuadraticFunction;

public class QuadraticRoots {
    // type defines either imaginary or real. can be used to calculate whether or not a shot is possible
    public enum QuadraticType {
        IMAGINARY,
        REAL
    }


    public double[] roots;
    public QuadraticType type;
    public QuadraticRoots(double[] roots, QuadraticType type) {
        this.roots = roots;
        this.type = type;
    }
    /**
     * Quadratic Roots Calculation
     * @return Calculate the roots of the function. If IMAGINARY, then calculate the (imaginary) roots 
     */ 
    public static QuadraticRoots calculate(QuadraticFunction function) {  
        // discriminant calculation
        double a = function.getA();
        double b = function.getB();
        double c = function.getC();
        double discriminant = b * b  + ((-4) * a * c);

        QuadraticType returnType = discriminant >= 0 ? QuadraticType.REAL : QuadraticType.IMAGINARY;
        if (returnType == QuadraticType.IMAGINARY) System.out.println("Imaginary Roots");
        double divisor = 1.0/(2*a);
        discriminant = returnType == QuadraticType.REAL ? Math.sqrt(discriminant) : Math.sqrt(-discriminant);
        double[] calcRoots = new double[]{
            divisor * (-b + discriminant),
            divisor * (-b - discriminant)
        };
        return new QuadraticRoots(calcRoots,returnType);
    }

}
