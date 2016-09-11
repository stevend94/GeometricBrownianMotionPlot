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
      gbm.setProcess(0, 5, 0.01f, 0.5f);
      gbm.setProcess(1, 5, 0.01f, 0.4f, true);
      gbm.setProcess(2, 5, 0.01f, 0.3f);
      gbm.setProcess(3, 5, 0.01f, 0.2f);
      gbm.setProcess(4, 5, 0.01f, 0.1f);
      DataGrapher graph = new DataGrapher(gbm.generateData());

      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(graph);
      f.setSize(400,400);
      f.setLocation(200,200);
      f.setVisible(true);
    }
}
