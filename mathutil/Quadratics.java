package mathutil;

public class Quadratics {
    
    public static double[] CalculateZeroes(double a, double b, double c){
        if (a == 0) return null;
        if (b*b-4*a*c < 0) return null;
        return new double[] {
            (-b+Math.sqrt(b*b-4*a*c))/(2*a),
            (-b-Math.sqrt(b*b-4*a*c))/(2*a)
        };
    }

    public static double ReturnGreaterZero(double a, double b, double c){
        double[] results = Quadratics.CalculateZeroes(a, b, c);
        return results[0] >= results[1] ? results[0] : results[1];
    }
}
