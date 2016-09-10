import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import lib.GeometricBrownianMotion;
import lib.DataGrapher;

public class Main {

  /**
     * @param args the command line arguments
     */

  private final static int ITERATIONS = 400;
  private final static int PROCESSES = 5;
  private final static float INCREMENT = 0.01f;

  public static void main(String[] args) {
      // TODO code application logic here
      GeometricBrownianMotion gbm = new GeometricBrownianMotion(PROCESSES, ITERATIONS, INCREMENT);
      gbm.setProcess(0, 5, 0.01f, 1f);
      gbm.setProcess(1, 5, 0.01f, 1.2f);
      gbm.setProcess(2, 5, 0.01f, 1.6f);
      gbm.setProcess(3, 5, 0.01f, 1.4f);
      gbm.setProcess(4, 5, 0.01f, 1.5f);
      DataGrapher graph = new DataGrapher(gbm.generateData());

      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(graph);
      f.setSize(400,400);
      f.setLocation(200,200);
      f.setVisible(true);
    }
}
