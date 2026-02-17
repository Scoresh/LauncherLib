package src.main.java.functions;

import src.main.java.mathutil.Quadratics;

/**
 * YFunction defines forces and velocities acting in the y direction (towards left of bot)
 */
public class YFunction extends BaseVelocityFlywheelFunction{
    public final double VELOCITY_Y;
    public final double DELTA_Y;
    /**
     * Requirements to run function 1
     * @param RADIUS_FLYWHEEL
     * @param EFFICIENCY
     * @param ANGLE_LAUNCH IN RADIANS
     * @param DELTA_Z
     * @param VELOCITY_Y
     */
    public YFunction(double RADIUS_FLYWHEEL, double EFFICIENCY, double ANGLE_LAUNCH, double DELTA_Z, double VELOCITY_Y, double DELTA_Y) {
        super(RADIUS_FLYWHEEL, EFFICIENCY, ANGLE_LAUNCH, DELTA_Z);
        this.VELOCITY_Y = VELOCITY_Y;
        this.DELTA_Y = DELTA_Y;
    }
    

    /**
     * Parameter 1 ==> Flywheel Velocity
     * Returns Angle
     */
    @Override
    public double CalculateFunction(double FlywheelVelocity) {
        CalculateTime(FlywheelVelocity);
        // robot velocity x minus target 
        System.out.println((DELTA_Y - VELOCITY_Y * this.CalculatedTime) / (-FlywheelVelocity*RADIUS_FLYWHEEL*EFFICIENCY*COS_ANGLE_LAUNCH * this.CalculatedTime));
        return Math.acos((DELTA_Y - VELOCITY_Y * this.CalculatedTime) / (-FlywheelVelocity*RADIUS_FLYWHEEL*EFFICIENCY*COS_ANGLE_LAUNCH * this.CalculatedTime));
    }
}


