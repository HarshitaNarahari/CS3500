import java.util.Arrays;
public class AverageTemperature {
  int[] temperatures = new int[10];
  static int average;
  int currentTemp;

  for(int i: temperatures){
    if (currentTemp > average) {
      System.out.println(currentTemp);
    }
  }


}
