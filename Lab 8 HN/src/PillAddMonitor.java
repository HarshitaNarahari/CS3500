import java.util.ArrayList;
import java.util.List;

/**
 * to represent a pill add monitor
 */
public class PillAddMonitor extends PillCounterDecorator{


  private List<Integer> addCounts;
  /**
   * the constructor
   *
   * @param delegate to represent a pill counter
   */
  public PillAddMonitor(PillCounter delegate) {
    super(delegate);
    addCounts = new ArrayList<Integer>();
    addCounts.add(0);
  }

  /**
   * to return the add counts
   * @return a list of integers
   */
  public List<Integer> getAddCounts() {
    return new ArrayList<Integer>(addCounts);
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
    addCounts.set(addCounts.size() - 1, addCounts.get(addCounts.size() - 1) + 1);
    super.addPill(count);
  }

  /**
   * Resets the counter to 0.
   */
  @Override
  public void reset() {
    addCounts.add(0);
    super.reset();
  }
}