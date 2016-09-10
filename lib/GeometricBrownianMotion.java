
package lib;

import java.lang.Math;
import java.util.Random;

public class GeometricBrownianMotion {
  private float[] s;                     //Price of stock
  private float[] mu;                    //Drift rate
  private float[] sigma;                 //Volatility
  private Random gauss;                  //Random gaussian numebr value
  private float dt;                      //Time increment
  private static int ProcessNo = 0;      //Number of processes
  private static int IterationNo = 0;    //Number of iterations
  private final int MAXPROCESSES = 5;    //Maximum allowed processes
  private final int EXIT_CODE = 0;

  public GeometricBrownianMotion(int processes, int iterations, float increment) {
    if(processes <= MAXPROCESSES) {
      s = new float[processes];
      mu = new float[processes];
      sigma = new float[processes];
      this.dt = increment;
      this.ProcessNo = processes;
      this.IterationNo = iterations;
      this.gauss = new Random();
    }
    else
    {
      System.out.println("Error: Exceeded number of processes [Initialization]");
      System.exit(EXIT_CODE);
    }
  }

  public void setProcess(int process, float spot_price, float drift_rate, float volatility) {
    if(process <= ProcessNo) {
      s[process] = spot_price;
      mu[process] = drift_rate;
      sigma[process] = volatility;
    }
    else
    {
      System.out.println("Error: Exceeded number of processes");
      System.exit(EXIT_CODE);
    }

  }

  public float[][] generateData() {
    float[][] data = new float[ProcessNo][IterationNo];

    for(int i = 0; i < IterationNo; i++) {
      double r = gauss.nextGaussian();
      for(int j = 0; j < ProcessNo; j++) {
        data[j][i] = s[j];
        s[j] = s[j] * (float)Math.exp((mu[j] - ((sigma[j]*sigma[j])/2) * dt) + (sigma[j] * Math.sqrt(dt) * r));
      }
    }
   return data;
  }
}
