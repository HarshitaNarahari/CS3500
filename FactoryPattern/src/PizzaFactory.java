public class PizzaFactory {
  public static Pizza createPizza(String type) {
    Pizza p = null;

    if(type.toLowerCase().equals("Cheese")) {
      p = new CheesePizza();
    }
    else if (type.toLowerCase().equals("Chicken")){
      p = new Chicken();
    }
    else if (type.toLowerCase().equals("Veggies")){
      p = new VegPizza();
    }
    return p;
  }

}
