package spreadsheet;

import java.util.List;

/**
 * This class is to represent a Mock Spread Sheet.
 */
public class MockSpreadSheet implements SpreadSheet {
  private List<String> log;

  MockSpreadSheet(List<String> log){
    this.log = log;
  }

  /**
   * Gets the row and column numbers and logs it
   *
   * @param row the row number of the cell, starting with 0
   * @param col the column number of the cell, starting with 0
   * @return 0
   */
  @Override
  public double get(int row, int col) throws IllegalArgumentException {
    log.add(String.format("get(%d, %d)", row, col));
    return 0;
  }

  /**
   * Sets the row and column numbers and logs it
   *
   * @param row the row number of the cell, starting with 0
   * @param col the column number of the cell, starting at 0
   * @param value the value that this cell must be set to
   */
  @Override
  public void set(int row, int col, double value) throws IllegalArgumentException {
    log.add(String.format("set(%d, %d, %.1f)", row, col, value));

  }

  /**
   * States if the cell of the given row and column is empty
   *
   * @param row the row number of the cell, starting with 0
   * @param col the column number of the cell, starting with 0
   * @return false
   */
  @Override
  public boolean isEmpty(int row, int col) throws IllegalArgumentException {
    log.add(String.format("isEmpty(%d, %d)", row, col));
    return false;
  }

  /**
   * Gets the width
   *
   * @return 0
   */
  @Override
  public int getWidth() {
    log.add("getWidth()");
    return 0;
  }

  /**
   * Gets the height
   *
   * @return 0
   */
  @Override
  public int getHeight() {
    log.add("getHeight()");
    return 0;
  }
}