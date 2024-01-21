package listadt;

import java.util.function.Function;

/**
 * This represents an empty node of the generic list implementation.
 */
public class GenericEmptyNode<T> implements GenericListADTNode<T> {

  /**
   * Return the number of objects in this list.
   *
   * @return the size of this list
   */
  @Override
  public int count() {
    return 0;
  }

  /**
   * Add the given object to the front of this list and return this modified
   * list.
   *
   * @param object object to be added
   * @return the resulting list
   */
  @Override
  public GenericListADTNode<T> addFront(T object) {
    return new GenericElementNode(object, this);
  }

  /**
   * Add the given object to the back of this list and return this modified list.
   *
   * @param object the object to be added
   * @return the resulting list
   */
  @Override
  public GenericListADTNode<T> addBack(T object) {
    return addFront(object);
  }

  /**
   * A method that adds the given object at the given index in this list
   * . If index is 0, it means this object should be added to the front of this
   * list.
   *
   * @param index the position to be occupied by this object, starting at 0
   * @param object the object to be added
   * @return the resulting list
   * @throws IllegalArgumentException if an invalid index is passed
   */
  @Override
  public GenericListADTNode<T> add(int index, T object) throws
          IllegalArgumentException {
    if (index == 0) {
      return addFront(object);
    }
    throw new IllegalArgumentException("Invalid index to add an element");
  }

  /**
   * Remove the first instance of this object from the list.
   *
   * @param object the object to be removed
   * @return GenericListADTNode<T>
   */
  @Override
  public GenericListADTNode<T> remove(T object) {
    return this; //cannot remove from nothing!
  }

  /**
   * Get the object at the specified index, with 0 meaning the first object in
   * this list.
   *
   * @param index the specified index
   * @return the object at the specified index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  @Override
  public T get(int index) throws IllegalArgumentException {
    throw new IllegalArgumentException("Wrong index");
  }

  /**
   * A general map higher order function on nodes. This returns a list of
   * identical structure, but each data item of type T converted into R using
   * the provided converter method.
   *
   * @param converter the function needed to convert T into R
   * @param <R> the type of the data in the returned list
   * @return the head of a list that is structurally identical to this list,
   *          but contains data of type R
   */
  @Override
  public <R> GenericListADTNode<R> map(Function<T, R> converter) {
    return new GenericEmptyNode();
  }

  /**
   * Overrides the toString method
   *
   * @return String representing the list of objects
   */
  @Override
  public String toString() {
    return "";
  }
}
