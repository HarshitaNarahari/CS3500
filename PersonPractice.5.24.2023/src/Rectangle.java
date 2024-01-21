import javax.lang.model.element.UnknownDirectiveException;

public class Rectangle {
  private double length;
  private double width;

  Rectangle(){
    length = 0.0;
    width = 0.0;
  }

  Rectangle(double l, double w){
    this.length = l;
    this.width = w;
  }

  void setDimensions(double l, double w){
    new Rectangle(l, w);

    if (l >= 0) {
      length = l;
    }
    if (w >= 0) {
      width = w;
    }
    else {
      length = 0;
    }

  }

  double getLength(){
    return length;
  }

  double getWidth(){
    return width;
  }

  double area(){
    return length * width;
  }

  double perimeter(){
    return (2*length) + (2*width);
  }

  public String toString(){
    return ("Length: " + length
            + "; Width: " + width + "\n"
            + "Area: " + area()
            + "; Perimeter: " + perimeter() + "\n");
  }
}
