package betterpizza;

import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents the operations for a pizza.
 */
public interface ObservablePizza {

  /**
   * Gets the cost of a pizza
   *
   * @return cost of the pizza in a DD.CC formatt
   */
  double cost();

  /**
   * Gets the cost of a pizza
   *
   * @param name the name of the topping
   * @return portion of the topping on the pizza or null if the given topping isn't on the pizza
   */
  ToppingPortion hasTopping(ToppingName name);
}
