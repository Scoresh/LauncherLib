package functions;

public class BasicArithmeticUtil {
    public static BaseFunction add(BaseFunction... bf) {
        BaseFunction rtFunc = FunctionLib.UnitFunction();
        for (BaseFunction b : bf) {
            BaseFunction previousFunc = rtFunc;
            rtFunc = (value) -> previousFunc.function(value) + b.function(value);
        }
        return rtFunc;
    }

    public static BaseFunction subtract(BaseFunction... bf) {
        BaseFunction rtFunc = FunctionLib.UnitFunction();
        for (BaseFunction b : bf) {
            BaseFunction previousFunc = rtFunc;
            rtFunc = (value) -> previousFunc.function(value) - b.function(value);
        }
        return rtFunc;
    }


    public static BaseFunction multiply(BaseFunction... bf) {
        BaseFunction rtFunc = FunctionLib.UnitFunction();
        for (BaseFunction b : bf) {
            BaseFunction previousFunc = rtFunc;
            rtFunc = (value) -> previousFunc.function(value) * b.function(value);
        }
        return rtFunc;
    }

    public static BaseFunction divide(BaseFunction... bf) {
        BaseFunction rtFunc = FunctionLib.UnitFunction();
        for (BaseFunction b : bf) {
            BaseFunction previousFunc = rtFunc;
            rtFunc = (value) -> previousFunc.function(value) / b.function(value);
        }
        return rtFunc;
    }


}
