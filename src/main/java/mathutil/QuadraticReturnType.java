package src.main.java.mathutil;

public class QuadraticReturnType {
        public enum QuadraticType {
            IMAGINARY,
            REAL
        }
        public double[] roots;
        public QuadraticType quadraticType;
        public QuadraticReturnType(double[] roots){
            if (roots != null) {
                this.roots = roots;
                this.quadraticType = QuadraticType.REAL;
            }
            else {
                this.roots = null;
                this.quadraticType = QuadraticType.IMAGINARY;
            }
        }

        public QuadraticReturnType(){
            this.roots = null;
            this.quadraticType = QuadraticType.IMAGINARY;
        }
    
        

    }
