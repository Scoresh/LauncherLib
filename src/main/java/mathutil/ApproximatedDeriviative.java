package src.main.java.mathutil;

import src.main.java.functions.BaseVelocityFlywheelFunction;

public class ApproximatedDeriviative {
    public static double Calculate(double Result1, double Result2, double dx){
        return (Result2-Result1)/dx;
    }
    public static double Calculate(BaseVelocityFlywheelFunction f1, BaseVelocityFlywheelFunction f2, double velocity){
        double dx = 0.001;
        return (BaseVelocityFlywheelFunction.CalculateDifferenceBetweenFunctions(f1, f2, velocity - dx/2) + BaseVelocityFlywheelFunction.CalculateDifferenceBetweenFunctions(f1, f2, velocity + dx/2))/dx;
    }
}
