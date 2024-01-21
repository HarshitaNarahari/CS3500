package spreadsheet;

/**
 * This class represents a range assign macro to assign
 * all the cells in a range to a specific value.
 */
public class RangeAssignMacro implements SpreadSheetMacro{
  private final int fromRow;
  private final int fromCol;
  private final int toRow;
  private final int toCol;
  private final double startValue;
  private final double increment;

  /**
   * Create a range assign macro object given the range of cells and the value
   * @param fromRow the row of the starting cell
   * @param fromCol the column of the starting cell
   * @param toRow the row of the ending cell
   * @param toCol the column of the ending cell
   * @param startValue the value we start with
   * @param increment the increment for the startValue
   */
  public RangeAssignMacro(int fromRow, int fromCol, int toRow, int toCol,
                         double startValue, double increment) throws IllegalArgumentException {
    if ((fromRow < 0) || (fromCol < 0) || (toRow < 0) || (toCol < 0)){
      throw new IllegalArgumentException("Arguments to range assignment cannot be negative");
    }
    if ((fromRow != toRow) && (fromCol != toCol)){
      throw new IllegalArgumentException("Range assignment should be in a single row or column");
    }
    this.fromRow = fromRow;
    this.fromCol = fromCol;
    this.toRow = toRow;
    this.toCol = toCol;
    this.startValue = startValue;
    this.increment = increment;
  }

  /**
   * Executes and updates the values in a sheet
   * @param sheet the sheet on which this macro must be executed
   */
  @Override
  public void execute(SpreadSheet sheet) {
    double value = startValue;
    for (int i = fromRow; i <= toRow; i = i + 1) {
      for (int j = fromCol; j <= toCol; j = j + 1) {
        sheet.set(i, j, value);
        value += increment;
      }
    }
  }
}

