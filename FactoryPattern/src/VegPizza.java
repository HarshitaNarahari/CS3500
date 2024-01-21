public class VegPizza implements Pizza{

  @Override
  public void prepare() {
    System.out.println("Prepare veggie pizza");
  }

  @Override
  public void bake() {
    System.out.println("Baking veggie pizza");
  }

  @Override
  public void cut() {
    System.out.println("Cutting veggie pizza");
  }
}
