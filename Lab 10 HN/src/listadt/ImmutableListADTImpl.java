package listadt;

import java.util.function.Function;

/**
 * This class represents an immutable list of objects
 *
 * @param <T> the type of elements in this list
 */
public class ImmutableListADTImpl<T> implements ImmutableListADT<T> {

  private ListADT<T> list;

  /**
   * Default constructor
   */
  private ImmutableListADTImpl() {
    list = new ListADTImpl();
  }

  /**
   * Getter for the size of list
   *
   * @return integer representing list size
   */
  @Override
  public int getSize() {
    return list.getSize();
  }

  /**
   * Getter for the T object
   *
   * @return T object
   */
  @Override
  public T get(int index) throws IllegalArgumentException {
    return list.get(index);
  }

  /**
   * Converts to a ImmutableListADT
   * @param converter the function that converts T into R
   * @return the immutable list
   * @param <R> the type of data in the resulting list
   */
  @Override
  public <R> ImmutableListADT<R> map(Function<T, R> converter) {
    ListADT<R> result = list.map(converter);
    ImmutableListADTImpl<R> resultList = new ImmutableListADTImpl();
    for (int i = 0; i < result.getSize(); i++) {
      resultList.addBack(result.get(i));
    }
    return resultList;
  }

  /**
   * Adds the data back into list
   *
   * @param data data to be added
   */
  private void addBack(T data) {
    list.addBack(data);
  }

  /**
   * Builds a new immutable list
   *
   * @return the builder
   * @param <R> the type of data in the resulting list
   */
  public static <R> ImmutableListBuilder<R> getBuilder() {
    return new ImmutableListBuilder<R>();
  }

  /**
   * Getter for mutable list
   *
   * @return the mutable list
   */
  @Override
  public MutableListADT<T> getMutableList() {
    MutableListADT<T> result = new MutableListADTImpl();
    for (int i = 0; i < list.getSize(); i++) {
      result.addBack(list.get(i));
    }
    return result;
  }

  /**
   * This class is a builder for the ImmutableListADTImpl<T> class above
   *
   * @param <T> the type of elements whose list is to be build
   */
  public static class ImmutableListBuilder<T> {

    private ImmutableListADTImpl<T> iList;

    /**
     * Builder constructor
     */
    private ImmutableListBuilder() {
      iList = new ImmutableListADTImpl();
    }

    /**
     * Adds an element to the end of this list
     *
     * @param data the element to be added
     * @return the builder
     */
    public ImmutableListBuilder<T> add(T data) {
      iList.addBack(data);
      return this;
    }

    /**
     * Return the immutable list using this builder
     *
     * @return the immutable list
     */
    public ImmutableListADT<T> build() {
      return iList;
    }
  }
}