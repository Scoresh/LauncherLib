package src.main.java.functions;

import src.main.java.mathutil.Quadratics;

/**
 * XFunction defines forces and velocities acting in the x direction (towards front of bot)
 */
public class XFunction extends BaseVelocityFlywheelFunction{
    public final double VELOCITY_X;
    public final double DELTA_X;
    /**
     * Requirements to run function 1
     * @param RADIUS_FLYWHEEL
     * @param EFFICIENCY
     * @param ANGLE_LAUNCH IN RADIANS
     * @param DELTA_Z
     * @param VELOCITY_X
     */
    public XFunction(double RADIUS_FLYWHEEL, double EFFICIENCY, double ANGLE_LAUNCH, double DELTA_Z, double VELOCITY_X, double DELTA_X) {
        super(RADIUS_FLYWHEEL, EFFICIENCY, ANGLE_LAUNCH, DELTA_Z);
        this.VELOCITY_X = VELOCITY_X;
        this.DELTA_X = DELTA_X;
    }
    

    /**
     * Parameter 1 ==> Flywheel Velocity
     * Returns Angle
     */
    @Override
    public double CalculateFunction(double FlywheelVelocity) {
        CalculateTime(FlywheelVelocity);
        // robot velocity x minus target 
        System.out.println((DELTA_X - VELOCITY_X * this.CalculatedTime) / (-FlywheelVelocity*RADIUS_FLYWHEEL*EFFICIENCY*COS_ANGLE_LAUNCH * this.CalculatedTime));
        return Math.asin((DELTA_X - VELOCITY_X * this.CalculatedTime) / (-FlywheelVelocity*RADIUS_FLYWHEEL*EFFICIENCY*COS_ANGLE_LAUNCH * this.CalculatedTime));
    }
}
