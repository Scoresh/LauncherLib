package functions;

import mathutil.Quadratics;

public class BaseVelocityFlywheelFunction {
    public final double RADIUS_FLYWHEEL;
    public final double EFFICIENCY;
    public final double ANGLE_LAUNCH;
    public final double SIN_ANGLE_LAUNCH;
    public final double COS_ANGLE_LAUNCH;
    public final double DELTA_Z;
    // you should update this
    public double CalculatedTime;
    public BaseVelocityFlywheelFunction(double RADIUS_FLYWHEEL, double EFFICIENCY, double ANGLE_LAUNCH, double DELTA_Z) {
        this.RADIUS_FLYWHEEL = RADIUS_FLYWHEEL;
        this.EFFICIENCY = EFFICIENCY;
        this.ANGLE_LAUNCH = ANGLE_LAUNCH;
        this.DELTA_Z = DELTA_Z;
        
        this.SIN_ANGLE_LAUNCH = Math.sin(ANGLE_LAUNCH);
        this.COS_ANGLE_LAUNCH = Math.cos(ANGLE_LAUNCH);

    }

    /**
     * Boiler for Calculating Functions
     * @return Angle
     */
    public double CalculateFunction(double FlywheelVelocity) {
        return 0.0;
    }

    public void CalculateTime(double FlywheelVelocity) {
        this.CalculatedTime = Quadratics.ReturnGreaterZero(-9.8, FlywheelVelocity*RADIUS_FLYWHEEL*EFFICIENCY*SIN_ANGLE_LAUNCH, DELTA_Z);
    }

}