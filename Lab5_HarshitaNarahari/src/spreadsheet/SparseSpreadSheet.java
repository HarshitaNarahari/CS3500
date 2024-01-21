package spreadsheet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class represents a sparse spreadsheet. A sparse spreadsheet is a spreadsheet
 * with a large number of empty cells. It represents this efficiently using a hash map.
 *
 */
public class SparseSpreadSheet implements SpreadSheet {
  private final Map<CellPosition,Double> sheet;
  private int width;
  private int height;

  /**
   * Constructs a sparse spreadsheet
   */
  public SparseSpreadSheet() {
    this.sheet = new HashMap<CellPosition,Double>();
    this.width = 0;
    this.height = 0;
  }

  /**
   * Gets the row and column numbers for a sparse spreadsheet
   *
   * @param row the row number of the cell, starting with 0
   * @param col the column number of the cell, starting with 0
   * @return the cell position for a sparse spreadsheet
   * @throws IllegalArgumentException if the row or column is negative
   */
  @Override
  public double get(int row, int col) throws IllegalArgumentException {
    if ((row<0) || (col<0)) {
      throw new IllegalArgumentException("Row or column cannot be negative");
    }
    return this.sheet.getOrDefault(new CellPosition(row,col),0.0);
  }

  /**
   * Gets the row and column numbers for a sparse spreadsheet
   *
   * @param row the row number of the cell, starting with 0
   * @param col the column number of the cell, starting with 0
   * @return the cell position set for a sparse spreadsheet
   * @throws IllegalArgumentException if the row or column is negative
   */
  @Override
  public void set(int row, int col,double value) throws IllegalArgumentException {
    if ((row<0) || (col<0)) {
      throw new IllegalArgumentException("Row or column cannot be negative");
    }
    this.sheet.put(new CellPosition(row,col),value);
    if ((row+1)>height) {
      height = row+1;
    }

    if ((col+1)>width) {
      width = col + 1;
    }
  }

  /**
   * States if the cell of the given row and column is empty for a sparse spreadsheet
   *
   * @param row the row number of the cell, starting with 0
   * @param col the column number of the cell, starting with 0
   * @return boolean determining if cell position is empty
   */
  @Override
  public boolean isEmpty(int row, int col) throws IllegalArgumentException {
    if ((row<0) || (col<0)) {
      throw new IllegalArgumentException("Row or column cannot be negative");
    }
    return !this.sheet.containsKey(new CellPosition(row,col));
  }

  /**
   * Gets the width
   *
   * @return int for width
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Gets the height
   *
   * @return int for height
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * This class represents the cell position
   */
  private static class CellPosition {
    private final int row;
    private final int column;

    /**
     * Constructs a cell position
     *
     * @param row the row number
     * @param column the column number
     */
    private CellPosition(int row,int column) {
      this.row = row;
      this.column = column;
    }

    /**
     * Overrides the equal method to check if this is equal to object o
     *
     * @param o an object
     * @return boolean stating if it is equal to
     */
    @Override
    public boolean equals(Object o) {
      if (this==o) {
        return true;
      }
      if (!(o instanceof CellPosition)) {
        return false;
      }
      CellPosition other = (CellPosition)o;
      return this.row==other.row && this.column==other.column;
    }

    /**
     * Hashcode method
     *
     * @return hashcode()
     */
    @Override
    public int hashCode() {
      return Objects.hash(this.row,this.column);
    }
  }
}
