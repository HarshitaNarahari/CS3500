package betterpizza;

import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents a cheese pizza.
 */
public class CheesePizza extends AlaCartePizza{

  /**
   * Constructor for cheese pizza
   *
   * @param builder a CheesePizza builder
   */
  public CheesePizza(CheesePizzaBuilder builder){
    super(builder.size, builder.crust, builder.toppings);
  }

  /**
   * This class is to represent a cheese pizza builder.
   */
  public static class CheesePizzaBuilder extends PizzaBuilder<CheesePizzaBuilder>{
    /**
     * returns the cheese pizza builder
     *
     * @return CheesePizzaBuilder
     */
    @Override
    public CheesePizzaBuilder returnBuilder(){
      return this;
    }

    /**
     * Default constructor for CheesePizzaBuilder
     */
    public CheesePizzaBuilder(){
      super();
      this.addToppings(ToppingName.Cheese, ToppingPortion.Full);
      this.addToppings(ToppingName.Sauce, ToppingPortion.Full);
    }

    /**
     * Builds a pizza
     *
     * @return CheesePizza
     */
    public ObservablePizza build(){
      return new CheesePizza(this);
    }

    /**
     * Removes the cheese
     *
     * @return CheesePizza with no cheese
     */
    public CheesePizzaBuilder noCheese(){
      toppings.remove(ToppingName.Cheese, ToppingPortion.Full);
      return this;
    }

    /**
     * Puts the cheese on the right half of the pizza
     *
     * @return CheesePizza with cheese on the right half of the pizza
     */
    public CheesePizzaBuilder rightHalfCheese(){
      toppings.put(ToppingName.Cheese, ToppingPortion.RightHalf);
      return this;
    }

    /**
     * Puts the cheese on the left half of the pizza
     *
     * @return CheesePizza with cheese on the left half of the pizza
     */
    public CheesePizzaBuilder leftHalfCheese(){
      toppings.put(ToppingName.Cheese, ToppingPortion.LeftHalf);
      return this;
    }

    /**
     * Removes the sauce
     *
     * @return CheesePizza with no sauce
     */
    public CheesePizzaBuilder noSauce(){
      toppings.remove(ToppingName.Sauce, ToppingPortion.Full);
      return this;
    }

    /**
     * Puts the sauce on the right half of the pizza
     *
     * @return CheesePizza with sauce on the right half of the pizza
     */
    public CheesePizzaBuilder rightHalfSauce(){
      toppings.put(ToppingName.Sauce, ToppingPortion.RightHalf);
      return this;
    }

    /**
     * Puts the sauce on the left half of the pizza
     *
     * @return CheesePizza with sauce on the left half of the pizza
     */
    public CheesePizzaBuilder leftHalfSauce(){
      toppings.put(ToppingName.Sauce, ToppingPortion.LeftHalf);
      return this;
    }
  }
}







