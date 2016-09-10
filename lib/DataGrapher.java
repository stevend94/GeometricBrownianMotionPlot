
package lib;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DataGrapher extends JPanel {
    private final int PAD = 10;
    public float[][] data;
    private final Color colors[] = {Color.red, Color.green, Color.blue, Color.yellow, Color.black, Color.cyan};

    public DataGrapher(float[][] dataset) {
      this.data = dataset;
    }

    protected void paintComponent(Graphics g) {
        //Initialize 2d Graphics
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        final int WIDTH = getWidth();
        final int HEIGHT = getHeight();

        g2.draw(new Line2D.Double(PAD, PAD, PAD, HEIGHT - PAD));
        g2.draw(new Line2D.Double(PAD, HEIGHT - PAD, WIDTH - PAD, HEIGHT - PAD));

        double xInc = (double)(WIDTH - (2 * PAD))/(data[0].length-1);
        double scale = (double)(HEIGHT - (2 * PAD))/dataMax();

        //Draw points and lines
        int block_scale = 0;
        for(int i = 0; i < data.length; i++) {
          if( i == ((block_scale + 1) * colors.length)) {
            block_scale++;
          }
          g2.setPaint(colors[i - (block_scale * colors.length)]);
          double x = PAD;
          double y = HEIGHT - PAD - scale*data[i][0];
          double xLast = x;
          double yLast = y;
          for(int j = 1; j < data[i].length; j++) {
              x = PAD + (j * xInc);
              y = HEIGHT - PAD - (scale*data[i][j]);
              g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
              g2.draw(new Line2D.Double(xLast, yLast, x, y));
              xLast = x;
              yLast = y;
            }
          }
    }

    private float dataMax() {
        float max = -1 * Integer.MAX_VALUE;
        for(int i = 0; i < data.length; i++) {
          for(int j = 0; j < data[i].length ; j++) {
            if(data[i][j] > max)
                max = data[i][j];
              }
        }
        return max;
    }
}
