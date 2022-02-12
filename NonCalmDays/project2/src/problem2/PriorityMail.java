package problem2;

import java.text.DecimalFormat;

public class PriorityMail extends Mail
{
	private double weight;
	private int zone;
	private double flat_price = 4.05;
	
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

	public double getFlat_price() {
		return flat_price;
	}

	public void setFlat_price(double flat_price) {
		this.flat_price = flat_price;
	}

	//precondition: 1 <= zone <= 8
	public PriorityMail(double weight, int zone) 
	{
		this.weight = weight;
		this.zone = zone;
	}
	
	public double calculatePostage()
	{
		if(weight > 1)
		{
			return flat_price + flat_price * zone;
		}
		else
			return flat_price;
	}
	
//	public String toString()
//	{
//		DecimalFormat dollars = new DecimalFormat("$0.00");
//		return "Cost: " + dollars.format(calculatePostage()) + " Weight: " + weight + " At Zone: " + zone;
//	}
}