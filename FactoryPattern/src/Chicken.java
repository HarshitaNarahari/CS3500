public class Chicken implements Pizza{
  @Override
  public void prepare() {
    System.out.println("Prepare chicken pizza");
  }

  @Override
  public void bake() {
    System.out.println("Baking chicken pizza");
  }

  @Override
  public void cut() {
    System.out.println("Cutting chicken pizza");
  }
}
