package functions;

public class FunctionLib {
    public static BaseFunction ArcCosine() {
        return (double value) -> {
            if (value < -1 || value > 1) return Double.NaN;
            return Math.acos(value);
        };
    }

    public static BaseFunction ArcSine() {
        return (double value) -> {
            if (value < -1 || value > 1) return Double.NaN;
            return Math.asin(value);
        };
    }

    public static BaseFunction ArcTangent() {return (value) -> Math.atan(value);}

    

}
