package Model;

import Interfaces.SocketAdapter;

public class SocketAdapterImplementation extends Socket implements SocketAdapter {

  @Override
  public Volt get120Volts() {
    return get1Volt();
  }

  @Override
  public Volt get12Volts() {
    Volt v = getVolt();
    return convertVolt(v, 10);
  }

  @Override
  public Volt get3Volts() {
    Volt v = getVolt();
    return convertVolt(v, 40);
  }

  @Override
  public Volt get1Volt() {
    return get1Volt();
  }

  private Volt convertVolt(Volt v, int i){
    return new Volt(v.getVolts()/i);
  }

}
