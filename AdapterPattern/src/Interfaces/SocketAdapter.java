package Interfaces;

import com.build.model.Volt;

import Model.Volt;

public interface SocketAdapter {
  static Volt get120Volts();
  static Volt get12Volts();
  static Volt get3Volts();
  Volt get1Volt();
}
