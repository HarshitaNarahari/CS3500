package betterpizza;

import com.sun.net.httpserver.HttpPrincipal;

import java.util.HashMap;
import java.util.Map;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents a AlaCarte pizza which is a pizza
 * that can have an arbitrary number of ingredients.
 */
public class AlaCartePizza implements ObservablePizza{
  protected final Crust crust;
  protected final Size size;
  protected final Map<ToppingName, ToppingPortion> toppings;

  /**
   * Creates a pizza given its crust type, size, and toppings
   */
  public AlaCartePizza(Size size, Crust crust, Map<ToppingName, ToppingPortion> toppings) throws IllegalArgumentException{
    if (size == null){
      throw new IllegalArgumentException("Size wasn't specified.");
    }
    if (crust == null){
      throw new IllegalArgumentException("Crust wasn't specified.");
    }
    if (toppings == null){
      throw new IllegalArgumentException("Toppings weren't specified.");
    }
    this.size = size;
    this.crust = crust;
    this.toppings = toppings;
  }

  /**
   * Represents a pizza as a String
   *
   * @return String
   */
  @Override
  public String toString(){
    return "Size: " + this.size + "" +"\n" +
            "Crust: " + this.crust + "" +"\n" +
            "Toppings: " + this.toppings;
  }


  /** Constructor for builder
   *
   * @param builder
   */
  public AlaCartePizza(AlaCartePizzaBuilder builder){
    size = builder.size;
    crust = builder.crust;
    toppings = builder.toppings;
  }

  /**
   * This class represents a builder for an AlaCarte pizza.
   */
  public static class AlaCartePizzaBuilder extends PizzaBuilder<AlaCartePizzaBuilder>{

    /**
     * Default constructor
     */
    public AlaCartePizzaBuilder(){
      size = null;
      crust = null;
      toppings = new HashMap<ToppingName, ToppingPortion>();
    }

    /**
     * returns the AlaCarte pizza builder
     *
     * @return AlaCartePizzaBuilder
     */
    @Override
    AlaCartePizzaBuilder returnBuilder(){
      return this;
    }

    /**
     * removes toppings in the AlaCarte pizza builder
     *
     * @param name name of topping
     * @return AlaCartePizzaBuilder
     */
    public AlaCartePizzaBuilder removeToppings(ToppingName name){
      this.toppings.remove(name);
      return returnBuilder();
    }

    /**
     * builds an AlaCarte pizza
     *
     * @return AlaCarte pizza
     * @throws IllegalStateException if the size was not specified.
     */
    public AlaCartePizza build() throws IllegalStateException{
      if (this.size == null){
        throw new IllegalStateException("Size has not been specified.");
      }
      return new AlaCartePizza(this);
    }
  }

  /**
   * Determines if the topping is on the pizza
   * If so, returns the portion of the topping
   *
   * @param name name of topping
   * @return portion of the topping on the pizza or null if the given topping isn't on the pizza
   */
  @Override
  public ToppingPortion hasTopping(ToppingName name){
    return this.toppings.getOrDefault(name, null);
  }

  /**
   * Overriding the equals method
   *
   * @param obj the object being evaluated in the equals method
   * @return boolean
   */
  @Override
  public boolean equals(Object obj){
    if (this == obj){
      return true;
    }
    if (obj == null){
      return false;
    }
    CheesePizza other = (CheesePizza) obj;
    return this.size == other.size &&
            this.crust == other.crust &&
            this.toppings.equals( other.toppings);
  }

  /**
   * Gets the cost of the pizza
   *
   * @return cost of the pizza in a DD.CC formatt
   */
  @Override
  public double cost() {
    double cost = 0.0;
    for (Map.Entry<ToppingName, ToppingPortion> item : this.toppings.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultiplier();
    }
    return cost + this.size.getBaseCost();
  }
}





