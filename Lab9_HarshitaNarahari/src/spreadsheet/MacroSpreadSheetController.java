package spreadsheet;

import java.util.Scanner;

/**
 * This class represents a Macro spreadsheet controller which updates the
 * different spreadsheets using the execute method.
 */
public class MacroSpreadSheetController extends SpreadSheetController {

  public MacroSpreadSheetController(SpreadSheet sheet,
                                    Readable readable,
                                    Appendable appendable) {
    super(sheet, readable, appendable);
  }

  @Override
  protected void processCommand(String userCommand, Scanner sc, SpreadSheet sheet) {
    if (!(sheet instanceof MacroSpreadSheet)) {
      throw new IllegalArgumentException("Must have a macro spreadsheet");
    }
    MacroSpreadSheet application = (MacroSpreadSheet) sheet;
    switch (userCommand) {
      case "bulk-assign-value":
        try {
          int fromRow = getRowNum(sc.next());
          int fromCol = sc.nextInt() - 1;
          int toRow = getRowNum(sc.next());
          int toCol = sc.nextInt() - 1;
          double value = sc.nextDouble();
          application.executeMacro(
                  new BulkAssignMacro(fromRow,
                          fromCol,
                          toRow,
                          toCol,
                          value));
        } catch (IllegalArgumentException e) {
          writeMessage("Error: " + e.getMessage() + System.lineSeparator());
        }
        break;

      case "range-assign":
        try {
          int fromRow = getRowNum(sc.next());
          int fromCol = sc.nextInt() - 1;
          int toRow = getRowNum(sc.next());
          int toCol = sc.nextInt() - 1;
          double fromValue = sc.nextDouble();
          double increment = sc.nextDouble();
          application.executeMacro(
                  new RangeAssignMacro(fromRow,
                          fromCol,
                          toRow,
                          toCol,
                          fromValue,
                          increment));
        } catch (IllegalArgumentException e) {
          writeMessage("Error: " + e.getMessage() + System.lineSeparator());
        }
        break;

      case "average":
        try {
          int fromRow = getRowNum(sc.next());
          int fromCol = sc.nextInt() - 1;
          int toRow = getRowNum(sc.next());
          int toCol = sc.nextInt() - 1;
          int destRow = getRowNum(sc.next());
          int destCol = sc.nextInt() - 1;
          application.executeMacro(
                  new AverageMacro(fromRow,
                          fromCol,
                          toRow,
                          toCol,
                          destRow,
                          destCol));
        } catch (IllegalArgumentException e) {
          writeMessage("Error: " + e.getMessage() + System.lineSeparator());
        }
        break;
      default:
        super.processCommand(userCommand, sc, sheet);
    }
  }

  @Override
  protected void printMenu() throws IllegalStateException {
    writeMessage("Supported user instructions are: " + System.lineSeparator());
    writeMessage("assign-value row-num col-num value (set a cell to a value)"
            + System.lineSeparator());
    writeMessage("print-value row-num col-num (print the value at a given cell)"
            + System.lineSeparator());
    writeMessage("bulk-assign-value from-row-num from-col-num to-row-num to-col-num value" +
            "(assigns value to given range)"
            + System.lineSeparator());
    writeMessage("range-assign-value rom-row-num from-col-num to-row-num to-col-num start-value " +
            "increment (assigns value to given range, increasing by the increment)"
            + System.lineSeparator());
    writeMessage("average from-row-num from-col-num to-row-num to-col-num dest-row-num " +
            "dest-col-num (averages values from given range and assigns the value to the " +
            "destination"
            + System.lineSeparator());
    writeMessage("menu (Print supported instruction list)" + System.lineSeparator());
    writeMessage("q or quit (quit the program) " + System.lineSeparator());
  }
}
