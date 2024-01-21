package betterpizza;

import java.util.Map;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents a veggie pizza.
 */
public class VeggiePizza extends AlaCartePizza{

  /**
   * Constructor for veggie pizza
   *
   * @param builder a VeggiePizza builder
   */
  private VeggiePizza(VeggiePizzaBuilder builder){
    super(builder.size, builder.crust, builder.toppings);
  }

  /**
   * This class is to represent a veggie pizza builder.
   */
  public static class VeggiePizzaBuilder extends PizzaBuilder<VeggiePizzaBuilder>{
    /**
     * returns the veggie pizza builder
     *
     * @return VeggiePizzaBuilder
     */
    public VeggiePizzaBuilder returnBuilder(){
      return this;
    }

    /**
     * Default constructor for VeggiePizzaBuilder
     */
    public VeggiePizzaBuilder(){
      this.addToppings(ToppingName.Sauce, ToppingPortion.Full);
      this.addToppings(ToppingName.Cheese, ToppingPortion.Full);
      this.addToppings(ToppingName.Tomato, ToppingPortion.Full);
      this.addToppings(ToppingName.BlackOlive, ToppingPortion.Full);
      this.addToppings(ToppingName.GreenPepper, ToppingPortion.Full);
      this.addToppings(ToppingName.Onion, ToppingPortion.Full);
      this.addToppings(ToppingName.Jalapeno, ToppingPortion.Full);
    }

    /**
     * Builds a pizza
     *
     * @return VeggiePizza
     */
    public ObservablePizza build(){
      return new VeggiePizza(this);
    }

    /**
     * Removes the sauce
     *
     * @return VeggiePizza with no sauce
     */
    public VeggiePizzaBuilder noSauce(){
      toppings.remove(ToppingName.Sauce, ToppingPortion.Full);
      return this;
    }

    /**
     * Puts the sauce on the right half of the pizza
     *
     * @return VeggiePizza with sauce on the right half of the pizza
     */
    public VeggiePizzaBuilder rightHalfSauce(){
      toppings.put(ToppingName.Sauce, ToppingPortion.RightHalf);
      return this;
    }

    /**
     * Puts the sauce on the left half of the pizza
     *
     * @return VeggiePizza with sauce on the left half of the pizza
     */
    public VeggiePizzaBuilder leftHalfSauce(){
      toppings.put(ToppingName.Sauce, ToppingPortion.LeftHalf);
      return this;
    }

    /**
     * Removes the cheese
     *
     * @return VeggiePizza with no cheese
     */
    public VeggiePizzaBuilder noCheese(){
      toppings.remove(ToppingName.Cheese, ToppingPortion.Full);
      return this;
    }

    /**
     * Puts the cheese on the right half of the pizza
     *
     * @return VeggiePizza with cheese on the right half of the pizza
     */
    public VeggiePizzaBuilder rightHalfCheese(){
      toppings.put(ToppingName.Cheese, ToppingPortion.RightHalf);
      return this;
    }

    /**
     * Puts the cheese on the left half of the pizza
     *
     * @return VeggiePizza with cheese on the left half of the pizza
     */
    public VeggiePizzaBuilder leftHalfCheese(){
      toppings.put(ToppingName.Cheese, ToppingPortion.LeftHalf);
      return this;
    }

    /**
     * Removes the tomatoes
     *
     * @return VeggiePizza with no tomatoes
     */
    public VeggiePizzaBuilder noTomato(){
      toppings.remove(ToppingName.Tomato, ToppingPortion.Full);
      return this;
    }

    /**
     * Puts the tomatoes on the right half of the pizza
     *
     * @return VeggiePizza with tomatoes on the right half of the pizza
     */
    public VeggiePizzaBuilder rightHalfTomato(){
      toppings.put(ToppingName.Tomato, ToppingPortion.RightHalf);
      return this;
    }

    /**
     * Puts the tomatoes on the left half of the pizza
     *
     * @return VeggiePizza with tomatoes on the left half of the pizza
     */
    public VeggiePizzaBuilder leftHalfTomato(){
      toppings.put(ToppingName.Tomato, ToppingPortion.LeftHalf);
      return this;
    }

    /**
     * Removes the black olives
     *
     * @return VeggiePizza with no black olives
     */
    public VeggiePizzaBuilder noBlackOlive(){
      toppings.remove(ToppingName.BlackOlive, ToppingPortion.Full);
      return this;
    }

    /**
     * Puts the black olives on the right half of the pizza
     *
     * @return VeggiePizza with black olives on the right half of the pizza
     */
    public VeggiePizzaBuilder rightHalfBlackOlive(){
      toppings.put(ToppingName.BlackOlive, ToppingPortion.RightHalf);
      return this;
    }

    /**
     * Puts the black olives on the left half of the pizza
     *
     * @return VeggiePizza with black olives on the left half of the pizza
     */
    public VeggiePizzaBuilder leftHalfBlackOlive(){
      toppings.put(ToppingName.BlackOlive, ToppingPortion.LeftHalf);
      return this;
    }

    /**
     * Removes the green peppers
     *
     * @return VeggiePizza with no green peppers
     */
    public VeggiePizzaBuilder noGreenPepper(){
      toppings.remove(ToppingName.GreenPepper, ToppingPortion.Full);
      return this;
    }

    /**
     * Puts the green peppers on the right half of the pizza
     *
     * @return VeggiePizza with green peppers on the right half of the pizza
     */
    public VeggiePizzaBuilder rightHalfGreenPepper(){
      toppings.put(ToppingName.GreenPepper, ToppingPortion.RightHalf);
      return this;
    }

    /**
     * Puts the green peppers on the left half of the pizza
     *
     * @return VeggiePizza with green peppers on the left half of the pizza
     */
    public VeggiePizzaBuilder leftHalfGreenPepper(){
      toppings.put(ToppingName.GreenPepper, ToppingPortion.LeftHalf);
      return this;
    }

    /**
     * Removes the onions
     *
     * @return VeggiePizza with no onions
     */
    public VeggiePizzaBuilder noOnion(){
      toppings.remove(ToppingName.Onion, ToppingPortion.Full);
      return this;
    }

    /**
     * Puts the onions on the right half of the pizza
     *
     * @return VeggiePizza with onions on the right half of the pizza
     */
    public VeggiePizzaBuilder rightHalfOnion(){
      toppings.put(ToppingName.Onion, ToppingPortion.RightHalf);
      return this;
    }

    /**
     * Puts the onions on the left half of the pizza
     *
     * @return VeggiePizza with onions on the left half of the pizza
     */
    public VeggiePizzaBuilder leftHalfOnion(){
      toppings.put(ToppingName.Onion, ToppingPortion.LeftHalf);
      return this;
    }

    /**
     * Removes the Jalapenos
     *
     * @return VeggiePizza with no Jalapenos
     */
    public VeggiePizzaBuilder noJalapeno(){
      toppings.remove(ToppingName.Jalapeno, ToppingPortion.Full);
      return this;
    }

    /**
     * Puts the Jalapenos on the right half of the pizza
     *
     * @return VeggiePizza with Jalapenos on the right half of the pizza
     */
    public VeggiePizzaBuilder rightHalfJalapeno(){
      toppings.put(ToppingName.Jalapeno, ToppingPortion.RightHalf);
      return this;
    }

    /**
     * Puts the Jalapenos on the left half of the pizza
     *
     * @return VeggiePizza with Jalapenos on the left half of the pizza
     */
    public VeggiePizzaBuilder leftHalfJalapeno(){
      toppings.put(ToppingName.Jalapeno, ToppingPortion.LeftHalf);
      return this;
    }
  }
}













