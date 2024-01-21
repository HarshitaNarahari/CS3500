public class PersonalInfo {
  private Person name;
  private Date bday;
  private int personID;

  PersonalInfo(){
    name = new Person("Harshita", "Narahari");
    bday = new Date(7, 29, 2004);
    personID = 1;
  }

  PersonalInfo(String firstName, String lastName, int month, int day, int year, int id){
    name = new Person(firstName, lastName);
    bday = new Date(month, day, year);
    personID = id;
  }

  public void setPersonalInfo(String first, String last, int month, int day, int year, int id){
    name.setName(first, last);
    bday.setDate(month, day, year);
    personID = id;
  }

  public String toString(){
    return ("Name: " + name.toString() + "\n"
    + "Date of birth: " + bday.toString() + "\n"
    + "Personal id: " + personID);
  }




}
