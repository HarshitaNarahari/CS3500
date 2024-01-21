package spreadsheet;

/**
 * This class represents an average macro to assign
 * all the cells in a range to a specific value.
 */
public class AverageMacro implements SpreadSheetMacro{
  private final int fromRow;
  private final int fromCol;
  private final int toRow;
  private final int toCol;
  private final int destRow;
  private final int destCol;

  /**
   * Create an average macro object given the range of cells and the value
   * @param fromRow the row of the starting cell
   * @param fromCol the column of the starting cell
   * @param toRow the row of the ending cell
   * @param toCol the column of the ending cell
   * @param destRow the row of the final destination
   * @param destCol the column of the final destination
   */
  public AverageMacro(int fromRow, int fromCol, int toRow, int toCol,
                      int destRow, int destCol) throws IllegalArgumentException{
    if ((fromRow < 0) || (fromCol < 0) || (toRow < 0) || (toCol < 0)
            || (destRow < 0) || (destCol < 0)){
      throw new IllegalArgumentException("Arguments to average macro cannot be negative");
    }
    this.fromRow = fromRow;
    this.fromCol = fromCol;
    this.toRow = toRow;
    this.toCol = toCol;
    this.destRow = destRow;
    this.destCol = destCol;
  }

  /**
   * Executes and updates the values in a sheet
   * @param sheet the sheet on which this macro must be executed
   */
  @Override
  public void execute(SpreadSheet sheet) {
    int n = Math.abs(this.toCol - this.fromCol + 1) * Math.abs(this.toRow - this.fromRow + 1);
    double average = 0;
    for (int row = Math.min(fromRow, toRow); row <= Math.max(fromRow, toRow); row = row + 1) {
      for (int col = Math.min(fromCol, toCol); col <= Math.max(fromCol, toCol); col = col + 1) {
        average += sheet.get(row, col);
      }
    }
    average /= n;
    sheet.set(destRow, destCol, average);
  }
}

