import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.util.Random;
import java.util.Scanner;

import spreadsheet.SparseSpreadSheet;
import spreadsheet.SpreadSheet;
import spreadsheet.SpreadSheetController;

import static org.junit.Assert.*;
public class SpreadSheetControllerTest {
  private Readable readable;
  private Appendable appendable;
  private SpreadSheet spreadSheet;
  private String[] outputMessages;

  @Before
  public void setup() {
    Readable readable = new StringReader("q");
    Appendable appendable = new StringBuilder();
    spreadSheet = new SparseSpreadSheet();
    SpreadSheetController controller = new SpreadSheetController(spreadSheet, readable, appendable);

    controller.go();

    String output = appendable.toString();
    outputMessages = output.split("\n");
  }

  @Test
  public void testGetSet() {
    Random r = new Random(100);

    double[][] expectedSet = new double[100][100];

    for (int i = 0; i < 100; i = i + 1) {
      for (int j = 0; j < 100; j = j + 1) {
        double num = r.nextDouble();

        expectedSet[i][j] = num;

        assertTrue(spreadSheet.isEmpty(i, j));

        assertEquals(0.0, spreadSheet.get(i, j), 0.001);
        spreadSheet.set(i, j, num);
        assertFalse(spreadSheet.isEmpty(i, j));
      }
    }
  }

  @Test
  public void testGetWidthHeight() {
    for (int i = 0; i < 100; i = i + 1) {
      for (int j = 0; j < 100; j = j + 1) {
        spreadSheet.set(i, j, 0);
        assertEquals(i + 1, spreadSheet.getHeight());
        if (i == 0) {
          assertEquals((j + 1), spreadSheet.getWidth());
        } else {
          assertEquals(100, spreadSheet.getWidth());
        }
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetWithNegativeRow() {
    spreadSheet.set(0, 0, 1);
    spreadSheet.set(0, 1, 9);
    spreadSheet.get(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetWithNegativeColumn() {
    spreadSheet.set(0, 0, 1);
    spreadSheet.set(0, -1, 9);
    spreadSheet.get(0, -1);
  }

  @Test
  public void testWelcomeMessage(){
    String welcomeMessage = outputMessages[0];
    String expectedWelcomeMessage = "Welcome to the spreadsheet program!";

    assertEquals(expectedWelcomeMessage, welcomeMessage);
  }

  @Test
  public void testFareWellMessage() {
    String farewellMessage = outputMessages[outputMessages.length - 1].replace("Type instruction: ","");
    String expectedFarewellMessage = "Thank you for using this program!";
    assertEquals(expectedFarewellMessage, farewellMessage);
  }
}
