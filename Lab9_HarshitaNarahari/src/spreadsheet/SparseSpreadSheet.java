package spreadsheet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class represents a sparse spreadsheet. A sparse spreadsheet is a spreadsheet
 * with a large number of empty cells. It represents this efficiently using a hash map.
 */
public class SparseSpreadSheet implements MacroSpreadSheet {
  private final Map<CellPosition, Double> sheet;
  private int width;
  private int height;


  /**
   * Constructs a sparse spreadsheet
   */
  public SparseSpreadSheet() {
    this.sheet = new HashMap<CellPosition, Double>();
    this.width = 0;
    this.height = 0;
  }

  /**
   * Gets the row and column numbers and logs it
   *
   * @param row the row number of the cell, starting with 0
   * @param col the column number of the cell, starting with 0
   * @return cell position as row and column
   */
  @Override
  public double get(int row, int col) throws IllegalArgumentException {
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Row or column cannot be negative");
    }
    return this.sheet.getOrDefault(new CellPosition(row, col), 0.0);
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
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Row or column cannot be negative");
    }
    this.sheet.put(new CellPosition(row, col), value);
    if ((row + 1) > height) {
      height = row + 1;
    }
    if ((col + 1) > width) {
      width = col + 1;
    }
  }

  /**
   * States if the cell of the given row and column is empty
   *
   * @param row the row number of the cell, starting with 0
   * @param col the column number of the cell, starting with 0
   * @return boolean representing if given row and column are empty
   */
  @Override
  public boolean isEmpty(int row, int col) throws IllegalArgumentException {
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Row or column cannot be negative");
    }
    return !this.sheet.containsKey(new CellPosition(row, col));
  }

  /**
   * Gets the width
   *
   * @return the width as an integer
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Gets the height
   *
   * @return the height as an integer
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Executes the given macro on this spreadsheet.
   *
   * @param sheet the macro to be executed
   */
  @Override
  public void executeMacro(SpreadSheetMacro sheet) {
    sheet.execute(this);
  }

  /**
   * This class represents a cell position
   */
  private static class CellPosition {
    private final int row;
    private final int column;

    /**
     * Constructs a cell position
     *
     * @param row the given row
     * @param column the given column
     */
    private CellPosition(int row, int column) {
      this.row = row;
      this.column = column;
    }

    /**
     * Checks if the object is equal or not
     *
     * @param o as an object
     * @return boolean representing if the object is equal
     */
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof CellPosition)) {
        return false;
      }
      CellPosition other = (CellPosition) o;
      return this.row == other.row && this.column == other.column;
    }


    /**
     * Hash code method
     * @return hash map
     */
    @Override
    public int hashCode() {
      return Objects.hash(this.row, this.column);
    }
  }
}