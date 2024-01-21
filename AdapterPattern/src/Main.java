import Interfaces.SocketAdapter;
import Model.SocketAdapterImplementation;
import Model.SocketObjectAdapterImplementation;
import Model.Volt;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    testingObjectAdapter();
    testingClassAdapter();
  }

  private static void testingClassAdapter(){
    SocketAdapter socketAdapter = new SocketAdapterImplementation();
    Volt v3 = getVolt(socketAdapter, 3);
    Volt v12 = getVolt(socketAdapter, 12);
    Volt v120 = getVolt(socketAdapter, 120);

    System.out.println(" V3 colts is using Class Adapter " + v3.getVolts());
    System.out.println(" V12 colts is using Class Adapter " + v12.getVolts());
    System.out.println(" V120 colts is using Class Adapter " + v120.getVolts());
  }

  private static void testingObjectAdapter(){
    SocketAdapter socketAdapter = new SocketObjectAdapterImplementation();
    Volt v3 = getVolt(socketAdapter, 3);
    Volt v12 = getVolt(socketAdapter, 12);
    Volt v120 = getVolt(socketAdapter, 120);

    System.out.println(" V3 colts is using Class Adapter " + v3.getVolts());
    System.out.println(" V12 colts is using Class Adapter " + v12.getVolts());
    System.out.println(" V120 colts is using Class Adapter " + v120.getVolts());
  }

  private static Volt getVolt(SocketAdapter socketAdapter, int i){
    switch (i){
      case 3 = return SocketAdapter.get3Volts();
      case 12 = return SocketAdapter.get12Volts();
      case 120 = return SocketAdapter.get120Volts();
      default = return SocketAdapter.get120Volts();
    }
  }

}