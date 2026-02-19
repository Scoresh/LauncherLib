package functions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import mathutil.Point;
import mathutil.quadratics.QuadraticRoots;
import mathutil.quadratics.QuadraticRoots.QuadraticType;

@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class QuadraticFunction implements BaseFunction {
    @Getter @Setter @Builder.Default
    private double a = 0.0;
    @Getter @Setter @Builder.Default
    private double b = 0.0;
    @Getter @Setter @Builder.Default
    private double c = 0.0;
    
    @Override
    public double function(double input) {
        return this.a * input * input + this.b * input + this.c; 
    }
    
    public QuadraticRoots getRoots() {
        return QuadraticRoots.calculate(this);
    }

    public boolean real() {
        return getRoots().type == QuadraticType.REAL;
    }

    public double[] getNumericalRoots() {
        return getRoots().roots;
    }
    /**
     * Get roots as points assume that you know if the roots are real or not. 
     * @return Points (2) of roots.
     */
    public Point[] getRootsAsPoints() {
        return new Point[]{
            new Point(getRoots().roots[0], 0),
            new Point(getRoots().roots[1], 0)
        };
    }
}
