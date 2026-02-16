package mathutil;

import mathutil.QuadraticReturnType.QuadraticType;

public class Quadratics {
    
    public static QuadraticReturnType CalculateZeroes(double a, double b, double c){
        // even though it isnt a Quadratic, Return imaginary
        if (a == 0) return new QuadraticReturnType();
        if (b*b-4*a*c < 0) return new QuadraticReturnType();
        return new QuadraticReturnType(new double[] {
            (-b+Math.sqrt(b*b-4*a*c))/(2*a),
            (-b-Math.sqrt(b*b-4*a*c))/(2*a)
        });
    }

    public static double ReturnGreaterZero(double a, double b, double c){
        QuadraticReturnType results = Quadratics.CalculateZeroes(a, b, c);
        if (results.quadraticType == QuadraticType.IMAGINARY) return -1.0;
        return results.roots[0] >= results.roots[1] ? results.roots[0] : results.roots[1];
    }

    
}
