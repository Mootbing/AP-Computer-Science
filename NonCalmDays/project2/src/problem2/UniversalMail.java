import java.text.NumberFormat;
import java.util.Locale;

public abstract class UniversalMail {
  protected double weight = 0.f;
  protected int zone;
  protected double flatPrice = 4.05;
  
  protected abstract double calculatePostage();
  
  public String toString(){
    NumberFormat dollars = NumberFormat.getCurrencyInstance(Locale.US);
    return dollars.format(calculatePostage());
  }
  
  public int compareTo(Object o) {
    
    UniversalMail o1 = (UniversalMail) o;
    
    if (o1.calculatePostage() > calculatePostage())
      return 1;
    else if (o1.calculatePostage() < calculatePostage())
      return -1;
    
    if (o1.getWeight() == getWeight())
      return 0;
    else if (o1.getWeight() > getWeight())
      return 1;
    
    return -1;
  }
  
  public boolean equals(Object o)
  {
    return compareTo(o) == 0;
  }
  
  
  
  //getters and setters
  public double getWeight() {
    return weight;
  }
  
  public void setWeight(double weight) {
    this.weight = weight;
  }
  
  public int getZone() {
    return zone;
  }
  
  public void setZone(int zone) {
    this.zone = zone;
  }
  
  public double getFlatPrice() {
    return flatPrice;
  }
  
  public void setFlatPrice(double flatPrice) {
    this.flatPrice = flatPrice;
  }
}

//The updated Mail class should look like this: 

/*
public abstract class Mail extends UniversalMail implements Comparable
{
  
  public abstract double calculatePostage();
  
  public String toString(){
    return super.toString();
  }
  
  public int compareTo(Object other){//[4 points]
    return super.compareTo(other);
  }
  public boolean equals(Object other){ //[4 points]
    return super.equals(other);
  }
  
  public static void main(String[] args){
  
  //insert test stuff here
  
  }
}
*/
