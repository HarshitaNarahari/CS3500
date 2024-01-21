public class Employee {
  private int id;
  private String name;

  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (o == this) {
      return true;
    }
    Employee e = (Employee) o;
    return (this.getId() == e.getId());
  }

  // better to have this method too when overriding the equals method
  @Override
  public int hashCode(){
    return getId();
  }
}
