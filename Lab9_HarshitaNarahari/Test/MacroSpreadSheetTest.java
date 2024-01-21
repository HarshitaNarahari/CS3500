import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.util.Random;

import spreadsheet.AverageMacro;
import spreadsheet.BulkAssignMacro;
import spreadsheet.MacroSpreadSheet;
import spreadsheet.MacroSpreadSheetController;
import spreadsheet.RangeAssignMacro;
import spreadsheet.SpreadSheet;
import spreadsheet.SparseSpreadSheet;
import spreadsheet.SpreadSheetMacro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import static org.junit.Assert.*;

/**
 * This class is the tester for a sparse spreadsheet.
 */
public class MacroSpreadSheetTest {

  private MacroSpreadSheet sheet;
  private AverageMacro average;
  private BulkAssignMacro bulkAssign;
  private RangeAssignMacro rangeAssign;

  @Before
  public void setup() {
    sheet = new SparseSpreadSheet();
    average = new AverageMacro(0, 0, 0, 1, 1, 2);
    bulkAssign = new BulkAssignMacro(0, 0, 4, 3, 4.0);
    rangeAssign = new RangeAssignMacro(0, 4, 4, 4, 3, 3);
  }

  @Test
  public void testGetSet() {
    Random r = new Random(100);
    double[][] expectedSet = new double[100][100];
    for (int i = 0; i < 100; i = i + 1) {
      for (int j = 0; j < 100; j = j + 1) {
        double num = r.nextDouble();
        expectedSet[i][j] = num;
        assertTrue(sheet.isEmpty(i, j));
        assertEquals(0.0, sheet.get(i, j), 0.001);
        sheet.set(i, j, num);
        assertFalse(sheet.isEmpty(i, j));
      }
    }
    for (int i = 0; i < 100; i = i + 1) {
      for (int j = 0; j < 100; j = j + 1) {
        assertEquals(expectedSet[i][j], sheet.get(i, j), 0.01);
      }
    }
  }

  @Test
  public void testGetWidthHeight() {
    for (int i = 0; i < 100; i = i + 1) {
      for (int j = 0; j < 100; j = j + 1) {
        sheet.set(i, j, 0);
        assertEquals((i + 1), sheet.getHeight());
        if (i == 0) {
          assertEquals((j + 1), sheet.getWidth());
        } else {
          assertEquals(100, sheet.getWidth());
        }
      }
    }
    sheet.set(100, 100, 0);
    assertEquals(101, sheet.getWidth());
    assertEquals(101, sheet.getHeight());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetWithNegativeRow() {
    sheet.set(0, 0, 1);
    sheet.set(0, 1, 9);
    sheet.get(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetWithNegativeColumn() {
    sheet.set(0, 0, 1);
    sheet.set(0, 1, 9);
    sheet.get(0, -1);
  }

  @Test
  public void testAverageMacro() {
    setup();
    sheet.executeMacro(average);

    assertEquals(sheet.get(1, 1), 0.0, 0.001);
    assertEquals(sheet.get(2, 3), 0.0, 0.001);
  }

  @Test
  public void testBulkMacro() {
    setup();
    sheet.executeMacro(bulkAssign);

    assertEquals(sheet.get(1, 1), 4.0, 0.001);
    assertEquals(sheet.get(2, 3), 4.0, 0.001);
  }

  @Test
  public void testRangeMacro() {
    setup();
    sheet.executeMacro(rangeAssign);

    assertEquals(sheet.get(1, 1), 0.0, 0.001);
    assertEquals(sheet.get(2, 3), 0.0, 0.001);
  }

  @Test
  public void testExceptionsAverageMacro() {
    try {
      SpreadSheetMacro invalidAverageMacro =
              new AverageMacro(-5, 0, 0, 0, 0, 0);
      fail("Arguments to average macro cannot be negative");
    } catch (IllegalArgumentException e) {
    }
    try {
      SpreadSheetMacro invalidAverageMacro =
              new AverageMacro(0, -5, 0, 0, 0, 0);
      fail("Arguments to average macro cannot be negative");
    } catch (IllegalArgumentException e) {
    }
    try {
      SpreadSheetMacro invalidAverageMacro =
              new AverageMacro(0, 0, -5, 0, 0, 0);
      fail("Arguments to average macro cannot be negative");
    } catch (IllegalArgumentException e) {
    }
  }

  @Test
  public void testInvalidRangeAssignMacro() {
    try {
      SpreadSheetMacro invalidRangeAssignMacro =
              new RangeAssignMacro(-1, 0, -1, 0, 0, 0);
      fail("Arguments to range assignment cannot be negative");
    } catch (IllegalArgumentException e) {
    }
    try {
      SpreadSheetMacro invalidRangeAssignMacro =
              new RangeAssignMacro(0, -1, 0, -1, 0, 0);
      fail("Arguments to range assignment cannot be negative");
    } catch (IllegalArgumentException e) {
    }
    try {
      SpreadSheetMacro invalidRangeAssignMacro =
              new RangeAssignMacro(2, 3, 1, 0, 0, 0);
      fail("Range assignment should be in a single row or column");
    } catch (IllegalArgumentException e) {
    }
    try {
      SpreadSheetMacro invalidRangeAssignMacro =
              new RangeAssignMacro(0, 1, 3, 3, 0, 0);
      fail("Range assignment should be in a single row or column");
    } catch (IllegalArgumentException e) {
    }
  }

  @Test
  public void testInvalidBulkAssignMacro() {
    try {
      SpreadSheetMacro invalidBulkAssignMacro =
              new BulkAssignMacro(-5, 0, 0, 0, 0);
      fail("Arguments to bulk assign macro cannot be negative");
    } catch (IllegalArgumentException e) {
    }
    try {
      SpreadSheetMacro invalidBulkAssignMacro =
              new BulkAssignMacro(0, -5, 0, 0, 0);
      fail("Arguments to bulk assign macro cannot be negative");
    } catch (IllegalArgumentException e) {
    }
    try {
      SpreadSheetMacro invalidBulkAssignMacro =
              new BulkAssignMacro(0, 0, -5, 0, 0);
      fail("Arguments to bulk assign macro cannot be negative");
    } catch (IllegalArgumentException e) {
    }
  }

  @Test
  public void testPrintMenu() {
    SparseSpreadSheet model = new SparseSpreadSheet();
    Readable readable = new StringReader("q");
    Appendable appendable = new StringBuilder();
    MacroSpreadSheetController controller = new MacroSpreadSheetController(model, readable, appendable);
    controller.control();

    String expectedMessage = "Welcome to the spreadsheet program!\n" +
            "Supported user instructions are: \n" +
            "assign-value row-num col-num value (set a cell to a value)\n" +
            "print-value row-num col-num (print the value at a given cell)\n" +
            "bulk-assign-value from-row-num from-col-num to-row-num to-col-num value(assigns value to given range)\n" +
            "range-assign-value rom-row-num from-col-num to-row-num to-col-num start-value increment (assigns value to given range, increasing by the increment)\n" +
            "average from-row-num from-col-num to-row-num to-col-num dest-row-num dest-col-num (averages values from given range and assigns the value to the destination\n" +
            "menu (Print supported instruction list)\n" +
            "q or quit (quit the program) \n" +
            "Type instruction: Thank you for using this program!";
    assertEquals(expectedMessage, appendable.toString());
  }
}
