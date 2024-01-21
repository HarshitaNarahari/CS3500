/**
 * to represent a pill batch add counter
 */
public class PillBatchAddCounter extends PillCounterDecorator {
  private int pillsAdded;

  /**
   * the constructor
   *
   * @param delegate to represent a pill counter
   */
  public PillBatchAddCounter(PillCounter delegate) {
    super(delegate);
  }


  /**
   * Add the specific number of pills to this counter. This method
   * is general enough to work with machines with different pill-filling
   * capacities.
   *
   * @param count
   */
  @Override
  public void addPill(int count) {
    if (count > 0) {
      this.pillsAdded += count;
    }
  }


  /**
   * to return the pill counts
   * @return integer
   */
  @Override
  public int getPillCount() {
    if (pillsAdded > 0) {
      this.delegate.addPill(pillsAdded);
    }
    this.pillsAdded = 0;
    return this.delegate.getPillCount();
  }

  /**
   * Resets the counter to 0.
   */
  @Override
  public void reset() {
    if (pillsAdded < 0) {
      this.delegate.addPill(pillsAdded);
    }
    this.delegate.reset();
    this.pillsAdded = 0;
  }
}