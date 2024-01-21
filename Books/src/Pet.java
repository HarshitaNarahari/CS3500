public class Pet {

  private String name;
  private int age;
  private double weight;

  Pet(){
    name = "undetermined";
    age = 0;
    weight = 0.0;

  }
  Pet(String name, int age, double weight){
    this.name = name;
    this.age = age;
    this.weight = weight;
  }

  String getName(){
    return this.name;
  }

  int getAge(){
    return this.age;
  }

  double getWeight(){
    return this.weight;
  }

  void initPet() {
    Pet dog = new Pet("dog", 4, 20.0);
  }

  public void setName(String name){
    this.name = name;
  }

  public void setAge(int newAge){
    if (newAge < 0){
      System.out.println("Error: Invalid age entered");
      System.exit(0);
    }
    else {
      age = newAge;
    }
  }

  public void setWeight(double newWeight){
    if (newWeight < 0) {
      System.out.println("Error: Invalid weight entered");
      System.exit(0);
    }
    else{
      weight = newWeight;
    }
  }

  public void writeOutput (){
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Weight: " + weight);
  }




}
