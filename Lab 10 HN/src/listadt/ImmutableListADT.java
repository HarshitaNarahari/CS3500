package listadt;

/**
 * This interface represents immutable lists of T elements.
 * @param <T> the type of element in this list
 */
public interface ImmutableListADT<T> extends CommonListADT<T> {

  /**
   * Creates and returns a mutable version of this list
   * @return a mutable list as a ListADT object
   */
  MutableListADT<T> getMutableList();

}