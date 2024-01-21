package spreadsheet;

/**
 * This interface represents a single macro in a spreadsheet.
 */
public interface MacroSpreadSheet extends SpreadSheet{
  /**
   * Executes the given macro on this spreadsheet.
   *
   * @param macro the macro to be executed
   */
  void executeMacro(SpreadSheetMacro macro);
}
