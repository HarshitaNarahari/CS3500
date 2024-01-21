package spreadsheet;

/**
 * This class represents a bulk assign macro to assign
 * all the cells in a range to a specific value.
 */
public class BulkAssignMacro implements SpreadSheetMacro{
  private final int fromRow;
  private final int fromCol;
  private final int toRow;
  private final int toCol;
  private final double value;

  /**
   * Create a bulk assign macro object given the range of cells and the value
   * @param fromRow the row of the starting cell
   * @param fromCol the column of the starting cell
   * @param toRow the row of the ending cell
   * @param toCol the column of the ending cell
   * @param value the value to be written in the range of cells
   */
  public BulkAssignMacro(int fromRow, int fromCol, int toRow, int toCol, double value) {
    if ((fromRow < 0) || (fromCol < 0) || (toRow < 0) || (toCol < 0)) {
      throw new IllegalArgumentException("Arguments to bulk assign macro cannot be negative");
    }
    this.fromRow = fromRow;
    this.fromCol = fromCol;
    this.toRow = toRow;
    this.toCol = toCol;
    this.value = value;
  }

  /**
   * Executes and updates the values in a sheet
   * @param sheet the sheet on which this macro must be executed
   */
  @Override
  public void execute(SpreadSheet sheet) {
    for (int i = fromRow; i <= toRow; i = i + 1) {
      for (int j = fromCol; j <= toCol; j = j + 1) {
        sheet.set(i, j, value);
      }
    }
  }
}
