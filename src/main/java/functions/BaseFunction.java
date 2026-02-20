package functions;

import java.util.function.DoubleSupplier;

@FunctionalInterface
public interface BaseFunction {
    double function(double input);
    default DoubleSupplier getDoubleSupplier(DoubleSupplier inputSupplier) {return () -> function(inputSupplier.getAsDouble());};
}
