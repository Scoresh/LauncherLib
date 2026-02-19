package mathutil;

import functions.BaseFunction;

public class LinearRegressionUtil {
    // calculates least square regression...
    // Slope of LSR = n(xy) - sum(x)sum(y) / (n)
    public static BaseFunction LinearRegression(Point... points) {
        if (points.length == 1) return null;
        double[] sum = Sums(points);
        double m = (sum[4] * sum[3] - sum[0] * sum[1])/(sum[4]*sum[2] - sum[0] * sum[0]);
        double b = (sum[1] - m * sum[0])/sum[4];
        return (value) -> m * value + b;
    }
    
    // Indice 0: x
    // Indice 1: y
    // Indice 2: x^2
    // Indice 3: xy
    // Indice 4: n
    private static double[] Sums(Point[] points) {
        double[] sum = new double[]{0,0,0,0,0};
        for (Point i : points) {
            sum[0] += i.getX();
            sum[1] += i.getY();
            sum[2] += i.getX() * i.getX();
            sum[3] += i.getX() * i.getY();
        }
        sum[4] = points.length;
        return sum;
    }
}
