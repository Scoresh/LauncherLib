/**
 * @blame Daniel Sabalakov
 */
package mathutil;

public class EpsilonEquals {
    public static double GLOBAL_EPSILON = 1E-9;
    public static boolean epsilonEquals(double a, double b) {return epsilonEquals(a, b, GLOBAL_EPSILON);}
    public static boolean epsilonEquals(double a, double b, double epsilon) {
        return (a - epsilon <= b) && (a + epsilon >= b);
    }

}
