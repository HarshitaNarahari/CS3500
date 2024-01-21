import org.junit.Before;
import org.junit.Test;

import listadt.ImmutableListADT;
import listadt.ListADT;
import listadt.MutableListADT;
import listadt.MutableListADTImpl;

import static org.junit.Assert.*;

public class MutableListADTImplTest {
  private MutableListADT<String> listOfStrings;

  @Before
  public void setUp() {
    listOfStrings = new MutableListADTImpl<String>();
    listOfStrings.addFront("hid");
    listOfStrings.addFront("Jerry");
    listOfStrings.addFront("mouse");
    listOfStrings.addBack("from");
    listOfStrings.addBack("Tom");
    listOfStrings.addBack("the");
    listOfStrings.addBack("cat");
    listOfStrings.add(2, "the");
  }

  @Test
  public void testMap() {
    setUp();

    String sentence = "I broke my neck from too much coding";
    String[] strings = sentence.split("\\s+");
    listOfStrings = new MutableListADTImpl<>();
    for (String s : strings) {
      listOfStrings.addBack(s);
    }

    ListADT<Integer> stringLengths = listOfStrings.map(s -> s.length());
    assertEquals("The mapped list's length does not match the original list!",
            listOfStrings.getSize(), stringLengths.getSize());

    for (int i = 0; i < strings.length; i++){
      assertEquals("String is " + listOfStrings.get(i), strings[i].length(),
              (int) stringLengths.get(i));
    }

    ImmutableListADT<String> immutableStrings = listOfStrings.getImmutableList();
    MutableListADT<String> mutableStrings = immutableStrings.getMutableList();

    mutableStrings.remove("Tom");
    assertEquals(8, listOfStrings.getSize());
    assertEquals(8, immutableStrings.getSize());
    assertEquals(8, mutableStrings.getSize());
  }
}