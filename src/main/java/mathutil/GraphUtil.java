package mathutil;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

import functions.BaseFunction;

public class GraphUtil extends JFrame {
    public GraphUtil(BaseFunction f) {
        super("Graph");

        // create a empty canvas
        Canvas c = new Canvas() {

            // paint the canvas
            public void paint(Graphics g){
                g.setColor(Color.RED);
                g.drawLine(500,0,500,600);
                g.drawLine(0,300,1000,300);
                g.setColor(Color.WHITE);
                for (double i = -1000; i < 1000; i+=0.001) {
                    g.fillOval((int)i/2 + 500,(int)f.function(i) * 5 + 300,1,1);
                }
                
            }
        };

        // set background
        c.setBackground(Color.black);

        add(c);
        setSize(1000, 600);
        show();
    }
}
