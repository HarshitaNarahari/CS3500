import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Random;


public class SimpleFractionTest {

  private SimpleFraction oneTwo;
  private SimpleFraction oneThree;
  private SimpleFraction twoThree;
  private SimpleFraction oneFour;
  private SimpleFraction threeFour;
  private SimpleFraction oneSix;
  private SimpleFraction fiveSix;

  public void setUp() {
    oneTwo = new SimpleFraction(1, 2);
    oneThree = new SimpleFraction(1, 3);
    twoThree = new SimpleFraction(2, 3);
    oneFour = new SimpleFraction(1, 4);
    threeFour = new SimpleFraction(3, 4);
    oneSix = new SimpleFraction(1, 6);
    fiveSix = new SimpleFraction(5, 6);
  }

  @Test
  public void testAddPositiveFraction() {
    setUp();
    assertEquals("3/3", oneThree.add(twoThree).toString());
    assertEquals("4/4", oneFour.add(threeFour).toString());
    assertEquals("5/6", oneThree.add(oneTwo).toString());
    assertEquals("8/12", oneTwo.add(oneSix).toString());
    assertEquals("27/18", fiveSix.add(twoThree).toString());

    Random r = new Random(200);
    for (int i = 0; i < 1000; i++) {
      int num1 = r.nextInt(20000) + 1;
      int den1 = r.nextInt(20000) + 1;
      int num2 = r.nextInt(20000) + 1;
      int den2 = r.nextInt(20000) + 1;

      Fraction f1 = new SimpleFraction(num1, den1);
      Fraction f2 = new SimpleFraction(2, den2);
      Fraction expected = f2.add(num1, den1);

      assertEquals(expected.toString(), f1.add(f2).toString());
      assertEquals(expected.toString(), f2.add(f1).toString());
    }
  }

    @Test
    public void testNegativeFractionsException() {
      setUp();
      Random r = new Random(200);

      for (int i = 0; i < 1000; i++) {
        try {
          oneTwo.add(-1 * r.nextInt(20000) + 1, r.nextInt(20000) + 1);
          fail("Fraction cannot be a negative value.");
        }
        catch (IllegalArgumentException e) {
        }
      }
    }

    @Test
    public void testZeroDenominatorException() {
      setUp();

      Random r = new Random(200);
      for (int i = 0; i < 1000; i++) {
        try {
          oneTwo.add(r.nextInt(20000) + 1, 0);
          fail("Denominator should not be 0");
        }
        catch (IllegalArgumentException e) {
        }
      }
    }

  public void testFirst() {
    setUp();
    Random r = new Random(200);

    for (int i = 0; i < 1000; i++) {
      int n1 = r.nextInt(1000) + 1;
      int d1 = r.nextInt(1000) + 1;
      int n2 = r.nextInt(1000) + 1;
      int d2 = r.nextInt(1000) + 1;

      Fraction f1 = new SimpleFraction(n1, d1);
      Fraction f2 = new SimpleFraction(n2, d2);

      Fraction expected1 = f2.add(f1.getNumerator(), f1.getDenominator());
      Fraction expected2 = f1.add(f2.getNumerator(), f2.getDenominator());

      assertEquals(expected1.toString(), f1.add(f2).toString());
      assertEquals(expected2.toString(), f2.add(f1).toString());

    }
  }

  @Test
  public void addFractionGivenNumAndDenomTest() {
    setUp();
    assertEquals("2/2", oneTwo.add(1, 2).toString());
    assertEquals("6/6", oneSix.add(5, 6).toString());
    assertEquals("2/4", oneFour.add(1, 4).toString());
    assertEquals("4/3", twoThree.add(2, 3).toString());
    assertEquals("6/8", oneFour.add(1, 2).toString());
    assertEquals("22/24", threeFour.add(1, 6).toString());
  }

  @Test
  public void fractionAsDecimalTest() {
    setUp();
    assertEquals(0.5, oneTwo.getDecimalValue(1), 0.001);
    assertEquals(0.333, oneThree.getDecimalValue(3), 0.001);
    assertEquals(0.6666, twoThree.getDecimalValue(4), 0.0001);
    assertEquals(0.833, fiveSix.getDecimalValue(3), 0.001);
  }
}
