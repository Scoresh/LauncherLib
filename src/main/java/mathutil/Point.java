/**
 * @blame Daniel Sabalakov
 */
package mathutil;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * Defines a point (x,y) 
 */
@Getter @Setter @EqualsAndHashCode @ToString @NoArgsConstructor 
public class Point {
    public double x;
    public double y;
    @Builder
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
