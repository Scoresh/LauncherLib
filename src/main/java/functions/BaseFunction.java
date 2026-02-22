/**
 * @blame Daniel Sabalakov
 */
package functions;

import java.util.function.DoubleSupplier;

import mathutil.Point;

/**
 * The very base of these values. Given an input "input" or 'x', override this method to return a f(input) or f(x).
 * Use case for a line of slope 2 and a y-intercept of 2:
 * BaseFunction line = () -> 2 * input + 2;
 */
@FunctionalInterface
public interface BaseFunction {
    double function(double input);
    default DoubleSupplier getDoubleSupplier(DoubleSupplier inputSupplier) {return () -> function(inputSupplier.getAsDouble());};
    default Point getPoint(double input) {return new Point(input,function(input));}
}
