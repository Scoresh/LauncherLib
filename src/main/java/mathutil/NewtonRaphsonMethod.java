package src.main.java.mathutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import src.main.java.functions.BaseVelocityFlywheelFunction;

public class NewtonRaphsonMethod {
    
    // create thread 
    public static double[] Calculate(BaseVelocityFlywheelFunction f1, BaseVelocityFlywheelFunction f2) {
        int it_count = 0;
        int count_max = 10;
        double velocity0 = 2.0, velocity = 1.0, error=1.0, tol=1E-12;

        while ((it_count <= count_max) && (error>=tol)){
            // look
            velocity = velocity0 - BaseVelocityFlywheelFunction.CalculateDifferenceBetweenFunctions(f1, f2, velocity) / ApproximatedDeriviative.Calculate(f1, f2, velocity);
            error = Math.abs(velocity-velocity0);
            it_count++;
            velocity0 = velocity;

        }
        return new double[]{
            velocity,
            BaseVelocityFlywheelFunction.CalculateDifferenceBetweenFunctions(f1, f2, velocity)
        };
    }   
}
