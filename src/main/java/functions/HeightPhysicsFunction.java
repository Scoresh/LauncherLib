package functions;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
public class HeightPhysicsFunction extends QuadraticFunction{
    public HeightPhysicsFunction(double initialUpwardVelocity, double initialHeight) {
        super (
           -9.8,
           initialUpwardVelocity,
           initialHeight 
        );
    }
    // give me two instead of one...
    public HeightPhysicsFunction(double initialUpwardVelocity, double initialHeight, double finalHeight) {
        super (
           -9.8,
           initialUpwardVelocity,
           finalHeight - initialHeight 
        );
    }
}
