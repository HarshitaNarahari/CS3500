/**
 * to represent a decorator for pill counter
 */
public class PillCounterDecorator implements PillCounter {

  PillCounter delegate;

  /**
   * the constructor
   * @param delegate to represent a pill counter
   */
  public PillCounterDecorator(PillCounter delegate) {
    this.delegate = delegate;
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
    this.delegate.addPill(count);
  }

  /**
   * Remove a pill from this counter. This method is called in case
   * a malfunction in the hardware is detected and it dispenses too
   * many pills. Only one pill may be removed at a time.
   */
  @Override
  public void removePill() {
    this.delegate.removePill();
  }

  /**
   * Reset the counter to 0.
   */
  @Override
  public void reset() {
    this.delegate.reset();
  }

  /**
   * Return how many pills have been counted so far.
   *
   * @return
   */
  @Override
  public int getPillCount() {
    return this.delegate.getPillCount();
  }
}