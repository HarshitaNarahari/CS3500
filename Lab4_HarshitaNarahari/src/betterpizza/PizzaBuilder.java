package betterpizza;

import java.util.HashMap;
import java.util.Map;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents a builder for pizza
 *
 * @param <T> represents building a pizza
 */
public abstract class PizzaBuilder<T extends PizzaBuilder<T>> {
  protected Size size;
  protected Crust crust;
  protected Map<ToppingName, ToppingPortion> toppings;


  /**
   * Default consturctor for pizza builder
   */
  public PizzaBuilder(){
    size = null;
    crust = null;
    toppings = new HashMap<ToppingName, ToppingPortion>();;
  }

  /**
   * Returns the builder
   * @return T
   */
  abstract T returnBuilder();

  /**
   * Constructor for pizza builder
   *
   * @param crust the crust of the pizza
   * @param size the size of the pizza
   * @param toppings the toppings on the pizza
   */
  public PizzaBuilder(pizza.Size size, Crust crust, Map<ToppingName, ToppingPortion> toppings){
    this.size = size;
    this.crust = crust;
    this.toppings = toppings;
  }

  /**
   * Sets the size for the pizza in builder
   *
   * @param s the size of the pizza
   * @return AlaCartePizzaBuilder
   */
  public PizzaBuilder size(Size s){
    this.size = s;
    return returnBuilder();
  }

  /**
   * Sets the crust for the pizza in builder
   *
   * @param c the size of the pizza
   * @return AlaCartePizzaBuilder
   */
  public PizzaBuilder crust(Crust c){
    this.crust = c;
    return returnBuilder();
  }

  /**
   * Determines if a type of topping is on the pizza
   * If so, it returns the portion of the topping
   *
   * @param name the name of the topping
   * @return portion of the topping on the pizza or null if the given topping isn't on the pizza
   */
  public PizzaBuilder<T> addToppings(ToppingName name, ToppingPortion portion){
    this.toppings.put(name, portion);
    return returnBuilder();
  }

  /**
   * To build the pizza
   *
   * @return ObservablePizza
   */
  public abstract ObservablePizza build();

}











