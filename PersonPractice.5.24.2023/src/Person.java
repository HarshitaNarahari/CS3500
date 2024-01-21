public class Person {
  private String firstName;
  private String lastName;

  Person(){
    this.firstName = "Harshita";
    this.lastName = "Narahari";
  }

  Person(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String toString(){
    return (firstName + " " + lastName);
  }

  public void setName(String first, String last){
    firstName = first;
    lastName = last;
  }

  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }


}
