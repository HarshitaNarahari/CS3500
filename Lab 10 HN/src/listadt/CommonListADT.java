package listadt;

import java.util.function.Function;

/**
 * This interface represents an immutable list.
 * It offers only observer methods.
 *
 * @param <T> the type of element in this list
 */
public interface CommonListADT<T> {

  /**
   * Getter for size (the number of objects currently in this list)
   *
   * @return integer representing the size of the list
   */
  int getSize();

  /**
   * Getter for the index object in this list
   *
   * @param index the index of the object to be returned
   * @return the object at the given index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  T get(int index) throws IllegalArgumentException;

  /**
   * A general purpose map higher order function on this list,
   * that returns the corresponding list of type R
   *
   * @param converter the function that converts T into R
   * @param <R> the type of data in the resulting list
   * @return the resulting list identical in structure to this list, instead with data of type R
   */
  <R> CommonListADT<R> map(Function<T, R> converter);
}