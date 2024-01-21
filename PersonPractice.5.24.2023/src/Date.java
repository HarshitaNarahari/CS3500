public class Date {

  private int dMonth;
  private int dDay;
  private int dYear;


  Date(){
    dMonth = 12;
    dDay = 365;
    dYear = 1;
  }

  Date(int month, int day, int year) {
    this.dMonth = month;
    this.dDay = day;
    this.dYear = year;
  }

  public void setDate(int day, int month, int year){
    dDay = day;
    dMonth = month;
    dYear = year;
  }

  public String toString(){
    return (dMonth + "-" + dDay + "-" + dYear);
  }
  public int getDay(){
    return dDay;
  }
  public int getMonth(){
    return dMonth;
  }
  public int getYear(){
    return dYear;
  }


}









