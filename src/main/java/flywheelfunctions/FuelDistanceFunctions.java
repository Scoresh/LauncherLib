/**
 * @blame Daniel Sabalakov
 */
package flywheelfunctions;

import constants.FlywheelConstants;
import functions.BaseConstant;
import functions.BaseFunction;
import functions.BasicArithmeticUtil;
import functions.FunctionLib;
import mathutil.FunctionUtil;
// TODO IMPLEMENT POSE3D IN REAL ROBOT PROJECT... USE ROBOTSTATE
public class FuelDistanceFunctions {
    // register constants
    public static BaseConstant dx = new BaseConstant(FlywheelConstants.dx);
    public static BaseConstant dy = new BaseConstant(FlywheelConstants.dy);
    public static BaseConstant vx = new BaseConstant(FlywheelConstants.vx);
    public static BaseConstant vy = new BaseConstant(FlywheelConstants.vy);

    public static BaseFunction getDistanceFlywheelFunction(FuelTimeFunction t) {
        return BasicArithmeticUtil.multiply(FuelVelocityOutOfLauncher.getFuelVelocityDistanceFunction(), t);
    }

    public static BaseFunction getRobotFuelOffsetX(FuelTimeFunction t) {
        return BasicArithmeticUtil.subtract(dx,BasicArithmeticUtil.multiply(vx,t));
    }
    public static BaseFunction getRobotFuelOffsetY(FuelTimeFunction t) {
        return BasicArithmeticUtil.subtract(dy,BasicArithmeticUtil.multiply(vy,t));
    }

    /**
     * In reality, I would use RobotState and given data here...
     * @param t time function to avoid redunancy
     * @return Fuel traveling in a predefined X direction.
     */
    public static BaseFunction getXDirectionDistanceFunction(FuelTimeFunction t) {
        return FunctionUtil.chain(
            FunctionLib.ArcCosine(), 
            BasicArithmeticUtil.divide(
                getRobotFuelOffsetX(t), 
                getDistanceFlywheelFunction(t)
            ));
    }
    /**
     * get Y direction as a distance function. 
     * @param t time function to avoid redundancy
     * @return Fuel traveling in a y direction
     */
    public static BaseFunction getYDirectionDistanceFunction(FuelTimeFunction t) {
        return FunctionUtil.chain(
            FunctionLib.ArcSine(), 
            BasicArithmeticUtil.divide(
                getRobotFuelOffsetY(t), 
                getDistanceFlywheelFunction(t)
            ));
    }
    /**
     * Return the root function (defined as f(x) - h(x))
     * @param t time function to avoid redundancy
     * @return Difference between the x and y functions
     */
    public static BaseFunction getRootFunction(FuelTimeFunction t) {
        // return (value) -> getXDirectionDistanceFunction(t).function(value) - getYDirectionDistanceFunction(t).function(value);
        return BasicArithmeticUtil.subtract(getXDirectionDistanceFunction(t), getYDirectionDistanceFunction(t));
    }


}
