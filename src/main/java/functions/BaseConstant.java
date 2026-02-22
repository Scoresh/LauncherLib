/**
 * @blame Daniel Sabalakov
 */
package functions;

import java.util.function.DoubleSupplier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
public class BaseConstant implements BaseFunction{
    @Getter @Setter
    private DoubleSupplier constant;
    public BaseConstant(DoubleSupplier constant){
        this.constant = constant;
    }
    @Override
    public double function(double input) {
        return constant.getAsDouble();
    }
}
