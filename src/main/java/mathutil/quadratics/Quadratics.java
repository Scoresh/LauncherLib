/**
 * @blame Daniel Sabalakov
 */
package mathutil.quadratics;

import functions.QuadraticFunction;
import mathutil.Point;

public class Quadratics {
    public Point getVertex(QuadraticFunction f) {
        return new Point(-f.getB()/(2*f.getA()), f.function(-f.getB()/(2*f.getA())));
    }

}
