/**
 * @blame Daniel Sabalakov
 */
package mathutil;

public class AngleUtil {
    // assume that the cosine value and sine value are the same triangle.
    public static double getAngle0to2PI(double cosvalue, double sinvalue) {
        // operation
        double sineSign = Math.signum(sinvalue);
        double cosSign = Math.signum(cosvalue);
        if (sineSign > 0 && cosSign > 0) {
            return cosvalue;
        }
        else if (sineSign > 0 && cosSign < 0) {
            return cosvalue + Math.PI;
        }
        else if (sineSign < 0 && cosSign > 0) {
            return cosvalue + 2 * Math.PI;
        }
        else if (sineSign < 0 && cosSign < 0){
            return sinvalue + Math.PI;
        }
        return cosvalue;
    }

    public static double degToRadians(double deg) {
        return deg * Math.PI / 180;
    }
    public static double radsToDegrees(double rad) {
        return rad * 180 / Math.PI;
    }
}
