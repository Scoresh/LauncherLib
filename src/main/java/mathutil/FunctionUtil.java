package mathutil;

import functions.BaseFunction;

public class FunctionUtil {
    public static double GLOBAL_DX = 1E-6;
    public static BaseFunction deriviativeFunction(BaseFunction baseFunction, double dx) {
        return (value) -> (baseFunction.function(value + dx) - baseFunction.function(value - dx))/(2*dx);
    }

    public static BaseFunction deriviativeFunction(BaseFunction baseFunction) {
        return deriviativeFunction(baseFunction, GLOBAL_DX);
    }

    public static BaseFunction nDeriviativeFunction(BaseFunction baseFunction, int a, double dx){
        if (a <= 0) return baseFunction;
        return nDeriviativeFunction(deriviativeFunction(baseFunction, dx), a-1, dx);
    }

    public static BaseFunction nDeriviativeFunction(BaseFunction baseFunction, int a){
        if (a <= 0) return baseFunction;
        return nDeriviativeFunction(deriviativeFunction(baseFunction, GLOBAL_DX), a-1, calculateDx(a));
    }

    private static double calculateDx(int n, double dx) {
        return Math.pow(dx,1.0/n);
    }
    private static double calculateDx(int n) {
        return calculateDx(n,GLOBAL_DX);
    }

}
