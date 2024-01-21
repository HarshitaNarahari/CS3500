import org.junit.Test;
import static org.junit.Assert.*;

public class dogDemo {
  public static void main (String [] args){
    Pet yourPet = new Pet ("Jerry", 12, 18);
    System.out.println("Your pet's records are inaccurate.");
    System.out.println("These are the current records: ");
    yourPet.writeOutput();
  }



}
