package functions;

public class BasicArithmeticUtil {
    public static BaseFunction add(BaseFunction... bf) {
        return (value) -> {
            double result = 0.0;
            for (BaseFunction b : bf) {
                result+=b.function(value);
            }
            return result;
        };
    }

    public static BaseFunction subtract(BaseFunction... bf) {
        return (value) -> {
            double result = bf[0].function(value);
            for (int i = 1; i < bf.length; i++) {
                result -= bf[i].function(value);
            }
            return result;
        };
    }


    public static BaseFunction multiply(BaseFunction... bf) {
        return (value) -> {
            double result = 1.0;
            for (BaseFunction b : bf) {
                result *= b.function(value);
            }
            return result;
        };
    }

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
