public class Box extends Rectangle{

  private double height;

  public Box(){
    super();
    height = 0.0;
  }

  public Box(double l, double w, double h){
    super(1, w);
    this.height = h;
  }

  void setDimensions(double l, double w, double h){
    super.setDimensions(l, w);
    if (h >= 0) {
      height = h;
    }
    else {
      height = 0;
    }
  }

  double getHeight(){
    return height;
  }

  double area(){
    return 2 * (getLength() * getWidth() + getLength() * height + getWidth() * height);
  }

  double volume(){
    return super.area()*height;
  }

  public String toString(){
    return ("Length: " + super.getLength()
            + "; Width: " + super.getWidth() + "\n"
            + "; Height: " + height);
  }




}
