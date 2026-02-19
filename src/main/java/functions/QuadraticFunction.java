package functions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

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
    

}
