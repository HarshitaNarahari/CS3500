import org.junit.Before;
import org.junit.Test;

import betterpizza.ObservablePizza;
import betterpizza.VeggiePizza;
import betterpizza.AlaCartePizza;
import betterpizza.CheesePizza;
import pizza.Pizza;
import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * The test class for the pizzas using the classes in the better pizza package.
 */
public class BetterPizzaTest {
  private ObservablePizza alacarte;
  private ObservablePizza cheese;
  private ObservablePizza halfCheese;
  private ObservablePizza veggie;


  @Before
  public void setup() {
    alacarte = new AlaCartePizza.AlaCartePizzaBuilder()
            .crust(Crust.Classic)
            .size(Size.Medium)
            .addToppings(ToppingName.Cheese, ToppingPortion.Full)
            .addToppings(ToppingName.Sauce,ToppingPortion.Full)
            .addToppings(ToppingName.GreenPepper,ToppingPortion.Full)
            .addToppings(ToppingName.Onion,ToppingPortion.Full)
            .addToppings(ToppingName.Jalapeno,ToppingPortion.LeftHalf)
            .build();

    cheese = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .build();

    halfCheese = new CheesePizza.CheesePizzaBuilder()
            .leftHalfCheese()
            .crust(Crust.Thin)
            .size(Size.Large)
            .build();

    veggie = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .addToppings(ToppingName.Cheese, ToppingPortion.Full)
            .addToppings(ToppingName.Sauce,ToppingPortion.Full)
            .addToppings(ToppingName.BlackOlive,ToppingPortion.Full)
            .addToppings(ToppingName.Tomato,ToppingPortion.Full)
            .addToppings(ToppingName.GreenPepper,ToppingPortion.Full)
            .addToppings(ToppingName.Onion,ToppingPortion.Full)
            .addToppings(ToppingName.Jalapeno,ToppingPortion.LeftHalf)
            .build();
  }

  @Test
  public void TestBuildAlaCartePizza() {
    new AlaCartePizza.AlaCartePizzaBuilder()
            .crust(Crust.Classic)
            .size(Size.Medium)
            .addToppings(ToppingName.Cheese, ToppingPortion.Full)
            .addToppings(ToppingName.Sauce,ToppingPortion.Full)
            .addToppings(ToppingName.GreenPepper,ToppingPortion.Full)
            .addToppings(ToppingName.Onion,ToppingPortion.Full)
            .addToppings(ToppingName.Jalapeno,ToppingPortion.LeftHalf)
            .build();
  }

  @Test
  public void TestBuildCheesePizza() {
    new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .build();
  }

  @Test
  public void TestBuildHalfCheesePizza() {
    new CheesePizza.CheesePizzaBuilder()
            .leftHalfCheese()
            .crust(Crust.Thin)
            .size(Size.Large)
            .build();
  }

  @Test
  public void TestBuildVeggiePizzaAndAddToppings() {
    new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .addToppings(ToppingName.Cheese, ToppingPortion.Full)
            .addToppings(ToppingName.Sauce,ToppingPortion.Full)
            .addToppings(ToppingName.BlackOlive,ToppingPortion.Full)
            .addToppings(ToppingName.Tomato,ToppingPortion.Full)
            .addToppings(ToppingName.GreenPepper,ToppingPortion.Full)
            .addToppings(ToppingName.Onion,ToppingPortion.Full)
            .addToppings(ToppingName.Jalapeno,ToppingPortion.LeftHalf)
            .build();
  }

  @Test
  public void testRemoveTopping() {
    setup();

    CheesePizza.CheesePizzaBuilder cheeseBuilder = new CheesePizza.CheesePizzaBuilder();
    cheeseBuilder.size(Size.Large);
    cheeseBuilder.crust(Crust.Thin);
    ObservablePizza pizza = new CheesePizza(cheeseBuilder);

    assertEquals(new CheesePizza.CheesePizzaBuilder()
            .size(Size.Large)
            .crust(Crust.Thin)
            .addToppings(ToppingName.Cheese, ToppingPortion.Full)
            .addToppings(ToppingName.Sauce,ToppingPortion.Full)
            .build(), pizza);

    // calling mutation method before testing again
    cheeseBuilder.noSauce();

    assertEquals(new CheesePizza.CheesePizzaBuilder()
            .noSauce()
            .size(Size.Large)
            .crust(Crust.Thin)
            .addToppings(ToppingName.Cheese, ToppingPortion.Full)
            .build(), pizza);

    // calling mutation method before testing again
    cheeseBuilder.leftHalfCheese();

    assertEquals(new CheesePizza.CheesePizzaBuilder()
            .noSauce()
            .leftHalfCheese()
            .size(Size.Large)
            .crust(Crust.Thin)
            .build(), pizza);
  }

  @Test
  public void testHasToppings(){
    setup();

    assertEquals(ToppingPortion.Full, cheese.hasTopping(ToppingName.Cheese));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.Tomato));
    assertEquals(ToppingPortion.Full, veggie.hasTopping(ToppingName.Onion));

    CheesePizza.CheesePizzaBuilder cheeseBuilder = new CheesePizza.CheesePizzaBuilder();
    cheeseBuilder.size(Size.Large);
    cheeseBuilder.crust(Crust.Thin);
    ObservablePizza pizza = new CheesePizza(cheeseBuilder);
    cheeseBuilder.rightHalfCheese();

    assertEquals(ToppingPortion.RightHalf, pizza.hasTopping(ToppingName.Cheese));
  }

  @Test
  public void testExceptions(){
    try {
      cheese = new CheesePizza.CheesePizzaBuilder()
              .crust(Crust.Thin)
              .build();
      fail("No size has been specified");
    }
    catch (IllegalArgumentException e){

    }

    try {
      cheese = new CheesePizza.CheesePizzaBuilder()
              .size(Size.Large)
              .build();
      fail("No crust has been specified");
    }
    catch (IllegalArgumentException e){

    }

    try {
      veggie = new VeggiePizza.VeggiePizzaBuilder()
              .size(Size.Medium)
              .addToppings(ToppingName.Cheese, ToppingPortion.Full)
              .addToppings(ToppingName.Sauce, ToppingPortion.Full)
              .addToppings(ToppingName.GreenPepper, ToppingPortion.Full)
              .addToppings(ToppingName.Onion, ToppingPortion.Full)
              .addToppings(ToppingName.Jalapeno, ToppingPortion.LeftHalf)
              .build();
      fail("No crust has been specified");
    }
      catch (IllegalArgumentException e){

      }

    try {
      alacarte = new AlaCartePizza(Size.Medium, Crust.Stuffed, null);
      fail("No toppings were specified");
    }
    catch (IllegalArgumentException e){
    }
  }

  @Test
  public void testCost() {
    assertEquals(8.25,alacarte.cost(),0.01);
    assertEquals(9,cheese.cost(),0.01);
    assertEquals(8.5,halfCheese.cost(),0.01);
    assertEquals(11.25,veggie.cost(),0.01);
  }
}