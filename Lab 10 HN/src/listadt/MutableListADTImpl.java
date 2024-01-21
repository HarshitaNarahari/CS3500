package listadt;

import java.util.function.Function;

/**
 * This class represents a Mutable List ADT Implementation
 * @param <T> the type of element in this list
 */
public class MutableListADTImpl<T> extends ListADTImpl<T> implements MutableListADT<T> {

  /**
   * Default constructor
   */
  public MutableListADTImpl() {
    super();
  }

  /**
   * Private constructor
   *
   * @param list list of adts
   */
  private MutableListADTImpl(ListADT<T> list) {
    for (int i = 0; i < list.getSize(); i++) {
      this.addBack(list.get(i));
    }
  }

  /**
   * Getter for the Immutable List
   * @return an Immutable List of T objects
   */
  @Override
  public ImmutableListADT<T> getImmutableList() {
    ImmutableListADTImpl.ImmutableListBuilder<T> builder = ImmutableListADTImpl.getBuilder();
    for (int i = 0; i < getSize(); i++) {
      builder = builder.add(get(i));
    }
    return builder.build();
  }

  /**
   * Converts a map to a list of ADTs
   * @param converter the function that converts T into R
   * @return ListADT of R objects
   * @param <R> the type of data in the resulting list
   */
  @Override
  public <R> ListADT<R> map(Function<T, R> converter) {
    return new MutableListADTImpl(super.map(converter));
  }
}