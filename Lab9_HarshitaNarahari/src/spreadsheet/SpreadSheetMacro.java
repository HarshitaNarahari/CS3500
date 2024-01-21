package spreadsheet;

/**
 * This interface represents a macro. A macro is a set of instructions that can
 * run on a given spreadsheet. Macros can thus be used to extend the set of
 * instructions (operations) that a spreadsheet offers, without editing the
 * spreadsheet.
 */
public interface SpreadSheetMacro{
  /**
   * Execute this macro on the given sheet
   * @param sheet the sheet on which this macro must be executed
   */
  void execute(SpreadSheet sheet);
}
