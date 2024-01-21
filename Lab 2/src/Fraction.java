/**
 * Represents the interface for Fraction
 */
public interface Fraction {

  // to add two fraction objects
  Fraction add(Fraction other);

  // to add a fraction with another fraction that is given as a numerator and denominator
  Fraction add(int numerator,int denominator);

  // to return the decimal value of a fraction, rounded to given number of spaces
  double getDecimalValue(int places);

  // to return the numerator of the intended fraction
  public int getNumerator();

  // to return the denominator of the intended fraction
  public int getDenominator();

  // to display final fraction value as a String
  String toString();
}
