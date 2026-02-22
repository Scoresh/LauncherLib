/**
 * @blame Daniel Sabalakov
 */
package functions;
/**
 * Add, subtract, multiply, and divide functions! Is a factory utility class to help create the BaseFunction sequences.
 */
public class BasicArithmeticUtil {
    /**
     * Adds a series of basefunctions
     * @param bf series of base functions to add
     * @return single function adding all the other functions
     */
    public static BaseFunction add(BaseFunction... bf) {
        return (value) -> {
            double result = 0.0;
            for (BaseFunction b : bf) {
                result+=b.function(value);
            }
            return result;
        };
    }
    /**
     * Subtracts a series of base functions
     * @param bf series of base functions: first one is going to be subtracted from the rest: a - b - c - d
     * @return single function subtracting the other functions
     */
    public static BaseFunction subtract(BaseFunction... bf) {
        return (value) -> {
            double result = bf[0].function(value);
            for (int i = 1; i < bf.length; i++) {
                result -= bf[i].function(value);
            }
            return result;
        };
    }
    /**
     * Multiplies a series of base functions
     * @param bf series of base functions to multiply. 
     * @return the base functions multiplied together.
     */
    public static BaseFunction multiply(BaseFunction... bf) {
        return (value) -> {
            double result = 1.0;
            for (BaseFunction b : bf) {
                result *= b.function(value);
            }
            return result;
        };
    }
    /**
     * Divides a series of base functions
     * @param bf series of base functions to divide: will be divided as: a / (b*c*d)
     * @return a single base function consisting of the other base functions divided
     */
    public static BaseFunction divide(BaseFunction... bf) {
        return (value) -> {
            double result = bf[0].function(value);
            for (int i = 1; i < bf.length; i++) {
                result /= bf[i].function(value);
            }
            return result;
        };
    }


}
