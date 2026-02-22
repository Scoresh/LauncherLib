package functions;

public class FunctionLib {
    /**
     * Extra checks to reduce compute
     * @return arc cosine function
     */
    public static BaseFunction ArcCosine() {
        return (double value) -> {
            if (value < -1 || value > 1) return Double.NaN;
            return Math.acos(value);
        };
    }
    /**
     * Extra checks to reduce compute
     * @return arc sine function
     */
    public static BaseFunction ArcSine() {
        return (double value) -> {
            if (value < -1 || value > 1) return Double.NaN;
            return Math.asin(value);
        };
    }
    /**
     * Return arc tangent function as a BaseFunction
     * @return arc tangent function
     */
    public static BaseFunction ArcTangent() {return (value) -> Math.atan(value);}
    /**
     * Unit function returns 1 regardless of the input, whether or not NaN or other.
     * @return Unit Function (1)
     */
    public static BaseFunction UnitFunction() {
        return (value) -> 1;
    }

}
