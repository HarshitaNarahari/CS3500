
/**
 * SimpleFraction class represents a simple fraction as a numerator and denominator
 */
public class SimpleFraction implements Fraction {
  private final int numerator, denominator;

  /**
   * Constructs a positive simple fraction
   *
   * @param numerator the fraction's numerator
   * @param denominator the fraction's denominator
   * @throws IllegalArgumentException if the fraction is negative or if the denominator is 0
   */
  public SimpleFraction(int numerator, int denominator){
    if ((numerator >= 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
      throw new IllegalArgumentException("final fraction value must be positive");
    }
    if (denominator == 0) {
      throw new IllegalArgumentException("denominator cannot be 0");
    }
    this.numerator = Math.abs(numerator);
    this.denominator = Math.abs(denominator);
  }

  /**
   * gets the numerator value of a SimpleFraction
   * @return numerator value
   */
  public int getNumerator(){
    return this.numerator;
  }

  /**
   * gets the denominator value of a SimpleFraction
   * @return denominator value
   */
  public int getDenominator(){
    return this.denominator;
  }


  /**
   * Adds the fraction to the given SimpleFraction
   *
   * @param other the given fraction from the user
   * @return add(int numerator, int denominator) method to add other Fraction
   * to the given numerator and denominator as a SimpleFraction
   */
  @Override
  public Fraction add(Fraction other) throws IllegalArgumentException {
    return other.add(this.numerator, this.denominator);
  }

  /**
   * Adds the fraction to a SimpleFraction given as a numerator and denominator
   *
   * @param numerator the numerator of the given fraction
   * @param denominator the denominator of the given fraction
   * @return SimpleFraction
   * @throws IllegalArgumentException if the fraction is negative or the denominator is 0
   */
  @Override
  public Fraction add(int numerator, int denominator) throws IllegalArgumentException {
    if (this.denominator == 0 || denominator == 0){
      throw new IllegalArgumentException("denominator cannot be 0");
    }
    if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)){
      throw new IllegalArgumentException("final fraction value must be positive");
    }
    if (this.denominator == denominator) {
      return new SimpleFraction(this.numerator + numerator, denominator);
    }
    else {
      return new SimpleFraction((this.numerator * denominator) + (numerator * this.denominator), this.denominator * denominator);
    }
  }

  /**
   * Calculates the decimal value of a fraction rounded to the given number of places
   *
   * @param places the amount of decimal places the user wants the value to be rounded to
   * @return fraction rounded to given number of decimal places
   */
  @Override
  public double getDecimalValue(int places) {
    double value = (double) this.numerator/this.denominator;
    int factor = (int) Math.pow(10, Math.max(1, places));
    return Math.round(value*factor)/(double) factor;
  }

  /**
   * Prints the fraction as a String
   * @return SimpleFraction as a string
   */
  public String toString() {
    return this.numerator + "/" + this.denominator;
  }

}






